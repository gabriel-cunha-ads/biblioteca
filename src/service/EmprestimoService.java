package service;
import entity.Emprestimo;
import entity.EnumSituacaoMulta;
import entity.Funcionario;
import entity.Livro;
import entity.Multa;

import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import repository.LivroPersistenciaImpl;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class EmprestimoService {

    private final String NOME_ARQUIVO_BANCO_EMPRESTIMO = "emprestimoBd.txt";
    
    private LivroPersistenciaImpl livroPersistenciaImpl;
    
    private FuncionarioService funcionarioService;
    
    private MultaService multaService;
    

    public EmprestimoService() throws Exception {
        this.livroPersistenciaImpl = new LivroPersistenciaImpl(NOME_ARQUIVO_BANCO_EMPRESTIMO);
//        this.funcionarioService = new FuncionarioService();
        this.multaService = new MultaService();
    }
    
    public void incluir(Livro livro) throws Exception {
        
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
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            livroBanco = livrosBanco.stream()
                                        .filter(a -> livro.getId().equals(a.getId())) 
                                        .findFirst()
                                        .orElse(null);
            
        } else if (!"".equals(livro.getTitulo())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            livroBanco = livrosBanco.stream()
                                        .filter(a -> livro.getTitulo().equals(a.getTitulo())) 
                                        .findFirst()
                                        .orElse(null); 
        } 
        
        return livroBanco;
    }    
    
    public List<Livro> listar() throws Exception {
        List<Livro> livros = livroPersistenciaImpl.listar();

        return livros;
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

    public boolean isPermitido(Funcionario funcionario) throws Exception {
        
        Funcionario funcionarioBanco = funcionarioService.consultar(funcionario);
        
        if (funcionarioBanco == null ) {
            throw new Exception();
        }
        
        boolean hasPendenciasMulta = multaService.hasMultasPendentes(new Multa(funcionario, EnumSituacaoMulta.PENDENTE));
        
        boolean isFuncionarioPermitido = funcionarioBanco.isAtivo() 
                                        && funcionarioBanco.isUsuarioSistema() 
                                        && !hasPendenciasMulta;
        
        return isFuncionarioPermitido;
    }
}
