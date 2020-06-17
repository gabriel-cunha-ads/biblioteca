package service;
import entity.Funcionario;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.FuncionarioPersistenciaImpl;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class FuncionarioService {

    private final String NOME_ARQUIVO_BANCO_FUNCIONARIO = "funcionarioBd.txt";
    
    private FuncionarioPersistenciaImpl funcionarioPersistenciaImpl;
    
    private MultaService multaService;
    
    public FuncionarioService() throws Exception {
        this.funcionarioPersistenciaImpl = new FuncionarioPersistenciaImpl(NOME_ARQUIVO_BANCO_FUNCIONARIO);
//        this.multaService = new MultaService();
    }
    
    public void incluir(Funcionario funcionario) throws Exception {
        
        Funcionario funcionarioBanco = (Funcionario) funcionarioPersistenciaImpl.consultar(funcionario);

        if (funcionarioBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer matricula = gerarNovoId();

        funcionario.setMatricula(matricula);

        funcionarioPersistenciaImpl.incluir(funcionario);
    }
    
    public Funcionario consultar(Funcionario funcionario) throws Exception {
       
        Funcionario funcionarioBanco = null;
        
        List<Funcionario> funcionariosBanco = funcionarioPersistenciaImpl.listar();
            
        if (funcionario.getMatricula() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            funcionarioBanco = funcionariosBanco.stream()
                                        .filter(a -> funcionario.getMatricula().equals(a.getMatricula())) 
                                        .findFirst()
                                        .orElse(null);
            
        } else if (!"".equals(funcionario.getNome())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            funcionarioBanco = funcionariosBanco.stream()
                                        .filter(a -> funcionario.getNome().equals(a.getNome())) 
                                        .findFirst()
                                        .orElse(null); 
        } 
        return funcionarioBanco;
    }    
    
    public List<Funcionario> listar() throws Exception {
        List<Funcionario> funcionarios = funcionarioPersistenciaImpl.listar();

        return funcionarios;
    }      
    
    public void alterar(Funcionario funcionario) throws Exception{
        Funcionario funcionarioBanco = (Funcionario) funcionarioPersistenciaImpl.consultar(funcionario);

        if (funcionarioBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        funcionarioPersistenciaImpl.alterar(funcionario);
    }    
    
    public void excluir(Funcionario funcionario) throws Exception{

        Funcionario funcionarioBanco = (Funcionario) funcionarioPersistenciaImpl.consultar(funcionario);

        if (funcionarioBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        funcionarioPersistenciaImpl.excluir(funcionario);
    }   
    
    public List<Funcionario> excluir(List<Funcionario> funcionarios) throws Exception{
        
        List<Funcionario> funcionariosNaoExistentesBanco = new ArrayList<>();
        
        for (Funcionario a : funcionarios) {
            Funcionario funcionarioBanco = (Funcionario) funcionarioPersistenciaImpl.consultar(a);
            
            if (funcionarioBanco != null) {
                funcionarioPersistenciaImpl.excluir(a);
            } else {
                funcionariosNaoExistentesBanco.add(a);
            }
        }
        
        return funcionariosNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = funcionarioPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    
    private List<String> getNomesEditoras(List<Funcionario> funcionarios) {
        
        List<String> nomes = new ArrayList();
        
        try {
            List<Funcionario> listaBanco = this.listar();
            for (Funcionario a : listaBanco ) {
                nomes.add(a.getNome());
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nomes;
    }      
}
