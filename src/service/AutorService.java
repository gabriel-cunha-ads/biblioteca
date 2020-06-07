package service;
import entity.Autor;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
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
        Autor autorBanco = (Autor) autorPersistenciaImpl.consultar(autor);

        if (autorBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        autor.setId(id);

        autorPersistenciaImpl.incluir(autor);
    }
    
    public Autor consultar(Autor autor) throws Exception {
       
        Autor autorBanco = null;
        
        List<Autor> autoresBanco = autorPersistenciaImpl.listar();
            
        if (autor.getId() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            autorBanco = autoresBanco.stream()
                                            .filter(a -> autor.getId().equals(a.getId())) 
                                            .findFirst()
                                            .orElse(null);
        } else if (!"".equals(autor.getNome())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            autorBanco = autoresBanco.stream()
                                            .filter(a -> autor.getNome().equals(a.getNome())) 
                                            .findFirst()
                                            .orElse(null); 
        } 
        
        return autorBanco;
    }    
    
    public List<Autor> listar() throws Exception {
        List<Autor> autores = autorPersistenciaImpl.listar();

        return autores;
    }      
    
    public void alterar(Autor autor) throws Exception{
        Autor autorBanco = (Autor) autorPersistenciaImpl.consultar(autor);

        if (autorBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        autorPersistenciaImpl.alterar(autor);
        
//        autorPersistenciaImpl.excluir(autor);
//
//        autorPersistenciaImpl.incluir(autor);        
    }    
    
    public void excluir(Autor autor) throws Exception{

        Autor autorBanco = (Autor) autorPersistenciaImpl.consultar(autor);

        if (autorBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        autorPersistenciaImpl.excluir(autor);
    }   
    
    public List<Autor> excluir(List<Autor> autores) throws Exception{
        
        List<Autor> autoresNaoExistentesBanco = new ArrayList<>();
        
        for (Autor a : autores) {
            Autor autorBanco = (Autor) autorPersistenciaImpl.consultar(a);
            
            if (autorBanco != null) {
                autorPersistenciaImpl.excluir(a);
            } else {
                autoresNaoExistentesBanco.add(a);
            }
        }
        
        return autoresNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = autorPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    

}
