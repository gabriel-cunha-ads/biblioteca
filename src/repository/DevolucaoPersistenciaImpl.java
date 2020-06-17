package repository;

import entity.Devolucao;
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
public class DevolucaoPersistenciaImpl implements Persistencia<Devolucao>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public DevolucaoPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object devolucao) throws Exception {
        
        List<Devolucao> devolucoesBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, devolucoesBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(devolucao.toString());

//      Fecha o arquivo
        bw.close();
    }



    @Override
    public List<Devolucao> listar() throws Exception {
        List<Devolucao> devolucoes = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Devolucao devolucao = new Devolucao(linha);
            devolucoes.add(devolucao);
        }
        
        br.close();
        
        return devolucoes;
    }

    @Override
    public Object consultar(Object devolucao) throws Exception {
        
        Devolucao devolucaoParaConsultar = (Devolucao) devolucao;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Devolucao> devolucoesBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Devolucao a = new Devolucao(linha);
            devolucoesBanco.add(a);
        }
        
        Devolucao devolucaoResultado = null;
        
        for (Devolucao d : devolucoesBanco) {
            if (devolucaoParaConsultar.getId() != null) {
                if (d.getId().equals(devolucaoParaConsultar.getId())) {
                    devolucaoResultado = d;
                } 
            } else if (d.getEmprestimo() != null && d.getEmprestimo().getId() != null) {
                if (d.getEmprestimo().getId().equals(d.getEmprestimo().getId())) {
                    devolucaoResultado = d;
                }                
            }
        }
        return devolucaoResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Devolucao devolucaoParaAlterar = (Devolucao) objeto;
        
        Devolucao devolucaoBanco = (Devolucao) this.consultar(devolucaoParaAlterar);
        
        this.excluir(devolucaoBanco);

        this.incluir(devolucaoParaAlterar);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Devolucao devolucaoParaExcluir = (Devolucao) objeto;
        
        List<Devolucao> devolucoes = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Devolucao devolucaoBanco = new Devolucao(linha);
            
            if (!devolucaoBanco.equals(devolucaoParaExcluir)) {
                devolucoes.add(devolucaoBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Devolucao a : devolucoes) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Devolucao> devolucoes = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Devolucao devolucaoBanco = new Devolucao(linha);
            devolucoes.add(devolucaoBanco);
        }
        
        Integer ultimoId = null;
        
        if (!devolucoes.isEmpty()) {
            Devolucao devolucao = devolucoes.get(devolucoes.size() -1);
            ultimoId = devolucao.getId();
        }
        return ultimoId;        
        
    }    
}
