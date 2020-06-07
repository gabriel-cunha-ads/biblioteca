package exception;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class RegistroNaoExistenteException extends Exception{
	
    private static final long serialVersionUID = 1L;
      
    public RegistroNaoExistenteException() {
        super("Registro NÃO existente na base de dados.");
    }
	
    @Override
    public String toString() {
            return this.getClass().getSimpleName()+": "+getMessage();
    }    
}
