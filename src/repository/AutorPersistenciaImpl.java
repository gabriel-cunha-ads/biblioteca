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
import sun.reflect.generics.factory.GenericsFactory;
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
        
        List<Autor> autores = listar();
  
        UtilArquivo.removerEspacosBranco(arquivoBancoDados, autores);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(autor + "\n");

//      Fecha o arquivo
        bw.close();
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void excluir(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Autor consultar(String nome) throws Exception {
        
        List<Autor> autores = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Autor autorBanco = new Autor(linha);
            autores.add(autorBanco);
        }
        
        Autor autorBanco = null;
        
        for (Autor a : autores) {
            if (a.getNome().equals(nome)) {
                autorBanco = a;
            }
        }
        return autorBanco;
    }

@Override
    public Autor consultar(Autor autor) throws Exception {
        List<Autor> autores = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Autor autorBanco = new Autor(linha);
            autores.add(autorBanco);
        }
        
        Autor autorBanco = null;
        
        for (Autor a : autores) {
            if (a.equals(autor)) {
                autorBanco = a;
            }
        }
        return autorBanco;
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
            ultimoId = autor.getId();
        }
        return ultimoId;        
        
    }



}
