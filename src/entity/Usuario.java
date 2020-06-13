package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class Usuario {

    private Integer idUsuario;
    private Funcionario funcionario;
    private Integer loginMatricula;
    private String senha;
    private LocalDate dataCadastro;
    private boolean ativo;
    private boolean selecionado = false;
    
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public Usuario(String dados) throws Exception {
        
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 5) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
            throw new Exception();
        }
        
        try {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");               
            
//          Se idAutor do vetor for null, atribui 1.
            Integer id          = Integer.parseInt(vetorString[0]);
            this.idUsuario      = vetorString[0].equals("null") ? 1 : id;  
            
            Integer matricula   = Integer.parseInt(vetorString[1]);
            this.funcionario    = new Funcionario(matricula);
            
            this.dataCadastro   = LocalDate.parse(vetorString[4], formatoData);
            this.loginMatricula          = Integer.parseInt(vetorString[2]);
            this.ativo          = Boolean.parseBoolean(vetorString[2]);
            
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }
    }

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

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
    public Usuario from (Usuario usuario) throws Exception {
        this.idUsuario      = usuario.getIdUsuario();
        this.funcionario    = usuario.getFuncionario();
        this.loginMatricula          = usuario.getLoginMatricula();
        this.senha          = usuario.getSenha();
        this.dataCadastro   = usuario.getDataCadastro();
        this.ativo          = usuario.isAtivo();
        this.selecionado    = usuario.isSelecionado();
        return this;
    }     
    
    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        
        StringBuffer sb = new StringBuffer();
        sb.append(funcionario.getMatricula()).append(";");
        sb.append(loginMatricula).append(";");
        sb.append(senha).append(";");
        sb.append(dataCadastro.format(formatoData)).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }     

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
