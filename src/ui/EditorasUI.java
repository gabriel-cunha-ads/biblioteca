package ui;

import java.util.List;
import entity.Editora;
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
import service.EditoraService;
import ui.components.AutoComplete;
import ui.components.EditoraTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class EditorasUI extends javax.swing.JInternalFrame {

    private static final String TITULO_COMBOBOX_NOME = "Nome";
    
    private static final String TITULO_COMBOBOX_ID = "Id";   
    
    private static final String COMMIT_ACTION = "commit";    
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private EditoraService editoraService = new EditoraService();
    
    private List<Editora> editorasTabela =  new ArrayList();
    
    
    public EditorasUI() throws Exception {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosEditoras(new ArrayList());
        
    }

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editoras");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        UtilComponentes.habilitarComponentes(false, jButtonEditarEditora, jButtonExcluirEditoras, 
                jTextFieldTextoPesquisa);
        
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        jTextFieldTextoPesquisa.setToolTipText(" <<<<<<<- SELECIONE um campo e digite sua pesquisa.");
        
        jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");

//      Define títulos para a combobox de pesquisa.        
        jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione", TITULO_COMBOBOX_ID, TITULO_COMBOBOX_NOME}));  

//      Auto sugestão
        List<String> nomes = listarNomesEditoras();
        jTextFieldTextoPesquisa.setFocusTraversalKeysEnabled(false);
        AutoComplete autoComplete = new AutoComplete(jTextFieldTextoPesquisa, nomes);
        jTextFieldTextoPesquisa.getDocument().addDocumentListener(autoComplete);
        jTextFieldTextoPesquisa.getInputMap().put(KeyStroke.getKeyStroke(title).getKeyStroke("TAB"), COMMIT_ACTION);
        jTextFieldTextoPesquisa.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());        
    }
    
    
    private void inicializarTabelaDadosEditoras(List<Editora> editoras) {
        
        try {
            if (editoras == null || editoras.isEmpty()) {
                this.editorasTabela = editoraService.listar();
            } else {
                this.editorasTabela = editoras;
            }
        } catch (Exception ex) {
            Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Instancia um novo LivroTableModel passando a lista de objetos.
        ViewAbstractTableModel editoraTableModel = new EditoraTableModel(this.editorasTabela);
        
        UtilTabela.inicializarTabela(jTableEditoras, editoraTableModel);
        
        addMouseListenerTabela();
    }
    
    private List<String> listarNomesEditoras() {
        List<String> nomes = new ArrayList();
        
        try {
            List<Editora> listaBanco = editoraService.listar();
            for (Editora e : listaBanco ) {
                nomes.add(e.getNome());
            }
        } catch (Exception ex) {
            Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomes;
    }    
    
    public void addMouseListenerTabela() {
        
        jTableEditoras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de editoras e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Editora a : editorasTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        jButtonEditarEditora.setEnabled(true);
                        jButtonExcluirEditoras.setEnabled(true);
                    } else if (qtdLinhasSelcionadas > 1){
                        jButtonEditarEditora.setEnabled(false);
                        jButtonExcluirEditoras.setEnabled(true);
                    } else if (qtdLinhasSelcionadas < 1) {
                        jButtonEditarEditora.setEnabled(false);
                        jButtonExcluirEditoras.setEnabled(false);                
                    }
                } 
            }
        });        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisarEditora = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEditoras = new javax.swing.JTable();
        jButtonAbrirEditoraCadastroUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonExcluirEditoras = new javax.swing.JButton();
        jButtonEditarEditora = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxCampoPesquisa = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNextFocusableComponent(jTextFieldTextoPesquisa);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButtonPesquisarEditora.setMnemonic('p');
        jButtonPesquisarEditora.setText("pesquisar");
        jButtonPesquisarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarEditoraActionPerformed(evt);
            }
        });

        jTableEditoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableEditoras.setColumnSelectionAllowed(true);
        jTableEditoras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableEditoras.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableEditoras);
        jTableEditoras.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirEditoraCadastroUI.setMnemonic('i');
        jButtonAbrirEditoraCadastroUI.setText("Incluir");
        jButtonAbrirEditoraCadastroUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirEditoraCadastroUIActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonExcluirEditoras.setMnemonic('x');
        jButtonExcluirEditoras.setText("Excluir");
        jButtonExcluirEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirEditorasActionPerformed(evt);
            }
        });

        jButtonEditarEditora.setMnemonic('e');
        jButtonEditarEditora.setText("Editar");
        jButtonEditarEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarEditoraActionPerformed(evt);
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
                        .addComponent(jButtonAbrirEditoraCadastroUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditarEditora)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonExcluirEditoras)
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarEditora)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarEditora)
                    .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAbrirEditoraCadastroUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonExcluirEditoras)
                        .addComponent(jButtonEditarEditora))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonAbrirEditoraCadastroUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirEditoraCadastroUIActionPerformed
        
        try {
            this.dispose();

            jDesktopPane.remove(this);

//          Cria um instância de LivroPrincipalUI.
            EditoraCadastroUI editoraCadastroUI = new EditoraCadastroUI();

//          Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(editoraCadastroUI);

//          Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(editoraCadastroUI);
    
//          Mostra a tela LivrosPrincipal.
            editoraCadastroUI.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAbrirEditoraCadastroUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        jDesktopPane.remove(this);
        
        dashboardUI.setJLabelNomeTela("Dashboard");
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirEditorasActionPerformed

//      Verifica os objetos selecionados para excluir.
        List<Editora> selecionados = getSelecionados();
        
        try {
            if (selecionados != null) {
                
                int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir?"
                        , "Excluir Editora(s)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                
                if (opcao == JOptionPane.OK_OPTION ) {
                    
//                  Remove do banco de dados (arquivo txt)
                    List<Editora> editorasNaoExlcuidos = editoraService.excluir(selecionados);
                    
//                  Busca a lista atualizada no banco.
                    editorasTabela = editoraService.listar();
                    
//                  Reinicializa a tabela
                    inicializarTabelaDadosEditoras(editorasTabela);
                    
                    if (!editorasNaoExlcuidos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Não foi possível excluir alguns dos registros selecionados porque existem operações gravadas.", "Editoras", JOptionPane.DEFAULT_OPTION);
                    }
                    
                    UtilComponentes.habilitarComponentes(false, jButtonEditarEditora, jButtonExcluirEditoras);
                    
                }  else if (opcao == JOptionPane.CANCEL_OPTION) {
                    editorasTabela = editoraService.listar();
                    inicializarTabelaDadosEditoras(editorasTabela);
                }
            }                    

        } catch (Exception e) {
            Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o(s) registro(s). Entre em contato com nosso suporte.", "Editoras", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonExcluirEditorasActionPerformed

    private void jButtonEditarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarEditoraActionPerformed
        
//      Verifica se tem editora selecionado (isSelecionado) para edição. 
        List<Editora> selecionados = getSelecionados();
        
        try {
            if (!selecionados.isEmpty() && selecionados.size() == 1) {
                this.dispose();

                jDesktopPane.remove(this);

//              Cria um instância da tela (UI) que será aberta e passa o selecionado.
                EditoraCadastroUI editoraCadastroUI = new EditoraCadastroUI(selecionados.get(0));        

//              Adiciona a pilha de do JDesktopPane o JInternalFrame.
                jDesktopPane.add(editoraCadastroUI);

                try {
//                  Remove barra de título e borda da janela
                    UtilComponentes.removerBarraTituloEBorda(editoraCadastroUI);
                } catch (Exception ex) {
                    Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, ex);
                }

//              Mostra a tela LivrosPrincipal.
                editoraCadastroUI.show();
            }            
        } catch (Exception e) {
            Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível editar o editora. Entre em contato com nosso suporte.");            
        }
    }//GEN-LAST:event_jButtonEditarEditoraActionPerformed
    
    private List<Editora> getSelecionados() {
        List<Editora> editorasSelecionados = new ArrayList();
        
        for (Editora editora : this.editorasTabela) {
            if (editora.isSelecionado() ) {
                editorasSelecionados.add(editora);
            }
        }
        return editorasSelecionados;
    }

    private void jButtonPesquisarEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarEditoraActionPerformed
        
        String dadosParaPesquisa = jTextFieldTextoPesquisa.getText().trim();
        Editora editoraPesquisado = null;
        
        try {
            if (dadosParaPesquisa.equals("")) {
                
                List<Editora> editoras = editoraService.listar();

                inicializarComponentes();

                inicializarTabelaDadosEditoras(editoras);  
            } else {
                
                if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_ID)) {
                    Integer id = null;

                    id = Integer.parseInt(dadosParaPesquisa);

                    editoraPesquisado = editoraService.consultar(new Editora(id));

                    this.editorasTabela = Arrays.asList(editoraPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosEditoras(this.editorasTabela);

                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_NOME)) {

                    Editora editoraParaPesquisa = new Editora();
                    editoraParaPesquisa.setNome(dadosParaPesquisa);

                    editoraPesquisado = editoraService.consultar(editoraParaPesquisa);

                    this.editorasTabela  = Arrays.asList(editoraPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosEditoras(this.editorasTabela );
                }

                if (editoraPesquisado == null) {

                    this.editorasTabela  = editoraService.listar();

                    inicializarComponentes();

                    inicializarTabelaDadosEditoras(this.editorasTabela );                

                    JOptionPane.showMessageDialog(this, "Não foram encontrados resultados para a pesquisa.", "Editoras", JOptionPane.DEFAULT_OPTION );                
                }                
                
            }
        } catch (NumberFormatException e) {
            jTextFieldTextoPesquisa.setText("");
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID válido.", "Pesquisa", JOptionPane.DEFAULT_OPTION );
        } catch (Exception ex) {
            Logger.getLogger(EditorasUI.class.getName()).log(Level.SEVERE, "EditorasUI.jButtonPesquisarEditoraActionPerformed().", ex);
            JOptionPane.showMessageDialog(this, "Não foi possível pesquisar. Entre em contato com nosso suporte.", "Editoras", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonPesquisarEditoraActionPerformed

    private void jComboBoxCampoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCampoPesquisaItemStateChanged
        if (jComboBoxCampoPesquisa.getSelectedIndex() != 0) {
            jTextFieldTextoPesquisa.setEnabled(true);
        } else {
            jTextFieldTextoPesquisa.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxCampoPesquisaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirEditoraCadastroUI;
    private javax.swing.JButton jButtonEditarEditora;
    private javax.swing.JButton jButtonExcluirEditoras;
    private javax.swing.JButton jButtonPesquisarEditora;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxCampoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableEditoras;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


 }

