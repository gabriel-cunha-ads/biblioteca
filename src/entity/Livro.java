package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
  * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Livro {
    
    private Integer idLivro;
    private List<Autor> autores;
    private Editora editora;
    private ClassificacaoDecimalDireito cdd;
    private Usuario usuarioCadastro;
    private String isbn;
    private String titulo;
    private String descricao;
    private Integer anoEdicao;
    private String edicao;
    private LocalDate dataCadastro;
    private String impressao;
    private boolean ativo;
    private boolean selecionado = false;
    

    public Livro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public Livro(String dados) throws Exception {
        String[] vetorString = dados.split(";");
        
        if (vetorString.length < 13) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");            
            
//          Se id do vetor for null, atribui 1.
            this.idLivro     = vetorString[0].equals("null") ? 1 : id;  
            
//          Prenche a lista de autores do livro.
            String[] vetorStringIdAutores = vetorString[1].split(",");
            for (String idAutor : vetorStringIdAutores) {
                this.autores.add(new Autor(Integer.parseInt(idAutor)));
            }            
            
            Integer idEditora   = Integer.parseInt(vetorString[2]);
            this.editora        = new Editora(idEditora, vetorString[3], Boolean.parseBoolean(vetorString[4]));
            
            Integer idCdd       = Integer.parseInt(vetorString[5]);
            this.cdd            = new ClassificacaoDecimalDireito(idCdd, vetorString[6], vetorString[7]);
            
            this.usuarioCadastro = new Usuario(vetorString[8]);
            this.isbn           = vetorString[9];
            this.titulo         = vetorString[10];
            this.descricao      = vetorString[11];
            this.anoEdicao      = Integer.parseInt(vetorString[12]);
            this.edicao         = vetorString[13];
            this.dataCadastro   = LocalDate.parse(vetorString[14], formatoData);
            this.impressao      = vetorString[15];
            this.ativo          = Boolean.parseBoolean(vetorString[16]);
                    
        } catch (DateTimeParseException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + vetorString[1]);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
        }
    }     

    public Livro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Livro(String nome, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    public void addAutor(Autor autor) {
        if (this.autores == null) {
            this.autores = new ArrayList<>();
        }
        this.autores.add(autor);
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public ClassificacaoDecimalDireito getCdd() {
        return cdd;
    }

    public void setCdd(ClassificacaoDecimalDireito cdd) {
        this.cdd = cdd;
    }

    public Usuario getUsuarioCadastro() {
        return usuarioCadastro;
    }

    public void setUsuarioCadastro(Usuario usuarioCadastro) {
        this.usuarioCadastro = usuarioCadastro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAnoEdicao() {
        return anoEdicao;
    }

    public void setAnoEdicao(Integer anoEdicao) {
        this.anoEdicao = anoEdicao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getImpressao() {
        return impressao;
    }

    public void setImpressao(String impressao) {
        this.impressao = impressao;
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
    
    public Livro from (Livro livro) throws Exception {
        this.idLivro    = livro.getIdLivro();
        this.autores    = livro.getAutores();
        this.editora    = livro.getEditora();
        this.cdd        = livro.getCdd();
        this.usuarioCadastro    = livro.getUsuarioCadastro();
        this.isbn       = livro.getIsbn();
        this.titulo     = livro.getTitulo();
        this.descricao  = livro.getDescricao();
        this.anoEdicao  = livro.getAnoEdicao();
        this.edicao     = livro.getEdicao();
        this.dataCadastro   = livro.getDataCadastro();
        this.impressao  = livro.getImpressao();
        this.ativo      = livro.isAtivo();
        return this;
    }     
    
    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        
        StringBuffer sb = new StringBuffer();
        sb.append(idLivro).append(";");
        
        for (Autor autor : autores) {
            sb.append(autor.getIdAutor()).append(",");
        }   
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(";");
        
        sb.append(editora.getIdEditora()).append(";");
        sb.append(editora.getNome()).append(";");
        sb.append(editora.isAtivo()).append(";");
        sb.append(cdd.getIdClassificacaoDecinal()).append(";");
        sb.append(cdd.getCodigoCDD()).append(";");
        sb.append(cdd.getDescricao()).append(";");
        sb.append(usuarioCadastro).append(";");
        sb.append(isbn).append(";");
        sb.append(titulo).append(";");
        sb.append(descricao).append(";");
        sb.append(anoEdicao).append(";");
        sb.append(edicao).append(";");
        sb.append(dataCadastro.format(formatoData)).append(";");
        sb.append(impressao).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }      
}
