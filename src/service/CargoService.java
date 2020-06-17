/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Cargo;
import entity.vo.CargoVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import repository.CargoPersistenciaImpl;
/**
 *
 * @author CroK
 */
public class CargoService {
    private CargoPersistenciaImpl CargoPersistenciaImpl;
    
    private final String NOME_ARQUIVO_BANCO_AUTOR = "cargoBd.txt";

    public CargoService() throws Exception {
        this.CargoPersistenciaImpl = new CargoPersistenciaImpl(NOME_ARQUIVO_BANCO_AUTOR);
    }
    
    public void incluir(Cargo cargo) throws Exception {
        Cargo cargoBanco = (Cargo) CargoPersistenciaImpl.consultar(cargo);

        if (cargoBanco != null) {
           throw new RegistroExistenteException(); 
        }

        Integer id = gerarNovoId();

        cargo.setIdCargo(id);

        CargoPersistenciaImpl.incluir(cargo);
    }
    
    public Cargo consultar(Cargo cargo) throws Exception {
       
        Cargo cargoBanco = null;
        
        List<Cargo> cargosBanco = CargoPersistenciaImpl.listar();
            
        if (cargo.getIdCargo() != null) {
        
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
            cargoBanco = cargosBanco.stream()
                                            .filter(a -> cargo.getIdCargo().equals(a.getIdCargo())) 
                                            .findFirst()
                                            .orElse(null);
        } else if (!"".equals(cargo.getDescricao())){
            
//          Percorrendo a lista com API Stream do java 8 e filtrando pelo nome.
            cargoBanco = cargosBanco.stream()
                                            .filter(a -> cargo.getDescricao().equals(a.getDescricao())) 
                                            .findFirst()
                                            .orElse(null); 
        } 
        
        return cargoBanco;
    }    
    
    public List<Cargo> listar() throws Exception {
        List<Cargo> cargos = CargoPersistenciaImpl.listar();

        return cargos;
    }      
    
    public void alterar(Cargo cargo) throws Exception{
        Cargo cargoBanco = (Cargo) CargoPersistenciaImpl.consultar(cargo);

        if (cargoBanco == null) {
           throw new RegistroNaoExistenteException();
        }
  
        CargoPersistenciaImpl.alterar(cargo);
    }    
    
    public void excluir(Cargo cargo) throws Exception{

        Cargo cargoBanco = (Cargo) CargoPersistenciaImpl.consultar(cargo);

        if (cargoBanco == null) {
           throw new RegistroNaoExistenteException();
        }
        
        CargoPersistenciaImpl.excluir(cargo);
    }   
    
    public List<Cargo> excluir(List<Cargo> cargos) throws Exception{
        
        List<Cargo> cargosNaoExistentesBanco = new ArrayList<>();
        
        for (Cargo a : cargos) {
            Cargo cargoBanco = (Cargo) CargoPersistenciaImpl.consultar(a);
            
            if (cargoBanco != null) {
                CargoPersistenciaImpl.excluir(a);
            } else {
                cargosNaoExistentesBanco.add(a);
            }
        }
        
        return cargosNaoExistentesBanco;
    } 
    
    
    public Vector<CargoVO> carregarTodosAutoresVetorComboBox() throws Exception {
        
        List<Cargo> cargos = this.listar();
        
        Vector<CargoVO> cargosVOVector = new Vector();
        
        for (Cargo cargo : cargos) {
            cargosVOVector.add(cargo.toCargoVO());
        }   
        
        return cargosVOVector;
    }      

    private Integer gerarNovoId() throws Exception {
        
        Integer ultimoIdBanco = CargoPersistenciaImpl.consultarUltimoID();
        
        return ultimoIdBanco != null ? ++ultimoIdBanco : 1;
    }
}
