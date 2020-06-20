/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpClient;

/**
 *
 * @author full
 */
public class Cliente {
    private long id;
    private String nome;
    private String cpf;
    private String celular;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    @Override
    public String toString (){
        return this.getClass().getSimpleName() + ";" + this.id+";" + this.nome+";"+this.cpf+";"+this.celular;
        
    }
    
}
