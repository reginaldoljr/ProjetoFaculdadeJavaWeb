/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.projeto.dao;

import br.com.exemplo.projeto.model.Campanha;
import br.com.exemplo.projeto.model.TipoCampanha;
import br.com.exemplo.projeto.dao.TipoCampanhaDAO;
import br.com.exemplo.projeto.utils.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CampanhaDAO implements GenericDAO {
   
    private Connection conexao;

    public CampanhaDAO() {
        try {
            this.conexao = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        } catch (Exception e) {
            System.out.println("Problemas ao abrir BD" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public Boolean cadastrar(Object objeto) {
        Campanha oCampanha = (Campanha) objeto;
        Boolean retorno = false;
        if (oCampanha.getIdCampanha() == 0) {
            retorno = this.inserir(oCampanha);
        } else {
            retorno = this.alterar(oCampanha);
        }
        
        return retorno;
    }

    @Override
    public Boolean inserir(Object objeto) {
        Campanha oCampanha = (Campanha) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into campanha(dataentrega,horaentrega, detalhes,enderecoentrega,encerrado,idtipocampanha) values (?,?,?,?,?,?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oCampanha.getDataEntrega());
            stmt.setString(2, oCampanha.getHoraEntrega());
            stmt.setString(3, oCampanha.getDetalhes());
            stmt.setString(4, oCampanha.getEnderecoEntrega());
            stmt.setString(5, oCampanha.getEncerrado());
            stmt.setInt(6, oCampanha.getTipoCampanha().getIdTipoCampanha());
            stmt.execute();
            
            return true;

        } catch (Exception ex) {
            System.out.println("Problemas ao cadastrar campanha" + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar BD" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean alterar(Object objeto) {
        Campanha oCampanha = (Campanha) objeto;
        PreparedStatement stmt = null;
        String sql = "update campanha set dataentrega=?, horaentrega=?, detalhes=?, enderecoentrega=?, encerrado=?, idtipocampanha=? where idcampanha=?";
    
        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oCampanha.getDataEntrega());
            stmt.setString(2, oCampanha.getHoraEntrega());
            stmt.setString(3, oCampanha.getDetalhes());
            stmt.setString(4, oCampanha.getEnderecoEntrega());
            stmt.setString(5, oCampanha.getEncerrado());
            stmt.setInt(6, oCampanha.getTipoCampanha().getIdTipoCampanha());
            stmt.setInt(7, oCampanha.getIdCampanha());
            stmt.execute();
            return true;
        } catch(Exception ex)
        {
            System.out.println("Problemas ao alterar campanha"+ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao,stmt);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar BD"+ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Boolean excluir(int numero) {
        int idCampanha = numero;
        PreparedStatement stmt = null;
        String sql = "update campanha set encerrado = ? where idcampanha = ?";

        try {

            GenericDAO oCampanhaDAO = new CampanhaDAO();
            Campanha oCampanha = (Campanha) oCampanhaDAO.carregar(numero);

            String encerrado = oCampanha.getEncerrado();
            if (oCampanha.getEncerrado().equals("Não")) {
                encerrado = "Sim";
            } else {
            if (oCampanha.getEncerrado().equals("Sim")) {
                encerrado = "Não";
            } else {
                encerrado = "Desativado";
            }
            }
           

            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, encerrado);
            stmt.setInt(2, idCampanha);
            stmt.execute();

            return true;

        } catch (Exception ex) {
            System.out.println("Problemas ao excluir campanha! Erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão com o BD! Erro" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int numero) {
        int idCampanha = numero;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Campanha oCampanha = null;

        String sql = "select * from campanha where idcampanha = ?";

        try {

            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idCampanha);
            rs = stmt.executeQuery();

            while (rs.next()) {
                oCampanha = new Campanha();
                oCampanha.setIdCampanha(rs.getInt("idcampanha"));
                oCampanha.setDataEntrega(rs.getString("dataentrega"));
                oCampanha.setHoraEntrega(rs.getString("horaentrega"));
                oCampanha.setDetalhes(rs.getString("detalhes"));
                oCampanha.setEnderecoEntrega(rs.getString("enderecoentrega"));
                oCampanha.setEncerrado(rs.getString("encerrado"));

                GenericDAO oTipoCampanhaDAO = new TipoCampanhaDAO();
                TipoCampanha oTipoCampanha = (TipoCampanha) oTipoCampanhaDAO.carregar(rs.getInt("idtipocampanha"));

                oCampanha.setTipoCampanha(oTipoCampanha);
            }

            return oCampanha;

        } catch (Exception ex) {
            System.out.println("Problemas ao carregar campanha! Erro:" + ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar conexão com o BD! Erro:" + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> listar() {
        List<Object> lstCampanhas = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "select * from campanha order by idcampanha";

        try {
            stmt = conexao.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Campanha oCampanha = new Campanha();
                oCampanha.setIdCampanha(rs.getInt("idcampanha"));
                oCampanha.setDataEntrega(rs.getString("dataentrega"));
                oCampanha.setHoraEntrega(rs.getString("horaentrega"));
                oCampanha.setDetalhes(rs.getString("detalhes"));
                oCampanha.setEnderecoEntrega(rs.getString("enderecoentrega"));
                oCampanha.setEncerrado(rs.getString("encerrado"));

                try {
                    TipoCampanhaDAO oTipoCampanhaDAO = new TipoCampanhaDAO();
                    oCampanha.setTipoCampanha((TipoCampanha) oTipoCampanhaDAO.carregar(rs.getInt("idtipocampanha")));
                } catch (Exception ex) {
                    System.out.println("Erro ao carregar tipo campanha" + ex.getMessage());
                    ex.printStackTrace();
                }

                lstCampanhas.add(oCampanha);
            }
            //campanha(dataentrega,horaentrega, detalhes,enderecoentrega,encerrado,idtipocampanha)

        } catch (Exception ex) {
            System.out.println("Problemas ao listar campanhas" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conexao, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Erro ao fechar BD" + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return lstCampanhas;

    }

}
