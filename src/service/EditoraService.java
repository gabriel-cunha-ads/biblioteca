package service;
import entity.Editora;
import entity.vo.EditoraVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import repository.EditoraPersistenciaImpl;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class EditoraService {

    private EditoraPersistenciaImpl editoraPersistenciaImpl;
    
    private final String NOME_ARQUIVO_BANCO_AUTOR = "editoraBd.txt";

    public EditoraService() throws Exception {
        this.editoraPersistenciaImpl = new EditoraPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(Editora editora) throws Exception {
        Editora editoraBanco = (Editora) editoraPersistenciaImpl.consultar(editora);

        if (editoraBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        editora.setIdEditora(id);

        editoraPersistenciaImpl.incluir(editora);
    }
    
    public Editora consultar(Editora editora) throws Exception {
       
        Editora editoraBanco = null;
        
        List<Editora> editorasBanco = editoraPersistenciaImpl.listar();
            
        if (editora.getIdEditora() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            editoraBanco = editorasBanco.stream()
                                            .filter(a -> editora.getIdEditora().equals(a.getIdEditora())) 
                                            .findFirst()
                                            .orElse(null);
        } else if (!"".equals(editora.getNome())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            editoraBanco = editorasBanco.stream()
                                            .filter(a -> editora.getNome().equals(a.getNome())) 
                                            .findFirst()
                                            .orElse(null); 
        } 
        
        return editoraBanco;
    }    
    
    public List<Editora> listar() throws Exception {
        List<Editora> editoras = editoraPersistenciaImpl.listar();

        return editoras;
    }      
    
    public void alterar(Editora editora) throws Exception{
        Editora editoraBanco = (Editora) editoraPersistenciaImpl.consultar(editora);

        if (editoraBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        editoraPersistenciaImpl.alterar(editora);
    }    
    
    public void excluir(Editora editora) throws Exception{

        Editora editoraBanco = (Editora) editoraPersistenciaImpl.consultar(editora);

        if (editoraBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        editoraPersistenciaImpl.excluir(editora);
    }   
    
    public List<Editora> excluir(List<Editora> editoras) throws Exception{
        
        List<Editora> editorasNaoExistentesBanco = new ArrayList<>();
        
        for (Editora a : editoras) {
            Editora editoraBanco = (Editora) editoraPersistenciaImpl.consultar(a);
            
            if (editoraBanco != null) {
                editoraPersistenciaImpl.excluir(a);
            } else {
                editorasNaoExistentesBanco.add(a);
            }
        }
        
        return editorasNaoExistentesBanco;
    }        

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = editoraPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
    
    public Vector<EditoraVO> carregarVetorComboBox() throws Exception {
        
        List<Editora> editoras = this.listar();
        
        Vector<EditoraVO> editoraVOVector = new Vector();
        
        for (Editora editora : editoras) {
            editoraVOVector.add(editora.toEditoraVO());
        }   
        
        return editoraVOVector;
    } 
}
