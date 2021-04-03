/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.projeto.controller.controlesessaoDAO;

import br.com.exemplo.projeto.model.Voluntario;

import br.com.exemplo.projeto.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author reginaldo
 */
public class VoluntarioDAOImpl {
        private Connection conn;
    //Construtor fazendo a conexão com BD
    public VoluntarioDAOImpl() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    
    public Voluntario logarUsuario(String emailusuario, String senhausuario){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Voluntario oVoluntario = null;
        ///oUsuario (objeto Usuario)        
        String sql = "select * from usuario"
                + "   where emailusuario=?"
                + "   and senhausuario=?;";
        
        try{
            ///Tentativa na busca do usuario
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailusuario);
            stmt.setString(2, senhausuario);
            rs = stmt.executeQuery();
            
            
            //String nomePessoa, String cpf_cnpj, String tipoPessoa, String emailusuario, String senhausuario, String categoria
            if(rs.next()){
                oVoluntario = new Voluntario("regis","regis","regis","regis@hotmail.com","123456","regis");
                
                oVoluntario.setEmailUsuario(rs.getString("emailusuario"));
                oVoluntario.setSenhaUsuario(rs.getString("senhausuario"));

            }            
        }catch(SQLException ex){
            System.out.println("Problemas ao logar Usuario:\n Erro: "+ ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar conexão BD: \n Erro: "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        return oVoluntario;
    }
    
    
    
    
}
