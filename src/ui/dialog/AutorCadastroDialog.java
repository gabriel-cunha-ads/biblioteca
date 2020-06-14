/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.dialog;

import entity.Autor;
import entity.vo.AutorVO;
import exception.RegistroExistenteException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.AutorService;
import ui.AutorCadastroUI;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorCadastroDialog extends javax.swing.JFrame {

    private AutorService autorService;

    private JComboBox box;
    
    public AutorCadastroDialog() {
        initComponents();
    }
    
    public AutorCadastroDialog(JComboBox box) {
        this();
        this.box = box;
    }    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldNomeAutor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonInlcuirNovoAutor = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(380, 250));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Incluir Novo Autor");

        jLabel2.setText("Nome");

        jButtonInlcuirNovoAutor.setMnemonic('i');
        jButtonInlcuirNovoAutor.setText("Incluir");
        jButtonInlcuirNovoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInlcuirNovoAutorActionPerformed(evt);
            }
        });

        jButton2.setMnemonic('s');
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Ativo");
        jCheckBox1.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonInlcuirNovoAutor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1))
                            .addComponent(jTextFieldNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInlcuirNovoAutor)
                    .addComponent(jButton2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonInlcuirNovoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInlcuirNovoAutorActionPerformed
        String nome = jTextFieldNomeAutor.getText().trim();
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldNomeAutor.setFocusable(true);
            return;
        }                

        try {
            autorService = new AutorService();

            Autor autor     = new Autor(nome,true);

            autorService.incluir(autor);

            UtilComponentes.limparCampos(jTextFieldNomeAutor);
            
            this.dispose();
            
            JOptionPane.showMessageDialog(this, "Autor Incluído com sucesso!",
                "Cadastro Autor", JOptionPane.DEFAULT_OPTION); 
            
//          Atualiza jComboBox
            Vector<AutorVO> autoresVO = autorService.carregarVetorComboBox();
            box.setModel(new DefaultComboBoxModel(autoresVO));
            box.setSelectedItem(autoresVO.lastElement());
            SwingUtilities.updateComponentTreeUI(box);
            
        } catch (RegistroExistenteException e) {
            JOptionPane.showMessageDialog(this, "Cadastro já existente. Tente novamente.",
                    "Cadastro Autor", JOptionPane.DEFAULT_OPTION);              
        } catch (Exception e) {
             Logger.getLogger(AutorCadastroUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Ocorreu um erro. Entre em contato com nosso suporte.",
                    "Cadastro Autor", JOptionPane.DEFAULT_OPTION);                
        }
         
    }//GEN-LAST:event_jButtonInlcuirNovoAutorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutorCadastroDialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonInlcuirNovoAutor;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldNomeAutor;
    // End of variables declaration//GEN-END:variables
}
