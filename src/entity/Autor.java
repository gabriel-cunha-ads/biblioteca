package entity;

import java.util.Objects;
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
    private boolean selecionado = false;
    
    
    public Autor() {
    }      
    
    public Autor(Integer id) {
        this.id = id;
    }    

    public Autor(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
    
    public Autor(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.ativo = autor.isAtivo();
    }
    
//    public Autor(String dados) throws Exception {
//        
//        String vetorString[] = dados.split(";");
//        
//        if (vetorString.length < 4) {
//            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Vetor de dados possui tamanho menor que 4. " + dados);
//            throw new Exception();
//        }
//        try {
//            Integer id = Integer.parseInt(vetorString[0]);
//            
////          Se id do vetor for null, atribui 1 para o id.
//            this.id          = vetorString[0].equals("null") ? 1 : id;  
//            this.nome        = vetorString[1];
//            this.ativo       = Boolean.parseBoolean(vetorString[2]);
//            this.selecionado = Boolean.parseBoolean(vetorString[3]);
//        } catch(NumberFormatException e) {
//            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
//            throw new Exception();
//        } catch(Exception e) {
//            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
//            throw new Exception();
//        }
//    }
    
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
    
    public Autor from (String dados) throws Exception {
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 4) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Vetor de dados possui tamanho menor que 4. " + dados);
            throw new Exception();
        }
        
        Autor autor = new Autor();
        
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1 para o id.
            autor.id          = vetorString[0].equals("null") ? 1 : id;  
            autor.nome        = vetorString[1];
            autor.ativo       = Boolean.parseBoolean(vetorString[2]);
            autor.selecionado = Boolean.parseBoolean(vetorString[3]);
            
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor id = " + vetorString[0] + "Erro: " + e);
            throw new Exception();
        }
        
        return autor;
    } 
    
    public Autor from (Autor autor) throws Exception {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.ativo = autor.isAtivo();
        
        return this;
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
