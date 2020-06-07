package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UtilArquivo {
    
    
    public static void removerLinhaSemRegistro(String arquivoBancoDados, List<?> lista) throws IOException {
        FileWriter fw = new FileWriter(arquivoBancoDados);
        
        BufferedWriter bw = new BufferedWriter(fw);

        for (Object a : lista) {
            if (a != null) {
                Object aux = a;
                bw.write(aux.toString() + "\n");
            }
        }   
        bw.close();
    }

}
