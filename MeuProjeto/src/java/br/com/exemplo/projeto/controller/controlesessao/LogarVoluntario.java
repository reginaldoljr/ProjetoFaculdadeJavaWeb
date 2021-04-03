/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.exemplo.projeto.controller.controlesessao;

import br.com.exemplo.projeto.controller.controlesessaoDAO.VoluntarioDAOImpl;
import br.com.exemplo.projeto.model.Voluntario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author reginaldo
 */
@WebServlet(name = "LogarVoluntario", urlPatterns = {"/LogarVoluntario"})
public class LogarVoluntario extends HttpServlet {

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

        String acao = request.getParameter("acao");

        if (acao.equals("logar")) {
            String email = request.getParameter("emailusuario");
            String senha = request.getParameter("senhausuario");
            //Verifica se email e senha foram preenchidos
            if (!email.equals("") && !senha.equals("")) {
                try {
                    VoluntarioDAOImpl dao = new VoluntarioDAOImpl();
                    Voluntario oVoluntario = dao.logarUsuario(email, senha);
                    if (oVoluntario != null) {
                        //Abertura da Sessão
                        HttpSession session = request.getSession(true);
                        session.setAttribute("oVoluntario", oVoluntario);
                        request.getRequestDispatcher("indexlogado.jsp").forward(request, response);
                    } else {
                        request.setAttribute("mensagem", "Login ou Senha inválidos");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } catch (Exception ex) {
                    System.out.println("Problemas ao logar Usuario! \n Erro:" + ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                request.setAttribute("mensagem", "Login ou Senha em branco");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if (acao.equals("logout")) {
            HttpSession session = request.getSession(true);
            session.invalidate();
            response.sendRedirect("login.jsp");
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
