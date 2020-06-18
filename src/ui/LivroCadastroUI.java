package ui;

import entity.Autor;
import entity.ClassificacaoDecimalDireito;
import entity.Editora;
import entity.Livro;
import entity.EnumOperacaoBanco;
import entity.Funcionario;
import entity.vo.AutorVO;
import entity.vo.ClassificacaoDecimalDireitoVO;
import entity.vo.EditoraVO;
import exception.RegistroExistenteException;
import exception.RegistroNaoExistenteException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import javax.swing.table.TableColumnModel;
import service.AutorService;
import service.ClassificacaoDecimalDireitoService;
import service.EditoraService;
import service.LivroService;
import ui.components.AutoresLivroCadastroTableModel;
import ui.components.ViewAbstractTableModel;
import ui.dialog.AutorCadastroDialog;
import ui.dialog.EditoraCadastroDialog;
import util.UtilComponentes;
import util.UtilTabela;

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
    
    private LivroService livroService;
    
    private AutorService autorService;
    
    private EditoraService editoraService;
    
    private List<Autor> autoresTabelaLivro;
    
    
    public LivroCadastroUI() {
        
        initComponents();
        
        inicializarComponentes();
        
        inicializarTabelaAutoresLivro(new ArrayList());
    }
   
    public LivroCadastroUI(Livro livroEmEdicao) throws Exception {
        this();
        
//      Defini o nome do títilo da tela.
        dashboardUI.setJLabelNomeTela("Editar Livro");     

//      Alterar o texto do botão incluir para salvar.
        jButtonIncluirSalvarLivro.setText("Salvar");
        
//      Habilita a edição da checkBox ativo
        jCheckBoxAtivo.setEnabled(true);
        
        this.livroEmEdicao = livroEmEdicao;

        editandoLivro = true;
        
        preencherCamposDaTelaComLivroEditando(livroEmEdicao);
    }    

    private void inicializarComponentes() {
        
        try {
            autorService = new AutorService();
            
            editoraService = new EditoraService();
            
            ClassificacaoDecimalDireitoService cddService = new ClassificacaoDecimalDireitoService();     
            
            List<Autor> autoresTabelaLivro =  new ArrayList();        

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
            Vector<AutorVO> autoresVO = autorService.carregarTodosAutoresVetorComboBox();
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
            
        } catch (Exception e) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, "LivrosUI - ", e);            
        }
        
    }
    
    private void inicializarTabelaAutoresLivro(List<Autor> autores) {
        try {
            if (autores != null || !autores.isEmpty()) {
                this.autoresTabelaLivro = autores;
            }
            
    //      Instancia um novo LivroTableModel passando a lista de objetos.
            ViewAbstractTableModel AutorLivroCadastroTabelModel = new AutoresLivroCadastroTableModel(this.autoresTabelaLivro);

            UtilTabela.inicializarTabela(jTableAutoresLivro, AutorLivroCadastroTabelModel);
            
//          Define o tamanho das colunas da tabela.
            TableColumnModel tcm = jTableAutoresLivro.getColumnModel();
            tcm.getColumn(0).setPreferredWidth(20);
            tcm.getColumn(1).setPreferredWidth(200);
            tcm.getColumn(2).setPreferredWidth(30);
            tcm.getColumn(3).setPreferredWidth(20);

            addMouseListenerTabela();
            
        } catch (Exception ex) {
            Logger.getLogger(LivrosUI.class.getName()).log(Level.SEVERE, "LivrosUI - ", ex);
        }
    }     
    
    public void addMouseListenerTabela() {
        
        jTableAutoresLivro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {

                    int qtdLinhasSelcionadas = 0;            

        //          Percorre a lista de livros e incrementa(++) na quantidade de 
        //          linhas selecionadas
                    for (Autor a : autoresTabelaLivro) {
                        if (a.isSelecionado()) {
                          qtdLinhasSelcionadas++;
                        }
                    }

        //          Regras para habilitar / desabilitar botões 
                    if (qtdLinhasSelcionadas > 0){
                        jButtonExcluirAutorTabela.setEnabled(true);
                    } else if (qtdLinhasSelcionadas <= 0) {
                        jButtonExcluirAutorTabela.setEnabled(false);                
                    }
                } 
//                inicializarTabelaAutoresLivro(autoresTabelaLivro);
            }
        });        
    }    
    
    public void preencherCamposDaTelaComLivroEditando(Livro livroEmEdicao) {
        try {
            jTextFieldTitulo.setText(livroEmEdicao.getTitulo());
            jTextFieldIsbn.setText(livroEmEdicao.getIsbn());
            jComboBoxCdds.setSelectedItem(livroEmEdicao.getCdd().toClassificacaoDecimalDireitoVO());
 
//          Consulta os autores pelo id e preenche a lista de autores da tabela.
            autorService = new AutorService();
            for (Autor a : livroEmEdicao.getAutores()) {
                 autoresTabelaLivro.add(autorService.consultar(a));
            }
            
            inicializarTabelaAutoresLivro(autoresTabelaLivro);      
            
            jComboBoxEdicao.setSelectedItem(livroEmEdicao.getEdicao());
            jComboBoxAnoEdicao.setSelectedItem(livroEmEdicao.getAnoEdicao());
            jComboBoxImpressao.setSelectedItem(livroEmEdicao.getImpressaoReimpressao());
            jTextAreaDescricao.setText(livroEmEdicao.getDescricao());
            jXDatePickerIDataImpressao.setDate(Date.from(livroEmEdicao.getDataImpressaoReimpressao().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            jCheckBoxAtivo.setSelected(livroEmEdicao.isAtivo());
            
        } catch (Exception e) {
            Logger.getLogger(LivroCadastroUI.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao preencher os dados para edição do livro. Entre em contato com nosso suporte.",
                    "Edição de Livros", JOptionPane.DEFAULT_OPTION);            
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jCheckBoxAtivo = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabelCDD = new javax.swing.JLabel();
        jTextFieldIsbn = new javax.swing.JTextField();
        jComboBoxCdds = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonIncluirSalvarLivro = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jComboBoxEditoras = new javax.swing.JComboBox<>();
        jButtonIncluirNovaEditora = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxEdicao = new javax.swing.JComboBox<>();
        jComboBoxAnoEdicao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxImpressao = new javax.swing.JComboBox<>();
        jXDatePickerIDataImpressao = new org.jdesktop.swingx.JXDatePicker();
        jXPanel2 = new org.jdesktop.swingx.JXPanel();
        jComboBoxAutores = new javax.swing.JComboBox<>();
        jButtonIncluirNovoAutor = new javax.swing.JButton();
        jButtonAdicionarAutorTabela = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAutoresLivro = new javax.swing.JTable();
        jButtonExcluirAutorTabela = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(850, 650));

        jLabel1.setLabelFor(jTextFieldTitulo);
        jLabel1.setText("Título");

        jCheckBoxAtivo.setSelected(true);
        jCheckBoxAtivo.setText("Ativo");
        jCheckBoxAtivo.setEnabled(false);

        jLabel2.setText("ISBN");

        jLabelCDD.setText("Classificação (CDD)");

        jComboBoxCdds.setMinimumSize(new java.awt.Dimension(33, 30));

        jSeparator1.setPreferredSize(new java.awt.Dimension(800, 1));

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

        jLabel14.setBackground(new java.awt.Color(255, 0, 0));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("(*) campos obrigatórios");

        jXPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Editora"));

        jComboBoxEditoras.setPreferredSize(new java.awt.Dimension(65, 24));

        jButtonIncluirNovaEditora.setMnemonic('o');
        jButtonIncluirNovaEditora.setText("novo");
        jButtonIncluirNovaEditora.setPreferredSize(new java.awt.Dimension(65, 28));
        jButtonIncluirNovaEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirNovaEditoraActionPerformed(evt);
            }
        });

        jLabel6.setText("Edição");

        jLabel9.setText("Ano Edição");

        jComboBoxEdicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxAnoEdicao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxAnoEdicao.setPreferredSize(new java.awt.Dimension(65, 24));

        jLabel7.setText("Impressão / Reimp.");

        jLabel8.setText("Data Imp. / Reimp.");

        jComboBoxImpressao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jXDatePickerIDataImpressao.setDate(new java.util.Date(1591920740000L));

        javax.swing.GroupLayout jXPanel1Layout = new javax.swing.GroupLayout(jXPanel1);
        jXPanel1.setLayout(jXPanel1Layout);
        jXPanel1Layout.setHorizontalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jComboBoxImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jXDatePickerIDataImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jXPanel1Layout.createSequentialGroup()
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jXPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42))
                                    .addGroup(jXPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(104, 104, 104)))
                                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jComboBoxAnoEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBoxEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonIncluirNovaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jXPanel1Layout.setVerticalGroup(
            jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonIncluirNovaEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEditoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAnoEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jXPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jXPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePickerIDataImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jXPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Autor"));

        jComboBoxAutores.setPreferredSize(new java.awt.Dimension(65, 24));

        jButtonIncluirNovoAutor.setMnemonic('n');
        jButtonIncluirNovoAutor.setText("novo");
        jButtonIncluirNovoAutor.setPreferredSize(new java.awt.Dimension(65, 28));
        jButtonIncluirNovoAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirNovoAutorActionPerformed(evt);
            }
        });

        jButtonAdicionarAutorTabela.setMnemonic('a');
        jButtonAdicionarAutorTabela.setText("add");
        jButtonAdicionarAutorTabela.setPreferredSize(new java.awt.Dimension(65, 28));
        jButtonAdicionarAutorTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarAutorTabelaActionPerformed(evt);
            }
        });

        jTableAutoresLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableAutoresLivro);

        jButtonExcluirAutorTabela.setText("excluir");
        jButtonExcluirAutorTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirAutorTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jXPanel2Layout = new javax.swing.GroupLayout(jXPanel2);
        jXPanel2.setLayout(jXPanel2Layout);
        jXPanel2Layout.setHorizontalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarAutorTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonIncluirNovoAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonExcluirAutorTabela)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        jXPanel2Layout.setVerticalGroup(
            jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jXPanel2Layout.createSequentialGroup()
                .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jXPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jButtonAdicionarAutorTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxAutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonIncluirNovoAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jXPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButtonExcluirAutorTabela)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonIncluirSalvarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))
                            .addComponent(jLabel10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel12)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelCDD)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jComboBoxCdds, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jCheckBoxAtivo))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jXPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(40, 40, 40)
                                    .addComponent(jXPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(jLabelCDD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxCdds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxAtivo))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jXPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIncluirSalvarLivro)
                    .addComponent(jButtonSair))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonIncluirSalvarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirSalvarLivroActionPerformed
        
        try {
            livroService = new LivroService();
            String titulo       = jTextFieldTitulo.getText().trim();
            String isbn         = jTextFieldIsbn.getText().trim();
            EditoraVO editoraVO = (EditoraVO) jComboBoxEditoras.getSelectedItem();
            Editora editora = editoraVO.toEditora();
            ClassificacaoDecimalDireitoVO cddVO = (ClassificacaoDecimalDireitoVO) jComboBoxCdds.getSelectedItem();
            Integer anoeEdicao  = (Integer) this.jComboBoxAnoEdicao.getSelectedItem();
            String edicao       = (String) this.jComboBoxEdicao.getSelectedItem();
            String impressao    = (String) this.jComboBoxImpressao.getSelectedItem();
            String descricao    = jTextAreaDescricao.getText();
            boolean ativo       = jCheckBoxAtivo.isSelected();
            LocalDate dataImpressao = jXDatePickerIDataImpressao.getDate()
                                                                .toInstant()
                                                                .atZone(ZoneId.systemDefault())
                                                                .toLocalDate();
            ClassificacaoDecimalDireito cdd = cddVO.toClassificacaoDecimalDireito();

//          Funcionario funcionario = funcionarioService.consultarLogado();
            
            if (this.autoresTabelaLivro.isEmpty()) {
                AutorVO autorVO = (AutorVO) jComboBoxAutores.getSelectedItem();
                this.autoresTabelaLivro.add(autorVO.toAutor());
            }

            if (titulo.equals("") || isbn.equals("")) {
                JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios (*)");
                jTextFieldTitulo.setFocusable(true);
                return;
            }

            Livro livro = new Livro(titulo,isbn, this.autoresTabelaLivro, editora, cdd, anoeEdicao, 
                edicao, impressao, dataImpressao, descricao, new Funcionario(1, "Mandrake", "175.394.660-30" ), ativo);                    
            
            if (!this.editandoLivro) {
                
                livroService.incluir(livro);
                
                finalizarAlteracoes(EnumOperacaoBanco.INCLUIR);     
                
            } else {
                livro.setId(livroEmEdicao.getId());
                
                livroService.alterar(livro);
                
                finalizarAlteracoes(EnumOperacaoBanco.EDITAR);
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
        
        if (EnumOperacaoBanco.INCLUIR.equals(operacao)){
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
            
            JOptionPane.showMessageDialog(this, "Livro incluído com sucesso!");

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    jTextFieldTitulo.requestFocus();
                }
            });      
            
        } else if (EnumOperacaoBanco.EDITAR.equals(operacao)){
            JOptionPane.showOptionDialog(null, "Livro alterado com sucesso!", "Cadastro de Livro!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
               
            this.dispose();

            jDesktopPane.remove(this);

            dashboardUI.setJLabelNomeTela("Livros");

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

    private void jButtonIncluirNovaEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirNovaEditoraActionPerformed
        EditoraCadastroDialog editoraCadastroDialog = new EditoraCadastroDialog(jComboBoxEditoras);
        editoraCadastroDialog.setVisible(true);
    }//GEN-LAST:event_jButtonIncluirNovaEditoraActionPerformed

    private void jButtonAdicionarAutorTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarAutorTabelaActionPerformed
        try {
            AutorVO autorVO = (AutorVO) jComboBoxAutores.getSelectedItem();
            
            Autor autor = autorVO.toAutor();
            
            for (Autor a : this.autoresTabelaLivro) {
                if (autor.getIdAutor().equals(a.getIdAutor())) {
                    
                    JOptionPane.showMessageDialog(this, "Já existe na tabela.",
                    "Tabela Autores", JOptionPane.DEFAULT_OPTION);
                    
                    inicializarTabelaAutoresLivro(autoresTabelaLivro);
                    
                    jButtonExcluirAutorTabela.setEnabled(false);
                    
                    return;
                }
            }
            
            this.autoresTabelaLivro.add(autor);
            
            inicializarTabelaAutoresLivro(autoresTabelaLivro);
            
            jButtonExcluirAutorTabela.setEnabled(false);            
            
        } catch (Exception ex) {
            Logger.getLogger(LivroCadastroUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAdicionarAutorTabelaActionPerformed

    
    
    private void jButtonExcluirAutorTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirAutorTabelaActionPerformed
        List<Autor> selecionados = getSelecionados();
        
//      Remove os itens selecionados da lista que popula a tabela
        this.autoresTabelaLivro.removeIf(a -> selecionados.contains(a));
        
        inicializarTabelaAutoresLivro(this.autoresTabelaLivro);
        
        jButtonExcluirAutorTabela.setEnabled(false);
    }//GEN-LAST:event_jButtonExcluirAutorTabelaActionPerformed

    private List<Autor> getSelecionados() {
        List<Autor> autoresSelecionado = new ArrayList();
        
        for (Autor a : this.autoresTabelaLivro) {
            if (a.isSelecionado() ) {
                autoresSelecionado.add(a);
            }
        }
        return autoresSelecionado;
    }    
    
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
    private javax.swing.JButton jButtonAdicionarAutorTabela;
    private javax.swing.JButton jButtonExcluirAutorTabela;
    private javax.swing.JButton jButtonIncluirNovaEditora;
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCDD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableAutoresLivro;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldIsbn;
    private javax.swing.JTextField jTextFieldTitulo;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerIDataImpressao;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXPanel jXPanel2;
    // End of variables declaration//GEN-END:variables

}
