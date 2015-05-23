/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.servlet;

import edu.depaul.cdm.QuizMaster.service.StatefulQuizBeanRemote;
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
@WebServlet(name = "CreateQuiz", urlPatterns = {"/CreateQuiz"})
public class CreateQuizServlet extends HttpServlet {

    @EJB
    private StatefulQuizBeanRemote quizBean;
    
    
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
            
        String action = request.getParameter("createQuizAction");
        action = (action  == null) ? "" : action;
        if (action.equals("Create")) {
            String name = request.getParameter("quizName");
            String type = request.getParameter("quizType");
            name = (name == null) ? "" : name;
            type = (type == null) ? "" : type;
            Long quizID = quizBean.createQuiz(name, type);
            request.setAttribute("quizID", quizID);
            
            request.getServletContext().getRequestDispatcher("/AddQuestion.jsp").forward(request, response);
            return;
        } else if (action.equals("Add Question")) {
            
            String questionText = request.getParameter("questionText");
            
            Long questionID = quizBean.addQuestion(questionText);
            
            String answerText;
            for (int i = 0; i < 4; i++) {
                answerText = request.getParameter("answerText_" + i);
                if (answerText != null && answerText.length() > 0) {
                    quizBean.addAnswer(questionID, answerText);
                }
            }
            
            
            request.getServletContext().getRequestDispatcher("/AddQuestion.jsp").forward(request, response);
            return;
        } else if (action.equals("Done")) {
        
            request.setAttribute("currentQuiz", this.quizBean.getCurrentQuiz());
            request.getServletContext().getRequestDispatcher("/CreateQuizDone.jsp").forward(request, response);
            return;
        }   
        request.getServletContext().getRequestDispatcher("/CreateQuiz.jsp").forward(request, response);
        
    
        
        
        
        
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
