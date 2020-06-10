package entity;

import service.strategy.livro.LivroPorId;
import service.strategy.FiltroStrategy;

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
    NOME {
        @Override
        public FiltroStrategy filtrarPor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    TITULO {
        @Override
        public FiltroStrategy filtrarPor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    },
    ISBN {
        @Override
        public FiltroStrategy filtrarPor() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    
    public abstract FiltroStrategy filtrarPor();
}
