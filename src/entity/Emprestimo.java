package entity;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.UtilData;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Emprestimo {
    
    private Integer id;
    private Funcionario funcionario;
    private Exemplar exemplar;
    private LocalDate dataEmprestimo = LocalDate.now(ZoneId.systemDefault());
    private LocalDate dataPrevistaDevolucao = LocalDate.now().plusWeeks(1L);
    private LocalDate dataRenovacao;
    private EnumSituacaoEmprestimo situacaoEmprestimo;
    private boolean selecionado = false;    

    public Emprestimo() {
    }

    public Emprestimo(Integer id) {
        this.id = id;
    }

    public Emprestimo(Integer id, Funcionario matricula, Exemplar exemplar, LocalDate DataRenovacao) {
        this.id = id;
        this.funcionario = matricula;
        this.exemplar = exemplar;
        this.dataRenovacao = DataRenovacao;
    }
    
    public Emprestimo(String dados) throws Exception {
        String[] vetorString = dados.split(";");
        
        if (vetorString.length < 7) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1.
            this.id             = vetorString[0].equals("null") ? 1 : id;  
            this.funcionario    = new Funcionario(Integer.parseInt(vetorString[1]));
            this.exemplar       = new Exemplar(Integer.parseInt(vetorString[2]));
            this.dataEmprestimo = LocalDate.parse(vetorString[3], UtilData.getFormatoData());
            this.dataPrevistaDevolucao = LocalDate.parse(vetorString[5], UtilData.getFormatoData());       
            this.dataRenovacao  = LocalDate.parse(vetorString[6], UtilData.getFormatoData());
            this.situacaoEmprestimo = EnumSituacaoEmprestimo.valueOf(vetorString[7]);
                    
        } catch (DateTimeParseException e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + e);
        } catch(NumberFormatException e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse String to Integer. Erro" + e);
        } catch(Exception e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor." + e);
        }        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDate getDataRenovacao() {
        return dataRenovacao;
    }

    public void setDataRenovacao(LocalDate dataRenovacao) {
        this.dataRenovacao = dataRenovacao;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public EnumSituacaoEmprestimo getSituacaoEmprestimo() {
        return situacaoEmprestimo;
    }

    public void setSituacaoEmprestimo(EnumSituacaoEmprestimo situacaoEmprestimo) {
        this.situacaoEmprestimo = situacaoEmprestimo;
    }
    
    

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(id).append(";");
        sb.append(funcionario.getMatricula()).append(";");
        sb.append(exemplar.getId()).append(";");
        sb.append(dataEmprestimo.format(UtilData.getFormatoData())).append(";");
        sb.append(dataPrevistaDevolucao.format(UtilData.getFormatoData())).append(";");
        sb.append(dataRenovacao.format(UtilData.getFormatoData())).append(";");
        sb.append(situacaoEmprestimo).append(";");
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
