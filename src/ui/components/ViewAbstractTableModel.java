package ui.components;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public abstract class ViewAbstractTableModel<E> extends AbstractTableModel{
            
    protected List<E> linhas;
    protected String[] colunas;
    
    public ViewAbstractTableModel(List<E> linhas) {
        this.linhas = linhas;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    /**
     * Retorna qual é o nome da coluna na respectiva posição. 
     * A primeira posição de uma coluna é Zero.    
     * @param indexColuna - indice da coluna que quer recupera o nome.
     * @return 
     */
    @Override
    public String getColumnName(int indexColuna) {
        if (indexColuna < getColumnCount()) {
            return colunas[indexColuna];
        }
        return super.getColumnName(indexColuna);
    }
    
    /**
     * Obtém o objeto E da List a partir da linha informada.
     * @param row int - Representa a linha da tabela.
     * @return E - objeto da linha da tabela
    */
    public E getValorDaLinha(int row) {
        return linhas.get(row);
    }
}



