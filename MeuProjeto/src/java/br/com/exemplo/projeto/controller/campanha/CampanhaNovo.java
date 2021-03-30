/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.projeto.controller.campanha;

import br.com.exemplo.projeto.dao.CampanhaDAO;
import br.com.exemplo.projeto.dao.GenericDAO;
import br.com.exemplo.projeto.dao.TipoCampanhaDAO;
import br.com.exemplo.projeto.model.Campanha;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reginaldo
 */
@WebServlet(name = "CampanhaNovo", urlPatterns = {"/CampanhaNovo"})
public class CampanhaNovo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        String mensagem = null;
        
        try{
            //cria uma campanha vazia
            Campanha oCampanha = new Campanha();
            request.setAttribute("campanha", oCampanha);
            
            // lista de tipo campanhas
            GenericDAO oTipoCampanhaDAO = new TipoCampanhaDAO();
            request.setAttribute("tipocampanhas", oTipoCampanhaDAO.listar());
            
            //dispachar para o jsp de cadastro de campanha
            request.getRequestDispatcher("/cadastros/campanha/campanhacadastrar.jsp").forward(request, response);
            
            
        }catch (Exception ex){
            System.out.println("Problemas no servelet Campanha Novo"+ex.getMessage());
            ex.printStackTrace();
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
