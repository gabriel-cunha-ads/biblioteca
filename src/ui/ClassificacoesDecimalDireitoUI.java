package ui;

import java.util.List;
import entity.ClassificacaoDecimalDireito;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import service.ClassificacaoDecimalDireitoService;
import ui.components.AutoComplete;
import ui.components.ClassificacaoDecimalDireitoTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Aires Ribeiro
 */
public class ClassificacoesDecimalDireitoUI extends javax.swing.JInternalFrame {

    private static final String TITULO_COMBOBOX_ID = "Id";   
    
    private static final String TITULO_COMBOBOX_CODIGO = "Código";
    
    private static final String TITULO_COMBOBOX_DESCRICAO = "Descricao";
    
    private static final String COMMIT_ACTION = "commit";    
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private ClassificacaoDecimalDireitoService cddService = new ClassificacaoDecimalDireitoService();
    
    private List<ClassificacaoDecimalDireito> cddsTabela =  new ArrayList();
    
    
    public ClassificacoesDecimalDireitoUI() throws Exception {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosCDDs(new ArrayList());
    }

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Classificação Decimal de Direito");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        UtilComponentes.habilitarComponentes(false, jButtonEditarCDD, jButtonExcluirCDD, 
                jTextFieldTextoPesquisa);
        
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        jTextFieldTextoPesquisa.setToolTipText(" <<<<<<<- SELECIONE um campo e digite sua pesquisa.");
        
        jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");

//      Define títulos para a combobox de pesquisa.        
        jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione", TITULO_COMBOBOX_ID, TITULO_COMBOBOX_CODIGO, TITULO_COMBOBOX_DESCRICAO}));  
       
//      Auto sugestão
        List<String> nomes = listarNomesCDDs();
        jTextFieldTextoPesquisa.setFocusTraversalKeysEnabled(false);
        AutoComplete autoComplete = new AutoComplete(jTextFieldTextoPesquisa, nomes);
        jTextFieldTextoPesquisa.getDocument().addDocumentListener(autoComplete);
        jTextFieldTextoPesquisa.getInputMap().put(KeyStroke.getKeyStroke(title).getKeyStroke("TAB"), COMMIT_ACTION);
        jTextFieldTextoPesquisa.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());        
    }
    
    
    private void inicializarTabelaDadosCDDs(List<ClassificacaoDecimalDireito> cdds) {
        
        try {
            if (cdds == null || cdds.isEmpty()) {
                this.cddsTabela = cddService.listar();
            } else {
                this.cddsTabela = cdds;
            }
        } catch (Exception ex) {
            Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, "ClassificacoesDecimalDireitoUI - ", ex);
        }
        
//      Instancia um novo LivroTableModel passando a lista de objetos.
        ViewAbstractTableModel classificacaoDecimalDireitoTableModel = new ClassificacaoDecimalDireitoTableModel(this.cddsTabela);
        
        UtilTabela.inicializarTabela(jTableCDD, classificacaoDecimalDireitoTableModel);
        
        addMouseListenerTabela();
        
    }
    
    private List<String> listarNomesCDDs() {
        
        List<String> nomes = new ArrayList();
        
        try {
            List<ClassificacaoDecimalDireito> listaBanco = cddService.listar();
            for (ClassificacaoDecimalDireito a : listaBanco ) {
                nomes.add(a.getDescricao());
            }
        } catch (Exception ex) {
            Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nomes;
    }    
    
    public void addMouseListenerTabela() {
        
        jTableCDD.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de cdds e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (ClassificacaoDecimalDireito a : cddsTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        jButtonEditarCDD.setEnabled(true);
                        jButtonExcluirCDD.setEnabled(true);
                    } else if (qtdLinhasSelcionadas > 1){
                        jButtonEditarCDD.setEnabled(false);
                        jButtonExcluirCDD.setEnabled(true);
                    } else if (qtdLinhasSelcionadas < 1) {
                        jButtonEditarCDD.setEnabled(false);
                        jButtonExcluirCDD.setEnabled(false);                
                    }
                } 
            }
        });        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisarCDD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCDD = new javax.swing.JTable();
        jButtonIncluirCDDUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonExcluirCDD = new javax.swing.JButton();
        jButtonEditarCDD = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxCampoPesquisa = new javax.swing.JComboBox<>();
        jButtonImportarCDDUI = new javax.swing.JButton();
        jPanelSelecionarArquivo = new javax.swing.JPanel();
        jFileChooserSelecionarArquivo = new javax.swing.JFileChooser();

        jFileChooser1.setApproveButtonText("");

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNextFocusableComponent(jTextFieldTextoPesquisa);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButtonPesquisarCDD.setMnemonic('p');
        jButtonPesquisarCDD.setText("pesquisar");
        jButtonPesquisarCDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarCDDActionPerformed(evt);
            }
        });

        jTableCDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCDD.setColumnSelectionAllowed(true);
        jTableCDD.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableCDD.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableCDD);
        jTableCDD.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonIncluirCDDUI.setMnemonic('i');
        jButtonIncluirCDDUI.setText("Incluir");
        jButtonIncluirCDDUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirCDDUIActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonExcluirCDD.setMnemonic('x');
        jButtonExcluirCDD.setText("Excluir");
        jButtonExcluirCDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirCDDActionPerformed(evt);
            }
        });

        jButtonEditarCDD.setMnemonic('e');
        jButtonEditarCDD.setText("Editar");
        jButtonEditarCDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarCDDActionPerformed(evt);
            }
        });

        jSeparator2.setToolTipText("");

        jComboBoxCampoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCampoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCampoPesquisaItemStateChanged(evt);
            }
        });

        jButtonImportarCDDUI.setText("Importar");
        jButtonImportarCDDUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarCDDUIActionPerformed(evt);
            }
        });

        jPanelSelecionarArquivo.setEnabled(false);

        javax.swing.GroupLayout jPanelSelecionarArquivoLayout = new javax.swing.GroupLayout(jPanelSelecionarArquivo);
        jPanelSelecionarArquivo.setLayout(jPanelSelecionarArquivoLayout);
        jPanelSelecionarArquivoLayout.setHorizontalGroup(
            jPanelSelecionarArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        jPanelSelecionarArquivoLayout.setVerticalGroup(
            jPanelSelecionarArquivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        jFileChooserSelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserSelecionarArquivoActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarCDD)
                        .addGap(0, 447, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonIncluirCDDUI, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonImportarCDDUI, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFileChooserSelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonEditarCDD)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluirCDD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jPanelSelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarCDD)
                    .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonIncluirCDDUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonExcluirCDD)
                        .addComponent(jButtonEditarCDD)
                        .addComponent(jButtonImportarCDDUI))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanelSelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFileChooserSelecionarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonIncluirCDDUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirCDDUIActionPerformed
        
        try {
            this.dispose();

            jDesktopPane.remove(this);

    //      Cria um instância de CDDPrincipalUI.
            ClassificacaoDecimalDireitoCadastroUI classificacaoDecimalDireitoCadastroUI = new ClassificacaoDecimalDireitoCadastroUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(classificacaoDecimalDireitoCadastroUI);

    //      Remove barra de título e borda da janela
                UtilComponentes.removerBarraTituloEBorda(classificacaoDecimalDireitoCadastroUI);
            
//          Mostra a tela LivrosPrincipal.
            classificacaoDecimalDireitoCadastroUI.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonIncluirCDDUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        jDesktopPane.remove(this);
        
        dashboardUI.setJLabelNomeTela("Dashboard");
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirCDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirCDDActionPerformed

//      Verifica os objetos selecionados para excluir.
        List<ClassificacaoDecimalDireito> selecionados = getSelecionados();
        
        try {
            if (selecionados != null) {
                
                int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir?"
                        , "Excluir ClassificacaoDecimalDireito(s)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                
                if (opcao == JOptionPane.OK_OPTION ) {
                    
//                  Remove do banco de dados (arquivo txt)
                    List<ClassificacaoDecimalDireito> cddsNaoExlcuidos = cddService.excluir(selecionados);
                    
//                  Busca a lista atualizada no banco.
                    cddsTabela = cddService.listar();
                    
//                  Reinicializa a tabela
                    inicializarTabelaDadosCDDs(cddsTabela);
                    
                    if (!cddsNaoExlcuidos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Não foi possível excluir alguns dos registros selecionados porque existem operações gravadas.");
                    }
                    
                    UtilComponentes.habilitarComponentes(false, jButtonEditarCDD, jButtonExcluirCDD);
                    
                }  else if (opcao == JOptionPane.CANCEL_OPTION) {
                    cddsTabela = cddService.listar();
                    inicializarTabelaDadosCDDs(cddsTabela);
                }
            }                    

        } catch (Exception e) {
            Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o(s) registro(s). Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonExcluirCDDActionPerformed

    private void jButtonEditarCDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarCDDActionPerformed
        
//      Verifica se tem classificacaoDecimalDireito selecionado (isSelecionado) para edição. 
        List<ClassificacaoDecimalDireito> selecionados = getSelecionados();
        
        try {
            if (!selecionados.isEmpty() && selecionados.size() == 1) {
                this.dispose();

                jDesktopPane.remove(this);

//              Cria um instância da tela (UI) que será aberta e passa o selecionado.
                ClassificacaoDecimalDireitoCadastroUI classificacaoDecimalDireitoCadastroUI = new ClassificacaoDecimalDireitoCadastroUI(selecionados.get(0));        

//              Adiciona a pilha de do JDesktopPane o JInternalFrame.
                jDesktopPane.add(classificacaoDecimalDireitoCadastroUI);

                try {
//                  Remove barra de título e borda da janela
                    UtilComponentes.removerBarraTituloEBorda(classificacaoDecimalDireitoCadastroUI);
                } catch (Exception ex) {
                    Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, ex);
                }

//              Mostra a tela LivrosPrincipal.
                classificacaoDecimalDireitoCadastroUI.show();
            }            
        } catch (Exception e) {
            Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível editar o classificacaoDecimalDireito. Entre em contato com nosso suporte.");            
        }
    }//GEN-LAST:event_jButtonEditarCDDActionPerformed
    
    private List<ClassificacaoDecimalDireito> getSelecionados() {
        List<ClassificacaoDecimalDireito> cddsSelecionados = new ArrayList();
        
        for (ClassificacaoDecimalDireito classificacaoDecimalDireito : this.cddsTabela) {
            if (classificacaoDecimalDireito.isSelecionado() ) {
                cddsSelecionados.add(classificacaoDecimalDireito);
            }
        }
        return cddsSelecionados;
    }

    private void jButtonPesquisarCDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarCDDActionPerformed
        
        String dadosParaPesquisa = jTextFieldTextoPesquisa.getText().trim();
        ClassificacaoDecimalDireito classificacaoDecimalDireitoPesquisado = null;
        
        try {
            if (dadosParaPesquisa.equals("")) {
                
                List<ClassificacaoDecimalDireito> cdds = cddService.listar();

                inicializarComponentes();

                inicializarTabelaDadosCDDs(cdds);  
            } else {
                
                if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_ID)) {
                    Integer id = null;

                    id = Integer.parseInt(dadosParaPesquisa);

                    classificacaoDecimalDireitoPesquisado = cddService.consultar(new ClassificacaoDecimalDireito(id));

                    this.cddsTabela = Arrays.asList(classificacaoDecimalDireitoPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosCDDs(this.cddsTabela);

                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_DESCRICAO)) {

                    ClassificacaoDecimalDireito classificacaoDecimalDireitoParaPesquisa = new ClassificacaoDecimalDireito();
                    classificacaoDecimalDireitoParaPesquisa.setDescricao(dadosParaPesquisa);

                    classificacaoDecimalDireitoPesquisado = cddService.consultar(classificacaoDecimalDireitoParaPesquisa);

                    this.cddsTabela  = Arrays.asList(classificacaoDecimalDireitoPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosCDDs(this.cddsTabela );
                }

                if (classificacaoDecimalDireitoPesquisado == null) {

                    this.cddsTabela  = cddService.listar();

                    inicializarComponentes();

                    inicializarTabelaDadosCDDs(this.cddsTabela );                

                    JOptionPane.showMessageDialog(this, "Não foram encontrados resultados para a pesquisa." );                
                }                
                
            }
        } catch (NumberFormatException e) {
            jTextFieldTextoPesquisa.setText("");
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID válido.");
        } catch (Exception ex) {
            Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, "ClassfificacoesDecimalDireitoUI.jButtonPesquisarClassificacaoDecimalDireitoActionPerformed().", ex);
            JOptionPane.showMessageDialog(this, "Não foi possível pesquisar. Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonPesquisarCDDActionPerformed

    private void jComboBoxCampoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCampoPesquisaItemStateChanged
        if (jComboBoxCampoPesquisa.getSelectedIndex() != 0) {
            jTextFieldTextoPesquisa.setEnabled(true);
        } else {
            jTextFieldTextoPesquisa.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxCampoPesquisaItemStateChanged

    private void jButtonImportarCDDUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarCDDUIActionPerformed
        int returnValue = jFileChooserSelecionarArquivo.showOpenDialog(this);
        
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                File arquivoSelecionado = jFileChooserSelecionarArquivo.getSelectedFile();
                
                cddService.importar(arquivoSelecionado);
                
                JOptionPane.showMessageDialog(this, "Arquivo importado com sucesso!");
    
                
            } catch (Exception ex) {
                Logger.getLogger(ClassificacoesDecimalDireitoUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ccorreu um erro ao abrir a tela Classificação Decimal. Entre em contato com nosso suporte.");
            }
        }        
    }//GEN-LAST:event_jButtonImportarCDDUIActionPerformed

    
    private void jFileChooserSelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserSelecionarArquivoActionPerformed

    }//GEN-LAST:event_jFileChooserSelecionarArquivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditarCDD;
    private javax.swing.JButton jButtonExcluirCDD;
    private javax.swing.JButton jButtonImportarCDDUI;
    private javax.swing.JButton jButtonIncluirCDDUI;
    private javax.swing.JButton jButtonPesquisarCDD;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxCampoPesquisa;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooserSelecionarArquivo;
    private javax.swing.JPanel jPanelSelecionarArquivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableCDD;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


 }

