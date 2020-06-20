package repository;

import entity.Autor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import repository.interfaces.Persistencia;
import tcpClient.ComunicadorTCP;
import util.UtilArquivo;
import util.UtilSistema;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorPersistenciaImpl implements Persistencia<Autor>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public AutorPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object autor) throws Exception {
        
        List<Autor> autoresBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, autoresBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(autor.toString());

//      Fecha o arquivo
        bw.close();
        
//      Grava servidor numve (socket)
        UtilSistema.gravarBancoDadosRemoto(arquivoBancoDados, autor.toString());
    }

    @Override
    public List<Autor> listar() throws Exception {
        List<Autor> autores = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Autor autor = new Autor(linha);
            autores.add(autor);
        }
        
        br.close();
        
        return autores;
    }

    @Override
    public Object consultar(Object autor) throws Exception {
        
        Autor autorParaConsultar = (Autor) autor;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Autor> autoresBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Autor a = new Autor(linha);
            autoresBanco.add(a);
        }
        
        Autor autorResultado = null;
        
        for (Autor a : autoresBanco) {
            if (autorParaConsultar.getIdAutor() != null) {
                if (a.getIdAutor().equals(autorParaConsultar.getIdAutor())) {
                    autorResultado = a;
                } 
            } else if (a.getNome() != null && !a.getNome().equals("")) {
                if (a.getNome().equals(autorParaConsultar.getNome())) {
                    autorResultado = a;
                }                
            } else {
                if (a.equals(autorParaConsultar)) {
                    autorResultado = a;
                }                                
            }
        }
        return autorResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Autor autorParaAlterar = (Autor) objeto;
        
        Autor autorBanco = (Autor) this.consultar(autorParaAlterar);
        
        this.excluir(autorBanco);

        Autor autorAtualizado = autorBanco.clone(autorParaAlterar);
        
        this.incluir(autorAtualizado);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Autor autorParaExcluir = (Autor) objeto;
        
        List<Autor> autores = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Autor autorBanco = new Autor(linha);
            
            if (!autorBanco.equals(autorParaExcluir)) {
                autores.add(autorBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Autor a : autores) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Autor> autores = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Autor autorBanco = new Autor(linha);
            autores.add(autorBanco);
        }
        
        Integer ultimoId = null;
        
        if (!autores.isEmpty()) {
            Autor autor = autores.get(autores.size() -1);
            ultimoId = autor.getIdAutor();
        }
        return ultimoId;        
        
    }    
}
