package ui;

import entity.Livro;
import entity.EnumOperacaoBanco;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.MaskFormatter;
import service.LivroService;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroCadastroUI extends javax.swing.JInternalFrame {
    
    private static final DateFormat df = new SimpleDateFormat("dd/mm/yyyy");    

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private boolean editandoLivro;
    
    private Livro livroEmEdicao;
    
    private LivroService livroService;
    
    
    public LivroCadastroUI() throws Exception {
        initComponents();
        inicializarComponentes();
    }
    
    public LivroCadastroUI(Livro livroEmEdicao) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editar Livro");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarLivro.setText("Salvar");
        
//      Habilita a edição da checkBox ativo
        jCheckBoxAtivo.setEnabled(true);
        
        editandoLivro = true;
        
        this.livroEmEdicao = livroEmEdicao;
        
        preencherCamposDaTelaComLivroEditando(livroEmEdicao);
    }    

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Cadastrar Livro");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
//      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
        UtilComponentes.maximizarJInternalFrame(this);
        
//      Data Impressão
//        jFormattedTextFieldDataImpressao = new JFormattedTextField(df);
        MaskFormatter mascaraData = new MaskFormatter("##/####");
        mascaraData.install(jFormattedTextFieldDataImpressao);
        
        
    }
    
    public void preencherCamposDaTelaComLivroEditando(Livro livroEmEdicao) {
        jTextFieldtitulo.setText(livroEmEdicao.getTitulo());
        jCheckBoxAtivo.setSelected(livroEmEdicao.isAtivo());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldtitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarLivro = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jFormattedTextFieldDataImpressao = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(850, 600));

        jLabel1.setLabelFor(jTextFieldtitulo);
        jLabel1.setText("Título");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(850, 1));

        jButtonIncluirSalvarLivro.setMnemonic('i');
        jButtonIncluirSalvarLivro.setText("Inlcuir");
        jButtonIncluirSalvarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSalvarLivroActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel2.setText("ISBN");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(65, 24));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(65, 24));

        jButton1.setText("add");
        jButton1.setPreferredSize(new java.awt.Dimension(60, 26));

        jButton2.setText("add");
        jButton2.setPreferredSize(new java.awt.Dimension(60, 26));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Autor");

        jLabel4.setText("Editora");

        jLabel5.setText("Classificação (CDD)");

        jLabel6.setText("Edição");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Impressão / Reimp.");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Data Imp. / Reimp.");

        jLabel9.setText("Ano");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox7.setPreferredSize(new java.awt.Dimension(65, 24));

        jFormattedTextFieldDataImpressao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonIncluirSalvarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldtitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBoxAtivo))
                                    .addComponent(jLabel2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(5, 5, 5)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jFormattedTextFieldDataImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAtivo)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldDataImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirSalvarLivro)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirSalvarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarLivroActionPerformed
        
        String nome = jTextFieldtitulo.getText().trim();
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldtitulo.setFocusable(true);
            return;
        }
        
        try {
            livroService    = new LivroService();
            
            if (!this.editandoLivro) {
                Livro livro     = new Livro(nome,true);

                livroService.incluir(livro);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
//              Busca no banco de dados (arquivo txt) o registro.
                Livro livroBanco = livroService.consultar(this.livroEmEdicao);
               
                if (livroBanco == null) {
                    throw new RegistroNaoExistenteException();
                }
                
//              Insere os novos valores
                livroBanco.setTitulo(jTextFieldtitulo.getText());
                livroBanco.setAtivo(jCheckBoxAtivo.isSelected());
                
                livroService.alterar(livroBanco);
                
                finalizarAlteracoes(EnumOperacaoBanco.ALTERAR);
            } 
         
        } catch (RegistroExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldtitulo);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldtitulo.requestFocus();
              }
            });                
             
        } catch (RegistroNaoExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldtitulo);
            
             JOptionPane.showMessageDialog(this, "Cadastro NÃO existente para edição.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldtitulo.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o livro. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirSalvarLivroActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws HeadlessException, Exception {
        UtilComponentes.limparCampos(jTextFieldtitulo);
        
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
            JOptionPane.showMessageDialog(this, "Livro incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldtitulo.requestFocus();
                }
            });      
            
        } else if (EnumOperacaoBanco.ALTERAR.equals(operacao)){
            JOptionPane.showOptionDialog(null, "Livro alterado com sucesso!", "Cadastro de Livro!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            dashboardUI.setJLabelNomeTela("Livros");

            jDesktopPane.remove(this);

            try {
                abrirTelaLivros();            
            } catch (Exception ex) {
                Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
                jDesktopPane.add(new DashboardUI());
            }                  
        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Livros");
        
        jDesktopPane.remove(this);
        
        try {
            abrirTelaLivros();            
            
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());
            } catch (Exception ex1) {
                Logger.getLogger(LivroCadastroUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    protected void abrirTelaLivros() throws Exception {
        LivrosUI livrosUI = new LivrosUI();
        
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(livrosUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(livrosUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        livrosUI.show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonIncluirSalvarLivro;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataImpressao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldtitulo;
    // End of variables declaration//GEN-END:variables

}
