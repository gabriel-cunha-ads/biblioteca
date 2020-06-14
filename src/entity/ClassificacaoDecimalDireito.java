package entity;

import entity.vo.ClassificacaoDecimalDireitoVO;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ClassificacaoDecimalDireito {

    private Integer idClassificacaoDecinal;
    private String codigoCDD;
    private String descricao;
    private boolean selecionado = false;

    public ClassificacaoDecimalDireito() {
    }
    
    public ClassificacaoDecimalDireito(Integer idClassificacaoDecinal) {
        this.idClassificacaoDecinal = idClassificacaoDecinal;
    }

    public ClassificacaoDecimalDireito(Integer idClassificacaoDecinal, String codigoCDD) {
        this.idClassificacaoDecinal = idClassificacaoDecinal;
        this.codigoCDD = codigoCDD;
    }

    public ClassificacaoDecimalDireito(Integer idClassificacaoDecinal, String codigoCDD, String descricao) {
        this.idClassificacaoDecinal = idClassificacaoDecinal;
        this.codigoCDD = codigoCDD;
        this.descricao = descricao;
    }
    
    public ClassificacaoDecimalDireito(ClassificacaoDecimalDireito cdd) {
        this.idClassificacaoDecinal = cdd.getIdClassificacaoDecimal();
        this.codigoCDD = cdd.getCodigoCDD();
        this.descricao = cdd.getDescricao();
    }    

    public ClassificacaoDecimalDireito(String dados) throws Exception {
        String vetorString[] = dados.split(";");
        
        if (vetorString.length < 3) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente. " + dados);
            throw new Exception();
        }
        try {
            Integer id = Integer.parseInt(vetorString[0]);
            
//          Se id do vetor for null, atribui 1.
            this.idClassificacaoDecinal = vetorString[0].equals("null") ? 1 : id;  
            this.codigoCDD              = vetorString[1];
            this.descricao              = vetorString[2];
            
        } catch(NumberFormatException e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do autor com nome " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do autor." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }
    }     
    

    public Integer getIdClassificacaoDecimal() {
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

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
    public ClassificacaoDecimalDireito from (ClassificacaoDecimalDireito cdd) throws Exception {
        this.idClassificacaoDecinal = cdd.getIdClassificacaoDecimal();
        this.codigoCDD      = cdd.getCodigoCDD();
        this.descricao      = cdd.getCodigoCDD();
        return this;
    }     
    
    public ClassificacaoDecimalDireitoVO toClassificacaoDecimalDireitoVO() {
        ClassificacaoDecimalDireitoVO cddVO = new ClassificacaoDecimalDireitoVO();
        cddVO.setIdClassificacaoDecinal(this.getIdClassificacaoDecimal());
        cddVO.setCodigoCDD(this.getCodigoCDD());
        cddVO.setDescricao(this.getDescricao());
        return cddVO;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(idClassificacaoDecinal).append(";");
        sb.append(codigoCDD).append(";");
        sb.append(descricao).append(";");
        return sb.toString();
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idClassificacaoDecinal);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClassificacaoDecimalDireito other = (ClassificacaoDecimalDireito) obj;
        if (!Objects.equals(this.idClassificacaoDecinal, other.idClassificacaoDecinal)) {
            return false;
        }
        return true;
    }
}
