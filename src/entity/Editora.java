package entity;

import entity.vo.EditoraVO;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Editora {
    
    private Integer idEditora;
    private String nome;
    private boolean ativo;
    private boolean selecionado = false;
    
 public Editora() {
    }      
    
    public Editora(Integer id) {
        this.idEditora = id;
    }    

    public Editora(String nome, boolean ativo) {
        this.nome = nome;
        this.ativo = ativo;
    }

    public Editora(Integer idEditora, String nome, boolean ativo) {
        this.idEditora = idEditora;
        this.nome = nome;
        this.ativo = ativo;
    }
    
    public Editora(Editora editora) {
        this.idEditora = editora.getIdEditora();
        this.nome = editora.getNome();
        this.ativo = editora.isAtivo();
    }
    
    public Editora(String dados) throws Exception {
        
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 3) {
            Logger.getLogger(Editora.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1.
            this.idEditora   = vetorString[0].equals("null") ? 1 : id;  
            this.nome        = vetorString[1];
            this.ativo       = Boolean.parseBoolean(vetorString[2]);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados da editora com nome " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados da editora." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }
    }    

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

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
    public Editora clone (Editora editora) throws Exception {
        Editora editoraClone = new Editora();
        editoraClone.setIdEditora(editora.getIdEditora());
        editoraClone.setNome(editora.getNome());
        editoraClone.setAtivo(editora.isAtivo());
        return editoraClone;
    }     
    
    public EditoraVO toEditoraVO () throws Exception {
        EditoraVO editoraVO = new EditoraVO();
        editoraVO.setIdEditora(this.getIdEditora());
        editoraVO.setNome(this.getNome());
        editoraVO.setAtivo(this.isAtivo());
        return editoraVO;
    }       
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(idEditora).append(";");
        sb.append(nome).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idEditora);
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
        final Editora other = (Editora) obj;
        if (!Objects.equals(this.idEditora, other.idEditora)) {
            return false;
        }
        return true;
    }
    
    
    


    
}
