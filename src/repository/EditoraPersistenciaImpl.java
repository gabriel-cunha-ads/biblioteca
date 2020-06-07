package repository;

import entity.Editora;
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
public class EditoraPersistenciaImpl implements Persistencia<Editora>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public EditoraPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object editora) throws Exception {
        
        List<Editora> editorasBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, editorasBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(editora.toString());

//      Fecha o arquivo
        bw.close();
    }

    @Override
    public List<Editora> listar() throws Exception {
        List<Editora> editoras = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Editora editora = new Editora(linha);
            editoras.add(editora);
        }
        
        br.close();
        
        return editoras;
    }

    @Override
    public Object consultar(Object editora) throws Exception {
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Editora> editorasBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Editora a = new Editora(linha);
            editorasBanco.add(a);
        }
        
        Editora editoraResultado = null;
        
        for (Editora a : editorasBanco) {
            if (a.equals(editora)) {
                editoraResultado = a;
            }
        }
        return editoraResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Editora editoraParaAlterar = (Editora) objeto;
        
        Editora editoraBanco = (Editora) this.consultar(editoraParaAlterar);
        
        this.excluir(editoraBanco);

        Editora editoraAtualizada = editoraBanco.from(editoraParaAlterar);
        
        this.incluir(editoraAtualizada);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Editora editoraParaExcluir = (Editora) objeto;
        
        List<Editora> editoras = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Editora editoraBanco = new Editora(linha);
            
            if (!editoraBanco.equals(editoraParaExcluir)) {
                editoras.add(editoraBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Editora a : editoras) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Editora> editoras = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Editora editoraBanco = new Editora(linha);
            editoras.add(editoraBanco);
        }
        
        Integer ultimoId = null;
        
        if (!editoras.isEmpty()) {
            Editora editora = editoras.get(editoras.size() -1);
            ultimoId = editora.getIdEditora();
        }
        return ultimoId;        
        
    }    
}
