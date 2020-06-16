package entity;

import service.strategy.livro.LivroPorId;
import service.strategy.FiltroStrategy;
import service.strategy.livro.LivroPorISBN;
import service.strategy.livro.LivroPorTitulo;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public enum EnumFiltroLivro {
    
    ID {
        @Override
        public FiltroStrategy filtrarPor() {
            return new LivroPorId();
        }
    },
    TITULO {
        @Override
        public FiltroStrategy filtrarPor() {
            return new LivroPorTitulo();
        }
    },
    ISBN {
        @Override
        public FiltroStrategy filtrarPor() {
            return new LivroPorISBN();
        }
    };
    
    public abstract FiltroStrategy filtrarPor();
}
