package ui.components;
import entity.Autor;
import java.util.List;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorTableModel extends ViewAbstractTableModel<Autor> {

    public AutorTableModel(List<Autor> linhas) {
        super(linhas);
        // Nomes das colunas do cabeçalho da tabela.
        colunas = new String[] {
            "id", 
            "Nome",
            "ativo",
            "Selecionar"
        };
    };

//    Recupera o valor do objeto de uma célula. 
    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        Autor autor = linhas.get(indexLinha);
        switch(indexColuna) {
            case 0: 
                return autor.getId();
            case 1: 
                return autor.getNome();
            case 2: 
                return autor.isAtivo();    
            case 3: 
                return autor.isSelecionado();     
            default:
                return null;
        }
    }
    
    /**
     * Defini o valor de uma célula na posição informada.
     * Esta implementação foi sobrescrita para permitir alterar o valor de 
     * uma célula somente se o tipo de dado for Boolean.
     * @param linha int - índice da linha da tabela.
     * @param coluna int - índice da coluna da tabela.
     * @param objeto Object - valor a ser inserido na linha da tabela.
    */    
    @Override
    public void setValueAt(Object objeto, int linha, int coluna) {
        Autor autor = linhas.get(linha);
        
        if (autor.isSelecionado()) {
            autor.setSelecionado(false);
        } else {
            autor.setSelecionado(true);
        }

        for (Autor autorDaLista : linhas) {
        
            if (!autorDaLista.equals(autor) && autorDaLista.isSelecionado()) {
                autorDaLista.setSelecionado(false);
                fireTableCellUpdated(linhas.indexOf(autorDaLista), coluna);
            }
            
        }
        fireTableCellUpdated(linha, coluna);
    }   
    
}