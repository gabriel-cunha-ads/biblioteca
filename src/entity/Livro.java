package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
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
    private String impressaoReimpressao;
    private LocalDate dataImpressaoReimpressao;
    private LocalDate dataCadastro;
    private boolean ativo;
    private boolean selecionado = false;
    

    public Livro() {
    }
    
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
            this.titulo         = vetorString[1];
            this.descricao      = vetorString[2];
            this.isbn           = vetorString[3];
            this.cdd            = new ClassificacaoDecimalDireito(Integer.parseInt(vetorString[4]));
            
//          Prenche a lista de autores do livro.
            String[] vetorStringIdAutores = vetorString[5].split(",");
            for (String idAutor : vetorStringIdAutores) {
                this.autores.add(new Autor(Integer.parseInt(idAutor)));
            }            
            
            this.editora        = new Editora(Integer.parseInt(vetorString[6]));
            this.edicao         = vetorString[7];
            this.anoEdicao      = Integer.parseInt(vetorString[8]);
            this.impressaoReimpressao       = vetorString[9];
            this.dataImpressaoReimpressao   = LocalDate.parse(vetorString[10], formatoData);
            this.usuarioCadastro = new Usuario(vetorString[11]);
            this.dataCadastro   = LocalDate.parse(vetorString[12], formatoData);
            this.ativo          = Boolean.parseBoolean(vetorString[13]);
                    
        } catch (DateTimeParseException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + e);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse String to Integer. Erro" + e);
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do livro." + e);
        }
    }     


    public Livro(String titulo, String isbn, List<Autor> autores, Editora editora, 
            ClassificacaoDecimalDireito cdd, Integer anoeEdicao, String edicao, 
            String impressao, LocalDate dataImpressao, String descricao,  
            Usuario usuarioCadastro, boolean ativo) {
        
        this.titulo     = titulo;
        this.descricao  = descricao;
        this.isbn       = isbn;
        this.cdd        = cdd;
        this.autores    = autores;
        this.editora    = editora;
        this.edicao     = edicao;
        this.anoEdicao  = anoeEdicao;
        this.impressaoReimpressao       = impressao;
        this.dataImpressaoReimpressao   = dataImpressao;
        this.usuarioCadastro            = usuarioCadastro;
        this.dataCadastro               = LocalDate.now(ZoneId.systemDefault());
        this.ativo                      = ativo;
        this.selecionado        =          false;
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

    public String getImpressaoReimpressao() {
        return impressaoReimpressao;
    }

    public void setImpressaoReimpressao(String impressaoReimpressao) {
        this.impressaoReimpressao = impressaoReimpressao;
    }

    public LocalDate getDataImpressaoReimpressao() {
        return dataImpressaoReimpressao;
    }

    public void setDataImpressaoReimpressao(LocalDate dataImpressaoReimpressao) {
        this.dataImpressaoReimpressao = dataImpressaoReimpressao;
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
        this.titulo     = livro.getTitulo();
        this.descricao  = livro.getDescricao();
        this.isbn       = livro.getIsbn();
        this.cdd        = livro.getCdd();
        this.autores    = livro.getAutores();
        this.editora    = livro.getEditora();
        this.edicao     = livro.getEdicao();
        this.anoEdicao  = livro.getAnoEdicao();
        this.impressaoReimpressao  = livro.getImpressaoReimpressao();
        this.dataImpressaoReimpressao = livro.getDataImpressaoReimpressao();
        this.usuarioCadastro    = livro.getUsuarioCadastro();
        this.dataCadastro   = livro.getDataCadastro();
        this.ativo      = livro.isAtivo();
        return this;
    }     
    
    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        
        StringBuffer sb = new StringBuffer();
        sb.append(idLivro).append(";");
        sb.append(titulo).append(";");
        sb.append(descricao).append(";");
        sb.append(isbn).append(";");
        sb.append(cdd.getIdClassificacaoDecimal()).append(";");
        
        for (Autor autor : autores) {
            sb.append(autor.getIdAutor()).append(",");
        }   
        int index = sb.lastIndexOf(",");
        sb.deleteCharAt(index);
        sb.append(";");
        
        sb.append(editora.getIdEditora()).append(";");
        sb.append(edicao).append(";");
        sb.append(anoEdicao).append(";");
        sb.append(impressaoReimpressao).append(";");
        sb.append(dataImpressaoReimpressao.format(formatoData));
        sb.append(usuarioCadastro.getIdUsuario()).append(";");
        sb.append(dataCadastro.format(formatoData)).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }      
}
