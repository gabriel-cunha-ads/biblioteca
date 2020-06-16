package ui;


import javax.swing.JFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import service.AutorService;
import service.EditoraService;
import ui.dialog.FaqDialog;
import ui.dialog.SobreDialog;
import util.UtilComponentes;
/**
 *
  * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class DashboardUI extends javax.swing.JFrame {
   
    private static DashboardUI instance = null;
    
    private AutorService autorService;
    
    private EditoraService editoraService;
    
    
    public DashboardUI() throws Exception {
        
        initComponents();
        
        jLabelNomeTela.setText("Dashboard");
        
        autorService = new AutorService();
    
        editoraService = new EditoraService();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPrincipal = new javax.swing.JDesktopPane();
        jLabelNomeTela = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainMenu = new javax.swing.JMenuBar();
        JMenuLivro = new javax.swing.JMenu();
        JMenuItemAbrirLivrosUI = new javax.swing.JMenuItem();
        jMenuItemAbrirAutoresUI = new javax.swing.JMenuItem();
        jMenuItemAbrirEditoras = new javax.swing.JMenuItem();
        jMenuItemAbrirCargoUI = new javax.swing.JMenuItem();
        jMenuItemAbrirCDD = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        JMenuItemAbrirUsuariosUI = new javax.swing.JMenuItem();
        JMenuItemAbrirFuncionariosUI = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemAbrirAquisicoes = new javax.swing.JMenuItem();
        jMenuItemAbrirLivrosOperacoes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuCliente = new javax.swing.JMenu();
        menuCliente1 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAbrirFAQUI = new javax.swing.JMenuItem();
        jMenuItemAbrirSobreUI = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 770));

        jDesktopPrincipal.setBackground(new java.awt.Color(244, 240, 240));
        jDesktopPrincipal.setMaximumSize(new java.awt.Dimension(850, 600));
        jDesktopPrincipal.setMinimumSize(new java.awt.Dimension(500, 300));
        jDesktopPrincipal.setOpaque(false);
        jDesktopPrincipal.setPreferredSize(new java.awt.Dimension(850, 600));

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jLabelNomeTela.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabelNomeTela.setText("Dashboard");

        jSeparator1.setPreferredSize(new java.awt.Dimension(850, 1));

        mainMenu.setBackground(new java.awt.Color(255, 255, 255));

        JMenuLivro.setMnemonic('c');
        JMenuLivro.setText("Cadastro");

        JMenuItemAbrirLivrosUI.setMnemonic('l');
        JMenuItemAbrirLivrosUI.setText("Livros");
        JMenuItemAbrirLivrosUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemAbrirLivrosUIActionPerformed(evt);
            }
        });
        JMenuLivro.add(JMenuItemAbrirLivrosUI);

        jMenuItemAbrirAutoresUI.setMnemonic('a');
        jMenuItemAbrirAutoresUI.setText("Autores");
        jMenuItemAbrirAutoresUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirAutoresUIActionPerformed(evt);
            }
        });
        JMenuLivro.add(jMenuItemAbrirAutoresUI);

        jMenuItemAbrirEditoras.setMnemonic('e');
        jMenuItemAbrirEditoras.setText("Editoras");
        jMenuItemAbrirEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirEditorasActionPerformed(evt);
            }
        });
        JMenuLivro.add(jMenuItemAbrirEditoras);

        jMenuItemAbrirCargoUI.setMnemonic('c');
        jMenuItemAbrirCargoUI.setText("Cargos");
        jMenuItemAbrirCargoUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirCargoUIActionPerformed(evt);
            }
        });
        JMenuLivro.add(jMenuItemAbrirCargoUI);

        jMenuItemAbrirCDD.setMnemonic('l');
        jMenuItemAbrirCDD.setText("Classificação Decimal");
        jMenuItemAbrirCDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirCDDActionPerformed(evt);
            }
        });
        JMenuLivro.add(jMenuItemAbrirCDD);
        JMenuLivro.add(jSeparator2);

        JMenuItemAbrirUsuariosUI.setMnemonic('u');
        JMenuItemAbrirUsuariosUI.setText("Usuários");
        JMenuItemAbrirUsuariosUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemAbrirUsuariosUIActionPerformed(evt);
            }
        });
        JMenuLivro.add(JMenuItemAbrirUsuariosUI);

        JMenuItemAbrirFuncionariosUI.setMnemonic('f');
        JMenuItemAbrirFuncionariosUI.setText("Funcionários");
        JMenuItemAbrirFuncionariosUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuItemAbrirFuncionariosUIActionPerformed(evt);
            }
        });
        JMenuLivro.add(JMenuItemAbrirFuncionariosUI);
        JMenuLivro.add(jSeparator3);

        jMenuItemAbrirAquisicoes.setMnemonic('s');
        jMenuItemAbrirAquisicoes.setText("Sugestões");
        jMenuItemAbrirAquisicoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirAquisicoesActionPerformed(evt);
            }
        });
        JMenuLivro.add(jMenuItemAbrirAquisicoes);

        mainMenu.add(JMenuLivro);

        jMenuItemAbrirLivrosOperacoes.setMnemonic('o');
        jMenuItemAbrirLivrosOperacoes.setText("Operações");

        jMenuItem1.setText("Livros");
        jMenuItemAbrirLivrosOperacoes.add(jMenuItem1);

        mainMenu.add(jMenuItemAbrirLivrosOperacoes);

        menuCliente.setMnemonic('r');
        menuCliente.setText("Relatórios");
        mainMenu.add(menuCliente);

        menuCliente1.setMnemonic('n');
        menuCliente1.setText("Configurações");
        mainMenu.add(menuCliente1);

        jMenu1.setMnemonic('a');
        jMenu1.setText("Ajuda");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItemAbrirFAQUI.setText("FAQ");
        jMenuItemAbrirFAQUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirFAQUIActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbrirFAQUI);

        jMenuItemAbrirSobreUI.setText("Sobre");
        jMenuItemAbrirSobreUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirSobreUIActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbrirSobreUI);

        mainMenu.add(jMenu1);

        jMenu2.setMnemonic('s');
        jMenu2.setText("Sair");
        mainMenu.add(jMenu2);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeTela)
                            .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelNomeTela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMenuItemAbrirLivrosUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemAbrirLivrosUIActionPerformed

        try {
    //      Cria uma instância.
            LivrosUI livrosUI = new LivrosUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame AutoresUI.
            jDesktopPrincipal.add(livrosUI);

    //      Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(livrosUI);
        
    //      Mostra a tela.
            livrosUI.show();
        
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao abrir tela Autores. Entre com contato com suporte.");
        }        
        

//        livros.add(livro2);  
//        
////      Cria um instância de LivroPrincipalUI.
//        LivroPrincipalUI livrosPrincipalUI = new LivroPrincipalUI(livros);
//       
////      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
//        jDesktopPrincipal.add(livrosPrincipalUI);
//        
////      Remove barra de título e borda da janela
//        try {
//            UtilComponentes.removerBarraTituloEBorda(livrosPrincipalUI);
//        } catch (Exception ex) {
//            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        Mostra a tela LivrosPrincipal.
//        livrosPrincipalUI.show();
//        
//        try {
//            UtilComponentes.abrirJInternalFrameMaximizado(livrosPrincipalUI);
//        } catch (Exception ex) {
//            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
       
    }//GEN-LAST:event_JMenuItemAbrirLivrosUIActionPerformed

    private void JMenuItemAbrirUsuariosUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemAbrirUsuariosUIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenuItemAbrirUsuariosUIActionPerformed

    private void JMenuItemAbrirFuncionariosUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuItemAbrirFuncionariosUIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JMenuItemAbrirFuncionariosUIActionPerformed

    private void jMenuItemAbrirAutoresUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirAutoresUIActionPerformed
       
        try {
    //      Cria uma instância.
            AutoresUI autoresUI = new AutoresUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame AutoresUI.
            jDesktopPrincipal.add(autoresUI);

    //      Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(autoresUI);
        
    //      Mostra a tela.
            autoresUI.show();
        
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao abrir tela Autores. Entre com contato com suporte.");
        }
     
    }//GEN-LAST:event_jMenuItemAbrirAutoresUIActionPerformed

    private void jMenuItemAbrirAquisicoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirAquisicoesActionPerformed
        
    }//GEN-LAST:event_jMenuItemAbrirAquisicoesActionPerformed

    private void jMenuItemAbrirEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirEditorasActionPerformed
        try {
    //      Cria uma instância.
            EditorasUI editorasUI = new EditorasUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame AutoresUI.
            jDesktopPrincipal.add(editorasUI);

    //      Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(editorasUI);
        
    //      Mostra a tela.
            editorasUI.show();
        
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao abrir tela de Editora. Entre com contato com suporte.");
        }
    }//GEN-LAST:event_jMenuItemAbrirEditorasActionPerformed

    private void jMenuItemAbrirCDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirCDDActionPerformed
        try {
    //      Cria uma instância.
            ClassificacoesDecimalDireitoUI cddUI = new ClassificacoesDecimalDireitoUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame AutoresUI.
            jDesktopPrincipal.add(cddUI);

    //      Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(cddUI);
        
    //      Mostra a tela.
            cddUI.show();
        
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao abrir tela de Classificação Decimal. Entre com contato com suporte.");
        }
    }//GEN-LAST:event_jMenuItemAbrirCDDActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItemAbrirFAQUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirFAQUIActionPerformed
        FaqDialog FaqDialog = new FaqDialog();
        FaqDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAbrirFAQUIActionPerformed

    private void jMenuItemAbrirSobreUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirSobreUIActionPerformed
        SobreDialog sobreDialog = new SobreDialog();
        sobreDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAbrirSobreUIActionPerformed

    private void jMenuItemAbrirCargoUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirCargoUIActionPerformed
       try {
    //      Cria uma instância.
            CargosUI cargosUI = new CargosUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame AutoresUI.
            jDesktopPrincipal.add(cargosUI);

    //      Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(cargosUI);
        
    //      Mostra a tela.
            cargosUI.show();
        
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao abrir tela de Cargos. Entre com contato com suporte.");
        }
        
        
    }//GEN-LAST:event_jMenuItemAbrirCargoUIActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {  
                
//              Obtém a instância do objeto DashboardUI
                DashboardUI dashboardUI;
                try {
                    dashboardUI = DashboardUI.getInstance();

//                  Define a resoluçao full para a tela princiapal em qualquer dispositivo.
                    dashboardUI.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    
//                  Define com visível
                    dashboardUI.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JLabel getjLabelNomeTela() {
        return jLabelNomeTela;
    }

    public void setJLabelNomeTela(String jLabelNomeTela) {
        this.jLabelNomeTela.setText(jLabelNomeTela); 
    }

    public JDesktopPane getJDesktopPrincipal() {
        return jDesktopPrincipal;
    }
    
    public static DashboardUI getInstance() throws Exception {
        if (instance == null) {
            instance = new DashboardUI();
        }
        return instance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMenuItemAbrirFuncionariosUI;
    private javax.swing.JMenuItem JMenuItemAbrirLivrosUI;
    private javax.swing.JMenuItem JMenuItemAbrirUsuariosUI;
    private javax.swing.JMenu JMenuLivro;
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JLabel jLabelNomeTela;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAbrirAquisicoes;
    private javax.swing.JMenuItem jMenuItemAbrirAutoresUI;
    private javax.swing.JMenuItem jMenuItemAbrirCDD;
    private javax.swing.JMenuItem jMenuItemAbrirCargoUI;
    private javax.swing.JMenuItem jMenuItemAbrirEditoras;
    private javax.swing.JMenuItem jMenuItemAbrirFAQUI;
    private javax.swing.JMenu jMenuItemAbrirLivrosOperacoes;
    private javax.swing.JMenuItem jMenuItemAbrirSobreUI;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenu menuCliente;
    private javax.swing.JMenu menuCliente1;
    // End of variables declaration//GEN-END:variables
}
