package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.UtilData;

/**
 *
  * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Livro {
    
    private Integer id;
    private List<Autor> autores;
    private Editora editora;
    private ClassificacaoDecimalDireito cdd;
    private String isbn;
    private String titulo;
    private String descricao;
    private Integer anoEdicao;
    private String edicao;
    private String impressaoReimpressao;
    private LocalDate dataImpressaoReimpressao;
    private Funcionario funcionarioCadastro;
    private LocalDate dataCadastro;
    private boolean ativo;
    private boolean selecionado = false;

    public Livro() {
    }
    
    public Livro(Integer idLivro) {
        this.id = idLivro;
    }

    public Livro(String dados) throws Exception {
        String[] vetorString = dados.split(";");
        
        if (vetorString.length < 13) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1.
            this.id     = vetorString[0].equals("null") ? 1 : id;  
            this.titulo         = vetorString[1];
            this.descricao      = vetorString[2];
            this.isbn           = vetorString[3];
            this.cdd            = new ClassificacaoDecimalDireito(Integer.parseInt(vetorString[4]));
            
//          Prenche a lista de autores do livro.
            String[] vetorStringIdAutores = vetorString[5].split(",");
            for (String idAutor : vetorStringIdAutores) {
                addAutor(new Autor(Integer.parseInt(idAutor)));
            }            
            
            this.editora        = new Editora(Integer.parseInt(vetorString[6]));
            this.edicao         = vetorString[7];
            this.anoEdicao      = Integer.parseInt(vetorString[8]);
            this.impressaoReimpressao       = vetorString[9];
            this.dataImpressaoReimpressao   = LocalDate.parse(vetorString[10], UtilData.getFormatoData());
            this.funcionarioCadastro = new Funcionario(Integer.parseInt(vetorString[11]));
            this.dataCadastro = LocalDate.parse(vetorString[12], UtilData.getFormatoData());
            this.ativo          = Boolean.parseBoolean(vetorString[13]);
                    
        } catch (DateTimeParseException e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + e);
        } catch(NumberFormatException e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse String to Integer. Erro" + e);
        } catch(Exception e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor." + e);
        }
    }     


    public Livro(String titulo, String isbn, List<Autor> autores, Editora editora, 
            ClassificacaoDecimalDireito cdd, Integer anoeEdicao, String edicao, 
            String impressao, LocalDate dataImpressao, String descricao,  
            Funcionario funcionarioCadastro, boolean ativo) {
        
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
        this.funcionarioCadastro        = funcionarioCadastro;
        this.dataCadastro               = LocalDate.now(ZoneId.systemDefault());
        this.ativo                      = ativo;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Funcionario getFuncionarioCadastro() {
        return funcionarioCadastro;
    }

    public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
        this.funcionarioCadastro = funcionarioCadastro;
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
    
    public Livro clone (Livro livro) throws Exception {
        this.id    = livro.getId();
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
        this.funcionarioCadastro    = livro.getFuncionarioCadastro();
        this.dataCadastro   = livro.getDataCadastro();
        this.ativo      = livro.isAtivo();
        return this;
    }     
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(id).append(";");
        sb.append(titulo).append(";");
        sb.append(descricao).append(";");
        sb.append(isbn).append(";");
        Integer idCdd = cdd.getIdClassificacaoDecimal() == null ? 999 : cdd.getIdClassificacaoDecimal();
        sb.append(idCdd).append(";");
        
//      Adiciona a lista de ids dos autores
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
        sb.append(dataImpressaoReimpressao.format(UtilData.getFormatoData())).append(";");
        sb.append(funcionarioCadastro.getMatricula()).append(";");
        sb.append(dataCadastro.format(UtilData.getFormatoData())).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
