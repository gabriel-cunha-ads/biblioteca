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
            this.impressaoReimpressao       = vetorString[14];
            this.dataImpressaoReimpressao   = LocalDate.parse(vetorString[15], formatoData);
            this.dataCadastro   = LocalDate.parse(vetorString[16], formatoData);
            this.ativo          = Boolean.parseBoolean(vetorString[17]);
                    
        } catch (DateTimeParseException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + vetorString[1]);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
        }
    }     


    public Livro(String titulo, String isbn, Autor autor, Editora editora, 
            ClassificacaoDecimalDireito cdd, Integer anoeEdicao, String edicao, 
            String impressao, LocalDate dataImpressao, String descricao,  
            Usuario usuarioCadastro, boolean ativo) {
        
        this.titulo     = titulo;
        this.isbn       = isbn;
        addAutor(autor);
        this.editora    = editora;
        this.cdd        = cdd;
        this.anoEdicao  = anoeEdicao;
        this.edicao     = edicao;
        this.impressaoReimpressao       = impressao;
        this.dataImpressaoReimpressao   = dataImpressao;
        this.descricao          = descricao;
        this.usuarioCadastro    = usuarioCadastro;
        this.dataCadastro       = LocalDate.now(ZoneId.systemDefault());
        this.ativo              = ativo;
        this.selecionado        =   false;
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
        this.impressaoReimpressao  = livro.getImpressaoReimpressao();
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
        sb.append(cdd.getIdClassificacaoDecimal()).append(";");
        sb.append(cdd.getCodigoCDD()).append(";");
        sb.append(cdd.getDescricao()).append(";");
        sb.append(usuarioCadastro).append(";");
        sb.append(isbn).append(";");
        sb.append(titulo).append(";");
        sb.append(descricao).append(";");
        sb.append(anoEdicao).append(";");
        sb.append(edicao).append(";");
        sb.append(impressaoReimpressao).append(";");
        sb.append(dataImpressaoReimpressao.format(formatoData));
        sb.append(dataCadastro.format(formatoData)).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }      
}
