/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.projeto.dao;

import br.com.exemplo.projeto.model.TipoCampanha;
import br.com.exemplo.projeto.utils.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author reginaldo
 */
public class TipoCampanhaDAO implements GenericDAO {
    
    private Connection conexao;
    
    public TipoCampanhaDAO(){
        try{
            this.conexao = ConnectionFactory.getConnection();
            System.out.println("Conectado com Sucesso");
        } catch (Exception ex) {
            System.out.println("Problemas ao carregar no BD! erro:"
                +ex.getMessage());
        }        
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        TipoCampanha oTipoCampanha = (TipoCampanha) objeto;
        Boolean retorno = false;
        if (oTipoCampanha.getIdTipoCampanha() == 0){
            retorno = this.inserir(oTipoCampanha);
        }else{
            retorno = this.alterar(oTipoCampanha);
        }
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        TipoCampanha oTipoCampanha = (TipoCampanha) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into tipocampanha (nometipocampanha, descricaotipocampanha) values (?,?)";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oTipoCampanha.getNomeTipoCampanha());
            stmt.setString(2, oTipoCampanha.getDescricaoTipoCampanha());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar a Tipo Campanha! Erro: "
                    + ex.getMessage());
            return false;
        }
        finally{
            try{
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conexão! "
                        +"Erro: "+ex.getMessage());
            }
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        TipoCampanha oTipoCampanha = (TipoCampanha) objeto;
        PreparedStatement stmt = null;
        String sql = "update tipocampanha set nometipocampanha = ?, descricaotipocampanha = ? where idtipocampanha = ?";
    
    
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1,oTipoCampanha.getNomeTipoCampanha());
            stmt.setString(2, oTipoCampanha.getDescricaoTipoCampanha());
            stmt.setInt(3, oTipoCampanha.getIdTipoCampanha());
            stmt.execute();
            return true;
        } catch (Exception ex){
            System.out.println("Problemas ao alterar Tipo Campanha! Erro:"+ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally{
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                Logger.getLogger(TipoCampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idTipoCampanha = numero;
        PreparedStatement stmt = null;
        
        String sql = "delete from tipocampanha where idtipocampanha = ?";
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1,idTipoCampanha);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir Tipo Campanha! Erro: "
                    +ex.getMessage());
            return false;
        }
        finally{
            try{
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex){
                System.out.println("Problemas ao fechar parametros de conexão! "
                        +"Erro: "+ex.getMessage());
            }
        }
    }

    @Override
    public Object carregar(int numero) {
        int idTipoCampanha = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoCampanha oTipoCampanha = null;
        String sql = "select * from tipocampanha where idtipocampanha = ?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idTipoCampanha);
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                oTipoCampanha = new TipoCampanha();
                oTipoCampanha.setIdTipoCampanha(rs.getInt("idtipocampanha"));
                oTipoCampanha.setNomeTipoCampanha(rs.getString("nometipocampanha"));
                oTipoCampanha.setDescricaoTipoCampanha(rs.getString("descricaotipocampanha"));
            }
            
            
        } catch(Exception ex){
            System.out.println("Problemas ao carregar dados de EStado! Erro: "+ ex.getMessage());
            ex.printStackTrace();
        } finally{
            try {
                ConnectionFactory.closeConnection(conexao, stmt, rs);
            } catch (Exception ex) {
                Logger.getLogger(TipoCampanhaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return oTipoCampanha;        
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from tipocampanha order by idtipocampanha";
        try{
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()) {
                TipoCampanha oTipoCampanha = new TipoCampanha();
                oTipoCampanha.setIdTipoCampanha(rs.getInt("idtipocampanha"));
                oTipoCampanha.setNomeTipoCampanha(rs.getString("nometipocampanha"));
                oTipoCampanha.setDescricaoTipoCampanha(rs.getString("descricaotipocampanha"));
                resultado.add(oTipoCampanha);
            }
            
        } catch (SQLException ex) {
            System.out.println("Problemas ao listar Tipo Campanha. Erro:"
                    + ex.getMessage());
        }
        finally{
            try{
                ConnectionFactory.closeConnection(conexao,stmt,rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar parametros de conexão! "
                        +"Erro: "+ex.getMessage());
            }
        }
        return resultado;
    }
    
    
    
}
