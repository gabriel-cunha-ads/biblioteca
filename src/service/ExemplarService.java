package service;
import entity.EnumFiltroExemplar;
import entity.EnumSituacaoExemplar;
import entity.Exemplar;
import entity.Livro;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import repository.ExemplarPersistenciaImpl;
import service.strategy.FiltroStrategy;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ExemplarService {

    private final String NOME_ARQUIVO_BANCO_AUTOR = "exemplarBd.txt";
    
    private ExemplarPersistenciaImpl exemplarPersistenciaImpl;
    
    private LivroService livroService;
    
    public ExemplarService() throws Exception {
        this.exemplarPersistenciaImpl = new ExemplarPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
        this.livroService   = new LivroService();
    }
    
    public void incluir(Exemplar exemplar) throws Exception {
        
//      Consulta se o exemplar ja existe na base de dados
        Exemplar exemplarBanco = (Exemplar) exemplarPersistenciaImpl.consultar(exemplar);

        if (exemplarBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        exemplar.setId(id);

        exemplarPersistenciaImpl.incluir(exemplar);
    }
    
    public Exemplar consultar(Exemplar exemplar) throws Exception {
       
        Exemplar exemplarBanco = null;
        
        List<Exemplar> exemplaresBanco = exemplarPersistenciaImpl.listar();
            
        if (exemplar.getId() != null) {
    //      Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            exemplarBanco = exemplaresBanco.stream()
                                    .filter(e -> exemplar.getId().equals(e.getId())) 
                                    .findFirst()
                                    .orElse(null);
        } else {
    //      Percorrendo a lista com API Stream do java 8 e filtrando pelo objeto.
            exemplarBanco = exemplaresBanco.stream()
                                    .filter(e -> exemplar.equals(e)) 
                                    .findFirst()
                                    .orElse(null);
        }
        return exemplarBanco;
    }  
    
    public Exemplar consultar(Exemplar exemplar, EnumFiltroExemplar colunaFiltro) throws Exception {
       
        Object exemplares = (Object) exemplarPersistenciaImpl.listar();
        
        Object exemplarParaPesquisa = exemplar;
            
        FiltroStrategy filtro = colunaFiltro.filtrarPor(); 
        
        Exemplar exemplarResultado = (Exemplar) filtro.filtrarPor(exemplarParaPesquisa, exemplares);
        
        return exemplarResultado;
    }       
    
    public Exemplar consultarPor(Livro livro) throws Exception {
       
        Exemplar exemplarBanco = null;
        
        List<Exemplar> exemplaresBanco = exemplarPersistenciaImpl.listar();

//      Percorrendo a lista com API Stream do java 8 e filtrando pelo objeto.
        exemplarBanco = exemplaresBanco.stream()
                                .filter(a -> livro.equals(a.getLivro())) 
                                .findFirst()
                                .orElse(null);
        return exemplarBanco;
    }      
    
    public List<Exemplar> listar() throws Exception {
        List<Exemplar> exemplaresBanco = exemplarPersistenciaImpl.listar();
        
        List<Livro> livros = exemplaresBanco.stream()
                                            .map(Exemplar::getLivro)
                                            .distinct()
                                            .collect(Collectors.toList());
        
        List<Exemplar> exemplaresRetorno = new ArrayList<>();
        
        for (Exemplar e :exemplaresBanco) {
            for (Livro l : livros) {
                if (!e.getLivro().getId().equals(l.getId())) {
                  exemplaresRetorno.add(e);
                }
            }
        }
        
        return exemplaresRetorno;
    }
    
  
    public List<Exemplar> listarPor(EnumSituacaoExemplar situacao) throws Exception {
        
        List<Exemplar> exemplaresBanco = exemplarPersistenciaImpl.listar();
  
        List<Exemplar> exemplaresResultado = new ArrayList();
        
        for (Exemplar e : exemplaresBanco) {
            if (e.getSituacao().equals(situacao)) {
                exemplaresResultado.add(e);
            }
        }
        return exemplaresResultado;
    }    
    
    public List<Exemplar> listarPor(List<Exemplar> exemplares) throws Exception {
        
        List<Exemplar> exemplaresBanco = exemplarPersistenciaImpl.listar();
  
//      Percorrendo a lista com API Stream do java 8 e filtrando pelo objeto.
         return exemplaresBanco.stream()
                                .filter(e -> exemplares.contains(e)) 
                                .collect(Collectors.toList());
    }      
    
    
    public void excluir(Exemplar exemplar) throws Exception{

        Exemplar exemplarBanco = (Exemplar) exemplarPersistenciaImpl.consultar(exemplar);

        if (exemplarBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        exemplarPersistenciaImpl.excluir(exemplar);
    }   
    
    public List<Exemplar> excluir(List<Exemplar> exemplares) throws Exception{
        
        List<Exemplar> exemplaresNaoExistentesBanco = new ArrayList<>();
        
        for (Exemplar a : exemplares) {
            
            Exemplar exemplarBanco = (Exemplar) exemplarPersistenciaImpl.consultar(a);
            
            if (exemplarBanco != null) {
                exemplarPersistenciaImpl.excluir(a);
            } else {
                exemplaresNaoExistentesBanco.add(a);
            }
        }
        
        return exemplaresNaoExistentesBanco;
    }   
    
    public void alterar(Exemplar exemplar) throws Exception{
        Exemplar autorBanco = (Exemplar) exemplarPersistenciaImpl.consultar(exemplar);

        if (autorBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        exemplarPersistenciaImpl.alterar(exemplar);
    }      

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = exemplarPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }

    public List<Exemplar> preencherExemplaresComLivros(List<Exemplar> exemplaresTabela) throws Exception {
        List<Exemplar> exemplaresRetorno = new ArrayList();
        
        for (Exemplar e : exemplaresTabela) {
            Livro livroBanco = livroService.consultar(e.getLivro());
            e.setLivro(livroBanco);
            exemplaresRetorno.add(e);
        }
        return exemplaresRetorno;
    }
    

}
