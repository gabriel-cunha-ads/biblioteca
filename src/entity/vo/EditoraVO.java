package entity.vo;

import entity.Editora;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class EditoraVO {
    
    private Integer idEditora;
    private String nome;
    private boolean ativo;

    public Integer getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Integer idEditora) {
        this.idEditora = idEditora;
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
    
     public Editora toEditora() throws Exception {
        Editora editora = new Editora();
        editora.setIdEditora(this.getIdEditora());
        editora.setNome(this.getNome());
        editora.setAtivo(this.isAtivo());
        return editora;
    }      

    @Override
    public String toString() {
        return this.nome;
    }
}
