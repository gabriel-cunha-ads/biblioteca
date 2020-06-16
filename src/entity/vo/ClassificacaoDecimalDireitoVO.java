package entity.vo;

import entity.ClassificacaoDecimalDireito;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ClassificacaoDecimalDireitoVO {

    private Integer idClassificacaoDecimal;
    private String codigoCDD;
    private String descricao;
    private boolean ativo;

    public Integer getIdClassificacaoDecimal() {
        return idClassificacaoDecimal;
    }

    public void setIdClassificacaoDecimal(Integer idClassificacaoDecimal) {
        this.idClassificacaoDecimal = idClassificacaoDecimal;
    }

    public String getCodigoCDD() {
        return codigoCDD;
    }

    public void setCodigoCDD(String codigoCDD) {
        this.codigoCDD = codigoCDD;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
     public ClassificacaoDecimalDireito toClassificacaoDecimalDireito () throws Exception {
        ClassificacaoDecimalDireito cdd = new ClassificacaoDecimalDireito();
        cdd.setIdClassificacaoDecimal(this.getIdClassificacaoDecimal());
        cdd.setCodigoCDD(this.getCodigoCDD());
        cdd.setDescricao(this.getDescricao());
        cdd.setAtivo(this.isAtivo());
        return cdd;
    }      

    @Override
    public String toString() {
        return this.descricao;
    }
}
