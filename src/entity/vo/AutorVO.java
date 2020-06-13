package entity.vo;

import entity.Autor;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorVO {

    private Integer idAutor;
    private String nome;
    private boolean ativo;

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
    
     public Autor toAutor () throws Exception {
        Autor autor = new Autor();
        autor.setIdAutor(this.getIdAutor());
        autor.setNome(this.getNome());
        autor.setAtivo(this.isAtivo());
        return autor;
    }  

    @Override
    public String toString() {
        return this.nome;
    }
    
}
