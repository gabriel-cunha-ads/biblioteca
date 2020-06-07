package ui;

import entity.Autor;
import entity.EnumOperacaoBanco;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.AutorService;
import service.interfaces.CompletionService;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class AutorCadastroUI extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private boolean editandoAutor;
    
    private Autor autorEmEdicao;
    
    private AutorService autorService;
    
    
    public AutorCadastroUI() {
        initComponents();
        inicializarComponentes();
    }
    
    public AutorCadastroUI(Autor autorEmEdicao) {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editar Autor");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarAutor.setText("Salvar");
        
//      Habilita a edição da checkBox ativo
        jCheckBoxAtivo.setEnabled(true);
        
        editandoAutor = true;
        
        this.autorEmEdicao = autorEmEdicao;
        
        preencherCamposDaTelaComAutorEditando(autorEmEdicao);
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
    
    public void preencherCamposDaTelaComAutorEditando(Autor autorEmEdicao) {
        jTextFieldTextoPesquisa.setText(autorEmEdicao.getNome());
        jCheckBoxAtivo.setSelected(autorEmEdicao.isAtivo());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarAutor = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setLabelFor(jTextFieldTextoPesquisa);
        jLabel1.setText("Nome");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonIncluirSalvarAutor.setMnemonic('i');
        jButtonIncluirSalvarAutor.setText("Inlcuir");
        jButtonIncluirSalvarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSalvarAutorActionPerformed(evt);
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
                                .addComponent(jButtonIncluirSalvarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jButtonIncluirSalvarAutor)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirSalvarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarAutorActionPerformed
        
        String nome = jTextFieldTextoPesquisa.getText().trim();
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldTextoPesquisa.setFocusable(true);
            return;
        }
        
        try {
            autorService    = new AutorService();
            
            if (!this.editandoAutor) {
                Autor autor     = new Autor(nome,true);

                autorService.incluir(autor);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
//              Busca no banco de dados (arquivo txt) o registro.
                Autor autorBanco = autorService.consultar(this.autorEmEdicao);
               
                if (autorBanco == null) {
                    throw new RegistroNaoExistenteException();
                }
                
//              Insere os novos valores
                autorBanco.setNome(jTextFieldTextoPesquisa.getText());
                autorBanco.setAtivo(jCheckBoxAtivo.isSelected());
                
                autorService.alterar(autorBanco);
                
                finalizarAlteracoes(EnumOperacaoBanco.ALTERAR);
            } 
         
        } catch (RegistroExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro / Edição de Autor", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTextoPesquisa.requestFocus();
              }
            });                
             
        } catch (RegistroNaoExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
            
             JOptionPane.showMessageDialog(this, "Cadastro NÃO existente para edição.",
                    "Cadastro / Edição de Autor", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTextoPesquisa.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o autor. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de Autor", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirSalvarAutorActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws HeadlessException {
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
            JOptionPane.showMessageDialog(this, "Autor incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldTextoPesquisa.requestFocus();
                }
            });      
            
        } else if (EnumOperacaoBanco.ALTERAR.equals(operacao)){
            JOptionPane.showOptionDialog(null, "Autor alterado com sucesso!", "Cadastro de Autor!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            dashboardUI.setJLabelNomeTela("Autores");

            jDesktopPane.remove(this);

            try {
                abrirTelaAutores();            
            } catch (Exception ex) {
                Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, ex);
                jDesktopPane.add(new DashboardUI());
            }                  
        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Autores");
        
        jDesktopPane.remove(this);
        
        try {
            abrirTelaAutores();            
            
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, ex);
            jDesktopPane.add(new DashboardUI());
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    protected void abrirTelaAutores() throws Exception {
        AutoresUI autoresUI = new AutoresUI();
        
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(autoresUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(autoresUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        autoresUI.show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirSalvarAutor;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables

}
