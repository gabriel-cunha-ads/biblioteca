package entity;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public enum EnumOperacaoBanco {
    
    INCLUIR("Incluir"), 
    EDITAR("Alterar"), 
    LISTAR("Listar"), 
    EXCLUIR("Excluir"), 
    CONSULTAR("Consultar");

    private String descricao; 
    
    EnumOperacaoBanco(String descricao) {
        this.descricao = descricao;
    }
}
