package service;
import entity.Autor;
import exception.RegistroExistenteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.AutorPersistenciaImpl;
/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorService {

    private AutorPersistenciaImpl autorPersistenciaImpl;
    
    private final String NOME_ARQUIVO_BANCO_AUTOR = "autorBd.txt";

    public AutorService() throws Exception {
        this.autorPersistenciaImpl = new AutorPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(Autor autor) throws Exception {

//          Consulta autor
            Autor autorBanco = autorPersistenciaImpl.consultar(autor.getNome());

            if (autorBanco != null) {
               throw new RegistroExistenteException(); 
            }
            
            Integer id = gerarNovoId();
    
            autor.setId(id);
            
    //      inlcui o autor
            autorPersistenciaImpl.incluir(autor);
            
    }
    
    public Autor consultar(String textoPesquisa) throws Exception {
        try {
            
            Autor autorBanco = autorPersistenciaImpl.consultar(textoPesquisa);
            
            return autorBanco;
            
        } catch (Exception ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, "Erro ao incluir o autor.", ex);
            throw new Exception(ex);
        }
    }    
    
    public List<Autor> listar() throws Exception {
        try {
            
            List<Autor> autores = autorPersistenciaImpl.listar();
            
            return autores;
            
        } catch (Exception ex) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, "Erro ao incluir o autor.", ex);
            throw new Exception(ex);
        }
    }      

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = autorPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
}
