package repository;

import entity.Usuario;
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
public class UsuarioPersistenciaImpl implements Persistencia<Usuario>{
    
    private final String arquivoBancoDados;
    
    private final String PATH_BANCO_DADOS;
    
    
    public UsuarioPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object usuario) throws Exception {
        
        List<Usuario> usuariosBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, usuariosBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(usuario.toString());

//      Fecha o arquivo
        bw.close();
    }

    @Override
    public List<Usuario> listar() throws Exception {
        List<Usuario> usuarios = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Usuario usuario = new Usuario(linha);
            usuarios.add(usuario);
        }
        
        br.close();
        
        return usuarios;
    }

    @Override
    public Object consultar(Object usuario) throws Exception {
        
        Usuario usuarioParaConsultar = (Usuario) usuario;
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Usuario> usuariosBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Usuario a = new Usuario(linha);
            usuariosBanco.add(a);
        }
        
        Usuario usuarioResultado = null;
        
        for (Usuario a : usuariosBanco) {
            if (usuarioParaConsultar.getIdUsuario() == null) {
                if (a.getLoginMatricula().equals(usuarioParaConsultar.getLoginMatricula())) {
                    usuarioResultado = a;
                } 
            } else if (a.getFuncionario() != null) {
                if (a.getFuncionario().equals(usuarioParaConsultar.getFuncionario())) {
                    usuarioResultado = a;
                }                                
            } else {
                    if (a.equals(usuarioParaConsultar)) {
                    usuarioResultado = a;
                }
            }
        }
        return usuarioResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Usuario usuarioParaAlterar = (Usuario) objeto;
        
        Usuario usuarioBanco = (Usuario) this.consultar(usuarioParaAlterar);
        
        this.excluir(usuarioBanco);

        Usuario usuarioAtualizado = usuarioBanco.from(usuarioParaAlterar);
        
        this.incluir(usuarioAtualizado);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Usuario usuarioParaExcluir = (Usuario) objeto;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Usuario usuarioBanco = new Usuario(linha);
            
            if (!usuarioBanco.equals(usuarioParaExcluir)) {
                usuarios.add(usuarioBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Usuario a : usuarios) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Usuario> usuarios = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Usuario usuarioBanco = new Usuario(linha);
            usuarios.add(usuarioBanco);
        }
        
        Integer ultimoId = null;
        
        if (!usuarios.isEmpty()) {
            Usuario usuario = usuarios.get(usuarios.size() -1);
            ultimoId = usuario.getIdUsuario();
        }
        return ultimoId;        
    }    
    
    public void consultarLogado() {
        
    }
}
