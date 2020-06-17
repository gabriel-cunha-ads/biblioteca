package repository;

import entity.Funcionario;
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
public class FuncionarioPersistenciaImpl implements Persistencia<Funcionario>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public FuncionarioPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object funcionario) throws Exception {
        
        List<Funcionario> funcionariosBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, funcionariosBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(funcionario.toString());

//      Fecha o arquivo
        bw.close();
    }

    @Override
    public List<Funcionario> listar() throws Exception {
        List<Funcionario> funcionarios = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Funcionario funcionario = new Funcionario(linha);
            funcionarios.add(funcionario);
        }
        
        br.close();
        
        return funcionarios;
    }

    @Override
    public Object consultar(Object funcionario) throws Exception {
        
        Funcionario funcionarioParaConsultar = (Funcionario) funcionario;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Funcionario> funcionariosBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Funcionario a = new Funcionario(linha);
            funcionariosBanco.add(a);
        }
        
        Funcionario funcionarioResultado = null;
        
        for (Funcionario a : funcionariosBanco) {
            if (funcionarioParaConsultar.getMatricula() == null) {
                if (a.getMatricula().equals(funcionarioParaConsultar.getMatricula())) {
                    funcionarioResultado = a;
                } else if (a.getNome().trim().equals(funcionarioParaConsultar.getNome().trim())) {
                    funcionarioResultado = a;
                } 
            } else {
                if (a.equals(funcionario)) {
                    funcionarioResultado = a;
                }                
            }
        }
        return funcionarioResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Funcionario funcionarioParaAlterar = (Funcionario) objeto;
        
        Funcionario funcionarioBanco = (Funcionario) this.consultar(funcionarioParaAlterar);
        
        this.excluir(funcionarioBanco);

        this.incluir(funcionarioParaAlterar);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Funcionario funcionarioParaExcluir = (Funcionario) objeto;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Funcionario funcionarioBanco = new Funcionario(linha);
            
            if (!funcionarioBanco.equals(funcionarioParaExcluir)) {
                funcionarios.add(funcionarioBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Funcionario a : funcionarios) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Funcionario> funcionarios = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Funcionario funcionarioBanco = new Funcionario(linha);
            funcionarios.add(funcionarioBanco);
        }
        
        Integer ultimoId = null;
        
        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(funcionarios.size() -1);
            ultimoId = funcionario.getMatricula();
        }
        return ultimoId;        
        
    }    
}
