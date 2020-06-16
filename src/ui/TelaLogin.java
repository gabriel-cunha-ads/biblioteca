package ui;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Aires Ribeiro
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jButtonEntrar = new javax.swing.JButton();
        jLabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Bibioteca2.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 125, 252, 138);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Autenticação de Usuário");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(107, 11, 281, 29);

        jLabel5.setFont(new java.awt.Font("Edwardian Script ITC", 1, 36)); // NOI18N
        jLabel5.setText("Biblioteca Godofredo & Associados");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(55, 58, 439, 43);
        getContentPane().add(jPasswordFieldSenha);
        jPasswordFieldSenha.setBounds(330, 160, 186, 20);
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(330, 120, 186, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Senha:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 160, 45, 17);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Usuário:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 120, 52, 17);

        jButtonSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonSair.setText("Sair");
        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(420, 240, 86, 25);

        jButtonEntrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButtonEntrar.setText("Entrar");
        getContentPane().add(jButtonEntrar);
        jButtonEntrar.setBounds(310, 240, 86, 25);

        jLabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Fundo azul - Matis 133, vermelho 237, sat 240, verde 249, lum 232, azul 255 - 1368 x 728.png"))); // NOI18N
        jLabelFundo.setText("jLabel6");
        getContentPane().add(jLabelFundo);
        jLabelFundo.setBounds(0, 0, 520, 280);

        setSize(new java.awt.Dimension(534, 313));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        // TODO add your handling code here:
        try {
            if(jTextFieldUsuario.getText().equals("Aires")&& jPasswordFieldSenha.getText().equals("1234")){
                DashboardUI tela = new DashboardUI();   //Chamar a tela
                              tela.setVisible(true);        //Tornar a tela visivel
                dispose();                                  //Fechar a tela de login e abrir apenas a tela principal
            }else{
                JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
            }
        } catch (Exception erro) {
            try {
                throw erro;
            } catch (Exception ex) {
                Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
   
        System.exit(0);                                 //Sai do sistema fechando a tela
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jPasswordFieldSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldSenhaKeyPressed
        // TODO add your handling code here:
     try {
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)   
         if(jTextFieldUsuario.getText().equals("Aires")&& jPasswordFieldSenha.getText().equals("1234")){
                DashboardUI tela = new DashboardUI();   //Chamar a tela
                              tela.setVisible(true);        //Tornar a tela visivel
                dispose();                                  //Fechar a tela de login e abrir apenas a tela principal
            }else{
                JOptionPane.showMessageDialog(rootPane, "Acesso Negado!");
            }
        } catch (Exception erro) {
         try {
             throw erro;
         } catch (Exception ex) {
             Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }//GEN-LAST:event_jPasswordFieldSenhaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
     

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelFundo;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}
