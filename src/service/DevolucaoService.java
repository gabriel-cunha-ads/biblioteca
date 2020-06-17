package service;
import entity.Devolucao;
import entity.Emprestimo;
import entity.EnumSituacaoMulta;
import entity.Funcionario;
import entity.Multa;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import repository.DevolucaoPersistenciaImpl;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class DevolucaoService {

    private final String NOME_ARQUIVO_BANCO_DEVOLUCAO = "devolucaoBd.txt";
    
    private DevolucaoPersistenciaImpl devolucaoPersistenciaImpl;
    
    private EmprestimoService emprestimoService;
    
    private MultaService multaService;

    
    public DevolucaoService() throws Exception {
        this.devolucaoPersistenciaImpl = new DevolucaoPersistenciaImpl(NOME_ARQUIVO_BANCO_DEVOLUCAO);
        this.emprestimoService = new EmprestimoService();
    }
    
    public void incluir(Devolucao devolucao) throws Exception {
        
        Devolucao devolucaoBanco = (Devolucao) devolucaoPersistenciaImpl.consultar(devolucao);

        if (devolucaoBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        devolucao.setId(id);

        devolucaoPersistenciaImpl.incluir(devolucao);
    }
    
    public Devolucao consultar(Devolucao devolucao) throws Exception {
       
        Devolucao devolucaoBanco = null;
        
        List<Devolucao> devolucoesBanco = devolucaoPersistenciaImpl.listar();
            
        if (devolucao.getId() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            devolucaoBanco = devolucoesBanco.stream()
                                        .filter(d -> devolucao.getId().equals(d.getId())) 
                                        .findFirst()
                                        .orElse(null);
            
        } else if (devolucao.getEmprestimo() != null && devolucao.getEmprestimo().getId() != null){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            devolucaoBanco = devolucoesBanco.stream()
                                        .filter(d -> devolucao.getEmprestimo().getId().equals(d.getEmprestimo().getId())) 
                                        .findFirst()
                                        .orElse(null); 
        } 
        return devolucaoBanco;
    }    
    
    public List<Devolucao> listar() throws Exception {
        List<Devolucao> devolucoes = devolucaoPersistenciaImpl.listar();

        return devolucoes;
    }      
    
    public void alterar(Devolucao devolucao) throws Exception{
        Devolucao devolucaoBanco = (Devolucao) devolucaoPersistenciaImpl.consultar(devolucao);

        if (devolucaoBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        devolucaoPersistenciaImpl.alterar(devolucao);
    }    
    
    public void excluir(Devolucao devolucao) throws Exception{

        Devolucao devolucaoBanco = (Devolucao) devolucaoPersistenciaImpl.consultar(devolucao);

        if (devolucaoBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        devolucaoPersistenciaImpl.excluir(devolucao);
    }   
    
    public List<Devolucao> excluir(List<Devolucao> devolucoes) throws Exception{
        
        List<Devolucao> devolucoesNaoExistentesBanco = new ArrayList<>();
        
        for (Devolucao a : devolucoes) {
            Devolucao devolucaoBanco = (Devolucao) devolucaoPersistenciaImpl.consultar(a);
            
            if (devolucaoBanco != null) {
                devolucaoPersistenciaImpl.excluir(a);
            } else {
                devolucoesNaoExistentesBanco.add(a);
            }
        }
        
        return devolucoesNaoExistentesBanco;
    }    

    public void incluirMultaPorAtraso() {
        
    }

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = devolucaoPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }

    public boolean hasMultasPendentes(Funcionario funcionario) throws Exception {
        return multaService.hasMultasPendentes(new Multa(funcionario, EnumSituacaoMulta.PENDENTE));
    }
    
}
