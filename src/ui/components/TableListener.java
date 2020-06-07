package ui.components;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ui.DashboardUI;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
@Deprecated
public class TableListener implements ListSelectionListener{
    
    private final JDesktopPane jDesktopPane;
    
    private final DashboardUI dashboardUI;
    
    private final JTable tabela;
    
    private final List<?> lista;
    
    public TableListener(JTable tabela, List<?> lista) {
        
        this.lista = lista;

        this.tabela = tabela;
        
//      Obtém a instancia do dashboard principal
        dashboardUI =  DashboardUI.getInstance();
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) { 
        
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        
//        if (lsm.isSelectionEmpty()) return;
//
//        if (!e.getValueIsAdjusting()) {
//            int minIndex = lsm.getMinSelectionIndex();
//            int maxIndex = lsm.getMaxSelectionIndex();
//            
//            for (int i = minIndex; i <= maxIndex; i++) {
//                if (lsm.isSelectedIndex(i)) {

//                    int index = tabela.getSelectedRow();
//                    ViewAbstractTableModel model = (ViewAbstractTableModel) tabela.getModel();
//                    Object objeto = model.getValorDaLinha(index);
//                    
//                    this.lista.remove(objeto);
//                    this.lista.add();
//                    
//                    System.out.println(this.lista);

                    
//                }
//            }
            
//            jDesktopPane.remove(tela);
//            jDesktopPane.add(livroCadastroUI);

    //      Remove barra de título e borda da janela
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
