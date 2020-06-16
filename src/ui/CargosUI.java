/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Cargo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import service.CargoService;
import ui.components.CargoTableModel;
import ui.components.ViewAbstractTableModel;
import util.UtilComponentes;
import util.UtilTabela;

/**
 *
 * @author CroK
 */
public class CargosUI extends javax.swing.JInternalFrame {
    
    private static final String TITULO_COMBOBOX_DESCRICAO = "Descrição";
    
    private static final String TITULO_COMBOBOX_ID = "Id";   
    
    private static final String COMMIT_ACTION = "commit";        

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private CargoService cargoService = new CargoService();    
    
    private List<Cargo> cargosTabela =  new ArrayList();    
    
    public CargosUI() throws Exception {
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaDadosCargos(new ArrayList());
    }


    private void inicializarComponentes() throws Exception {
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Autores");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
        UtilComponentes.habilitarComponentes(false, jButtonEditarCargo, jButtonExcluirCargos, 
                jTextFieldTextoPesquisa);
        
        UtilComponentes.limparCampos(jTextFieldTextoPesquisa);
        
        jTextFieldTextoPesquisa.setToolTipText(" <<<<<<<- SELECIONE um campo e digite sua pesquisa.");
        
        jComboBoxCampoPesquisa.setToolTipText(" Selecione um campo para pesquisa.");        
        
//      Define títulos para a combobox de pesquisa.        
        jComboBoxCampoPesquisa.setModel(new DefaultComboBoxModel<>(new String[] {"Selecione", TITULO_COMBOBOX_ID, TITULO_COMBOBOX_DESCRICAO}));          
    }    
    
    private void inicializarTabelaDadosCargos(List<Cargo> cargos) {
        try {
            if (cargos == null || cargos.isEmpty()) {
                this.cargosTabela = cargoService.listar();
            } else {
                this.cargosTabela = cargos;
            }
        } catch (Exception ex) {
            Logger.getLogger(AutoresUI.class.getName()).log(Level.SEVERE, "AutoresUI - ", ex);
        }
        
//      Instancia um novo LivroTableModel passando a lista de objetos.
        ViewAbstractTableModel cargoTableModel = new CargoTableModel(this.cargosTabela);
        
        UtilTabela.inicializarTabela(jTableCargosTabela, cargoTableModel);
        
        addMouseListenerTabela();
    }    
    
 public void addMouseListenerTabela() {
        
        jTableCargosTabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de autores e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Cargo a : cargosTabela) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas == 1 ) {
                        jButtonEditarCargo.setEnabled(true);
                        jButtonExcluirCargos.setEnabled(true);
                    } else if (qtdLinhasSelcionadas > 1){
                        jButtonEditarCargo.setEnabled(false);
                        jButtonExcluirCargos.setEnabled(true);
                    } else if (qtdLinhasSelcionadas < 1) {
                        jButtonEditarCargo.setEnabled(false);
                        jButtonExcluirCargos.setEnabled(false);                
                    }
                } 
            }
        });        
    }    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxCampoPesquisa = new javax.swing.JComboBox();
        jTextFieldTextoPesquisa = new javax.swing.JTextField();
        jButtonPesquisarCargo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCargosTabela = new javax.swing.JTable();
        jButtonIncluirCargo = new javax.swing.JButton();
        jButtonEditarCargo = new javax.swing.JButton();
        jButtonExcluirCargos = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setNextFocusableComponent(jTextFieldTextoPesquisa);

        jComboBoxCampoPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonPesquisarCargo.setMnemonic('p');
        jButtonPesquisarCargo.setText("pesquisar");
        jButtonPesquisarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarCargoActionPerformed(evt);
            }
        });

        jTableCargosTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableCargosTabela);

        jButtonIncluirCargo.setMnemonic('i');
        jButtonIncluirCargo.setText("INCLUIR");
        jButtonIncluirCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirCargoActionPerformed(evt);
            }
        });

        jButtonEditarCargo.setMnemonic('e');
        jButtonEditarCargo.setText("EDITAR");

        jButtonExcluirCargos.setMnemonic('x');
        jButtonExcluirCargos.setText("EXCLUIR");
        jButtonExcluirCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirCargosActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("SAIR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisarCargo)
                        .addContainerGap(289, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonIncluirCargo)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEditarCargo)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonExcluirCargos)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair))
                            .addComponent(jScrollPane1))
                        .addGap(19, 19, 19))))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTextoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisarCargo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonIncluirCargo)
                        .addComponent(jButtonEditarCargo)
                        .addComponent(jButtonExcluirCargos)
                        .addComponent(jButtonSair))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirCargoActionPerformed
   
        try {
            this.dispose();

            jDesktopPane.remove(this);

    //      Cria um instância de LivroPrincipalUI.
            CargoCadastroUI cargoCadastroUI = new CargoCadastroUI();

    //      Adiciona a pilha de do JDesktopPane o JInternalFrame.
            jDesktopPane.add(cargoCadastroUI);

    //      Remove barra de título e borda da janela
                UtilComponentes.removerBarraTituloEBorda(cargoCadastroUI);
            
//          Mostra a tela LivrosPrincipal.
            cargoCadastroUI.show();
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }//GEN-LAST:event_jButtonIncluirCargoActionPerformed

    private void jButtonExcluirCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirCargosActionPerformed
  
    }//GEN-LAST:event_jButtonExcluirCargosActionPerformed

    private void jButtonPesquisarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPesquisarCargoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditarCargo;
    private javax.swing.JButton jButtonExcluirCargos;
    private javax.swing.JButton jButtonIncluirCargo;
    private javax.swing.JButton jButtonPesquisarCargo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxCampoPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableCargosTabela;
    private javax.swing.JTextField jTextFieldTextoPesquisa;
    // End of variables declaration//GEN-END:variables



}
