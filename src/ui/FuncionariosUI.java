package ui;

import java.util.List;
import entity.Funcionario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import service.FuncionarioService;
import ui.components.AutoComplete;
import ui.components.FuncionarioTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class FuncionariosUI extends javax.swing.JInternalFrame {

    private static final String TITULO_COMBOBOX_NOME = "Nome";
    
    private static final String TITULO_COMBOBOX_ID = "Id";   
    
    private static final String COMMIT_ACTION = "commit";    
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private FuncionarioService funcionarioService;
    
    private List<Funcionario> funcionariosTabela =  new ArrayList();
    
    
    public FuncionariosUI() throws Exception {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosFuncionarios(new ArrayList());
        
    }

    private void inicializarComponentes() throws Exception {
        
        funcionarioService = new FuncionarioService();
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Funcionarios");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        UtilComponentes.habilitarComponentes(false, jButtonEditarFuncionario, jButtonExcluirFuncionarios, 
                jTextFieldTextoPesquisa);
        
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        jTextFieldTextoPesquisa.setToolTipText(" <<<<<<<- SELECIONE um campo e digite sua pesquisa.");
        
        jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");

//      Define títulos para a combobox de pesquisa.        
        jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione", TITULO_COMBOBOX_ID, TITULO_COMBOBOX_NOME}));  
    }
    
    
    private void inicializarTabelaDadosFuncionarios(List<Funcionario> funcionarios) {
        
        try {
            if (funcionarios == null || funcionarios.isEmpty()) {
                this.funcionariosTabela = funcionarioService.listar();
            } else {
                this.funcionariosTabela = funcionarios;
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, "FuncionariosUI - ", ex);
        }
        
//      Instancia um novo LivroTableModel passando a lista de objetos.
        ViewAbstractTableModel funcionarioTableModel = new FuncionarioTableModel(this.funcionariosTabela);
        
        UtilTabela.inicializarTabela(jTableFuncionarios, funcionarioTableModel);
        
        addMouseListenerTabela();
    }
    
    private List<String> listarNomesFuncionarios() {
        
        List<String> nomes = new ArrayList();
        
        try {
            List<Funcionario> listaBanco = funcionarioService.listar();
            for (Funcionario a : listaBanco ) {
                nomes.add(a.getNome());
            }
        } catch (Exception ex) {
            Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nomes;
    }    
    
    public void addMouseListenerTabela() {
        
        jTableFuncionarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de funcionarioes e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Funcionario a : funcionariosTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        jButtonEditarFuncionario.setEnabled(true);
                        jButtonExcluirFuncionarios.setEnabled(true);
                    } else if (qtdLinhasSelcionadas > 1){
                        jButtonEditarFuncionario.setEnabled(false);
                        jButtonExcluirFuncionarios.setEnabled(true);
                    } else if (qtdLinhasSelcionadas < 1) {
                        jButtonEditarFuncionario.setEnabled(false);
                        jButtonExcluirFuncionarios.setEnabled(false);                
                    }
                } 
            }
        });        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisarAutor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jButtonAbrirFuncionarioCadastroUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonExcluirFuncionarios = new javax.swing.JButton();
        jButtonEditarFuncionario = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxCampoPesquisa = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNextFocusableComponent(jTextFieldTextoPesquisa);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButtonPesquisarAutor.setMnemonic('p');
        jButtonPesquisarAutor.setText("pesquisar");
        jButtonPesquisarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarAutorActionPerformed(evt);
            }
        });

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableFuncionarios.setColumnSelectionAllowed(true);
        jTableFuncionarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableFuncionarios.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableFuncionarios);
        jTableFuncionarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirFuncionarioCadastroUI.setMnemonic('i');
        jButtonAbrirFuncionarioCadastroUI.setText("Incluir");
        jButtonAbrirFuncionarioCadastroUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirFuncionarioCadastroUIActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonExcluirFuncionarios.setMnemonic('x');
        jButtonExcluirFuncionarios.setText("Excluir");
        jButtonExcluirFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirFuncionariosActionPerformed(evt);
            }
        });

        jButtonEditarFuncionario.setMnemonic('e');
        jButtonEditarFuncionario.setText("Editar");
        jButtonEditarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarFuncionarioActionPerformed(evt);
            }
        });

        jSeparator2.setToolTipText("");

        jComboBoxCampoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCampoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCampoPesquisaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAbrirFuncionarioCadastroUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditarFuncionario)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonExcluirFuncionarios)
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarAutor)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarAutor)
                    .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAbrirFuncionarioCadastroUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonExcluirFuncionarios)
                        .addComponent(jButtonEditarFuncionario))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonAbrirFuncionarioCadastroUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirFuncionarioCadastroUIActionPerformed
        
        try {
            this.dispose();

            jDesktopPane.remove(this);

    //      Cria um instância de LivroPrincipalUI.
            FuncionarioCadastroUI funcionarioCadastroUI = new FuncionarioCadastroUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(funcionarioCadastroUI);

    //      Remove barra de título e borda da janela
                UtilComponentes.removerBarraTituloEBorda(funcionarioCadastroUI);
            
//          Mostra a tela LivrosPrincipal.
            funcionarioCadastroUI.show();
            
            
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAbrirFuncionarioCadastroUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        jDesktopPane.remove(this);
        
        dashboardUI.setJLabelNomeTela("Dashboard");
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirFuncionariosActionPerformed

//      Verifica os objetos selecionados para excluir.
        List<Funcionario> selecionados = getSelecionados();
        
        try {
            if (selecionados != null) {
                
                int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir?"
                        , "Excluir Funcionario(s)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                
                if (opcao == JOptionPane.OK_OPTION ) {
                    
//                  Remove do banco de dados (arquivo txt)
                    List<Funcionario> funcionarioesNaoExlcuidos = funcionarioService.excluir(selecionados);
                    
//                  Busca a lista atualizada no banco.
                    funcionariosTabela = funcionarioService.listar();
                    
//                  Reinicializa a tabela
                    inicializarTabelaDadosFuncionarios(funcionariosTabela);
                    
                    if (!funcionarioesNaoExlcuidos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Não foi possível excluir alguns dos registros selecionados porque existem operações gravadas.");
                    }
                    
                    UtilComponentes.habilitarComponentes(false, jButtonEditarFuncionario, jButtonExcluirFuncionarios);
                    
                }  else if (opcao == JOptionPane.CANCEL_OPTION) {
                    funcionariosTabela = funcionarioService.listar();
                    inicializarTabelaDadosFuncionarios(funcionariosTabela);
                }
            }                    

        } catch (Exception e) {
            Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o(s) registro(s). Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonExcluirFuncionariosActionPerformed

    private void jButtonEditarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarFuncionarioActionPerformed
        
//      Verifica se tem funcionario selecionado (isSelecionado) para edição. 
        List<Funcionario> selecionados = getSelecionados();
        
        try {
            if (!selecionados.isEmpty() && selecionados.size() == 1) {
                this.dispose();

                jDesktopPane.remove(this);

//              Cria um instância da tela (UI) que será aberta e passa o selecionado.
                FuncionarioCadastroUI funcionarioCadastroUI = new FuncionarioCadastroUI(selecionados.get(0));        

//              Adiciona a pilha de do JDesktopPane o JInternalFrame.
                jDesktopPane.add(funcionarioCadastroUI);

                try {
//                  Remove barra de título e borda da janela
                    UtilComponentes.removerBarraTituloEBorda(funcionarioCadastroUI);
                } catch (Exception ex) {
                    Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, null, ex);
                }

//              Mostra a tela LivrosPrincipal.
                funcionarioCadastroUI.show();
            }            
        } catch (Exception e) {
            Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível editar o funcionario. Entre em contato com nosso suporte.");            
        }
    }//GEN-LAST:event_jButtonEditarFuncionarioActionPerformed
    
    private List<Funcionario> getSelecionados() {
        List<Funcionario> funcionarioesSelecionados = new ArrayList();
        
        for (Funcionario funcionario : this.funcionariosTabela) {
            if (funcionario.isSelecionado() ) {
                funcionarioesSelecionados.add(funcionario);
            }
        }
        return funcionarioesSelecionados;
    }

    private void jButtonPesquisarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarAutorActionPerformed
        
        String dadosParaPesquisa = jTextFieldTextoPesquisa.getText().trim();
        Funcionario funcionarioPesquisado = null;
        
        try {
            if (dadosParaPesquisa.equals("")) {
                
                List<Funcionario> funcionarioes = funcionarioService.listar();

                inicializarComponentes();

                inicializarTabelaDadosFuncionarios(funcionarioes);  
            } else {
                
                if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_ID)) {
                    Integer id = null;

                    id = Integer.parseInt(dadosParaPesquisa);

                    funcionarioPesquisado = funcionarioService.consultar(new Funcionario(id));

                    this.funcionariosTabela = Arrays.asList(funcionarioPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosFuncionarios(this.funcionariosTabela);

                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_NOME)) {

                    Funcionario funcionarioParaPesquisa = new Funcionario();
                    funcionarioParaPesquisa.setNome(dadosParaPesquisa);

                    funcionarioPesquisado = funcionarioService.consultar(funcionarioParaPesquisa);

                    this.funcionariosTabela  = Arrays.asList(funcionarioPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosFuncionarios(this.funcionariosTabela );
                }

                if (funcionarioPesquisado == null) {

                    this.funcionariosTabela  = funcionarioService.listar();

                    inicializarComponentes();

                    inicializarTabelaDadosFuncionarios(this.funcionariosTabela );                

                    JOptionPane.showMessageDialog(this, "Não foram encontrados resultados para a pesquisa." );                
                }                
                
            }
        } catch (NumberFormatException e) {
            jTextFieldTextoPesquisa.setText("");
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID válido.");
        } catch (Exception ex) {
            Logger.getLogger(FuncionariosUI.class.getName()).log(Level.SEVERE, "FuncionariosUI.jButtonPesquisarFuncionarioActionPerformed().", ex);
            JOptionPane.showMessageDialog(this, "Não foi possível pesquisar. Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonPesquisarAutorActionPerformed

    private void jComboBoxCampoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCampoPesquisaItemStateChanged
        if (jComboBoxCampoPesquisa.getSelectedIndex() != 0) {
            jTextFieldTextoPesquisa.setEnabled(true);
        } else {
            jTextFieldTextoPesquisa.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxCampoPesquisaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirFuncionarioCadastroUI;
    private javax.swing.JButton jButtonEditarFuncionario;
    private javax.swing.JButton jButtonExcluirFuncionarios;
    private javax.swing.JButton jButtonPesquisarAutor;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxCampoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


 }

