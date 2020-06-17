package ui.components;
import entity.Autor;
import entity.Livro;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroTableModel extends ViewAbstractTableModel<Livro> {

    public LivroTableModel(List<Livro> linhas) {
        super(linhas);
        // Nomes das colunas do cabeçalho da tabela.
        colunas = new String[] {
            "id", 
            "Título", 
            "ISBN", 
            "Data Cadastro",
            "ativo",
            "X"
        };
    };

//    Recupera o valor de uma célula. 
    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        Livro livro = linhas.get(indexLinha);
        switch(indexColuna) {
            case 0: 
                return livro.getId();
            case 1: 
                return livro.getTitulo();
            case 2: 
                return livro.getIsbn();
            case 3: 
                return livro.getDataCadastro().format(formatoData);
            case 4: 
                return livro.isAtivo();                
            case 5:
                return livro.isSelecionado();
            default:
                return null;
        }
    }
    
    /**
    * JTable usa esse método para determinar o renderizador padrão editor para 
    * cada célula. Se não implementássemos esse método, a última coluna 
    * conteria texto ("true" / "false"), * em vez de uma caixa de seleção.
    * @param c
    * @return 
    */
    @Override
    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
    }  
  
    /**
     * Defini o valor de uma célula na posição informada.
     * Esta implementação foi sobrescrita para permitir alterar o valor de 
     * uma célula somente se o tipo de dado for Boolean.
     * @param linha int - índice da linha da tabela.
     * @param coluna int - índice da coluna da tabela.
     * @param objeto Object - valor a ser inserido na linha da tabela.
    */    
    @Override
    public void setValueAt(Object objeto, int linha, int coluna) {
        
//          Pega o autor selecionado e altera o valor do selecionado   
            Livro livroSelecionado = linhas.get(linha); 
            livroSelecionado.setSelecionado((boolean) objeto);
            
//          Atualiza a tabela
            fireTableCellUpdated(linha, coluna);
    }   
    
      /**
     * Defini se a celula pode ser editavel.
     * Essa implementação foi sobrescrita para  permitir ser editável somente 
     * objetos que sejam do tipo Boolean.
     * @param linha - linha da tabela
     * @param coluna - coluna da tabela
     * @return booelan - informando se é permitido a edição da celula.
     */
    @Override
    public boolean isCellEditable(int linha, int coluna) {
        Object objeto = getValueAt(linha, coluna);
        return objeto instanceof Boolean;
    }       
}