package repository;

import entity.Multa;
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
public class MultaPersistenciaImpl implements Persistencia<Multa>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public MultaPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object multa) throws Exception {
        
        List<Multa> multasBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, multasBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(multa.toString());

//      Fecha o arquivo
        bw.close();
    }

    @Override
    public List<Multa> listar() throws Exception {
        List<Multa> multas = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Multa multa = new Multa(linha);
            multas.add(multa);
        }
        
        br.close();
        
        return multas;
    }

    @Override
    public Object consultar(Object multa) throws Exception {
        
        Multa multaParaConsulta = (Multa) multa;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Multa> multasBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Multa a = new Multa(linha);
            multasBanco.add(a);
        }
        
        Multa multaResultado = null;
        
        for (Multa m : multasBanco) {
            if (multaParaConsulta.getId() != null) {
                if (m.getId().equals(multaParaConsulta.getId())) {
                    multaResultado = m;
                }
            } else if (!UtilObjetos.ehNuloOuVazio(multaParaConsulta.getFuncionario()) 
                        && !UtilObjetos.ehNuloOuVazio(multaParaConsulta.getFuncionario().getMatricula()) ) {
                
                if (m.getFuncionario().getMatricula().equals(multaParaConsulta.getFuncionario().getMatricula())) {
                    multaResultado = m;
                }
                
            } else if (!UtilObjetos.ehNuloOuVazio(multaParaConsulta.getDevolucao()) && 
                        !UtilObjetos.ehNuloOuVazio(multaParaConsulta.getDevolucao().getId())) {
                
                if (m.getDevolucao().getId().equals(multaParaConsulta.getDevolucao().getId())) {
                    multaResultado = m;
                }
            }
                    
        }
        return multaResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Multa multaParaAlterar = (Multa) objeto;
        
        Multa multaBanco = (Multa) this.consultar(multaParaAlterar);
        
        this.excluir(multaBanco);

        this.incluir(multaParaAlterar);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Multa multaParaExcluir = (Multa) objeto;
        
        List<Multa> multas = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Multa multaBanco = new Multa(linha);
            
            if (!multaBanco.equals(multaParaExcluir)) {
                multas.add(multaBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Multa a : multas) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Multa> multas = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Multa multaBanco = new Multa(linha);
            multas.add(multaBanco);
        }
        
        Integer ultimoId = null;
        
        if (!multas.isEmpty()) {
            Multa multa = multas.get(multas.size() -1);
            ultimoId = multa.getId();
        }
        return ultimoId;        
        
    }    
}
