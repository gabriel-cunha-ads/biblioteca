package repository;

import entity.Livro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import repository.interfaces.Persistencia;
import util.UtilArquivo;
import util.UtilSistema;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroPersistenciaImpl implements Persistencia<Livro>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public LivroPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object livro) throws Exception {
        
        List<Livro> livrosBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, livrosBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(livro.toString());

//      Fecha o arquivo
        bw.close();
    }



    @Override
    public List<Livro> listar() throws Exception {
        List<Livro> livros = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Livro livro = new Livro(linha);
            livros.add(livro);
        }
        
        br.close();
        
        return livros;
    }

    @Override
    public Object consultar(Object livro) throws Exception {
        
        Livro livroParaConsultar = (Livro) livro;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Livro> livrosBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Livro a = new Livro(linha);
            livrosBanco.add(a);
        }
        
        Livro livroResultado = null;
        
        for (Livro a : livrosBanco) {
            if (livroParaConsultar.getIdLivro() == null) {
                
                if (a.getIsbn().trim().equals(livroParaConsultar.getIsbn().trim()) 
                        || (a.getTitulo().trim().equals(livroParaConsultar.getTitulo().trim()) 
                        && a.getCdd().getCodigoCDD().equals(livroParaConsultar.getCdd().getCodigoCDD()) )) {
                    
                    livroResultado = a;
                } 
            } else {
                if (a.equals(livro)) {
                    livroResultado = a;
                }                
            }
        }
        return livroResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Livro livroParaAlterar = (Livro) objeto;
        
        Livro livroBanco = (Livro) this.consultar(livroParaAlterar);
        
        this.excluir(livroBanco);

        Livro livroAtualizado = livroBanco.from(livroParaAlterar);
        
        this.incluir(livroAtualizado);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Livro livroParaExcluir = (Livro) objeto;
        
        List<Livro> livros = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Livro livroBanco = new Livro(linha);
            
            if (!livroBanco.equals(livroParaExcluir)) {
                livros.add(livroBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Livro a : livros) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Livro> livros = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Livro livroBanco = new Livro(linha);
            livros.add(livroBanco);
        }
        
        Integer ultimoId = null;
        
        if (!livros.isEmpty()) {
            Livro livro = livros.get(livros.size() -1);
            ultimoId = livro.getIdLivro();
        }
        return ultimoId;        
        
    }    
}
