package ui;

import entity.Autor;
import entity.ClassificacaoDecimalDireito;
import entity.Editora;
import entity.Livro;
import entity.EnumOperacaoBanco;
import entity.Usuario;
import entity.vo.AutorVO;
import entity.vo.ClassificacaoDecimalDireitoVO;
import entity.vo.EditoraVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.HeadlessException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import service.AutorService;
import service.ClassificacaoDecimalDireitoService;
import service.EditoraService;
import service.LivroService;
import service.UsuarioService;
import ui.dialog.AutorCadastroDialog;
import ui.dialog.EditoraCadastroDialog;
import util.UtilComponentes;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroCadastroUI extends javax.swing.JInternalFrame {
    
    private static final DateFormat df = new SimpleDateFormat("dd/mm/yyyy");    

    private JDesktopPane jDesktopPane;
    
    private DashboardUI dashboardUI;
    
    private boolean editandoLivro;
    
    private Livro livroEmEdicao;
    
    private LivroService livroService = new LivroService();
    
    private AutorService autorService = new AutorService();
    
    private EditoraService editoraService = new EditoraService();
    
    private UsuarioService usuarioService = new UsuarioService();
    
    private ClassificacaoDecimalDireitoService cddService = new ClassificacaoDecimalDireitoService();
    
    
    public LivroCadastroUI() throws Exception {
        initComponents();
        inicializarComponentes();
    }
    
    public LivroCadastroUI(Livro livroEmEdicao) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editar Livro");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarLivro.setText("Salvar");
        
//      Habilita a edição da checkBox ativo
        jCheckBoxAtivo.setEnabled(true);
        
        editandoLivro = true;
        
        this.livroEmEdicao = livroEmEdicao;
        
        preencherCamposDaTelaComLivroEditando(livroEmEdicao);
    }    

    private void inicializarComponentes() throws Exception {
        
//      Obtém a instancia do dashboard, inicializa o título da janela.
        dashboardUI =  DashboardUI.getInstance();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Cadastrar Livro");
        
//      Obtém a instancia do JDesktopPane
        jDesktopPane = dashboardUI.getJDesktopPrincipal();
        
//      Maximiza o JInternalFrame para o tamanho do JDesktopPane (pai);
        UtilComponentes.maximizarJInternalFrame(this);
        
//      Data formata dataImpressao
        jXDatePickerIDataImpressao.setFormats(new String[] {"MM/yyyy"});
        jXDatePickerIDataImpressao.setLinkDate(System.currentTimeMillis(), "Hoje é {0}");
        
//      Inicializa jComboBoxAutores
        Vector<AutorVO> autoresVO = autorService.carregarVetorComboBox();
        jComboBoxAutores.setModel(new DefaultComboBoxModel(autoresVO));

//      Inicializa jComboBoxEditoras
        Vector<EditoraVO> editorasVO = editoraService.carregarVetorComboBox();
        jComboBoxEditoras.setModel(new DefaultComboBoxModel(editorasVO));
        
//      Inicializa Combobox ClassificacaoDecimalDireito
        Vector<ClassificacaoDecimalDireitoVO> cddVO = cddService.carregarVetorComboBox();
        jComboBoxCdds.setModel(new DefaultComboBoxModel(cddVO));  
        
//      Inicializa a ComboBox  AnoAno
        LocalDate dataAtual = LocalDate.now();
        Vector<Integer> rangeAnosEdicao = IntStream.rangeClosed(1800, dataAtual.getYear())
                                        .boxed()
                                        .sorted(Collections.reverseOrder())
                                        .collect(Collectors.toCollection(Vector::new));
        
        jComboBoxAnoEdicao.setModel(new DefaultComboBoxModel(rangeAnosEdicao));  

        
        
//      Cria um range de um inteiros para edicao e impressao
        List<Integer> rangeInteiros = IntStream.rangeClosed(1, 99)
                                            .boxed()
                                            .collect(Collectors.toList());  
        
//      Passa o range de inteiros para range de Vector<string> inserindo o caractere (º)
        Vector<String> rangeString = rangeInteiros.stream()
                                                .map(s -> String.valueOf(s) + "º")
                                                .collect(Collectors.toCollection(Vector::new));
        
//      Inicializa jComboBoxEdicao
        jComboBoxEdicao.setModel(new DefaultComboBoxModel(rangeString));
        
//      Inicializa jComboBoxImpressao
        jComboBoxImpressao.setModel(new DefaultComboBoxModel(rangeString));
        
        
        
    }
    
    public void preencherCamposDaTelaComLivroEditando(Livro livroEmEdicao) {
        jTextFieldTitulo.setText(livroEmEdicao.getTitulo());
        jCheckBoxAtivo.setSelected(livroEmEdicao.isAtivo());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarLivro = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jTextFieldIsbn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEditoras = new javax.swing.JComboBox<>();
        jButtonIncluirNovoAutor = new javax.swing.JButton();
        jButtonAddEditora = new javax.swing.JButton();
        jComboBoxCdds = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxEdicao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxImpressao = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxAnoEdicao = new javax.swing.JComboBox<>();
        jXDatePickerIDataImpressao = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxAutores = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(850, 600));

        jLabel1.setLabelFor(jTextFieldTitulo);
        jLabel1.setText("Título");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jSeparator1.setPreferredSize(new java.awt.Dimension(850, 1));

        jButtonIncluirSalvarLivro.setMnemonic('i');
        jButtonIncluirSalvarLivro.setText("Inlcuir");
        jButtonIncluirSalvarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirSalvarLivroActionPerformed(evt);
            }
        });

        jButtonSair.setMnemonic('s');
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel2.setText("ISBN");

        jComboBoxEditoras.setPreferredSize(new java.awt.Dimension(65, 24));

        jButtonIncluirNovoAutor.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonIncluirNovoAutor.setMnemonic('a');
        jButtonIncluirNovoAutor.setText("+");
        jButtonIncluirNovoAutor.setPreferredSize(new java.awt.Dimension(50, 26));
        jButtonIncluirNovoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirNovoAutorActionPerformed(evt);
            }
        });

        jButtonAddEditora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonAddEditora.setMnemonic('e');
        jButtonAddEditora.setText("+");
        jButtonAddEditora.setPreferredSize(new java.awt.Dimension(50, 26));
        jButtonAddEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEditoraActionPerformed(evt);
            }
        });

        jLabel3.setText("Autores");

        jLabel4.setText("Editora");

        jLabel5.setText("Classificação (CDD)");

        jLabel6.setText("Edição");

        jComboBoxEdicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Impressão / Reimp.");

        jComboBoxImpressao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Data Imp. / Reimp.");

        jLabel9.setText("Ano Edição");

        jComboBoxAnoEdicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAnoEdicao.setPreferredSize(new java.awt.Dimension(65, 24));

        jXDatePickerIDataImpressao.setDate(new java.util.Date(1591920740000L));

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabel10.setText("Descrição");

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("*");

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*");

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("*");

        jLabel14.setBackground(new java.awt.Color(255, 0, 0));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("(*) campos obrigatórios");

        jComboBoxAutores.setPreferredSize(new java.awt.Dimension(65, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jComboBoxAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonIncluirNovoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jComboBoxAnoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBoxEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6))))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jComboBoxEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(5, 5, 5)
                                                        .addComponent(jButtonAddEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel4))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel13))
                                                    .addComponent(jComboBoxCdds, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBoxImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jXDatePickerIDataImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11))
                                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jCheckBoxAtivo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12))))
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(0, 30, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonIncluirSalvarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAtivo)
                    .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIncluirNovoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCdds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxAnoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXDatePickerIDataImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirSalvarLivro)
                    .addComponent(jButtonSair))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirSalvarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarLivroActionPerformed
        
        String titulo       = jTextFieldTitulo.getText().trim();
        String isbn         = jTextFieldIsbn.getText().trim();
        AutorVO autorVO     = (AutorVO) jComboBoxAutores.getSelectedItem();
        EditoraVO editoraVO = (EditoraVO) jComboBoxEditoras.getSelectedItem();
        ClassificacaoDecimalDireitoVO cddVO = (ClassificacaoDecimalDireitoVO) jComboBoxCdds.getSelectedItem();
        Integer anoeEdicao  = (Integer) this.jComboBoxAnoEdicao.getSelectedItem();
        String edicao       = (String) this.jComboBoxEdicao.getSelectedItem();
        String impressao = (String) this.jComboBoxImpressao.getSelectedItem();
        String descricao = jTextAreaDescricao.getText();
        LocalDate dataImpressao = jXDatePickerIDataImpressao.getDate()
                                                            .toInstant()
                                                            .atZone(ZoneId.systemDefault())
                                                            .toLocalDate();
        
        if (titulo.equals("") || isbn.equals("")) {
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios (*)");
            jTextFieldTitulo.setFocusable(true);
            return;
        }
        
        try {
            Autor autor = autorVO.toAutor();
            Editora editora = editoraVO.toEditora();
            ClassificacaoDecimalDireito cdd = cddVO.toClassificacaoDecimalDireito();
            Usuario usuario = usuarioService.consultarLogado();
            
            if (!this.editandoLivro) {
                
                Livro livro = new Livro(titulo,isbn, autor, editora, cdd, anoeEdicao, 
                        edicao, impressao, dataImpressao, descricao, usuario, true);

                livroService.incluir(livro);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
//              Busca no banco de dados (arquivo txt) o registro.
                Livro livroBanco = livroService.consultar(this.livroEmEdicao);
               
                if (livroBanco == null) {
                    throw new RegistroNaoExistenteException();
                }
                
//              Insere os novos valores
                livroBanco.setTitulo(jTextFieldTitulo.getText());
                livroBanco.setAtivo(jCheckBoxAtivo.isSelected());
                
                livroService.alterar(livroBanco);
                
                finalizarAlteracoes(EnumOperacaoBanco.ALTERAR);
            } 
         
        } catch (RegistroExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTitulo);
            
             JOptionPane.showMessageDialog(this, "Cadastro já existente.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTitulo.requestFocus();
              }
            });                
             
        } catch (RegistroNaoExistenteException e) {
            UtilComponentes.limparCampos(jTextFieldTitulo);
            
             JOptionPane.showMessageDialog(this, "Cadastro NÃO existente para edição.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
             
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                jTextFieldTitulo.requestFocus();
              }
            });                
        } catch (Exception e) {
              JOptionPane.showMessageDialog(this, "Ocorreu um erro ao incluir/salvar o livro. Entre em contato com nosso suporte.",
                    "Cadastro / Edição de Livro", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_jButtonIncluirSalvarLivroActionPerformed

    protected void finalizarAlteracoes(EnumOperacaoBanco operacao) throws Exception {
        UtilComponentes.limparCampos(jTextFieldTitulo);
        
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
            JOptionPane.showMessageDialog(this, "Livro incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldTitulo.requestFocus();
                }
            });      
            
        } else if (EnumOperacaoBanco.ALTERAR.equals(operacao)){
            JOptionPane.showOptionDialog(null, "Livro alterado com sucesso!", "Cadastro de Livro!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            dashboardUI.setJLabelNomeTela("Livros");

            jDesktopPane.remove(this);

            try {
                abrirTelaLivros();            
            } catch (Exception ex) {
                Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
                jDesktopPane.add(new DashboardUI());
            }                  
        }
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        
        this.dispose();
        
        dashboardUI.setJLabelNomeTela("Livros");
        
        jDesktopPane.remove(this);
        
        try {
            abrirTelaLivros();            
            
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                jDesktopPane.add(new DashboardUI());
            } catch (Exception ex1) {
                Logger.getLogger(LivroCadastroUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }        
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButtonIncluirNovoAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirNovoAutorActionPerformed
        AutorCadastroDialog autorCadastroDialog = new AutorCadastroDialog(jComboBoxAutores);
        autorCadastroDialog.setVisible(true);
    }//GEN-LAST:event_jButtonIncluirNovoAutorActionPerformed

    private void jButtonAddEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEditoraActionPerformed
        EditoraCadastroDialog editoraCadastroDialog = new EditoraCadastroDialog(jComboBoxEditoras);
        editoraCadastroDialog.setVisible(true);
    }//GEN-LAST:event_jButtonAddEditoraActionPerformed

    protected void abrirTelaLivros() throws Exception {
        LivrosUI livrosUI = new LivrosUI();
        
//      Adiciona a pilha de do JDesktopPane o JInternalFrame LivrosPrincipalUI.
        jDesktopPane.add(livrosUI);
        
//      Remove barra de título e borda da janela
        try {
            UtilComponentes.removerBarraTituloEBorda(livrosUI);
        } catch (Exception ex) {
            Logger.getLogger(DashboardUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//      Mostra a tela LivrosPrincipal.
        livrosUI.show();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEditora;
    private javax.swing.JButton jButtonIncluirNovoAutor;
    private javax.swing.JButton jButtonIncluirSalvarLivro;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAtivo;
    private javax.swing.JComboBox<String> jComboBoxAnoEdicao;
    private javax.swing.JComboBox<String> jComboBoxAutores;
    private javax.swing.JComboBox<String> jComboBoxCdds;
    private javax.swing.JComboBox<String> jComboBoxEdicao;
    private javax.swing.JComboBox<String> jComboBoxEditoras;
    private javax.swing.JComboBox<String> jComboBoxImpressao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldIsbn;
    private javax.swing.JTextField jTextFieldTitulo;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerIDataImpressao;
    // End of variables declaration//GEN-END:variables

}
