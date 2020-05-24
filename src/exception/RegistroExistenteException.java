package exception;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class RegistroExistenteException extends Exception{
	
    private static final long serialVersionUID = 1L;
    
    public RegistroExistenteException() {
        super();
    }
    
    public RegistroExistenteException(String message) {
        super(message);
    }
    
        
    public RegistroExistenteException(Throwable t) {
        super("Registro já existente na base de dados.", t);
    }
	
    @Override
    public String toString() {
            return this.getClass().getSimpleName()+": "+getMessage();
    }    
}
