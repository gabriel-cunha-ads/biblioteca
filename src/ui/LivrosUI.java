package ui;

import java.util.List;
import ui.components.LivroTableModel;
import entity.Livro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import ui.components.TableListener;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class LivrosUI extends javax.swing.JInternalFrame implements ActionListener  {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
   
    
    public LivrosUI(List<Livro> livros) {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosLivros(livros);
        
    }

    private void inicializarComponentes() {
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Livros");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
    }
    
    public void inicializarTabelaDadosLivros(List<Livro> livros) {
        
//      Instancia um novo LivroTableModel passando a lista de livros.
        LivroTableModel livroTableModel = new LivroTableModel(livros);

        UtilTabela.inicializarTabela(jTableLivros, livroTableModel);

    }
  
        @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jButtonAbrirLivroCadastroUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonAbrirLivroCadastroUI1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNextFocusableComponent(jTextFieldTextoPesquisa);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jTextFieldTextoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTextoPesquisaActionPerformed(evt);
            }
        });

        jButton1.setText("pesquisar");

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableLivros.setColumnSelectionAllowed(true);
        jTableLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableLivros.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableLivros);
        jTableLivros.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirLivroCadastroUI.setText("Incluir");
        jButtonAbrirLivroCadastroUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirLivroCadastroUIActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Título");

        jButtonAbrirLivroCadastroUI1.setText("Excluir");
        jButtonAbrirLivroCadastroUI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirLivroCadastroUI1ActionPerformed(evt);
            }
        });

        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSeparator2.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAbrirLivroCadastroUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonAbrirLivroCadastroUI1)
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAbrirLivroCadastroUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonAbrirLivroCadastroUI1)
                        .addComponent(jButton3))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTextoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTextoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTextoPesquisaActionPerformed

    private void jButtonAbrirLivroCadastroUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirLivroCadastroUIActionPerformed
        
        LivroCadastroUI livroCadastroUI = new LivroCadastroUI("livro");
        jDesktopPane.remove(this);
        jDesktopPane.add(livroCadastroUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(livroCadastroUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        livroCadastroUI.pack();
        livroCadastroUI.show();
        this.dispose();
        
        try {
            livroCadastroUI.setMaximum(true);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAbrirLivroCadastroUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
        dashboardUI.setJLabelNomeTela("Dashboard");
        jDesktopPane.remove(this);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonAbrirLivroCadastroUI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirLivroCadastroUI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAbrirLivroCadastroUI1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAbrirLivroCadastroUI;
    private javax.swing.JButton jButtonAbrirLivroCadastroUI1;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


}

