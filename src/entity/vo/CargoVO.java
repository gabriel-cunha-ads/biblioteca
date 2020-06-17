package entity.vo;

import entity.Autor;
import entity.Cargo;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class CargoVO {

    private Integer idCargo;
    private String descricao;
    private boolean selecionado = false;

    public CargoVO() {
    }

    public CargoVO(Integer idCargo, String descricao) {
        this.idCargo = idCargo;
        this.descricao = descricao;
    }
    public CargoVO(String descricao, boolean selecionado){
        this.descricao=descricao;
        this.selecionado=selecionado;
    }
    public CargoVO(Integer idCargo,String descricao, boolean selecionado){
        this.idCargo=idCargo;
        this.descricao=descricao;
        this.selecionado=selecionado;
    }
    public CargoVO(CargoVO cargo){
        this.idCargo=cargo.idCargo;
        this.descricao=cargo.descricao;
        this.selecionado=cargo.selecionado;
    }
    
    
    public CargoVO(String dados) throws Exception {
        
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 2) {
            Logger.getLogger(CargoVO.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1.
            this.idCargo   = vetorString[0].equals("null") ? 1 : id;  
            this.descricao        = vetorString[1];
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados da editora com nome " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados da editora." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }
    }        
    
    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
    
    public Cargo toCargo () throws Exception {
        Cargo cargo    = new Cargo();
        cargo.setIdCargo(this.getIdCargo());
        cargo.setDescricao(this.getDescricao());
        cargo.setSelecionado(this.isSelecionado());
        return cargo;
    }     

    @Override
    public String toString() {
        return this.descricao;
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.idCargo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CargoVO other = (CargoVO) obj;
        if (!Objects.equals(this.idCargo, other.idCargo)) {
            return false;
        }
        return true;
    }

    
}
