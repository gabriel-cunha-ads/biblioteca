package entity;

import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.AutorService;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Autor {
    
    private Integer id;
    private String nome;
    private boolean ativo;
    private boolean selecionado;
    
    

    public Autor(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.ativo = autor.isAtivo();
        this.selecionado = autor.isSelecionado();
    }

    public Autor(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
    
    public Autor(String dados) throws Exception {
        
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 4) {
            Logger.getLogger(AutorService.class.getName()).log(Level.SEVERE, "Erro ao incluir o autor. " + dados);
            throw new Exception("Faltam dados na String");
        }
        
        Integer idBanco = vetorString[0].equals("null") ? -1 : Integer.parseInt(vetorString[0]);  
        
        id          = idBanco == -1 ? 1 : idBanco;
        nome        = vetorString[1];
        ativo       = Boolean.parseBoolean(vetorString[2]);
        selecionado = Boolean.parseBoolean(vetorString[3]);
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(id).append(";");
        sb.append(nome).append(";");
        sb.append(ativo).append(";");
        sb.append(selecionado).append(";");
        
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
