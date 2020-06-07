package repository.interfaces;

import java.util.List;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public interface Persistencia<E> {
    
    /**
     * Responsável por incluir um novo registro.
     * @param objeto - objeto a ser persistido.
     * @throws java.lang.Exception
     */
    void incluir(Object objeto) throws Exception;
    
    /**
     * Responsável por alterar um registro existente.
     * @param objeto - objeto a ser alterado.
     * @throws java.lang.Exception
     */
    void alterar(Object objeto) throws Exception;
    
    /**
     * Responsável por listar todos os registros.
     * @return Lista - lista contendo os registros.
     * @throws java.lang.Exception
     */
    List<E> listar() throws Exception;
    
    /**
     * Responsável por excluir um registro.
     * @param objeto -  objeto a ser excluido.
     * @throws java.lang.Exception
     */
    void excluir(Object objeto) throws Exception;
    
    /**
     * Responsável por consultar um objeto específico.
     * @param e - objeto consultado.
     * @throws java.lang.Exception
     */
    Object consultar(Object objeto) throws Exception;
    
//    Object consultar(String str) throws Exception;
    
    Integer consultarUltimoID() throws Exception;
    
}
