package repository;

import entity.Exemplar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import repository.interfaces.Persistencia;
import util.UtilArquivo;
import util.UtilObjetos;
import util.UtilSistema;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ExemplarPersistenciaImpl implements Persistencia<Exemplar>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public ExemplarPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object exemplar) throws Exception {
        
        List<Exemplar> exemplaresBanco = listar();
        if (!UtilObjetos.ehNuloOuVazio(exemplaresBanco)) {
            UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, exemplaresBanco);
        }
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(exemplar.toString());

//      Fecha o arquivo
        bw.close();
    }



    @Override
    public List<Exemplar> listar() throws Exception {
        List<Exemplar> exemplares = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Exemplar exemplar = new Exemplar(linha);
            exemplares.add(exemplar);
        }
        
        br.close();
        
        return exemplares;
    }

    @Override
    public Exemplar consultar(Object exemplar) throws Exception {
        
        Exemplar exemplarParaConsultar = (Exemplar) exemplar;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Exemplar> exemplaresBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Exemplar a = new Exemplar(linha);
            exemplaresBanco.add(a);
        }
        
        Exemplar exemplarResultado = null;
        
        for (Exemplar a : exemplaresBanco) {
            if (exemplarParaConsultar.getId() != null) {
                if (a.getId() ==  exemplarParaConsultar.getId()) {
                    exemplarResultado = a;
                }
            } else {
                if (a.equals(exemplar)) {
                    exemplarResultado = a;
                }                
            }
        }
        return exemplarResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Exemplar exemplarParaAlterar = (Exemplar) objeto;
        
        this.excluir(exemplarParaAlterar);

        this.incluir(exemplarParaAlterar);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Exemplar exemplarParaExcluir = (Exemplar) objeto;
        
        List<Exemplar> exemplares = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Exemplar exemplarBanco = new Exemplar(linha);
            
            if (!exemplarBanco.getId().equals(exemplarParaExcluir.getId())) {
                exemplares.add(exemplarBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Exemplar a : exemplares) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Exemplar> exemplares = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Exemplar exemplarBanco = new Exemplar(linha);
            exemplares.add(exemplarBanco);
        }
        
        Integer ultimoId = null;
        
        if (!exemplares.isEmpty()) {
            Exemplar exemplar = exemplares.get(exemplares.size() -1);
            ultimoId = exemplar.getId();
        }
        return ultimoId;        
        
    }    
}
