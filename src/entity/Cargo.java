package entity;

import java.util.Objects;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Cargo {

    private Integer idCargo;
    private String descricao;
    private boolean selecionado = false;

    public Cargo() {
    }

    public Cargo(Integer idCargo, String descricao) {
        this.idCargo = idCargo;
        this.descricao = descricao;
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
    
    
    public Cargo from (Cargo cargo) throws Exception {
        this.idCargo    = cargo.getIdCargo();
        this.descricao  = cargo.getDescricao();
        this.selecionado = cargo.isSelecionado();
        return this;
    }     
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(idCargo).append(";");
        sb.append(descricao).append(";");
        return sb.toString();
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
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.idCargo, other.idCargo)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
