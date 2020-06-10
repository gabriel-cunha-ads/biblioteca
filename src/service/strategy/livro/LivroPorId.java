package service.strategy.livro;

import entity.Livro;
import java.util.List;
import service.strategy.FiltroStrategy;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroPorId implements FiltroStrategy{

    @Override
    public Livro filtrarPor(Object objetoParaPesquisar, Object lista ) {
       
        Livro livro = (Livro) objetoParaPesquisar;
        
        List<Livro> livros = (List<Livro>) lista;

//      Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
        return livros.stream()
                    .filter(a -> livro.getIdLivro().equals(a.getIdLivro())) 
                    .findFirst()
                    .orElse(null);        
        
    }

}
