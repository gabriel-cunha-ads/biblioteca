package entity.vo;

import entity.ClassificacaoDecimalDireito;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ClassificacaoDecimalDireitoVO {

    private Integer idClassificacaoDecinal;
    private String codigoCDD;
    private String descricao;

    public Integer getIdClassificacaoDecinal() {
        return idClassificacaoDecinal;
    }

    public void setIdClassificacaoDecinal(Integer idClassificacaoDecinal) {
        this.idClassificacaoDecinal = idClassificacaoDecinal;
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
    
     public ClassificacaoDecimalDireito toClassificacaoDecimalDireito () throws Exception {
        ClassificacaoDecimalDireito cdd = new ClassificacaoDecimalDireito();
        cdd.setIdClassificacaoDecinal(this.getIdClassificacaoDecinal());
        cdd.setCodigoCDD(this.getCodigoCDD());
        cdd.setDescricao(this.getDescricao());
        return cdd;
    }      

    @Override
    public String toString() {
        return this.descricao;
    }
}
