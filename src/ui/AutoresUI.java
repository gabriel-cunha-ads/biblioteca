package ui;

import java.util.List;
import entity.Autor;
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
import service.AutorService;
import ui.components.AutoComplete;
import ui.components.AutorTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class AutoresUI extends javax.swing.JInternalFrame {

    private static final String TITULO_COMBOBOX_NOME = "Nome";
    
    private static final String TITULO_COMBOBOX_ID = "Id";   
    
    private static final String COMMIT_ACTION = "commit";    
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private AutorService autorService = new AutorService();
    
    private List<Autor> autoresTabela =  new ArrayList();
    
    
    public AutoresUI() throws Exception {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosAutores(new ArrayList());
        
    }

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Autores");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        UtilComponentes.habilitarComponentes(false, jButtonEditarAutor, jButtonExcluirAutores, 
                jTextFieldTextoPesquisa);
        
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        jTextFieldTextoPesquisa.setToolTipText(" <<<<<<<- SELECIONE um campo e digite sua pesquisa.");
        
        jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");

//      Define títulos para a combobox de pesquisa.        
        jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione", TITULO_COMBOBOX_ID, TITULO_COMBOBOX_NOME}));  
       
    }
    
    
    private void inicializarTabelaDadosAutores(List<Autor> autores) {
        
        try {
            if (autores == null || autores.isEmpty()) {
                this.autoresTabela = autorService.listar();
            } else {
                this.autoresTabela = autores;
            }
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, "AutoresUI - ", ex);
        }
        
//      Instancia um novo LivroTableModel passando a lista de objetos.
        ViewAbstractTableModel autorTableModel = new AutorTableModel(this.autoresTabela);
        
        UtilTabela.inicializarTabela(jTableAutores, autorTableModel);
        
        addMouseListenerTabela();
    }
    
    private List<String> listarNomesAutores() {
        
        List<String> nomes = new ArrayList();
        
        try {
            List<Autor> listaBanco = autorService.listar();
            for (Autor a : listaBanco ) {
                nomes.add(a.getNome());
            }
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nomes;
    }    
    
    public void addMouseListenerTabela() {
        
        jTableAutores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de autores e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Autor a : autoresTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        jButtonEditarAutor.setEnabled(true);
                        jButtonExcluirAutores.setEnabled(true);
                    } else if (qtdLinhasSelcionadas > 1){
                        jButtonEditarAutor.setEnabled(false);
                        jButtonExcluirAutores.setEnabled(true);
                    } else if (qtdLinhasSelcionadas < 1) {
                        jButtonEditarAutor.setEnabled(false);
                        jButtonExcluirAutores.setEnabled(false);                
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
        jTableAutores = new javax.swing.JTable();
        jButtonAbrirAutorCadastroUI = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jButtonExcluirAutores = new javax.swing.JButton();
        jButtonEditarAutor = new javax.swing.JButton();
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

        jTableAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAutores.setColumnSelectionAllowed(true);
        jTableAutores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableAutores.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableAutores);
        jTableAutores.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirAutorCadastroUI.setMnemonic('i');
        jButtonAbrirAutorCadastroUI.setText("Incluir");
        jButtonAbrirAutorCadastroUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirAutorCadastroUIActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jButtonExcluirAutores.setMnemonic('x');
        jButtonExcluirAutores.setText("Excluir");
        jButtonExcluirAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirAutoresActionPerformed(evt);
            }
        });

        jButtonEditarAutor.setMnemonic('e');
        jButtonEditarAutor.setText("Editar");
        jButtonEditarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarAutorActionPerformed(evt);
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
                        .addComponent(jButtonAbrirAutorCadastroUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEditarAutor)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonExcluirAutores)
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
                        .addComponent(jButtonAbrirAutorCadastroUI)
                        .addComponent(jButtonSair)
                        .addComponent(jButtonExcluirAutores)
                        .addComponent(jButtonEditarAutor))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonAbrirAutorCadastroUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirAutorCadastroUIActionPerformed
        
        try {
            this.dispose();

            jDesktopPane.remove(this);

    //      Cria um instância de LivroPrincipalUI.
            AutorCadastroUI autorCadastroUI = new AutorCadastroUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(autorCadastroUI);

    //      Remove barra de título e borda da janela
                UtilComponentes.removerBarraTituloEBorda(autorCadastroUI);
            
//          Mostra a tela LivrosPrincipal.
            autorCadastroUI.show();
            
            
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAbrirAutorCadastroUIActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        jDesktopPane.remove(this);
        
        dashboardUI.setJLabelNomeTela("Dashboard");
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonExcluirAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirAutoresActionPerformed

//      Verifica os objetos selecionados para excluir.
        List<Autor> selecionados = getSelecionados();
        
        try {
            if (selecionados != null) {
                
                int opcao = JOptionPane.showOptionDialog(null, "Tem certeza que deseja excluir?"
                        , "Excluir Autor(s)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                
                if (opcao == JOptionPane.OK_OPTION ) {
                    
//                  Remove do banco de dados (arquivo txt)
                    List<Autor> autoresNaoExlcuidos = autorService.excluir(selecionados);
                    
//                  Busca a lista atualizada no banco.
                    autoresTabela = autorService.listar();
                    
//                  Reinicializa a tabela
                    inicializarTabelaDadosAutores(autoresTabela);
                    
                    if (!autoresNaoExlcuidos.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Não foi possível excluir alguns dos registros selecionados porque existem operações gravadas.");
                    }
                    
                    UtilComponentes.habilitarComponentes(false, jButtonEditarAutor, jButtonExcluirAutores);
                    
                }  else if (opcao == JOptionPane.CANCEL_OPTION) {
                    autoresTabela = autorService.listar();
                    inicializarTabelaDadosAutores(autoresTabela);
                }
            }                    

        } catch (Exception e) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível excluir o(s) registro(s). Entre em contato com nosso suporte.");
        }
    }//GEN-LAST:event_jButtonExcluirAutoresActionPerformed

    private void jButtonEditarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarAutorActionPerformed
        
//      Verifica se tem autor selecionado (isSelecionado) para edição. 
        List<Autor> selecionados = getSelecionados();
        
        try {
            if (!selecionados.isEmpty() && selecionados.size() == 1) {
                this.dispose();

                jDesktopPane.remove(this);

//              Cria um instância da tela (UI) que será aberta e passa o selecionado.
                AutorCadastroUI autorCadastroUI = new AutorCadastroUI(selecionados.get(0));        

//              Adiciona a pilha de do JDesktopPane o JInternalFrame.
                jDesktopPane.add(autorCadastroUI);

                try {
//                  Remove barra de título e borda da janela
                    UtilComponentes.removerBarraTituloEBorda(autorCadastroUI);
                } catch (Exception ex) {
                    Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, ex);
                }

//              Mostra a tela LivrosPrincipal.
                autorCadastroUI.show();
            }            
        } catch (Exception e) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível editar o autor. Entre em contato com nosso suporte.");            
        }
    }//GEN-LAST:event_jButtonEditarAutorActionPerformed
    
    private List<Autor> getSelecionados() {
        List<Autor> autoresSelecionados = new ArrayList();
        
        for (Autor autor : this.autoresTabela) {
            if (autor.isSelecionado() ) {
                autoresSelecionados.add(autor);
            }
        }
        return autoresSelecionados;
    }

    private void jButtonPesquisarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarAutorActionPerformed
        
        String dadosParaPesquisa = jTextFieldTextoPesquisa.getText().trim();
        Autor autorPesquisado = null;
        
        try {
            if (dadosParaPesquisa.equals("")) {
                
                List<Autor> autores = autorService.listar();

                inicializarComponentes();

                inicializarTabelaDadosAutores(autores);  
            } else {
                
                if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_ID)) {
                    Integer id = null;

                    id = Integer.parseInt(dadosParaPesquisa);

                    autorPesquisado = autorService.consultar(new Autor(id));

                    this.autoresTabela = Arrays.asList(autorPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosAutores(this.autoresTabela);

                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(TITULO_COMBOBOX_NOME)) {

                    Autor autorParaPesquisa = new Autor();
                    autorParaPesquisa.setNome(dadosParaPesquisa);

                    autorPesquisado = autorService.consultar(autorParaPesquisa);

                    this.autoresTabela  = Arrays.asList(autorPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosAutores(this.autoresTabela );
                }

                if (autorPesquisado == null) {

                    this.autoresTabela  = autorService.listar();

                    inicializarComponentes();

                    inicializarTabelaDadosAutores(this.autoresTabela );                

                    JOptionPane.showMessageDialog(this, "Não foram encontrados resultados para a pesquisa." );                
                }                
                
            }
        } catch (NumberFormatException e) {
            jTextFieldTextoPesquisa.setText("");
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID válido.");
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, "AutoresUI.jButtonPesquisarAutorActionPerformed().", ex);
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
    private javax.swing.JButton jButtonAbrirAutorCadastroUI;
    private javax.swing.JButton jButtonEditarAutor;
    private javax.swing.JButton jButtonExcluirAutores;
    private javax.swing.JButton jButtonPesquisarAutor;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxCampoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableAutores;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


 }

