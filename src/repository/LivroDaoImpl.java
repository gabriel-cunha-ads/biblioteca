package repository;

import entity.Livro;
import java.util.List;
import repository.interfaces.Persistencia;

/**
 *
 * @author Gabriel Cunha <gabrielcunhadev@gmail.com>
 */
public class LivroDaoImpl implements Persistencia<Livro>{
    
    private String nomeArquivoDados;
    
    public LivroDaoImpl (String nomeArquivoDados) {
        this.nomeArquivoDados = nomeArquivoDados;
    }

    @Override
    public List<Livro> listar() throws Exception {
//        List<Object> livros  = new ArrayList<>();
//        FileReader fr       = new FileReader(nomeArquivoDados);
//        BufferedReader br   = new BufferedReader(fr);
//        String linha        = "";
//
//        while((linha = br.readLine()) != null) {
//            Livro livro = new Livro(linha);
//            livros.add(livro);
//        }
//        br.close();
//        return livros;
        return null;
    }

    @Override
    public void incluir(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultar(Object objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer consultarUltimoID() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
