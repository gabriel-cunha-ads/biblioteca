package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UtilString {
    
    	
    public static boolean ehTextoSemCaracteresNumericos(String str) {
            String regex = "^[a-zA-Z]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);

            if (matcher.matches()) {
                    return true;
            }	

            return false;
    }
    

	public void gerador_url_confirmacao_cadastro() throws Exception {
		
            List<String> names = new ArrayList<String>();

            names.add("GABRIEL CUNHA TESTE");  
            names.add("LOkesh123");  
            names.add("LOkesh_ -");  //Incorrect
            names.add("LOkesh Göiania Goiás");  //Incorrect

            String regex = "^[a-zA-Z0-9]+$";

            Pattern pattern = Pattern.compile(regex);

            for (String name : names) {
              Matcher matcher = pattern.matcher(name);
              System.out.println(matcher.matches());
            }		

//		String email	= "gabrielcunhadev@gmail.com";
//		String cpf 		= "80623280078";
//		
//		String urlBase = "http://localhost:8080/confirma-cadastro/";
//		
//		String urlCompleta = urlBase + Base64.getUrlEncoder().encodeToString((email + "|" + cpf).getBytes());
//		
////		String urlCompleta = new String(Base64.getDecoder().decode("dXN1YXJpbzcxODc="));
//		
//		System.out.println(urlCompleta);
        }

}
