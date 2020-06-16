package ui;

import entity.ClassificacaoDecimalDireito;
import entity.EnumOperacaoBanco;
import entity.vo.ClassificacaoDecimalDireitoVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.ClassificacaoDecimalDireitoService;
import util.UtilComponentes;

/**
 *
 * @author Aires Ribeiro
 */
public class ClassificacaoDecimalDireitoImportarUI extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private boolean editandoClassificacaoDecimalDireito;
    
    private ClassificacaoDecimalDireito cddEmEdicao;
    
    private ClassificacaoDecimalDireitoService cddService;
    
    
    public ClassificacaoDecimalDireitoImportarUI() throws Exception {
        initComponents();
        inicializarComponentes();
    }
    
    public ClassificacaoDecimalDireitoImportarUI(ClassificacaoDecimalDireito cddEmEdicao) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Importar Classificacao Decimal Direito");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarCDD.setText("Salvar");
        
////      Habilita a edição da checkBox ativo
//        jCheckBoxAtivo.setEnabled(true);
        
        editandoClassificacaoDecimalDireito = true;
        
        this.cddEmEdicao = cddEmEdicao;
        
        preencherCamposDaTelaComClassificacaoDecimalDireitoEditando(cddEmEdicao);
    }    

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Importar Classificacao Decimal Direito");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
//      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
        UtilComponentes.maximizarJInternalFrame(this);
    }
    
    public void preencherCamposDaTelaComClassificacaoDecimalDireitoEditando(ClassificacaoDecimalDireito cddEmEdicao) {
   
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldDescricao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarCDD = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setLabelFor(jTextFieldDescricao);
        jLabel1.setText("Descrição");

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonIncluirSalvarCDD.setMnemonic('i');
        jButtonIncluirSalvarCDD.setText("Importar");
        jButtonIncluirSalvarCDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSalvarCDDActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonIncluirSalvarCDD, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 461, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirSalvarCDD)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirSalvarCDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarCDDActionPerformed
        
        String descricao = jTextFieldDescricao.getText().trim();
        
        if (descricao.equals("")){
            JOptionPane.showMessageDialog(this, "Campos com preenchimento obrigatório.");
            jTextFieldDescricao.setFocusable(true);
            return;
        }
        
        try {
            cddService      = new ClassificacaoDecimalDireitoService();
            if (!this.editandoClassificacaoDecimalDireito) {
                ClassificacaoDecimalDireito cdd = new ClassificacaoDecimalDireito(descricao);
              //ClassificacaoDecimalDireito cdd     = new ClassificacaoDecimalDireito(codigoCDD, descricao, true);

                cddService.incluir(cdd);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
//              Busca no banco de dados (arquivo txt) o registro.
                ClassificacaoDecimalDireito cddBanco = cddService.consultar(this.cddEmEdicao);
               
                if (cddBanco == null) {
                    throw new RegistroNaoExistenteException();
                }
                
//              Insere os novos valores
              //  cddBanco.setCodigoCDD(jTextFieldCodigo.getText());
                cddBanco.setDescricao(jTextFieldDescricao.getText());
            //    cddBanco.setAtivo(jCheckBoxAtivo.isSelected());
                
                cddService.alterar(cddBanco);
                
                finalizarAlteracoes(EnumOperacaoBanco.ALTERAR);
            } 
         
        } catch (RegistroExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldDescricao);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro / Edição de ClassificacaoDecimalDireito", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldDescricao.requestFocus();
              }
            });                
             
        } catch (RegistroNaoExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldDescricao);
            
             JOptionPane.showMessageDialog(this, "Cadastro NÃO existente para edição.",
                    "Cadastro / Edição de ClassificacaoDecimalDireito", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldDescricao.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o cdd. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de ClassificacaoDecimalDireito", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirSalvarCDDActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws HeadlessException, Exception {
        UtilComponentes.limparCampos(jTextFieldDescricao);
        
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
            JOptionPane.showMessageDialog(this, "ClassificacaoDecimalDireito incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldDescricao.requestFocus();
                }
            });      
            
        } else if (EnumOperacaoBanco.ALTERAR.equals(operacao)){
            JOptionPane.showOptionDialog(null, "ClassificacaoDecimalDireito alterado com sucesso!", "Cadastro de ClassificacaoDecimalDireito!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            dashboardUI.setJLabelNomeTela("CDDs");

            jDesktopPane.remove(this);

            try {
                abrirTelaCDDs();            
            } catch (Exception ex) {
                Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, ex);
                jDesktopPane.add(new DashboardUI());
            }                  
        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("CDDs");
        
        jDesktopPane.remove(this);
        
        try {
            abrirTelaCDDs();            
            
        } catch (Exception ex) {
            Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());
            } catch (Exception ex1) {
                Logger.getLogger(ClassificacaoDecimalDireitoImportarUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    protected void abrirTelaCDDs() throws Exception {
        ClassificacoesDecimalDireitoUI cddsUI = new ClassificacoesDecimalDireitoUI();
        
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(cddsUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(cddsUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        cddsUI.show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirSalvarCDD;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldDescricao;
    // End of variables declaration//GEN-END:variables

}
