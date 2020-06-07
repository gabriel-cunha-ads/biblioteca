package util;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class UtilTabela {
    
    public static JTable inicializarTabela(JTable tabela, AbstractTableModel modelo ) {

//      Insere a LivroTableModel dentro da tabela da tela.
        tabela.setModel(modelo);

//      Quando clica em uma célula, seleciona toda linha.
        tabela.setRowSelectionAllowed(true);

//      Desabilita a seleção de coluna da tabela.
        tabela.setColumnSelectionAllowed(false);   
        
        return tabela;
    }    
    
    /**
    * obtenha todas as linhas selecionadas e DELETE uma a uma da última.
    *
    * @param tabela tabela para deletar as linhas
    */
   public static void deletarTodasLinhas(JTable tabela) {
       int[] selectedrows = tabela.getSelectedRows();
       for (int row : selectedrows) {
           row = tabela.getSelectedRow();
           if (tabela.getRowSorter() != null) {
               row = tabela.getRowSorter().convertRowIndexToModel(row);
           }
           ((DefaultTableModel) tabela.getModel()).removeRow(row);
       }
   }

}
