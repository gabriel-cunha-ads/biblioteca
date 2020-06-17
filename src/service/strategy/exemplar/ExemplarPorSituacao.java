package service.strategy.exemplar;

import entity.Exemplar;
import java.util.List;
import service.strategy.FiltroStrategy;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ExemplarPorSituacao implements FiltroStrategy{

    @Override
    public Exemplar filtrarPor(Object objetoParaPesquisar, Object lista ) {
       
        Exemplar exemplar = (Exemplar) objetoParaPesquisar;
        
        List<Exemplar> exemplares = (List<Exemplar>) lista;

//      Percorrendo a lista com API Stream do java 8 e filtrando pela situacao.
        return exemplares.stream()
                    .filter(a -> exemplar.getSituacao().equals(a.getSituacao())) 
                    .findFirst()
                    .orElse(null);        
        
    }

}
