/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.Cargo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import repository.interfaces.Persistencia;
import util.UtilArquivo;
import util.UtilSistema;

/**
 *
 * @author CroK
 */
public class CargoPersistenciaImpl implements Persistencia<Cargo> {
        private final String arquivoBancoDados;
    
        private final String PATH_BANCO_DADOS;
    
    
    public CargoPersistenciaImpl(String nomeArquivoBancoDados) throws Exception {
        
        PATH_BANCO_DADOS = UtilSistema.getDiretorioBancoDados();
        
        UtilSistema.criarArquivoBancoDados(nomeArquivoBancoDados);
        
        arquivoBancoDados = PATH_BANCO_DADOS + File.separator + nomeArquivoBancoDados;
    }
    
    @Override
    public void incluir(Object Cargo) throws Exception {
        
        List<Cargo> cargosBanco = listar();
  
        UtilArquivo.removerLinhaSemRegistro(arquivoBancoDados, cargosBanco);
        
        FileWriter fw = new FileWriter(arquivoBancoDados, true);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        bw.write(Cargo.toString());

//      Fecha o arquivo
        bw.close();
    }

    @Override
    public List<Cargo> listar() throws Exception {
        List<Cargo> cargos = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Cargo cargo = new Cargo(linha);
            cargos.add(cargo);
        }
        
        br.close();
        
        return cargos;
    }

    @Override
    public Object consultar(Object cargo) throws Exception {
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        List<Cargo> cargosBanco = new ArrayList<>();
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Cargo a = new Cargo(linha);
            cargosBanco.add(a);
        }
        
        Cargo cargoResultado = null;
        
        for (Cargo a : cargosBanco) {
            if (a.equals(cargo)) {
                cargoResultado = a;
            }
        }
        return cargoResultado;
    }

    @Override
    public void alterar(Object objeto) throws Exception {
        Cargo cargoParaAlterar = (Cargo) objeto;
        
        Cargo cargoBanco = (Cargo) this.consultar(cargoParaAlterar);
        
        this.excluir(cargoBanco);

        Cargo cargoAtualizada = cargoBanco.from(cargoParaAlterar);
        
        this.incluir(cargoAtualizada);
    }

    @Override
    public void excluir(Object objeto) throws Exception {
        
        Cargo cargoParaExcluir = (Cargo) objeto;
        
        List<Cargo> cargos = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Cargo cargoBanco = new Cargo(linha);
            
            if (!cargoBanco.equals(cargoParaExcluir)) {
                cargos.add(cargoBanco);
            }
        }   
        
        FileWriter fw = new FileWriter(arquivoBancoDados, false);
        
        BufferedWriter bw = new BufferedWriter(fw);
        
//      Escreve no arquivo  
        for (Cargo a : cargos) {
            bw.write(a + "\n");
        }
//      Fecha o arquivo
        bw.close();        
    }
    
    @Override
    public Integer consultarUltimoID() throws Exception {
        
        List<Cargo> cargos = new ArrayList<>();
        
        FileReader fr = new FileReader(arquivoBancoDados);
        
        BufferedReader br = new BufferedReader(fr);
        
        String linha = "";
        
        while((linha = br.readLine()) != null && !linha.trim().equals("")) {
            Cargo cargoBanco = new Cargo(linha);
            cargos.add(cargoBanco);
        }
        
        Integer ultimoId = null;
        
        if (!cargos.isEmpty()) {
            Cargo cargo = cargos.get(cargos.size() -1);
            ultimoId = cargo.getIdCargo();
        }
        return ultimoId;        
        
    }    
}