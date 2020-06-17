package entity;

import entity.vo.FuncionarioVO;
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
public class Funcionario {

    private Integer matricula;
    private String nome;
    private String cpf;
    private Cargo cargo;
    private String oab  = "";
    private String celular;
    private String email;
    private boolean usuarioSistema = false;
    private String senha = "";
    private LocalDate dataCadastro = LocalDate.now(ZoneId.systemDefault());
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
    
    public Funcionario(Integer matricula, String nome,String cpf, Cargo cargo, String oab, String celular, 
            String email, boolean ativo, boolean isUsuarioSistema, String senha) {
        this.matricula  = matricula;
        this.nome       = nome;
        this.cpf        = cpf;
        this.cargo      = cargo;
        this.oab        = oab;
        this.celular    = celular; 
        this.email      = email;
        this.ativo      = ativo;
        this.usuarioSistema = isUsuarioSistema();
        this.senha = senha  = senha;
        this.dataCadastro = LocalDate.now(ZoneId.systemDefault());
        this.selecionado = false;        
    }    
    
    public Funcionario(String dados) throws Exception {
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 10) {
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
            this.cargo      = new Cargo(idCargo, vetorString[3]); // Cargo deverá estar cadastrado obrigatóriamente.
            this.oab        = vetorString[4];
            this.celular    = vetorString[5];        
            this.email      = vetorString[6];
            this.usuarioSistema = Boolean.parseBoolean(vetorString[7]);
            this.senha          = vetorString[8];
            this.dataCadastro   = LocalDate.parse(vetorString[9], UtilData.getFormatoData());
            this.ativo      = Boolean.parseBoolean(vetorString[10]);
                    
        } catch (DateTimeParseException e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse de String para LocalDate" + e);
        } catch(NumberFormatException e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse String to Integer. Erro" + e);
        } catch(Exception e) {
            Logger.getLogger(Livro.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor." + e);
        }
    }      

    public Funcionario(Integer matricula, String nome, String cpf, Cargo cargo, String celular, String email, boolean ativo) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.celular = celular;
        this.email = email;
        this.ativo = ativo;
    }

    public Funcionario(String nome, String cpf, Cargo cargo, String oab, String celular, String email, boolean ativo, boolean usuarioSistema, String valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public boolean isUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(boolean usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
    public Funcionario clone() {
        Funcionario funcionarioClone = new Funcionario();
        funcionarioClone.setMatricula(this.getMatricula());
        funcionarioClone.setNome(this.getNome());
        funcionarioClone.setCpf(this.getCpf());
        funcionarioClone.setCargo(this.getCargo());
        funcionarioClone.setOab(this.getOab());
        funcionarioClone.setCelular(this.getCelular());
        funcionarioClone.setEmail(this.getEmail());
        funcionarioClone.setUsuarioSistema(this.isUsuarioSistema());
        funcionarioClone.setDataCadastro(this.getDataCadastro());
        funcionarioClone.setAtivo(this.isAtivo());
        return funcionarioClone;
    } 
    

    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(matricula).append(";");
        sb.append(nome).append(";");
        sb.append(cpf).append(";");
        sb.append(cargo.getIdCargo()).append(";");
        sb.append(oab).append(";");
        sb.append(celular).append(";");
        sb.append(email).append(";");
        sb.append(usuarioSistema).append(";");
        sb.append(senha).append(";");
        sb.append(dataCadastro.format(UtilData.getFormatoData())).append(";");
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
