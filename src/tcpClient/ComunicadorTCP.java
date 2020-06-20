/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author full
 */
public class ComunicadorTCP {  //cliente
    private Socket conexao;
    private ServerSocket ouvir;
    private DataInputStream receberMsg;
    private DataOutputStream enviarMsg;
    
    //Construtor Cliente
    public ComunicadorTCP(String ipServer, int porta)throws IOException{
        this.conexao = new Socket(ipServer, porta);
        this.receberMsg = new DataInputStream(conexao.getInputStream());
        this.enviarMsg = new DataOutputStream(conexao.getOutputStream());
        
    }
    //Construtor Servidor
    public ComunicadorTCP(int porta)throws IOException{
        this.conexao = ouvir.accept();
        this.ouvir = new ServerSocket(porta);
        this.receberMsg = new DataInputStream(this.conexao.getInputStream());
        this.enviarMsg = new DataOutputStream(this.conexao.getOutputStream());
    }
    
    //Envia uma mensagem texto utilizando o objeto DataOutputStream
    public void enviarMensagem(String mensagem)throws IOException{
        this.enviarMsg.writeUTF(mensagem);
        this.enviarMsg.flush();
    }
    //Recebe uma mensagem texto utilizando o objeto DataImputStream
    public String receberMensagem()throws IOException{
        return this.receberMsg.readUTF();
    }
     public void fecharConexao()throws IOException{
        this.conexao.close();
    }
}
