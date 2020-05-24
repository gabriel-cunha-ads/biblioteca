package ui.components;
import entity.Livro;
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
            "Autor", 
            "Editora",
            "Edição", 
            "Ano", 
            "ISBN", 
            "Exemp. Dispon.",
            "Selecione"};
        };

//    Recupera o valor de uma célula. 
    @Override
    public Object getValueAt(int indexLinha, int indexColuna) {
        Livro livro = linhas.get(indexLinha);
        switch(indexColuna) {
            case 0: 
                return livro.getIdLivro();
            case 1: 
                return livro.getTitulo();
            case 2: 
                return livro.getAutor();
            case 3: 
                return livro.getEditora();
            case 4: 
                return livro.getEdicao();
            case 5: 
                return livro.getAno();
            case 6: 
                return livro.getISBN();
            case 7: 
                return livro.getQtdExemplaresDisponiveis();   
            case 8:
                return livro.isSelecionado();
            default:
                return null;
        }
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
        Livro livro = linhas.get(linha);
        
        if (livro.isSelecionado()) {
            livro.setSelecionado(false);
        } else {
            livro.setSelecionado(true);
        }

        for (Livro livroDaLista : linhas) {
            
            if (!livroDaLista.equals(livro) && livroDaLista.isSelecionado()) {
                livroDaLista.setSelecionado(false);
            } 
            
            fireTableCellUpdated(linhas.indexOf(livroDaLista), coluna);
        }
        fireTableCellUpdated(linha, coluna);
    }   
}