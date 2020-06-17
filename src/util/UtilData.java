package util;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UtilData {
    
    public static DateTimeFormatter getFormatoData() {
        return  DateTimeFormatter.ofPattern("dd/MM/yyyy");  
    }
    
}
