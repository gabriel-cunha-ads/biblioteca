package ui.components;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ui.DashboardUI;
import ui.LivroCadastroUI;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class TableListener implements ListSelectionListener{
    
    private final JDesktopPane jDesktopPane;
    
    private final DashboardUI dashboardUI;
    
    private final JTable tabela;
    
    private final JInternalFrame tela;
    
    public TableListener(JTable tabela, JInternalFrame tela) {

        this.tabela = tabela;
        
        this.tela = tela;
        
//      Obtém a instancia do dashboard principal
        dashboardUI =  DashboardUI.getInstance();
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) { 
        
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        
        if (lsm.isSelectionEmpty()) return;

//        String firstIndex = "" + e.getFirstIndex();
//        String lastIndex = "" + e.getLastIndex();


//        if (!e.getValueIsAdjusting()) {
//            int indexLinha = lsm.getMinSelectionIndex();
//            
//            tabela.getValueAt(indexLinha, 0);
//            
//            LivroCadastroUI livroCadastroUI = new LivroCadastroUI("livro");
//            jDesktopPane.remove(tela);
//            jDesktopPane.add(livroCadastroUI);
//
//    //      Remove barra de título e borda da janela
//            try {
//                UtilComponentes.removerBarraTituloEBorda(livroCadastroUI);
//            } catch (Exception ex) {
//                Logger.getLogger(DashboardUI.class.getName()).log(Level.ALL.SEVERE, null, ex);
//            }        
//
////          Abre a tela para edição do objeto.
//            livroCadastroUI.pack();
//            livroCadastroUI.show();
//            tela.dispose();
//        }
        
//        System.out.println(String.format("firtsIndes %s lastIndex %s " , firstIndex, lastIndex));
        
//            output.append("Event for indexes "
//                          + firstIndex + " - " + lastIndex
//                          + "; isAdjusting is " + isAdjusting
//                          + "; selected indexes:");

//        if (lsm.isSelectionEmpty()) {
////                output.append(" <none>");
//
//        } else {
//            // Find out which indexes are selected.
//            int minIndex = lsm.getMinSelectionIndex();
//            int maxIndex = lsm.getMaxSelectionIndex();
//            for (int i = minIndex; i <= maxIndex; i++) {
//                if (lsm.isSelectedIndex(i)) {
////                        output.append(" " + i);
//                }
//            }
//        }

    }
    
}
