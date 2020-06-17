package entity;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.UtilData;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Multa {

    private Integer id;
    private Funcionario funcionario;
    private Devolucao devolucao;
    private LocalDate data;
    private Double valor;
    private EnumSituacaoMulta situacao;

    public Multa() {
    }
    
    public Multa(Integer id) {
        this.id = id;
    }

    public Multa(Funcionario funcionario, EnumSituacaoMulta situacao) {
        this.funcionario = funcionario;
        this.situacao = situacao;
    }
    
    public Multa(Integer id, Devolucao devolucao, Double valor) {
        this.id = id;
        this.devolucao = devolucao;
        this.valor = valor;
    }
    
    public Multa (String dados) throws Exception {
        String[] vetorString = dados.split(";");
        
        if (vetorString.length < 3) {
            Logger.getLogger(Multa.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1.
            this.id             = vetorString[0].equals("null") ? 1 : id;  
            this.funcionario    = new Funcionario(Integer.parseInt(vetorString[1]));
            this.devolucao      = new Devolucao(Integer.parseInt(vetorString[2]));
            this.data           = LocalDate.parse(vetorString[3], UtilData.getFormatoData());
            this.valor          = Double.parseDouble(vetorString[4]);
            this.situacao       = EnumSituacaoMulta.valueOf(vetorString[5]);
                    
        } catch (DateTimeParseException e) {
            Logger.getLogger(Multa.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + e);
        } catch(NumberFormatException e) {
            Logger.getLogger(Multa.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse String to Integer. Erro" + e);
        } catch(Exception e) {
            Logger.getLogger(Multa.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do livro." + e);
        }        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public EnumSituacaoMulta getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacaoMulta situacao) {
        this.situacao = situacao;
    }
    
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(id).append(";");
        sb.append(funcionario.getMatricula());
        sb.append(devolucao.getId()).append(";");
        sb.append(data.format(UtilData.getFormatoData())).append(";");
        sb.append(valor).append(";");
        sb.append(situacao).append(";");
        return sb.toString();        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Multa other = (Multa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
