package ui;

import java.util.List;
import entity.Autor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import service.AutorService;
import ui.components.AutorTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class AutoresUI extends javax.swing.JInternalFrame implements ActionListener  {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private AutorService autorService;
       
    
    public AutoresUI(List<Autor> autores) throws Exception {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosAutores(autores);
        
    }

    private void inicializarComponentes() throws Exception {
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Autores");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        autorService = new AutorService();
    }
    
    public void inicializarTabelaDadosAutores(List<Autor> autores) {
//      Instancia um novo LivroTableModel passando a lista de livros.
        AutorTableModel autorTableModel = new AutorTableModel(autores);

        UtilTabela.inicializarTabela(jTableAutores, autorTableModel);
    }
  
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisarAutor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAutores = new javax.swing.JTable();
        jButtonAbrirAutorCadastroUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonAbrirLivroCadastroUI1 = new javax.swing.JButton();
        jButtonAbrirEditarAutor = new javax.swing.JButton();
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

        jButtonPesquisarAutor.setMnemonic('p');
        jButtonPesquisarAutor.setText("pesquisar");
        jButtonPesquisarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarAutorActionPerformed(evt);
            }
        });

        jTableAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAutores.setColumnSelectionAllowed(true);
        jTableAutores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableAutores.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableAutores);
        jTableAutores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirAutorCadastroUI.setMnemonic('i');
        jButtonAbrirAutorCadastroUI.setText("Incluir");
        jButtonAbrirAutorCadastroUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirAutorCadastroUIActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jButtonAbrirLivroCadastroUI1.setMnemonic('x');
        jButtonAbrirLivroCadastroUI1.setText("Excluir");
        jButtonAbrirLivroCadastroUI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirLivroCadastroUI1ActionPerformed(evt);
            }
        });

        jButtonAbrirEditarAutor.setMnemonic('e');
        jButtonAbrirEditarAutor.setText("Editar");
        jButtonAbrirEditarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirEditarAutorActionPerformed(evt);
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
                        .addComponent(jButtonAbrirAutorCadastroUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAbrirEditarAutor)
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
                                .addComponent(jButtonPesquisarAutor)))
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
                    .addComponent(jButtonPesquisarAutor))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAbrirAutorCadastroUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonAbrirLivroCadastroUI1)
                        .addComponent(jButtonAbrirEditarAutor))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTextoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTextoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTextoPesquisaActionPerformed

    private void jButtonAbrirAutorCadastroUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirAutorCadastroUIActionPerformed
        this.dispose();
        
        jDesktopPane.remove(this);
        
//      Cria um instância de LivroPrincipalUI.
        AutorCadastroUI autorCadastroUI = new AutorCadastroUI();
       
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(autorCadastroUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(autorCadastroUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        autorCadastroUI.show();
    }//GEN-LAST:event_jButtonAbrirAutorCadastroUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Dashboard");
        
        jDesktopPane.remove(this);
        

    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonAbrirLivroCadastroUI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirLivroCadastroUI1ActionPerformed
        
    }//GEN-LAST:event_jButtonAbrirLivroCadastroUI1ActionPerformed

    private void jButtonAbrirEditarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirEditarAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAbrirEditarAutorActionPerformed

    private void jButtonPesquisarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarAutorActionPerformed
        String textoPesquisa = jTextFieldTextoPesquisa.getText().trim();
        
        if (textoPesquisa.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            return;
        }
        
        try {
            Autor autorBanco = autorService.consultar(textoPesquisa);
            if (autorBanco == null){
                UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
                JOptionPane.showMessageDialog(this, "Não há resultados para a pesquisa.");  
            }
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Não foi possível pesquisar. Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonPesquisarAutorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirAutorCadastroUI;
    private javax.swing.JButton jButtonAbrirEditarAutor;
    private javax.swing.JButton jButtonAbrirLivroCadastroUI1;
    private javax.swing.JButton jButtonPesquisarAutor;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableAutores;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

