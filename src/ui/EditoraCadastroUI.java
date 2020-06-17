package ui;

import entity.Editora;
import entity.EnumOperacaoBanco;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.EditoraService;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class EditoraCadastroUI extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private boolean editandoEditora;
    
    private Editora editoraEmEdicao;
    
    private EditoraService editoraService;
    
    
    public EditoraCadastroUI() throws Exception {
        initComponents();
        inicializarComponentes();
    }
    
    public EditoraCadastroUI(Editora editoraEmEdicao) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editar Editora");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarEditora.setText("Salvar");
        
//      Habilita a edição da checkBox ativo
        jCheckBoxAtivo.setEnabled(true);
        
        editandoEditora = true;
        
        this.editoraEmEdicao = editoraEmEdicao;
        
        preencherCamposDaTelaComEditoraEditando(editoraEmEdicao);
    }    

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Cadastrar Editora");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
//      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
        UtilComponentes.maximizarJInternalFrame(this);
    }
    
    public void preencherCamposDaTelaComEditoraEditando(Editora editoraEmEdicao) {
        jTextFieldTextoPesquisa.setText(editoraEmEdicao.getNome());
        jCheckBoxAtivo.setSelected(editoraEmEdicao.isAtivo());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarEditora = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setLabelFor(jTextFieldTextoPesquisa);
        jLabel1.setText("Nome");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonIncluirSalvarEditora.setMnemonic('i');
        jButtonIncluirSalvarEditora.setText("Inlcuir");
        jButtonIncluirSalvarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSalvarEditoraActionPerformed(evt);
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
                                .addComponent(jButtonIncluirSalvarEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 176, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirSalvarEditora)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirSalvarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarEditoraActionPerformed
        
        String nome = jTextFieldTextoPesquisa.getText().trim();
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldTextoPesquisa.setFocusable(true);
            return;
        }
        
        try {
            editoraService    = new EditoraService();
            
            if (!this.editandoEditora) {
                Editora editora     = new Editora(nome,true);

                editoraService.incluir(editora);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
//              Busca no banco de dados (arquivo txt) o registro.
                Editora editoraBanco = editoraService.consultar(this.editoraEmEdicao);
               
                if (editoraBanco == null) {
                    throw new RegistroNaoExistenteException();
                }
                
//              Insere os novos valores
                editoraBanco.setNome(jTextFieldTextoPesquisa.getText());
                editoraBanco.setAtivo(jCheckBoxAtivo.isSelected());
                
                editoraService.alterar(editoraBanco);
                
                finalizarAlteracoes(EnumOperacaoBanco.EDITAR);
            } 
         
        } catch (RegistroExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro / Edição de Editora", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTextoPesquisa.requestFocus();
              }
            });                
             
        } catch (RegistroNaoExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
            
             JOptionPane.showMessageDialog(this, "Cadastro NÃO existente para edição.",
                    "Cadastro / Edição de Editora", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTextoPesquisa.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o editora. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de Editora", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirSalvarEditoraActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws HeadlessException, Exception {
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
            JOptionPane.showMessageDialog(this, "Editora incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldTextoPesquisa.requestFocus();
                }
            });      
            
        } else if (EnumOperacaoBanco.EDITAR.equals(operacao)){
            JOptionPane.showOptionDialog(null, "Editora alterado com sucesso!", "Cadastro de Editora!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            dashboardUI.setJLabelNomeTela("Editoras");

            jDesktopPane.remove(this);

            try {
                abrirTelaEditoras();            
            } catch (Exception ex) {
                Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, ex);
                jDesktopPane.add(new DashboardUI());
            }                  
        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Editoras");
        
        jDesktopPane.remove(this);
        
        try {
            abrirTelaEditoras();            
            
        } catch (Exception ex) {
            Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());
            } catch (Exception ex1) {
                Logger.getLogger(EditoraCadastroUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    protected void abrirTelaEditoras() throws Exception {
        EditorasUI editoraesUI = new EditorasUI();
        
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(editoraesUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(editoraesUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        editoraesUI.show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirSalvarEditora;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables

}
