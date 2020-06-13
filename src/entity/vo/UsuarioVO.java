package entity.vo;

import entity.Autor;
import entity.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UsuarioVO {

    private Integer idUsuario;
    private Funcionario funcionario;
    private Integer loginMatricula;
    private String senha;
    private LocalDate dataCadastro;
    private boolean ativo;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getLoginMatricula() {
        return loginMatricula;
    }

    public void setLoginMatricula(Integer loginMatricula) {
        this.loginMatricula = loginMatricula;
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
    
    

}
