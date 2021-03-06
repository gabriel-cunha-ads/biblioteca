package service;
import entity.EnumFiltroLivro;
import entity.Exemplar;
import entity.Livro;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import repository.LivroPersistenciaImpl;
import service.strategy.FiltroStrategy;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroService {

    private final String NOME_ARQUIVO_BANCO_AUTOR = "livroBd.txt";
    
    private LivroPersistenciaImpl livroPersistenciaImpl;
    
    private ExemplarService exemplarService;

    public LivroService() throws Exception {
        this.livroPersistenciaImpl = new LivroPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(Livro livro) throws Exception {
        
//      Consulta se o livro ja existe na base de dados
        Livro livroBanco = (Livro) livroPersistenciaImpl.consultar(livro);

        if (livroBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        livro.setId(id);

        livroPersistenciaImpl.incluir(livro);
    }
    
    public Livro consultar(Livro livro) throws Exception {
       
        Livro livroBanco = null;
        
        List<Livro> livrosBanco = livroPersistenciaImpl.listar();
            
        if (livro.getId() != null) {
//      Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
        livroBanco = livrosBanco.stream()
                                .filter(a -> livro.getId().equals(a.getId())) 
                                .findFirst()
                                .orElse(null);
        } else {
//      Percorrendo a lista com API Stream do java 8 e filtrando pelo objeto.
        livroBanco = livrosBanco.stream()
                                .filter(a -> livro.equals(a)) 
                                .findFirst()
                                .orElse(null);
        }
        
        return livroBanco;
    }  
    
    public Livro consultar(Livro livro, EnumFiltroLivro colunaFiltro) throws Exception {
       
        Object livrosBanco = (Object) livroPersistenciaImpl.listar();
        
        Object livroParaPesquisa = livro;
            
        FiltroStrategy filtro = colunaFiltro.filtrarPor(); 
        
        Livro LivroResultado = (Livro) filtro.filtrarPor(livroParaPesquisa, livrosBanco);
        
        return LivroResultado;
    }      
    
    public List<Livro> listar() throws Exception {
        
        List<Livro> livros = livroPersistenciaImpl.listar();

        return livros;
    }  

    public List<Livro> listarPor(List<Exemplar> exemplares) throws Exception {
        
         List<Livro> livros = this.listar();
         
         List<Livro> livrosResultado = new ArrayList();
         
         for (Livro l : livros) {
             for (Exemplar e : exemplares) {
                 if (e.getLivro().getId().equals(l.getId())) {
                     livrosResultado.add(l);
                 }
             }
         }
         return livrosResultado;
} 
    
    public void alterar(Livro livro) throws Exception{
       
        Livro livroBanco = (Livro) livroPersistenciaImpl.consultar(livro);

        if (livroBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        livroPersistenciaImpl.alterar(livro);
    }    
    
    public void excluir(Livro livro) throws Exception{

        Livro livroBanco = (Livro) livroPersistenciaImpl.consultar(livro);

        if (livroBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        livroPersistenciaImpl.excluir(livro);
    }   
    
    public List<Livro> excluir(List<Livro> livros) throws Exception{
        
        List<Livro> livrosNaoExistentesBanco = new ArrayList<>();
        
        for (Livro a : livros) {
            
            Livro livroBanco = (Livro) livroPersistenciaImpl.consultar(a);
            
            if (livroBanco != null) {
                livroPersistenciaImpl.excluir(a);
            } else {
                livrosNaoExistentesBanco.add(a);
            }
        }
        
        return livrosNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = livroPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    

}
