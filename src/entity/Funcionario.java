package entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Funcionario {

    private Integer matricula;
    private String nome;
    private String cpf;
    private Cargo cargo;
    private String oab;
    private String celular;
    private String email;
    private LocalDate dataCadastro;
    private boolean ativo;
    private boolean selecionado = false;

    public Funcionario() {
    }

    public Funcionario(Integer matricula) {
        this.matricula = matricula;
    }

    public Funcionario(Integer matricula, String nome, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public Funcionario(String dados) throws Exception {
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 9) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            Integer idCargo = Integer.parseInt(vetorString[3]);
            
//          Se matricula do vetor for null, atribui 1.
            this.matricula  = vetorString[0].equals("null") ? 1 : id;  
            this.nome       = vetorString[1];
            this.cpf        = vetorString[2];
            this.cargo      = new Cargo(idCargo, vetorString[4]); // Cargo deverá estar cadastrado obrigatóriamente.
            this.oab        = vetorString[5];
            this.celular    = vetorString[6];        
            this.email      = vetorString[7];
            this.ativo      = Boolean.parseBoolean(vetorString[8]);
                    
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }
    }      

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
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
        
        
        StringBuffer sb = new StringBuffer();
        sb.append(matricula).append(";");
        sb.append(nome).append(";");
        sb.append(cpf).append(";");
        sb.append(cargo.getIdCargo()).append(";");
        sb.append(cargo.getDescricao()).append(";");
        sb.append(oab).append(";");
        sb.append(celular).append(";");
        sb.append(email).append(";");
        sb.append(dataCadastro).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.matricula);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
    
    
    
}
