package tcpClient;

import tcpClient.ComunicadorTCP;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Aires Ribeiro
 */
public class TCPCliente {

    public static void main(String[] args)throws IOException {
        
        Scanner teclado = new Scanner(System.in);
        String mensagem;
        ComunicadorTCP comunicacao = new ComunicadorTCP("127.0.0.1", 6789);
        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNome("Aires");
        cliente.setCpf("999.");
        cliente.setCelular("(62) 99999 9999");
        //envio unico dos dados da classe cliente
        comunicacao.enviarMensagem(cliente.toString());
        System.out.println(comunicacao.receberMensagem());
        // ou  usar este metodo para trocar mensagem até que encerre o processo
        while(true){
            System.out.println("Entre com a mensagem: ");
            mensagem = teclado.nextLine();
            comunicacao.enviarMensagem(mensagem);
            System.out.println(comunicacao.receberMensagem());
        }
            
    }
    
}
