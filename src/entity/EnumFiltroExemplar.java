package entity;

import service.strategy.FiltroStrategy;
import service.strategy.exemplar.ExemplarPorISBN;
import service.strategy.exemplar.ExemplarPorId;
import service.strategy.exemplar.ExemplarPorSituacao;
import service.strategy.exemplar.ExemplarPorTitulo;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public enum EnumFiltroExemplar {
    
    ID {
        @Override
        public FiltroStrategy filtrarPor() {
            return new ExemplarPorId();
        }
    },
    TITULO {
        @Override
        public FiltroStrategy filtrarPor() {
            return new ExemplarPorTitulo();
        }
    },
    ISBN {
        @Override
        public FiltroStrategy filtrarPor() {
            return new ExemplarPorISBN();
        }
    },
    SITUACAO {
        @Override
        public FiltroStrategy filtrarPor() {
            return new ExemplarPorSituacao();
        }
    };    
    
    public abstract FiltroStrategy filtrarPor();


}
