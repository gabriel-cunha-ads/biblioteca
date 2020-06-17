package ui;

import entity.Exemplar;
import entity.EnumOperacaoBanco;
import entity.Livro;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.ExemplarService;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ExemplarCadastroUI extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private Livro livroDoExemplar;
    
    private ExemplarService exemplarService = new ExemplarService();
    
    
    public ExemplarCadastroUI() throws Exception {
        initComponents();
        inicializarComponentes();
    }
    
    public ExemplarCadastroUI(Livro exemplarDoLivro) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Incluir Exemplar");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirExemplar.setText("Incluir");
        
        this.livroDoExemplar = exemplarDoLivro;
        
        preencherCamposDaTelaComExemplarEditando(livroDoExemplar);
    }    

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Cadastrar Exemplar");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        
//      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
        UtilComponentes.maximizarJInternalFrame(this);
    }
    
    public void preencherCamposDaTelaComExemplarEditando(Livro livroDoExemplar) {
        jTextFieldIdLivro.setText(String.valueOf(livroDoExemplar.getId()));
        jTextFieldTitulo.setText(livroDoExemplar.getTitulo());
        jCheckBoxAtivo.setSelected(true);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirExemplar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextFieldIdLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPrecoCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jTextFieldTitulo.setEnabled(false);

        jLabel1.setLabelFor(jTextFieldTitulo);
        jLabel1.setText("Título");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonIncluirExemplar.setMnemonic('i');
        jButtonIncluirExemplar.setText("Inlcuir");
        jButtonIncluirExemplar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirExemplarActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jTextFieldIdLivro.setEnabled(false);

        jLabel2.setLabelFor(jTextFieldTitulo);
        jLabel2.setText("Id Livro");

        jLabel3.setLabelFor(jTextFieldTitulo);
        jLabel3.setText("Preço Compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonIncluirExemplar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextFieldIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBoxAtivo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jCheckBoxAtivo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirExemplar)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirExemplarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirExemplarActionPerformed
        
        Double valorCompra = Double.parseDouble(jTextFieldPrecoCompra.getText());
        
        if (jTextFieldPrecoCompra.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Campo preço de compra não pode ser nulo.");
            jTextFieldPrecoCompra.setFocusable(true);
            return;
        }
        
        try {
            Exemplar exemplar = new Exemplar(livroDoExemplar, valorCompra);

            exemplarService.incluir(exemplar);

            finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
         
        } catch (RegistroExistenteException e) {
            
            UtilComponentes.limparCampos(jTextFieldPrecoCompra);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro de Exemplar", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTitulo.requestFocus();
              }
            });                
             
        } catch (RegistroNaoExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTitulo);
            
             JOptionPane.showMessageDialog(this, "Registro NÃO existente para edição.",
                    "Cadastro Exemplar", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTitulo.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir o exemplar. Entre em contato com nosso suporte.",
                    "Cadastro de Exemplar", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirExemplarActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws HeadlessException, Exception {
        try {

            JOptionPane.showOptionDialog(null, "Exemplar alterado com sucesso!", "Cadastro de Exemplar!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            dashboardUI.setJLabelNomeTela("Livros");

            jDesktopPane.remove(this);

            abrirTelaLivrosUI();         
            
        } catch (Exception ex) {
            Logger.getLogger(ExemplarCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
            jDesktopPane.add(new DashboardUI());
        }                  
    }



    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Exemplares");
        
//        jDesktopPane.remove(this);
        
        jDesktopPane = new JDesktopPane();
        
        try {
            abrirTelaLivrosUI();            
            
        } catch (Exception ex) {
            Logger.getLogger(ExemplarCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());
            } catch (Exception ex1) {
                Logger.getLogger(ExemplarCadastroUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    protected void abrirTelaLivrosUI() throws Exception {
        try {
            LivrosUI livrosUI = new LivrosUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
            jDesktopPane.add(livrosUI);

    //      Remove barra de título e borda da janela
                UtilComponentes.removerBarraTituloEBorda(livrosUI);

    //      Mostra a tela LivrosPrincipal.
            livrosUI.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirExemplar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldIdLivro;
    private javax.swing.JTextField jTextFieldPrecoCompra;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables

}
