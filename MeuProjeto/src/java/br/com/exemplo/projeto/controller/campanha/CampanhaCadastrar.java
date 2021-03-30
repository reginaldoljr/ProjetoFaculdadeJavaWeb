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
import br.com.exemplo.projeto.model.TipoCampanha;
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
@WebServlet(name = "CampanhaCadastrar", urlPatterns = {"/CampanhaCadastrar"})
public class CampanhaCadastrar extends HttpServlet {

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
        int idCampanha = Integer.parseInt(request.getParameter("idcampanha"));
        String dataEntrega = request.getParameter("dataentrega");
        String horaEntrega = request.getParameter("horaentrega");
        String detalhes = request.getParameter("detalhes");
        String enderecoEntrega = request.getParameter("enderecoentrega");
        String encerrado = request.getParameter("encerrado");
        int idTipoCampanha = Integer.parseInt(request.getParameter("idtipocampanha"));
        String mensagem = null;
        
        try{
            GenericDAO oTipoCampanhaDAO = new TipoCampanhaDAO();
            TipoCampanha oTipoCampanha = (TipoCampanha) oTipoCampanhaDAO.carregar(idTipoCampanha);
            
            Campanha oCampanha = new Campanha();
            oCampanha.setIdCampanha(idCampanha);
            oCampanha.setDataEntrega(dataEntrega);
            oCampanha.setHoraEntrega(horaEntrega);
            oCampanha.setDetalhes(detalhes);
            oCampanha.setEnderecoEntrega(enderecoEntrega);
            oCampanha.setEncerrado(encerrado);
            oCampanha.setTipoCampanha(oTipoCampanha);
            
            GenericDAO dao = new CampanhaDAO();
            if (dao.cadastrar(oCampanha)){
                mensagem = "Campanha cadastrada com sucesso";
            } else {
                mensagem = "Problemas ao cadastrar campanha";
            }
            
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("CampanhaListar");
            
            
        } catch(Exception ex) {
            System.out.println("Erro ao gravar campanha"+ex.getMessage());
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
