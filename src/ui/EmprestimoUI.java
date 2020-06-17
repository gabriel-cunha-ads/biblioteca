package ui;

import entity.Cargo;
import entity.Livro;
import entity.EnumOperacaoBanco;
import entity.Exemplar;
import entity.Funcionario;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.CargoService;
import service.EmprestimoService;
import service.ExemplarService;
import service.FuncionarioService;
import util.UtilComponentes;
import util.UtilData;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class EmprestimoUI extends javax.swing.JInternalFrame {
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private EmprestimoService emprestimoService;
    
    private FuncionarioService funcionarioService;
    
    private CargoService cargoService;
    
    private ExemplarService exemplarService;
    
    private Exemplar exemplarEmprestimo;
    
    
    public EmprestimoUI() {
        
        initComponents();
        
        inicializarComponentes();
    }
   
    public EmprestimoUI(Exemplar exemplarEmprestimo){
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Emprestar Exemplar");  
        
        this.exemplarEmprestimo = exemplarEmprestimo;
    }    

    private void inicializarComponentes() {
        try {
            
//            jPanelDados.setVisible(false);
            
            UtilComponentes.limparCampos(jLabelMatriculaFuncionario, 
                    jLabelNomeFuncionario, jLabelOab, jLabelCargo, jLabelEmail, 
                    jLabelCelular, jLabelDataEmprestimo, jLabelDataDevolucao);
            
            emprestimoService = new EmprestimoService();
            
            funcionarioService = new FuncionarioService();
            
            cargoService = new CargoService();
            
            exemplarService = new ExemplarService();
            
//          Obtém a instancia do dashboard, inicializa o título da janela.
            dashboardUI =  DashboardUI.getInstance();

    //      Defini o nome do títilo da tela.
            dashboardUI.setJLabelNomeTela("Emprestar Exemplar");

    //      Obtém a instancia do JDesktopPane
            jDesktopPane = dashboardUI.getJDesktopPrincipal();

    //      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
            UtilComponentes.maximizarJInternalFrame(this);
            
        } catch (Exception e) {
            
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jButtonConcluirEmprestimo = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMatriculaSolicitante = new javax.swing.JTextField();
        jButtonBuscarFuncionario = new javax.swing.JButton();
        jPanelDados = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabelDataEmprestimo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabelDataDevolucao = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabelMatriculaFuncionario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelNomeFuncionario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCargo = new javax.swing.JLabel();
        jLabelOab = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelCelular = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabelIsbnExemplar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabelTituloExemplar = new javax.swing.JLabel();
        jLabelCDD = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelIdExemplar = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(850, 650));

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

        jButtonConcluirEmprestimo.setMnemonic('c');
        jButtonConcluirEmprestimo.setText("Concluir Emprésitmo");
        jButtonConcluirEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirEmprestimoActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel3.setText("Matrícula do Solicitante");

        jButtonBuscarFuncionario.setMnemonic('l');
        jButtonBuscarFuncionario.setText("Localizar");
        jButtonBuscarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarFuncionarioActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Entrega"));

        jLabel14.setText("Data Empréstimo: ");

        jLabelDataEmprestimo.setText("dataEmprestimo");

        jLabel16.setText("Data Devolução:");

        jLabelDataDevolucao.setText("dataDevolucao");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDataDevolucao)
                            .addComponent(jLabelDataEmprestimo)))
                    .addComponent(jLabel20))
                .addContainerGap(521, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelDataEmprestimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabelDataDevolucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Funcionario Solicitante"));

        jLabel4.setText("Matricula : ");

        jLabelMatriculaFuncionario.setText("Matricula");

        jLabel5.setText("Nome:");

        jLabelNomeFuncionario.setText("nomeFuncionario");

        jLabel6.setText("Cargo:");

        jLabel7.setText("OAB:");

        jLabelCargo.setText("cargo");

        jLabelOab.setText("oab");

        jLabel10.setText("e-mail:");

        jLabel11.setText("celular:");

        jLabelEmail.setText("email");

        jLabelCelular.setText("celular");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeFuncionario)
                            .addComponent(jLabelMatriculaFuncionario))
                        .addGap(223, 223, 223)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel10)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelOab)
                    .addComponent(jLabelEmail)
                    .addComponent(jLabelCelular))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelMatriculaFuncionario)
                    .addComponent(jLabel10)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelNomeFuncionario)
                    .addComponent(jLabel11)
                    .addComponent(jLabelCelular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelCargo)
                    .addComponent(jLabel7)
                    .addComponent(jLabelOab))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Livro"));

        jLabel1.setText("Título:");

        jLabel.setText("CDD:");

        jLabelIsbnExemplar.setText("isbn");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jTextAreaDescricao.setToolTipText("");
        jTextAreaDescricao.setEnabled(false);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabel8.setText("ISBN:");

        jLabelTituloExemplar.setText("titulo");

        jLabelCDD.setText("cdd");

        jLabel18.setText("Descrição:");

        jLabelIdExemplar.setText("idExemplar");

        jLabel13.setText("Id Exemplar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTituloExemplar)
                            .addComponent(jLabelIsbnExemplar)
                            .addComponent(jLabelCDD)))
                    .addComponent(jLabel8)
                    .addComponent(jLabel)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIdExemplar)))
                .addGap(207, 207, 207)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTituloExemplar)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabelIsbnExemplar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel)
                            .addComponent(jLabelCDD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabelIdExemplar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonConcluirEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldMatriculaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscarFuncionario)))
                        .addGap(0, 38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMatriculaSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConcluirEmprestimo)
                    .addComponent(jButtonSair))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonConcluirEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirEmprestimoActionPerformed
        try {
         
        } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o livro. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonConcluirEmprestimoActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) {
        
        try {
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
            this.dispose();

            jDesktopPane.remove(this);

    //      Cria um instância de LivroPrincipalUI.
            ExemplarOperacoesUI livroOperacoesUI = new ExemplarOperacoesUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(livroOperacoesUI);

    //      Remove barra de título e borda da janela
             UtilComponentes.removerBarraTituloEBorda(livroOperacoesUI);
            
//          Mostra a tela LivrosPrincipal.
            livroOperacoesUI.show();            
            
            JOptionPane.showMessageDialog(this, "Livro incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldMatriculaSolicitante.requestFocus();
                }
            });      
        }             
        } catch (Exception e) {
            Logger.getLogger(EmprestimoUI.class.getName()).log(Level.SEVERE, null, e);   
            
        }     
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        try {
            this.dispose();

            dashboardUI.setJLabelNomeTela("Livros");

            jDesktopPane.remove(this);
        
            abrirTelaLivros();            
            
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());   
            } catch (Exception ex1) {
                Logger.getLogger(EmprestimoUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }  
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonBuscarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarFuncionarioActionPerformed
        Integer matricula = Integer.parseInt(jTextFieldMatriculaSolicitante.getText());
        
        if (matricula.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo matrícula não pode ser vazio.");
            return;
        }
        
        try {
            Funcionario funcionario = funcionarioService.consultar(new Funcionario(matricula));
            
            boolean isPermitidoEmprestimo = emprestimoService.isPermitido(funcionario);
            
            if (isPermitidoEmprestimo) {
                jLabelMatriculaFuncionario.setText(String.valueOf(funcionario.getMatricula()));
                jLabelNomeFuncionario.setText(funcionario.getNome());
                Cargo cargo = cargoService.consultar(funcionario.getCargo());
                jLabelCargo.setText(cargo.getDescricao());
                jLabelEmail.setText(funcionario.getEmail()); 
                jLabelCelular.setText(funcionario.getCelular());
                jLabelOab.setText(funcionario.getOab());
                jLabelDataEmprestimo.setText(LocalDate.now(ZoneId.systemDefault()).format(UtilData.getFormatoData()));
                jLabelDataDevolucao.setText(LocalDate.now(ZoneId.systemDefault()).plusWeeks(1L).format(UtilData.getFormatoData()));
                
                Exemplar exemplar = exemplarService.consultar(this.exemplarEmprestimo);
                jLabelTituloExemplar.setText(exemplar.getLivro().getTitulo());
                jLabelIsbnExemplar.setText(exemplar.getLivro().getIsbn());
                jLabelCDD.setText(exemplar.getLivro().getCdd().getDescricao());
                jLabelIdExemplar.setText(String.valueOf(exemplar.getId()));
                jTextAreaDescricao.setText(exemplar.getLivro().getDescricao());
            }
            
        } catch (Exception e) {
            Logger.getLogger(EmprestimoUI.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        
    }//GEN-LAST:event_jButtonBuscarFuncionarioActionPerformed

    
    protected void abrirTelaLivros() throws Exception {
        try {
            LivrosUI livrosUI = new LivrosUI();
        
//          Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
            jDesktopPane.add(livrosUI);
        
//          Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(livrosUI);
            
//          Mostra a tela LivrosPrincipal.
            livrosUI.show();
            
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarFuncionario;
    private javax.swing.JButton jButtonConcluirEmprestimo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCDD;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelDataDevolucao;
    private javax.swing.JLabel jLabelDataEmprestimo;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelIdExemplar;
    private javax.swing.JLabel jLabelIsbnExemplar;
    private javax.swing.JLabel jLabelMatriculaFuncionario;
    private javax.swing.JLabel jLabelNomeFuncionario;
    private javax.swing.JLabel jLabelOab;
    private javax.swing.JLabel jLabelTituloExemplar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldMatriculaSolicitante;
    // End of variables declaration//GEN-END:variables

}
