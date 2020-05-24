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
     * Defini se a celula pode ser editavel.
     * Essa implementação foi sobrescrita para  permitir ser editável somente 
     * objetos que sejam do tipo Boolean.
     * @param linha - linha da tabela
     * @param coluna - coluna da tabela
     * @return booelan - informando se é permitido a edição da celula.
     */
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        Object objeto = getValueAt(linha, coluna);
        
        if (objeto instanceof Boolean) {
            return true;
        } else {
            return false;
        }
    }      
    
   /**
    * JTable usa esse método para determinar o renderizador padrão editor para 
    * cada célula. Se não implementássemos esse método, a última coluna 
    * conteria texto ("true" / "false"), * em vez de uma caixa de seleção.
    * @param c
    * @return 
    */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
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



