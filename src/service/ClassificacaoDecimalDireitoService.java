package service;
import entity.ClassificacaoDecimalDireito;
import entity.vo.ClassificacaoDecimalDireitoVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.ClassificacaoDecimalDireitoPersistenciaImpl;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ClassificacaoDecimalDireitoService {

    private ClassificacaoDecimalDireitoPersistenciaImpl cddPersistenciaImpl;
    
    private final String NOME_ARQUIVO_BANCO_AUTOR = "cddBd.txt";

    public ClassificacaoDecimalDireitoService() throws Exception {
        this.cddPersistenciaImpl = new ClassificacaoDecimalDireitoPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(ClassificacaoDecimalDireito cdd) throws Exception {
        
        ClassificacaoDecimalDireito cddBanco = (ClassificacaoDecimalDireito) cddPersistenciaImpl.consultar(cdd);

        if (cddBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        cdd.setIdClassificacaoDecinal(id);

        cddPersistenciaImpl.incluir(cdd);
    }
    
    public ClassificacaoDecimalDireito consultar(ClassificacaoDecimalDireito cdd) throws Exception {
       
        ClassificacaoDecimalDireito cddBanco = null;
        
        List<ClassificacaoDecimalDireito> cddsBanco = cddPersistenciaImpl.listar();
            
        if (cdd.getIdClassificacaoDecimal()!= null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            cddBanco = cddsBanco.stream()
                                .filter(a -> cdd.getIdClassificacaoDecimal().equals(a.getIdClassificacaoDecimal())) 
                                .findFirst()
                                .orElse(null);
            
        } else if (!"".equals(cdd.getCodigoCDD())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo codigoCDD.
            cddBanco = cddsBanco.stream()
                                        .filter(a -> cdd.getCodigoCDD().equals(a.getCodigoCDD())) 
                                        .findFirst()
                                        .orElse(null); 
        } 
        
        return cddBanco;
    }    
    
    public List<ClassificacaoDecimalDireito> listar() throws Exception {
        List<ClassificacaoDecimalDireito> cdds = cddPersistenciaImpl.listar();

        return cdds;
    }      
    
    public void alterar(ClassificacaoDecimalDireito cdd) throws Exception{
        ClassificacaoDecimalDireito cddBanco = (ClassificacaoDecimalDireito) cddPersistenciaImpl.consultar(cdd);

        if (cddBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        cddPersistenciaImpl.alterar(cdd);
    }    
    
    public void excluir(ClassificacaoDecimalDireito cdd) throws Exception{

        ClassificacaoDecimalDireito cddBanco = (ClassificacaoDecimalDireito) cddPersistenciaImpl.consultar(cdd);

        if (cddBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        cddPersistenciaImpl.excluir(cdd);
    }   
    
    public List<ClassificacaoDecimalDireito> excluir(List<ClassificacaoDecimalDireito> cdds) throws Exception{
        
        List<ClassificacaoDecimalDireito> cddsNaoExistentesBanco = new ArrayList<>();
        
        for (ClassificacaoDecimalDireito a : cdds) {
            ClassificacaoDecimalDireito cddBanco = (ClassificacaoDecimalDireito) cddPersistenciaImpl.consultar(a);
            
            if (cddBanco != null) {
                cddPersistenciaImpl.excluir(a);
            } else {
                cddsNaoExistentesBanco.add(a);
            }
        }
        
        return cddsNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = cddPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    
    private List<String> getCodigosCdds(List<ClassificacaoDecimalDireito> cdds) {
        
        List<String> nomes = new ArrayList();
        
        try {
            List<ClassificacaoDecimalDireito> listaBanco = this.listar();
            for (ClassificacaoDecimalDireito cdd : listaBanco ) {
                nomes.add(cdd.getCodigoCDD());
            }
        } catch (Exception ex) {
            Logger.getLogger(ClassificacaoDecimalDireitoService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nomes;
    }      
    
    
    public Vector<ClassificacaoDecimalDireitoVO> carregarVetorComboBox() throws Exception {
        
        List<ClassificacaoDecimalDireito> cdds = this.listar();
        
        Vector<ClassificacaoDecimalDireitoVO> cddsVOVector = new Vector();
        
        for (ClassificacaoDecimalDireito cdd : cdds) {
            cddsVOVector.add(cdd.toClassificacaoDecimalDireitoVO());
        }   
        
        return cddsVOVector;
    } 

}
