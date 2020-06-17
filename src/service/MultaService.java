package service;
import entity.EnumSituacaoMulta;
import entity.Funcionario;
import entity.Multa;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import repository.MultaPersistenciaImpl;
import util.UtilObjetos;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class MultaService {

    private final String NOME_ARQUIVO_BANCO_AUTOR = "multaBd.txt";
    
    private MultaPersistenciaImpl multaPersistenciaImpl;
    
    private DevolucaoService devolucaoService;
    
    public MultaService() throws Exception {
        this.multaPersistenciaImpl = new MultaPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(Multa multa) throws Exception {
        
        Multa multaBanco = (Multa) multaPersistenciaImpl.consultar(multa);

        if (multaBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer matricula = gerarNovoId();

        multa.setId(matricula);

        multaPersistenciaImpl.incluir(multa);
    }
    
    public Multa consultar(Multa multa) throws Exception {
       
        Multa multaBanco = null;
        
        List<Multa> multasBanco = multaPersistenciaImpl.listar();
            
        if (multa.getId() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            multaBanco = multasBanco.stream()
                                        .filter(a -> multa.getId().equals(a.getId())) 
                                        .findFirst()
                                        .orElse(null);
            
        } else if (!UtilObjetos.ehNuloOuVazio(multa.getFuncionario()) && 
                    !UtilObjetos.ehNuloOuVazio(multa.getFuncionario().getMatricula())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            multaBanco = multasBanco.stream()
                                        .filter(a -> multa.getFuncionario().getMatricula().equals(a.getFuncionario().getMatricula())) 
                                        .findFirst()
                                        .orElse(null); 
            
        } else if (!UtilObjetos.ehNuloOuVazio(multa.getDevolucao()) && 
                    !UtilObjetos.ehNuloOuVazio(multa.getFuncionario().getMatricula())){ 
            
        }
        return multaBanco;
    }    
        
    public List<Multa> listarPor(Funcionario funcionario, EnumSituacaoMulta situacaoMulta) throws Exception {  
        List<Multa> multasBanco = multaPersistenciaImpl.listar();
        
        List<Multa> multasResultado = new ArrayList<Multa>();
        
        for (Multa m : multasBanco) {
            if (m.getFuncionario().getMatricula().equals(funcionario.getMatricula()) 
                    && m.getSituacao().equals(situacaoMulta)) {
                multasResultado.add(m);
            }
        }
        return multasResultado;
    }
    
    public List<Multa> listar() throws Exception {
        List<Multa> multas = multaPersistenciaImpl.listar();

        return multas;
    }      
    
    public void alterar(Multa multa) throws Exception{
        Multa multaBanco = (Multa) multaPersistenciaImpl.consultar(multa);

        if (multaBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        multaPersistenciaImpl.alterar(multa);
    }    
    
    public void excluir(Multa multa) throws Exception{

        Multa multaBanco = (Multa) multaPersistenciaImpl.consultar(multa);

        if (multaBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        multaPersistenciaImpl.excluir(multa);
    }   
    
    public List<Multa> excluir(List<Multa> multas) throws Exception{
        
        List<Multa> multasNaoExistentesBanco = new ArrayList<>();
        
        for (Multa a : multas) {
            Multa multaBanco = (Multa) multaPersistenciaImpl.consultar(a);
            
            if (multaBanco != null) {
                multaPersistenciaImpl.excluir(a);
            } else {
                multasNaoExistentesBanco.add(a);
            }
        }
        return multasNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = multaPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    
    public boolean hasMultasPendentes(Multa multa) throws Exception {
        List<Multa> multas = listarPor(multa.getFuncionario(), multa.getSituacao());
        return !multas.isEmpty();
    }

}
