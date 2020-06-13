package entity;

import entity.vo.AutorVO;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Autor {
    
    private Integer idAutor;
    private String nome;
    private boolean ativo;
    private boolean selecionado = false;
    
    
    public Autor() {
    }      
    
    public Autor(Integer id) {
        this.idAutor = id;
    }    

    public Autor(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }
    
    public Autor(Autor autor) {
        this.idAutor = autor.getIdAutor();
        this.nome = autor.getNome();
        this.ativo = autor.isAtivo();
    }
    
    public Autor(String dados) throws Exception {
        
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 3) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se idAutor do vetor for null, atribui 1.
            this.idAutor          = vetorString[0].equals("null") ? 1 : id;  
            this.nome        = vetorString[1];
            this.ativo       = Boolean.parseBoolean(vetorString[2]);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }
    }
    
    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
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
    
    public Autor from (Autor autor) throws Exception {
        this.idAutor = autor.getIdAutor();
        this.nome = autor.getNome();
        this.ativo = autor.isAtivo();
        return this;
    }    
    
     public AutorVO toAutorVO () throws Exception {
        AutorVO autorVO = new AutorVO();
        autorVO.setIdAutor(this.getIdAutor());
        autorVO.setNome(this.getNome());
        autorVO.setAtivo(this.isAtivo());
        return autorVO;
    }      

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(idAutor).append(";");
        sb.append(nome).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idAutor);
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
        if (!Objects.equals(this.idAutor, other.idAutor)) {
            return false;
        }
        return true;
    }
}
