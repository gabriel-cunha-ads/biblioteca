package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.UtilData;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Exemplar {

    private Integer id;
    private Livro livro;
    private LocalDate dataCompra;
    private Double precoCompra;
    private LocalDate dataBaixa;
    private String motivoBaixa;
    private EnumSituacaoExemplar situacao;
    private boolean ativo;
    private boolean selecionado = false;

    public Exemplar(Integer idExemplar) {
        this.id = idExemplar;
    }

    public Exemplar(EnumSituacaoExemplar situacao) {
        this.situacao = situacao;
    }
    
    public Exemplar(Livro livro, Double precoCompra) {
        this.livro = livro;
        this.precoCompra = precoCompra;
        this.dataCompra  = LocalDate.now();
        this.situacao    = EnumSituacaoExemplar.DISPONIVEL;
        this.motivoBaixa = "";
        this.ativo       = true;
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
            
//          Se id do vetor for null, atribui 1.
            this.id     = vetorString[0].equals("null") ? 1 : id;  
            this.livro          = new Livro(idLivro);
            this.dataCompra     = LocalDate.parse(vetorString[2], UtilData.getFormatoData());
            this.precoCompra    = Double.parseDouble(vetorString[3]);
            this.dataBaixa      = LocalDate.parse(vetorString[4], UtilData.getFormatoData());
            this.motivoBaixa    = vetorString[5];
            this.situacao       = EnumSituacaoExemplar.valueOf(vetorString[6]);
            this.ativo          = Boolean.parseBoolean(vetorString[7]);
                    
        } catch (DateTimeParseException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + vetorString[1]);
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor do objeto" + vetorString[1]);
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor." + vetorString[1] + "Erro: " + e);
        }
    } 

    public Exemplar() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public EnumSituacaoExemplar getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacaoExemplar situacao) {
        this.situacao = situacao;
    }
    
    
    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        
        StringBuffer sb = new StringBuffer();
        sb.append(id).append(";");
        sb.append(livro.getId()).append(";");
        sb.append(dataCompra.format(formatoData)).append(";");
        sb.append(precoCompra).append(";");
        LocalDate dataDaBaixa = dataBaixa == null ? LocalDate.now().minusYears(1L) : dataBaixa;
        sb.append(dataDaBaixa.format(UtilData.getFormatoData())).append(";");
        sb.append(motivoBaixa).append(";");
        sb.append(situacao.name()).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }      
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
