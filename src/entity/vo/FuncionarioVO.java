package entity.vo;

import entity.Autor;
import entity.Cargo;
import entity.ClassificacaoDecimalDireito;
import entity.Funcionario;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class FuncionarioVO {

    private Integer matricula;
    private String nome;
    private String cpf;
    private Cargo cargo;
    private String oab;
    private String celular;
    private String email;
    private boolean isUsuarioSistema;
    private LocalDate dataCadastro;
    private boolean ativo;
    private boolean selecionado = false;

    public FuncionarioVO() {
    }

    public FuncionarioVO(Integer matricula) {
        this.matricula = matricula;
    }

    public FuncionarioVO(Integer matricula, String nome, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public FuncionarioVO(String dados) throws Exception {
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

    public boolean isIsUsuarioSistema() {
        return isUsuarioSistema;
    }

    public void setIsUsuarioSistema(boolean isUsuarioSistema) {
        this.isUsuarioSistema = isUsuarioSistema;
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
    
    public Funcionario toFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setMatricula(this.matricula);
        funcionario.setNome(this.nome);
        funcionario.setCpf(this.cpf);
        funcionario.setCargo(this.cargo);
        funcionario.setOab(this.oab);
        funcionario.setCelular(this.celular);
        funcionario.setEmail(this.email);
        funcionario.setUsuarioSistema(this.isUsuarioSistema);
        funcionario.setDataCadastro(this.dataCadastro);
        funcionario.setAtivo(this.isAtivo());
        return funcionario;
    }  

    @Override
    public String toString() {
        return this.nome; 
    }

    
 
}
