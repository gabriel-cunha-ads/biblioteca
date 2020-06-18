package ui;

import entity.EnumFiltroExemplar;
import java.util.List;
import entity.Exemplar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import service.ExemplarService;
import ui.components.ExemplarTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 * 
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com> 
 */
public class ExemplarOperacoesUI extends javax.swing.JInternalFrame {

    private static final String CAMPO_COMBOBOX_ID = "Id";   
    
    private static final String CAMPO_COMBOBOX_TITULO = "Titulo";
    
    private static final String CAMPO_COMBOBOX_ISBN = "ISBN";
    
    private static final String CAMPO_COMBOBOX_SITUACAO = "SITUACAO";
    
    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private ExemplarService exemplarService;
    
    private List<Exemplar> exemplaresTabela =  new ArrayList();
    
    
    public ExemplarOperacoesUI() {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosExemplares(new ArrayList());
    }

    private void inicializarComponentes() {
        
        try {
            exemplarService = new ExemplarService();

    //      Obtém a instancia do dashboard, inicializa o título da janela.
            dashboardUI =  DashboardUI.getInstance();

    //      Defini o nome do títilo da tela.
            dashboardUI.setJLabelNomeTela("Operações Exemplares");

    //      Obtém a instancia do JDesktopPane
            jDesktopPane = dashboardUI.getJDesktopPrincipal();

            UtilComponentes.habilitarComponentes(false, jButtonAbrirEmprestimo);

            UtilComponentes.limparCampos(jTextFieldTextoPesquisa);

            jTextFieldTextoPesquisa.setToolTipText(" <- SELECIONE um campo e digite sua pesquisa.");

            jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");

    //      Define títulos para a combobox de pesquisa.        
            jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione",
                CAMPO_COMBOBOX_ID, CAMPO_COMBOBOX_TITULO, CAMPO_COMBOBOX_ISBN, CAMPO_COMBOBOX_SITUACAO}));              
        } catch (Exception e) {
            Logger.getLogger(ExemplarOperacoesUI.class.getName()).log(Level.SEVERE, "ExemplarsUI - ", e);   
            
        }
    }
    
    
    private void inicializarTabelaDadosExemplares(List<Exemplar> exemplares) {
        try {
            if (exemplares == null || exemplares.isEmpty()) {
                this.exemplaresTabela = exemplarService.listar();
                this.exemplaresTabela = exemplarService.preencherExemplaresComLivros(exemplaresTabela);
            } else {
                this.exemplaresTabela = exemplares;
            }
            
    //      Instancia um novo ExemplarTableModel passando a lista de objetos.
            ViewAbstractTableModel operacoesTableModel = new ExemplarTableModel(this.exemplaresTabela);

            UtilTabela.inicializarTabela(jTableLivrosOperacoes, operacoesTableModel);
            
//          Defini tamanho das colunas
            TableColumnModel tcm = jTableLivrosOperacoes.getColumnModel();
            tcm.getColumn(0).setPreferredWidth(10);
            tcm.getColumn(1).setPreferredWidth(280);
            tcm.getColumn(2).setPreferredWidth(90);
            tcm.getColumn(3).setPreferredWidth(50);      
            tcm.getColumn(4).setPreferredWidth(10);            
            tcm.getColumn(5).setPreferredWidth(10);            

            addMouseListenerTabela();
            
        } catch (Exception ex) {
            Logger.getLogger(ExemplarOperacoesUI.class.getName()).log(Level.SEVERE, "ExemplarsUI - ", ex);
        }
    }

    public void addMouseListenerTabela() {
        jTableLivrosOperacoes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de exemplares e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Exemplar a : exemplaresTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        UtilComponentes.habilitarComponentes(true, jButtonAbrirEmprestimo,
                            jButtonAbrirDevolucao,jButtonAbrirReserva);
                    } else {
                        UtilComponentes.habilitarComponentes(false, jButtonAbrirEmprestimo,
                            jButtonAbrirDevolucao,jButtonAbrirReserva);                        
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
        jTableLivrosOperacoes = new javax.swing.JTable();
        jButtonAbrirEmprestimo = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxCampoPesquisa = new javax.swing.JComboBox<>();
        jButtonAbrirDevolucao = new javax.swing.JButton();
        jButtonAbrirReserva = new javax.swing.JButton();

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

        jTableLivrosOperacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableLivrosOperacoes.setColumnSelectionAllowed(true);
        jTableLivrosOperacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableLivrosOperacoes.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTableLivrosOperacoes);
        jTableLivrosOperacoes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonAbrirEmprestimo.setMnemonic('e');
        jButtonAbrirEmprestimo.setText("Emprestar");
        jButtonAbrirEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirEmprestimoActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jComboBoxCampoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCampoPesquisa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCampoPesquisaItemStateChanged(evt);
            }
        });

        jButtonAbrirDevolucao.setMnemonic('d');
        jButtonAbrirDevolucao.setText("Devolver");

        jButtonAbrirReserva.setMnemonic('r');
        jButtonAbrirReserva.setText("Reservar");

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
                        .addComponent(jButtonAbrirEmprestimo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAbrirDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAbrirReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jButtonAbrirEmprestimo)
                        .addComponent(jButtonAbrirDevolucao)
                        .addComponent(jButtonAbrirReserva))
                    .addComponent(jButtonSair))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonAbrirEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirEmprestimoActionPerformed
        
        try {
            Exemplar exemplarSelecionado = getSelecionado();
            
            this.dispose();

            jDesktopPane.remove(this);

//          Cria um instância de ExemplarPrincipalUI.
            EmprestimoUI emprestimoUI = new EmprestimoUI(exemplarSelecionado);

//          Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(emprestimoUI);

//          Remove barra de título e borda da janela
            UtilComponentes.removerBarraTituloEBorda(emprestimoUI);
            
//          Mostra a tela ExemplarsPrincipal.
            emprestimoUI.show();
            
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Não foi possível abrir o Empréstimo de Exemplar. Entre em contato com nosso suporte.");  
        }
        
    }//GEN-LAST:event_jButtonAbrirEmprestimoActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        jDesktopPane.remove(this);
        
        dashboardUI.setJLabelNomeTela("Dashboard");
    }//GEN-LAST:event_jButtonSairActionPerformed
    
    private Exemplar getSelecionado() {
        Exemplar exemplar = new Exemplar();
        
        for (Exemplar l : this.exemplaresTabela) {
            if (l.isSelecionado() ) {
                exemplar = l;
            }
        }
        return exemplar;
    }

    private void jButtonPesquisarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarLivroActionPerformed
        
        String dadosParaPesquisa = jTextFieldTextoPesquisa.getText().trim();
        Exemplar exemplarPesquisado = null;
        
        try {
            if (dadosParaPesquisa.equals("")) {
                
                List<Exemplar> exemplares = exemplarService.listar();

                inicializarComponentes();

                inicializarTabelaDadosExemplares(exemplares);  
            } else {
                
                if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_ID)) {
                    Integer id = null;

                    id = Integer.parseInt(dadosParaPesquisa);

                    exemplarPesquisado = exemplarService.consultar(new Exemplar(id), EnumFiltroExemplar.ID);

                    this.exemplaresTabela = Arrays.asList(exemplarPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosExemplares(this.exemplaresTabela);

                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_TITULO)) {

                    Exemplar exemplarParaPesquisa = new Exemplar();
                    
                    exemplarParaPesquisa.getLivro().setTitulo(dadosParaPesquisa);

                    exemplarPesquisado = exemplarService.consultar(exemplarParaPesquisa, EnumFiltroExemplar.TITULO);

                    this.exemplaresTabela  = Arrays.asList(exemplarPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosExemplares(this.exemplaresTabela );
                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_ISBN)) {

                    Exemplar exemplarParaPesquisa = new Exemplar();
                    
                    exemplarParaPesquisa.getLivro().setTitulo(dadosParaPesquisa);

                    exemplarPesquisado = exemplarService.consultar(exemplarParaPesquisa, EnumFiltroExemplar.ISBN);

                    this.exemplaresTabela  = Arrays.asList(exemplarPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosExemplares(this.exemplaresTabela );
                } else if (jComboBoxCampoPesquisa.getSelectedItem().equals(CAMPO_COMBOBOX_SITUACAO)) {

                    Exemplar exemplarParaPesquisa = new Exemplar();
                    
                    exemplarParaPesquisa.getLivro().setTitulo(dadosParaPesquisa);

                    exemplarPesquisado = exemplarService.consultar(exemplarParaPesquisa, EnumFiltroExemplar.SITUACAO);

                    this.exemplaresTabela  = Arrays.asList(exemplarPesquisado);

                    inicializarComponentes();

                    inicializarTabelaDadosExemplares(this.exemplaresTabela );
                } 

                if (exemplarPesquisado == null) {

                    this.exemplaresTabela  = exemplarService.listar();

                    inicializarComponentes();

                    inicializarTabelaDadosExemplares(this.exemplaresTabela );                

                    JOptionPane.showMessageDialog(this, "Não foram encontrados resultados para a pesquisa." );                
                }                
                
            }
        } catch (NumberFormatException e) {
            jTextFieldTextoPesquisa.setText("");
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID válido.");
        } catch (Exception ex) {
            Logger.getLogger(ExemplarOperacoesUI.class.getName()).log(Level.SEVERE, "ExemplarsUI.jButtonPesquisarExemplarActionPerformed().", ex);
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
    private javax.swing.JButton jButtonAbrirDevolucao;
    private javax.swing.JButton jButtonAbrirEmprestimo;
    private javax.swing.JButton jButtonAbrirReserva;
    private javax.swing.JButton jButtonPesquisarLivro;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox<String> jComboBoxCampoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableLivrosOperacoes;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables


 }

