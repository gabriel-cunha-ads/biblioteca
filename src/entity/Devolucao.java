package entity;

import java.time.LocalDate;
import java.time.ZoneId;
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
public class Devolucao {
    
    private Integer id;
    private Emprestimo emprestimo;
    private LocalDate dataDevolucao = LocalDate.now(ZoneId.systemDefault());
    private EnumSituacaoDevolucao situacao;
    private Multa multa;

    public Devolucao() {
    }

    public Devolucao(Integer id) {
        this.id = id;
    }

    public Devolucao(String dados) throws Exception {
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 5) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se matricula do vetor for null, atribui 1.
            this.id             = vetorString[0].equals("null") ? 1 : id;  
            this.emprestimo     = new Emprestimo(Integer.parseInt(vetorString[1]));
            this.dataDevolucao  = LocalDate.parse(vetorString[2], UtilData.getFormatoData());
            this.situacao       = EnumSituacaoDevolucao.valueOf(vetorString[3]);
            this.multa          = new Multa(Integer.parseInt(vetorString[8]));
                    
        } catch (DateTimeParseException e) {
            Logger.getLogger(Devolucao.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + e);
        } catch(NumberFormatException e) {
            Logger.getLogger(Devolucao.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse String to Integer. Erro" + e);
        } catch(Exception e) {
            Logger.getLogger(Devolucao.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados." + e);
        }       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public EnumSituacaoDevolucao getSituacao() {
        return situacao;
    }

    public void setSituacao(EnumSituacaoDevolucao situacao) {
        this.situacao = situacao;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(id).append(";");
        sb.append(emprestimo).append(";");

        sb.append(dataDevolucao.format(UtilData.getFormatoData())).append(";");
        sb.append(situacao).append(";");
        sb.append(multa.getId()).append(";");
        return sb.toString(); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Devolucao other = (Devolucao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
