package ui;

import entity.Autor;
import entity.EnumFiltroLivro;
import java.util.List;
import entity.Livro;
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
import javax.swing.table.TableColumnModel;
import service.LivroService;
import ui.components.AutoComplete;
import ui.components.LivroTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class LivrosUI extends javax.swing.JInternalFrame {

    private static final String CAMPO_COMBOBOX_ID = "Id";   
    
    private static final String CAMPO_COMBOBOX_TITULO = "Titulo";
    
    private static final String CAMPO_COMBOBOX_ISBN = "ISBN";
    
    private static final String COMMIT_ACTION = "commit";    
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private LivroService livroService = new LivroService();
    
    private List<Livro> livrosTabela =  new ArrayList();
    
    
    public LivrosUI() throws Exception {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosLivros(new ArrayList());
        
    }

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Livros");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        UtilComponentes.habilitarComponentes(false, jButtonEditarLivro, jButtonExcluirLivros, 
                jTextFieldTextoPesquisa);
        
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        jTextFieldTextoPesquisa.setToolTipText(" <<<<<<<- SELECIONE um campo e digite sua pesquisa.");
        
        jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");

//      Define títulos para a combobox de pesquisa.        
        jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione",
            CAMPO_COMBOBOX_ID, CAMPO_COMBOBOX_TITULO, CAMPO_COMBOBOX_ISBN}));  
       
//      Auto sugestão
//        List<String> titulos = listarTitulosLivros();
//        jTextFieldTextoPesquisa.setFocusTraversalKeysEnabled(false);
//        AutoComplete autoComplete = new AutoComplete(jTextFieldTextoPesquisa, titulos);
//        jTextFieldTextoPesquisa.getDocument().addDocumentListener(autoComplete);
//        jTextFieldTextoPesquisa.getInputMap().put(KeyStroke.getKeyStroke(title).getKeyStroke("TAB"), COMMIT_ACTION);
//        jTextFieldTextoPesquisa.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction());         
    }
    
    
    private void inicializarTabelaDadosLivros(List<Livro> livros) {
        try {
            if (livros == null || livros.isEmpty()) {
                this.livrosTabela = livroService.listar();
            } else {
                this.livrosTabela = livros;
            }
            
    //      Instancia um novo LivroTableModel passando a lista de objetos.
            ViewAbstractTableModel livroTableModel = new LivroTableModel(this.livrosTabela);

            UtilTabela.inicializarTabela(jTableLivros, livroTableModel);
            
//          Defini tamanho das colunas
            TableColumnModel tcm = jTableLivros.getColumnModel();
            tcm.getColumn(0).setPreferredWidth(10);
            tcm.getColumn(1).setPreferredWidth(280);
            tcm.getColumn(2).setPreferredWidth(90);
            tcm.getColumn(3).setPreferredWidth(50);      
            tcm.getColumn(4).setPreferredWidth(10);            
            tcm.getColumn(5).setPreferredWidth(10);            

            addMouseListenerTabela();
            
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, "LivrosUI - ", ex);
        }
    }
    
   
    
    private List<String> listarTitulosLivros() {
        
        List<String> titulos = new ArrayList();
        
        try {
            List<Livro> listaBanco = livroService.listar();
            for (Livro a : listaBanco ) {
                titulos.add(a.getTitulo());
            }
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return titulos;
    }    
    
    public void addMouseListenerTabela() {
        
        jTableLivros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de livros e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Livro a : livrosTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        jButtonEditarLivro.setEnabled(true);
                        jButtonExcluirLivros.setEnabled(true);
                    } else if (qtdLinhasSelcionadas > 1){
                        jButtonEditarLivro.setEnabled(false);
                        jButtonExcluirLivros.setEnabled(true);
                    } else if (qtdLinhasSelcionadas < 1) {
                        jButtonEditarLivro.setEnabled(false);
                        jButtonExcluirLivros.setEnabled(false);                
                    }
                } 
            }
        });        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisarLivro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLivros = new javax.swing.JTable();
        jButtonAbrirLivroCadastroUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonExcluirLivros = new javax.swing.JButton();
        jButtonEditarLivro = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jComboBoxCampoPesquisa = new javax.swing.JComboBox<>();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setNextFocusableComponent(jTextFieldTextoPesquisa);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jButtonPesquisarLivro.setMnemonic('p');
        jButtonPesquisarLivro.setText("pesquisar");
        jButtonPesquisarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarLivroActionPerformed(evt);
            }
        });

        jTableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableLivros.setColumnSelectionAllowed(true);
        jTableLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableLivros.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableLivros);
        jTableLivros.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirLivroCadastroUI.setMnemonic('i');
        jButtonAbrirLivroCadastroUI.setText("Incluir");
        jButtonAbrirLivroCadastroUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirLivroCadastroUIActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonExcluirLivros.setMnemonic('x');
        jButtonExcluirLivros.setText("Excluir");
        jButtonExcluirLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirLivrosActionPerformed(evt);
            }
        });

        jButtonEditarLivro.setMnemonic('e');
        jButtonEditarLivro.setText("Editar");
        jButtonEditarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarLivroActionPerformed(evt);
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
                        .addComponent(jButtonAbrirLivroCadastroUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditarLivro)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonExcluirLivros)
                        .addGap(51, 51, 51)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPesquisarLivro)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarLivro)
                    .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAbrirLivroCadastroUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonExcluirLivros)
                        .addComponent(jButtonEditarLivro))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonAbrirLivroCadastroUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirLivroCadastroUIActionPerformed
        
        try {
            this.dispose();

            jDesktopPane.remove(this);

    //      Cria um instância de LivroPrincipalUI.
            LivroCadastroUI livroCadastroUI = new LivroCadastroUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(livroCadastroUI);

    //      Remove barra de título e borda da janela
                UtilComponentes.removerBarraTituloEBorda(livroCadastroUI);
            
//          Mostra a tela LivrosPrincipal.
            livroCadastroUI.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAbrirLivroCadastroUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        jDesktopPane.remove(this);
        
        dashboardUI.setJLabelNomeTela("Dashboard");
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirLivrosActionPerformed

//      Verifica os objetos selecionados para excluir.
        List<Livro> selecionados = getSelecionados();
        
        try {
            if (selecionados != null && !selecionados.isEmpty()) {
                
                int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir?"
                        , "Excluir Livro(s)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                
                if (opcao == JOptionPane.OK_OPTION ) {
                    
//                  Remove do banco de dados (arquivo txt)
                    List<Livro> livrosNaoExlcuidos = livroService.excluir(selecionados);
                    
//                  Busca a lista atualizada no banco.
                    livrosTabela = livroService.listar();
                    
//                  Reinicializa a tabela
                    inicializarTabelaDadosLivros(livrosTabela);
                    
                    if (!livrosNaoExlcuidos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Não foi possível excluir alguns dos registros selecionados porque existem operações gravadas.");
                    }
                    
                    UtilComponentes.habilitarComponentes(false, jButtonEditarLivro, jButtonExcluirLivros);
                    
                }  else if (opcao == JOptionPane.CANCEL_OPTION) {
                    livrosTabela = livroService.listar();
                    inicializarTabelaDadosLivros(livrosTabela);
                }
            }                    

        } catch (Exception e) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o(s) registro(s). Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonExcluirLivrosActionPerformed

    private void jButtonEditarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarLivroActionPerformed
        
//      Verifica se tem livro selecionado (isSelecionado) para edição. 
        List<Livro> selecionados = getSelecionados();
        
        try {
            if (!selecionados.isEmpty() && selecionados.size() == 1) {
                this.dispose();

                jDesktopPane.remove(this);

//              Cria um instância da tela (UI) que será aberta e passa o selecionado.
                LivroCadastroUI livroCadastroUI = new LivroCadastroUI(selecionados.get(0));        

//              Adiciona à pilha do JDesktopPane o JInternalFrame.
                jDesktopPane.add(livroCadastroUI);

                try {
//                  Remove barra de título e borda da janela
                    UtilComponentes.removerBarraTituloEBorda(livroCadastroUI);
                } catch (Exception ex) {
                    Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
                }

//              Mostra a tela LivrosPrincipal.
                livroCadastroUI.show();
            }            
        } catch (Exception e) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível editar o livro. Entre em contato com nosso suporte.");            
        }
    }//GEN-LAST:event_jButtonEditarLivroActionPerformed
    
    private List<Livro> getSelecionados() {
        List<Livro> livrosSelecionados = new ArrayList();
        
        for (Livro livro : this.livrosTabela) {
            if (livro.isSelecionado() ) {
                livrosSelecionados.add(livro);
            }
        }
        return livrosSelecionados;
    }

    private void jButtonPesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarLivroActionPerformed
        
        String dadosParaPesquisa = jTextFieldTextoPesquisa.getText().trim();
        Livro livroPesquisado = null;
        
        try {
            if (dadosParaPesquisa.equals("")) {
                
                List<Livro> livros = livroService.listar();

                inicializarComponentes();

                inicializarTabelaDadosLivros(livros);  
            } else {
                
                if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_ID)) {
                    Integer id = null;

                    id = Integer.parseInt(dadosParaPesquisa);

                    livroPesquisado = livroService.consultar(new Livro(id), EnumFiltroLivro.ID);

                    this.livrosTabela = Arrays.asList(livroPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosLivros(this.livrosTabela);

                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_TITULO)) {

                    Livro livroParaPesquisa = new Livro();
                    
                    livroParaPesquisa.setTitulo(dadosParaPesquisa);

                    livroPesquisado = livroService.consultar(livroParaPesquisa, EnumFiltroLivro.TITULO);

                    this.livrosTabela  = Arrays.asList(livroPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosLivros(this.livrosTabela );
                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_ISBN)) {

                    Livro livroParaPesquisa = new Livro();
                    
                    livroParaPesquisa.setTitulo(dadosParaPesquisa);

                    livroPesquisado = livroService.consultar(livroParaPesquisa, EnumFiltroLivro.ISBN);

                    this.livrosTabela  = Arrays.asList(livroPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosLivros(this.livrosTabela );
                } 

                if (livroPesquisado == null) {

                    this.livrosTabela  = livroService.listar();

                    inicializarComponentes();

                    inicializarTabelaDadosLivros(this.livrosTabela );                

                    JOptionPane.showMessageDialog(this, "Não foram encontrados resultados para a pesquisa." );                
                }                
                
            }
        } catch (NumberFormatException e) {
            jTextFieldTextoPesquisa.setText("");
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID válido.");
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, "LivrosUI.jButtonPesquisarLivroActionPerformed().", ex);
            JOptionPane.showMessageDialog(this, "Não foi possível pesquisar. Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonPesquisarLivroActionPerformed

    private void jComboBoxCampoPesquisaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCampoPesquisaItemStateChanged
        if (jComboBoxCampoPesquisa.getSelectedIndex() != 0) {
            jTextFieldTextoPesquisa.setEnabled(true);
        } else {
            jTextFieldTextoPesquisa.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBoxCampoPesquisaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrirLivroCadastroUI;
    private javax.swing.JButton jButtonEditarLivro;
    private javax.swing.JButton jButtonExcluirLivros;
    private javax.swing.JButton jButtonPesquisarLivro;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxCampoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableLivros;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


 }

