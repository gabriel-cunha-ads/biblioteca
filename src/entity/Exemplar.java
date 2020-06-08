package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Exemplar {

    private Integer idExemplar;
    private Livro livro;
    private LocalDate dataCompra;
    private Double precoCompra;
    private LocalDate dataBaixa;
    private String motivoBaixa;
    private EnumSituacaoEmprestimo situacaoEmprestimo;
    private boolean ativo;
    private boolean selecionado = false;

    public Exemplar(Integer idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Exemplar(Livro livro) {
        this.livro.setIdLivro(livro.getIdLivro());
    }
    
    public Exemplar(String dados) throws Exception {
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 8) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            Integer idLivro = Integer.parseInt(vetorString[1]);
            
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");            
            
//          Se id do vetor for null, atribui 1.
            this.idExemplar     = vetorString[0].equals("null") ? 1 : id;  
            this.livro          = new Livro(idLivro);
            this.dataCompra     = LocalDate.parse(vetorString[2], formatoData);
            this.precoCompra    = Double.parseDouble(vetorString[3]);
            this.dataBaixa      = LocalDate.parse(vetorString[4], formatoData);
            this.motivoBaixa    = vetorString[5];
            this.situacaoEmprestimo = EnumSituacaoEmprestimo.valueOf(vetorString[6]);
            this.ativo          = Boolean.parseBoolean(vetorString[8]);
                    
        } catch (DateTimeParseException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + vetorString[1]);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
        }
    } 
    

    public Integer getIdExemplar() {
        return idExemplar;
    }

    public void setIdExemplar(Integer idExemplar) {
        this.idExemplar = idExemplar;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public LocalDate getDataBaixa() {
        return dataBaixa;
    }

    public void setDataBaixa(LocalDate dataBaixa) {
        this.dataBaixa = dataBaixa;
    }

    public String getMotivoBaixa() {
        return motivoBaixa;
    }

    public void setMotivoBaixa(String motivoBaixa) {
        this.motivoBaixa = motivoBaixa;
    }

    public EnumSituacaoEmprestimo getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    public void setSituacaoEmprestimo(EnumSituacaoEmprestimo situacaoEmprestimo) {
        this.situacaoEmprestimo = situacaoEmprestimo;
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
    
    
    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        
        StringBuffer sb = new StringBuffer();
        sb.append(idExemplar).append(";");
        sb.append(livro.getIdLivro()).append(";");
        sb.append(dataCompra.format(formatoData)).append(";");
        sb.append(precoCompra).append(";");
        sb.append(dataBaixa.format(formatoData)).append(";");
        sb.append(motivoBaixa).append(";");
        sb.append(situacaoEmprestimo).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }      
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idExemplar);
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
        final Exemplar other = (Exemplar) obj;
        if (!Objects.equals(this.idExemplar, other.idExemplar)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
