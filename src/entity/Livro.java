package entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
  * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Livro {
    
    private Integer idLivro;
    private String titulo;
    private String descricao;
    private String isbn;
    private int exemplar;
    private Autor autor;
    private String editora;
    private String edicao;
    private int impressao;
    private String ano;
    private LocalDate dataCadastro;
    private String idUsuarioCadatro;
    private boolean ativo;
    private String motivoInativo;
    private String qtdExmeplaresDisponíveis;
    private BigDecimal valorCompra;
    private Boolean selecionado;
    
    public Livro(Integer idLivro,String titulo, String descricao, String isbn, 
            Autor autor, String editora, String edicao, int impressao, String ano,
            String idUsuarioCadastro, String motivoInativo ) {
        this.idLivro        = idLivro;
        this.titulo         = titulo;
        this.descricao      = descricao;
        this.isbn           = isbn;
        this.autor          = autor;
        this.editora        = editora;
        this.edicao         = edicao;
        this.impressao      = impressao;
        this.ano            = ano;
        this.dataCadastro   = LocalDate.now();
        this.idUsuarioCadatro = idUsuarioCadastro;
        this.ativo          = true;
        this.motivoInativo  = motivoInativo;
    }
    
    public Livro(Integer idLivro, String titulo, Autor autor, String editora, 
                String edicao, String ano, String isbn, Boolean selecionado) {
        this.idLivro             = idLivro;
        this.titulo         = titulo;
        this.autor          = autor;
        this.editora        = editora;
        this.edicao         = edicao;
        this.ano            = ano;
        this.isbn           = isbn;
        this.qtdExmeplaresDisponíveis = getQtdExemplaresDisponiveis();
        this.selecionado    = selecionado;
    }
        
    public Livro(String linhaTabela) throws Exception{
        String vetorString[]    = linhaTabela.split(";");
        this.idLivro            = Integer.parseInt(vetorString[0]);
        this.titulo             = vetorString[1];
        this.autor.setIdAutor(Integer.parseInt(vetorString[2]));
        this.editora            = vetorString[3];
        this.edicao             = vetorString[4];
        this.ano                = vetorString[5];
        this.isbn               = vetorString[6];
        this.qtdExmeplaresDisponíveis = vetorString[7];   
    }    
        
    public Livro(Livro livro) {
//      TODO implementar manipulando objeto
        this.dataCadastro   = LocalDate.now(); 
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
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

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public int getExemplar() {
        return exemplar;
    }

    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public int getImpressao() {
        return impressao;
    }

    public void setImpressao(int impressao) {
        this.impressao = impressao;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getIdUsuarioCadatro() {
        return idUsuarioCadatro;
    }

    public void setIdUsuarioCadatro(String idUsuarioCadatro) {
        this.idUsuarioCadatro = idUsuarioCadatro;
    }

    public boolean isAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getMotivoInativo() {
        return motivoInativo;
    }

    public void setMotivoInativo(String motivoInativo) {
        this.motivoInativo = motivoInativo;
    }
        
    public String getQtdExemplaresDisponiveis() {
//       TODO implementar a busca da qtd exemplares
        
        return this.qtdExmeplaresDisponíveis = "2";
    }
    
    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }    
    
    public BigDecimal getValorCompra() {
        return this.valorCompra;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    @Override
    public String toString() {
        return "Livro{" + "id=" + idLivro + ", titulo=" + titulo + ", descricao=" + descricao + ", isbn=" + isbn + ", exemplar=" + exemplar + ", autor=" + autor + ", editora=" + editora + ", edicao=" + edicao + ", impressao=" + impressao + ", ano=" + ano + ", dataCadastro=" + dataCadastro + ", idUsuarioCadatro=" + idUsuarioCadatro + ", ativo=" + ativo + ", motivoInativo=" + motivoInativo + ", qtdExmeplaresDispon\u00edveis=" + qtdExmeplaresDisponíveis + ", valorCompra=" + valorCompra + ", selecionado=" + selecionado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.idLivro, other.idLivro)) {
            return false;
        }
        return true;
    }
    
    
    
}

