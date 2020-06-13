package service;
import entity.Usuario;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import repository.UsuarioPersistenciaImpl;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UsuarioService {

    private UsuarioPersistenciaImpl usuarioPersistenciaImpl;
    
    private final String NOME_ARQUIVO_BANCO_AUTOR = "usuarioBd.txt";

    public UsuarioService() throws Exception {
        this.usuarioPersistenciaImpl = new UsuarioPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(Usuario usuario) throws Exception {
        
        Usuario usuarioBanco = (Usuario) usuarioPersistenciaImpl.consultar(usuario);

        if (usuarioBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        usuario.setIdUsuario(id);

        usuarioPersistenciaImpl.incluir(usuario);
    }
    
    public Usuario consultar(Usuario usuario) throws Exception {
       
        Usuario usuarioBanco = null;
        
        List<Usuario> usuariosBanco = usuarioPersistenciaImpl.listar();
            
        if (usuario.getIdUsuario() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            usuarioBanco = usuariosBanco.stream()
                                        .filter(a -> usuario.getIdUsuario().equals(a.getIdUsuario())) 
                                        .findFirst()
                                        .orElse(null);
            
        } 
//        else if (!"".equals(usuario.getNome())){
//            
////          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
//            usuarioBanco = usuariosBanco.stream()
//                                        .filter(a -> usuario.getNome().equals(a.getNome())) 
//                                        .findFirst()
//                                        .orElse(null); 
//        } 
        
        return usuarioBanco;
    }    
    
    public List<Usuario> listar() throws Exception {
        List<Usuario> usuarios = usuarioPersistenciaImpl.listar();

        return usuarios;
    }      
    
    public void alterar(Usuario usuario) throws Exception{
        Usuario usuarioBanco = (Usuario) usuarioPersistenciaImpl.consultar(usuario);

        if (usuarioBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        usuarioPersistenciaImpl.alterar(usuario);
    }    
    
    public void excluir(Usuario usuario) throws Exception{

        Usuario usuarioBanco = (Usuario) usuarioPersistenciaImpl.consultar(usuario);

        if (usuarioBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        usuarioPersistenciaImpl.excluir(usuario);
    }   
    
    public List<Usuario> excluir(List<Usuario> usuarios) throws Exception{
        
        List<Usuario> usuariosNaoExistentesBanco = new ArrayList<>();
        
        for (Usuario a : usuarios) {
            Usuario usuarioBanco = (Usuario) usuarioPersistenciaImpl.consultar(a);
            
            if (usuarioBanco != null) {
                usuarioPersistenciaImpl.excluir(a);
            } else {
                usuariosNaoExistentesBanco.add(a);
            }
        }
        
        return usuariosNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = usuarioPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    
    public Usuario consultarLogado() {
//        return usuarioPersistenciaImpl.consultarLogado();
        return new Usuario();
    }    
    
//    public Vector<UsuarioVO> carregarVetorComboBox() throws Exception {
//        
//        List<Usuario> usuarios = this.listar();
//        
//        Vector<UsuarioVO> usuariosVOVector = new Vector();
//        
//        for (Usuario usuario : usuarios) {
//            usuariosVOVector.add(usuario.toUsuarioVO());
//        }   
//        
//        return usuariosVOVector;
//    } 

}
