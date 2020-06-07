package service.interfaces;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public interface CompletionService<T> {
    
    /**
     * Autcomplete automático da String passada. 
     * O método retornará a correspondência objeto quando um único objeto 
     * corresponde aos critérios de pesquisa. 
     * Enquanto vários objetos armazenados no serviço correspondem, 
     * o método retornará <code>null</code>.
     * 
     * @param comecandoCom 
     *            prefix string
     * @return o objeto correspondente ou <code>null</code> se várias 
     *         correspondências forem encontradas
     */
    T autoComplete(String comecandoCom);    
}
