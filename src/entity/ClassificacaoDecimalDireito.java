package entity;

import entity.vo.ClassificacaoDecimalDireitoVO;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class ClassificacaoDecimalDireito {
    
    private Integer idClassificacaoDecimal;
    private String codigoCDD;
    private String descricao;
    private boolean ativo;
    private boolean selecionado = false;
    

    public ClassificacaoDecimalDireito() {
    }
    
    public ClassificacaoDecimalDireito(Integer idClassificacaoDecimal) {
        this.idClassificacaoDecimal = idClassificacaoDecimal;
    }    

    public ClassificacaoDecimalDireito(String descricao, String codigoCDD) {
        this.codigoCDD = codigoCDD;
        this.descricao = descricao;
    }
    
    public ClassificacaoDecimalDireito(String descricao, String codigoCDD, boolean ativo) {
        this.codigoCDD = codigoCDD;
        this.descricao = descricao;
        this.ativo     = ativo;
    }    
    public ClassificacaoDecimalDireito(Integer idClassificacaoDecimal, String descricao, String codigoCDD) {
        this.idClassificacaoDecimal = idClassificacaoDecimal;
        this.codigoCDD = codigoCDD;
        this.descricao = descricao;
    }
    public ClassificacaoDecimalDireito(Integer idClassificacaoDecimal, String descricao,String codigoCDD, boolean ativo) {
        this.idClassificacaoDecimal = idClassificacaoDecimal;
        this.codigoCDD = codigoCDD;
        this.descricao = descricao;
        this.ativo = ativo;
    }
    
    public ClassificacaoDecimalDireito(ClassificacaoDecimalDireito cdd) {
        this.idClassificacaoDecimal = cdd.getIdClassificacaoDecimal();
        this.codigoCDD = cdd.getCodigoCDD();
        this.descricao = cdd.getDescricao();
        this.ativo = cdd.isAtivo();
    }
    
    public ClassificacaoDecimalDireito(String dados) throws Exception {

        String vetorString[] = dados.split(";");

        if (vetorString.length < 4) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
            throw new Exception();
        }
        
        try {
            Integer id = Integer.parseInt(vetorString[0]);

//          Se idClassificacaoDecimal do vetor for null, atribui 1.
            this.idClassificacaoDecimal          = vetorString[0].equals("null") ? 1 : id;  
            this.codigoCDD      = vetorString[1];
            this.descricao      = vetorString[2];
            this.ativo       = Boolean.parseBoolean(vetorString[3]);
            
        } catch(NumberFormatException e) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, 
                    "Erro ao fazer o parse do campo id do vetor de dados do cdd com descricao." + vetorString[0]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do cdd." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }            
    }  

    public ClassificacaoDecimalDireito(String dados, boolean importando) throws Exception {
        
        String vetorString[] = dados.split(";");

        if (vetorString.length < 2) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Quantidade de colunas do Vetor de dados divergente." + dados);
            throw new Exception();
        }
        try {
            this.codigoCDD      = vetorString[0];
            this.descricao      = vetorString[1];
        } catch(NumberFormatException e) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Erro ao fazer o parse do campo id do vetor de dados do cdd com descricao " + vetorString[1]);
            throw new Exception();
        } catch(Exception e) {
            Logger.getLogger(ClassificacaoDecimalDireito.class.getName()).log(Level.SEVERE, "Erro ao extrair dados do vetor de dados do cdd." + vetorString[1] + "Erro: " + e);
            throw new Exception();
        }              
    }      
    
    
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

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }
    
    public ClassificacaoDecimalDireito from (ClassificacaoDecimalDireito cdd) throws Exception {
        this.idClassificacaoDecimal = cdd.getIdClassificacaoDecimal();
        this.codigoCDD = cdd.getCodigoCDD();
        this.descricao = cdd.getDescricao();
        this.ativo = cdd.isAtivo();
        return this;
    }     
    
     public ClassificacaoDecimalDireitoVO toClassificacaoDecimalDireitoVO () throws Exception {
        ClassificacaoDecimalDireitoVO cddVO = new ClassificacaoDecimalDireitoVO();
        cddVO.setIdClassificacaoDecimal(this.getIdClassificacaoDecimal());
        cddVO.setCodigoCDD(this.getCodigoCDD());
        cddVO.setDescricao(this.getDescricao());
        return cddVO;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(idClassificacaoDecimal).append(";");
        sb.append(codigoCDD).append(";");
        sb.append(descricao).append(";");
        sb.append(ativo).append(";");
        return sb.toString();
    }    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idClassificacaoDecimal);
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
        if (!Objects.equals(this.idClassificacaoDecimal, other.idClassificacaoDecimal)) {
            return false;
        }
        return true;
    }
}
