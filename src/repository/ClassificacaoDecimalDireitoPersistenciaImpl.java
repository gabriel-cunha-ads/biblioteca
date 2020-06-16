package repository;

import entity.ClassificacaoDecimalDireito;
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
public class ClassificacaoDecimalDireitoPersistenciaImpl implements Persistencia<ClassificacaoDecimalDireito>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public ClassificacaoDecimalDireitoPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object cdd) throws Exception {
        
        List<ClassificacaoDecimalDireito> cddsBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, cddsBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(cdd.toString());

//      Fecha o arquivo
        bw.close();
    }



    @Override
    public List<ClassificacaoDecimalDireito> listar() throws Exception {
        List<ClassificacaoDecimalDireito> cdds = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            ClassificacaoDecimalDireito cdd = new ClassificacaoDecimalDireito(linha);
            cdds.add(cdd);
        }
        
        br.close();
        
        return cdds;
    }

    @Override
    public Object consultar(Object cdd) throws Exception {
        
        ClassificacaoDecimalDireito cddParaConsultar = (ClassificacaoDecimalDireito) cdd;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<ClassificacaoDecimalDireito> cddsBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            ClassificacaoDecimalDireito a = new ClassificacaoDecimalDireito(linha);
            cddsBanco.add(a);
        }
        
        ClassificacaoDecimalDireito cddResultado = null;
        
        for (ClassificacaoDecimalDireito c : cddsBanco) {
            if (cddParaConsultar.getIdClassificacaoDecimal() == null) {
                if (c.getCodigoCDD().trim().equals(cddParaConsultar.getCodigoCDD().trim())) {   //
                    cddResultado = c;
                } 
                if (c.getDescricao().trim().equals(cddParaConsultar.getDescricao().trim())) {
                    cddResultado = c;
                } 
            } else {
                if (c.equals(cdd)) {
                    cddResultado = c;
                }                
            }
        }
        return cddResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        ClassificacaoDecimalDireito cddParaAlterar = (ClassificacaoDecimalDireito) objeto;
        
        ClassificacaoDecimalDireito cddBanco = (ClassificacaoDecimalDireito) this.consultar(cddParaAlterar);
        
        this.excluir(cddBanco);

        ClassificacaoDecimalDireito cddAtualizado = cddBanco.from(cddParaAlterar);
        
        this.incluir(cddAtualizado);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        ClassificacaoDecimalDireito cddParaExcluir = (ClassificacaoDecimalDireito) objeto;
        
        List<ClassificacaoDecimalDireito> cdds = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            ClassificacaoDecimalDireito cddBanco = new ClassificacaoDecimalDireito(linha);
            
            if (!cddBanco.equals(cddParaExcluir)) {
                cdds.add(cddBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (ClassificacaoDecimalDireito cdd : cdds) {
            bw.write(cdd + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<ClassificacaoDecimalDireito> cdds = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            ClassificacaoDecimalDireito cddBanco = new ClassificacaoDecimalDireito(linha);
            cdds.add(cddBanco);
        }
        
        Integer ultimoId = null;
        
        if (!cdds.isEmpty()) {
            ClassificacaoDecimalDireito cdd = cdds.get(cdds.size() -1);
            ultimoId = cdd.getIdClassificacaoDecimal();
        }
        return ultimoId;        
        
    }    
}
