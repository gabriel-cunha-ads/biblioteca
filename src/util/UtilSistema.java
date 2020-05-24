package util;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UtilSistema {
    
    private static final String HOME_USUARIO    = System.getProperty("user.home");
    private static final String PASTA_PADRAO_SISTEMA    = "Sistema";
    private static final String PASTA_BANCO_DADOS       = "bancoDados";    
    
    public static String getDiretorioBancoDados() throws Exception {
        
        String diretorioBancoDados  = HOME_USUARIO + File.separator 
                                      + PASTA_PADRAO_SISTEMA + File.separator 
                                      + PASTA_BANCO_DADOS;
        
        Path diretorio =  Paths.get(diretorioBancoDados);
        
//      Verifica se o diretorio não existe, se não existir, cria os diretórios.
        if (!Files.exists(diretorio)) {
            File dir = new File(diretorioBancoDados);
            dir.mkdirs();
        }   
        
        return diretorioBancoDados;
    }
    
    public static void criarArquivoBancoDados(String nomeBanco) throws Exception {
        File arquivo = null;
        
        Path arquivoBanco =  Paths.get(getDiretorioBancoDados() + File.separator + nomeBanco);
        
//      Verifica se o diretorio não existe, se não existir, cria os diretórios.
        if (!Files.exists(arquivoBanco)) {
            arquivo = new File(getDiretorioBancoDados() + File.separator + nomeBanco);
            FileWriter fw = new FileWriter(arquivo);
        } 
    }

}
