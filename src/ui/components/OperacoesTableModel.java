package ui.components;
import entity.Autor;
import entity.Exemplar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class OperacoesTableModel extends ViewAbstractTableModel<Exemplar> {

    public OperacoesTableModel(List<Exemplar> linhas) {
        super(linhas);
        // Nomes das colunas do cabeçalho da tabela.
        colunas = new String[] {
            "id", 
            "Título", 
            "ISBN", 
            "Situação",
            "ativo",
            "X"
        };
    };

//    Recupera o valor de uma célula. 
    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        Exemplar exemplar = linhas.get(indexLinha);
        switch(indexColuna) {
            case 0: 
                return exemplar.getId();
            case 1: 
                return exemplar.getLivro().getTitulo();
            case 2: 
                return exemplar.getLivro().getIsbn();
            case 3: 
                return exemplar.getSituacao().name();
            case 4: 
                return exemplar.isAtivo();                
            case 5:
                return exemplar.isSelecionado();
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
            Exemplar exemplarSelecionado = linhas.get(linha); 
            exemplarSelecionado.setSelecionado((boolean) objeto);
            
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