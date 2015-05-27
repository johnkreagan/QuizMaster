/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.servlet;

import edu.depaul.cdm.QuizMaster.service.StatefulQuizMatchBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author John
 */
@WebServlet(name = "TakeQuizStateful", urlPatterns = {"/TakeQuizStateful"})
public class TakeQuizStatefulServlet extends HttpServlet {

    @EJB
    private StatefulQuizMatchBeanRemote quizBean;
    
    
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
        response.setContentType("text/html;charset=UTF-8");
        
        
        if (request.getAttribute("startQuiz") != null) {
            
            Long quizID = (Long)request.getAttribute("quizID");
            Long playerID = (Long)request.getAttribute("playerID");
            
            Long quizMatchID = quizBean.startQuiz(quizID, playerID);
            
        }
        
        if (request.getParameter("addAnswer") != null) {
            Long answerID = Long.parseLong(request.getParameter("answerID"));
            quizBean.submitAnswer(answerID);
        }
        
        if (request.getParameter("next") != null) {
            if (quizBean.hasNextQuestion()) {
                quizBean.goToNextQuestion();
            } else {
                request.setAttribute("quizMatch", quizBean.getQuizMatch());
                request.getServletContext().getRequestDispatcher("/TakeQuizStatefulDone.jsp").forward(request, response);
                return;
            }
            
        }
        
        request.setAttribute("currentQuestion", quizBean.getCurrentQuestion());
        
        request.getServletContext().getRequestDispatcher("/TakeQuizStateful.jsp").forward(request, response);
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
