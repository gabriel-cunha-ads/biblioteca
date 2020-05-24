package ui;

import entity.Autor;
import exception.RegistroExistenteException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import repository.interfaces.Persistencia;
import service.AutorService;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorCadastroUI extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private Autor autorEditando;
    
    private AutorService autorService;
    
    public AutorCadastroUI() {
        initComponents();
        
        inicializarComponentes();
        
//      preencherEditandoAutor(autor)
    }

    private void inicializarComponentes() {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Cadastrar Autor");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
//      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
        UtilComponentes.maximizarJInternalFrame(this);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNomeAutor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirAutor = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setLabelFor(jTextFieldNomeAutor);
        jLabel1.setText("Nome");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonIncluirAutor.setMnemonic('i');
        jButtonIncluirAutor.setText("Inlcuir");
        jButtonIncluirAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirAutorActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonIncluirAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextFieldNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxAtivo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 176, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirAutor)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirAutorActionPerformed
        
        String nome = jTextFieldNomeAutor.getText().trim();
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldNomeAutor.setFocusable(true);
            return;
        }
        
        try {
            Autor autor     = new Autor(nome,true);

            autorService    = new AutorService();
            
            autorService.incluir(autor);
            
            UtilComponentes.limparCampos(jTextFieldNomeAutor);
            
            JOptionPane.showMessageDialog(this, "Autor incluído com sucesso!");
            
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldNomeAutor.requestFocus();
              }
            });            
            
        } catch (RegistroExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldNomeAutor);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro de Autor", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldNomeAutor.requestFocus();
              }
            });                
             
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir o autor. Entre em contato com nosso suporte.",
                    "Cadastro de Autor", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirAutorActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Autores");
        
        jDesktopPane.remove(this);
        
        try {
            List<Autor> autores = autorService.listar();
           
            AutoresUI autoresUI = new AutoresUI(autores);
            
    //      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
            jDesktopPane.add(autoresUI);

    //      Remove barra de título e borda da janela
            try {
                UtilComponentes.removerBarraTituloEBorda(autoresUI);
            } catch (Exception ex) {
                Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            }

    //        Mostra a tela LivrosPrincipal.
            autoresUI.show();            
            
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, ex);
            jDesktopPane.add(new DashboardUI());
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirAutor;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldNomeAutor;
    // End of variables declaration//GEN-END:variables


}
