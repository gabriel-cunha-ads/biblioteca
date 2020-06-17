package service.strategy.exemplar;

import entity.Exemplar;
import java.util.List;
import service.strategy.FiltroStrategy;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ExemplarPorTitulo implements FiltroStrategy{

    @Override
    public Exemplar filtrarPor(Object objetoParaPesquisar, Object lista ) {
       
        Exemplar exemplar = (Exemplar) objetoParaPesquisar;
        
        List<Exemplar> exemplares = (List<Exemplar>) lista;

//      Percorrendo a lista com API Stream do java 8 e filtrando pelo id.
        return exemplares.stream()
                    .filter(a -> exemplar.getLivro().getTitulo().equals(a.getLivro().getTitulo())) 
                    .findFirst()
                    .orElse(null);        
        
    }

}
