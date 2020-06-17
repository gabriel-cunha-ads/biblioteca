package util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */

public class UtilObjetos {

    /**
     * Retorna true se a colecao for null ou vazia. 
     * @param collection
     * @return true | false
     */
    public static Boolean ehNuloOuVazio(Collection<?> colecao) {
            if (colecao == null || colecao.isEmpty()) {
                    return true;
            }			
            return false;
    }

    /**
     * Retorna true se o mapa for null ou vazio. 
     * @param Map
     * @return true | false
     */
    public static Boolean ehNuloOuVazio(Map<?, ?> mapa) {
            if (mapa == null || mapa.isEmpty()) {
                    return true;
            }			
            return false;
    }

    /**
     * Retorna true se o objeto for null. 
     * @param Object
     * @return true | false
     */
    public static Boolean ehNuloOuVazio(Object objeto) {
            if (objeto == null) {
                    return true;
            }			
            return false;
    }

    /**
     * Retorna true se o array de objeto for null ou igual a zero.
     * @param Object[]
     * @return true | false
     */
    public static Boolean ehNuloOuVazio(Object[] objeto) {
            if (objeto == null || objeto.length == 0) {
                    return true;
            }			
            return false;
    }

    /**
     * Retorna true se o string for null ou tiver tamanho igual a zero. 
     * @param String
     * @return true | false
     */
    public static Boolean ehNuloOuVazio(String string) {
            if (string == null || string.trim().length() == 0) {
                    return true;
            }			
            return false;
    }
    
    /**
     * Preenche os atributos de um objeto com os valores default de criação da instancia
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T preencherAtributos(Object object) {
            try {
                    for (Field field : object.getClass().getDeclaredFields()) {
                            field.setAccessible(true);
                            if (!field.getType().isPrimitive()) {
                                    if (field.getType().isEnum() || field.getType().equals(List.class)) {
                                            field.set(object, null);
                                    } else if (field.getType().equals(Integer.class)) {
                                            field.set(object, new Integer(0));
                                    } else if (field.getType().equals(BigDecimal.class)) {
                                            field.set(object, BigDecimal.ZERO);
                                    } else if (field.getType().equals(Double.class)) {
                                            field.set(object, new Double(0));						
                                    } else {
                                        field.set(object, field.getType().newInstance());	        
                                    }
                                    if (field.getType().getPackage().equals(object.getClass().getPackage())) {
                                            preencherAtributos(field.get(object));
                                    }
                            }
                    }
                    return (T) object;
            } catch (Exception e) {
                    return null;
            }
    }    

}
