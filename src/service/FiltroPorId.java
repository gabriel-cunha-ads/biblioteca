package service;

import entity.Livro;
import java.util.List;
import service.strategy.FiltroStrategy;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class FiltroPorId implements FiltroStrategy{

    @Override
    public Livro filtrarPor(Object objetoParaPesquisar, Object lista) {
        
        Livro livroParaPesquisa = (Livro) objetoParaPesquisar;
        
        List<Livro> livros = (List<Livro>) lista;
        
        return livros.stream()
                .filter(a -> a.getIdLivro().equals(livroParaPesquisa.getIdLivro()))
                .findFirst()
                .orElse(null);
    }

}
