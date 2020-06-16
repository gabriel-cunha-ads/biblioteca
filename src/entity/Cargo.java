package entity;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Cargo {

    private Integer idCargo;
    private String descricao;
    private boolean selecionado = false;


    public Cargo(Integer idCargo, String descricao) {
        this.idCargo = idCargo;
        this.descricao = descricao;
    }
    public Cargo(String descricao, boolean selecionado){
        this.descricao=descricao;
        this.selecionado=selecionado;
    }
    public Cargo(Integer idCargo,String descricao, boolean selecionado){
        this.idCargo=idCargo;
        this.descricao=descricao;
        this.selecionado=selecionado;
    }
    public Cargo(Cargo cargo){
        this.idCargo=cargo.idCargo;
        this.descricao=cargo.descricao;
        this.selecionado=cargo.selecionado;
    }
    
    
    public Cargo(String dados) throws Exception {
        
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 2) {
            Logger.getLogger(Cargo.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
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
