package ui;

import entity.Cargo;
import entity.Funcionario;
import entity.EnumOperacaoBanco;
import entity.vo.CargoVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.CargoService;
import service.FuncionarioService;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class FuncionarioCadastroUI extends javax.swing.JInternalFrame {

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private boolean editandoFuncionario;
    
    private Funcionario funcionarioEmEdicao;
    
    private FuncionarioService funcionarioService = new FuncionarioService();
    
    private CargoService cargoService = new CargoService();
    
    
    public FuncionarioCadastroUI() throws Exception {
        initComponents();
        inicializarComponentes();
    }
    
    public FuncionarioCadastroUI(Funcionario funcionarioEmEdicao) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editar Funcionario");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarFuncionario.setText("Salvar");
        
//      Habilita a edição da checkBox ativo
        jCheckBoxAtivo.setEnabled(true);
        
        editandoFuncionario = true;
        
        this.funcionarioEmEdicao = funcionarioEmEdicao;
        
        preencherCamposDaTelaComFuncionarioEditando(funcionarioEmEdicao);
    }    

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Cadastrar Funcionario");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
//      Inicializa jComboBoxCargos
        Vector<CargoVO> cargosVO = cargoService.carregarTodosAutoresVetorComboBox();
        jComboBoxCargos.setModel(new DefaultComboBoxModel(cargosVO));
    }
    
    public void preencherCamposDaTelaComFuncionarioEditando(Funcionario funcionarioEmEdicao) {
        jTextFieldNome.setText(funcionarioEmEdicao.getNome());
        jTextFieldCpf.setText(funcionarioEmEdicao.getNome());
        jCheckBoxAtivo.setSelected(funcionarioEmEdicao.isAtivo());
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarFuncionario = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jComboBoxCargos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldOab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCelular = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jPasswordFieldConfirmacaoSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonIncluirSalvarFuncionario.setMnemonic('i');
        jButtonIncluirSalvarFuncionario.setText("Inlcuir");
        jButtonIncluirSalvarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSalvarFuncionarioActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("CPF");

        jComboBoxCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCargos.setPreferredSize(new java.awt.Dimension(65, 28));

        jLabel4.setText("Cargo");

        jLabel5.setText("OAB");

        jLabel6.setText("Celular");

        jLabel7.setText("E-mail");

        jCheckBox1.setText("Usuario Sistema");

        jLabel1.setText("Senha");

        jLabel8.setText("Confirmar senha");

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
                                .addComponent(jButtonIncluirSalvarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jCheckBoxAtivo))
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldOab, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jPasswordFieldConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxAtivo))))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldConfirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirSalvarFuncionario)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirSalvarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarFuncionarioActionPerformed
        
        String nome     = jTextFieldNome.getText().trim();
        String cpf      = jTextFieldCpf.getText().trim();
        CargoVO cargoVO = (CargoVO) jComboBoxCargos.getSelectedItem();
        String oab      = jTextFieldOab.getText().trim();
        String celular  = jTextFieldCelular.getText().trim();
        String email    = jTextFieldEmail.getText();
        boolean ativo   = jCheckBoxAtivo.isSelected();
        boolean isUsuarioSistema = jCheckBoxAtivo.isSelected();
        char[] senha    = jPasswordFieldSenha.getPassword();
        char[] confirmacaoSenha = jPasswordFieldConfirmacaoSenha.getPassword();
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldNome.setFocusable(true);
            return;
        }
        
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo nome não pode ser nulo.");
            jTextFieldNome.setFocusable(true);
            return;
        }        
        
        try {
            Cargo cargo = cargoVO.toCargo();
            
            if (!this.editandoFuncionario) {
                Funcionario funcionario = new Funcionario(nome,cpf, cargo , oab, celular, 
                                        email, ativo, isUsuarioSistema, String.valueOf(senha));

                funcionarioService.incluir(funcionario);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
//              Busca no banco de dados (arquivo txt) o registro.
                Funcionario funcionarioBanco = funcionarioService.consultar(this.funcionarioEmEdicao);
               
                if (funcionarioBanco == null) {
                    throw new RegistroNaoExistenteException();
                }
                
//              Insere os novos valores
                funcionarioBanco.setAtivo(jCheckBoxAtivo.isSelected());
                
                funcionarioService.alterar(funcionarioBanco);
                
                finalizarAlteracoes(EnumOperacaoBanco.EDITAR);
            } 
         
        } catch (RegistroExistenteException e) {
            
             
        } catch (RegistroNaoExistenteException e) {
           
             JOptionPane.showMessageDialog(this, "Cadastro NÃO existente para edição.",
                    "Cadastro / Edição de Funcionario", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldNome.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o funcionario. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de Funcionario", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirSalvarFuncionarioActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws HeadlessException, Exception {
//        UtilComponentes.limparCampos(jTextFieldMatricula);
//        
//        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
//            JOptionPane.showMessageDialog(this, "Funcionario incluído com sucesso!");
//
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    jTextFieldMatricula.requestFocus();
//                }
//            });      
//            
//        } else if (EnumOperacaoBanco.EDITAR.equals(operacao)){
//            JOptionPane.showOptionDialog(null, "Funcionario alterado com sucesso!", "Cadastro de Funcionario!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
//               
//            this.dispose();
//
//            dashboardUI.setJLabelNomeTela("Funcionarios");
//
//            jDesktopPane.remove(this);
//
//            try {
//                abrirTelaFuncionarios();            
//            } catch (Exception ex) {
//                Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, null, ex);
//                jDesktopPane.add(new DashboardUI());
//            }                  
//        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Funcionarios");
        
        jDesktopPane.remove(this);
        
        try {
            abrirTelaFuncionarios();            
            
        } catch (Exception ex) {
            Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());
            } catch (Exception ex1) {
                Logger.getLogger(FuncionarioCadastroUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    protected void abrirTelaFuncionarios() throws Exception {
        FuncionariosUI funcionariosUI = new FuncionariosUI();
        
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(funcionariosUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(funcionariosUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        funcionariosUI.show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluirSalvarFuncionario;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JComboBox<String> jComboBoxCargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordFieldConfirmacaoSenha;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldOab;
    // End of variables declaration//GEN-END:variables

}
