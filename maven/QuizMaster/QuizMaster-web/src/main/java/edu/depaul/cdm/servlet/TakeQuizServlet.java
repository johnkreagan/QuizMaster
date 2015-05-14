/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.servlet;

import edu.depaul.cdm.QuizMaster.Answer;
import edu.depaul.cdm.QuizMaster.Question;
import edu.depaul.cdm.QuizMaster.Quiz;
import edu.depaul.cdm.QuizMaster.QuizBean;
import edu.depaul.cdm.QuizMaster.QuizMatch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
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
@WebServlet(name = "TakeQuiz", urlPatterns = {"/TakeQuiz"})
public class TakeQuizServlet extends HttpServlet {

    @EJB
    private QuizBean quizBean;
    
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
            
            try {
                
                QuizMatch quizMatch = (QuizMatch)request.getSession().getAttribute("activeQuizMatch");
                Quiz activeQuiz = quizMatch.getQuiz();
                request.setAttribute("activeQuiz", activeQuiz);
                String submitVal = request.getParameter("submitQuiz");
                if (submitVal != null) {
                    
                    Enumeration<String> params = request.getParameterNames();
                    String paramName = params.nextElement();
                    String paramValue;
                    Answer answer;
                    while(paramName != null && paramName.startsWith("Question_")) {
                        paramValue = request.getParameter(paramName);
                        
                        quizMatch.addAnswer(this.getAnswerByParamaterValue(activeQuiz, paramName, paramValue));
                        
                        paramName = params.nextElement();
                    }
                    
                    quizBean.GradeQuizMatch(quizMatch);
                    request.setAttribute("gradedQuizMatch", quizMatch);
                    request.getServletContext().getRequestDispatcher("/QuizComplete.jsp").forward(request, response);
                    return;
                }
                
            } catch(Exception e) {

            }
        
        
        request.getServletContext().getRequestDispatcher("/TakeQuiz.jsp").forward(request, response);
        
        
    }

    private Answer getAnswerByParamaterValue(Quiz quiz, String paramName, String paramValue) {
        Answer answer = null;
        
        try {
            long questionID = Long.parseLong(paramName.replace("Question_", ""));
            long answerID = Long.parseLong(paramValue);
            
            Question questionByID = null;
            for(Question q: quiz.getQuestions()) {
                if (q.getId() == questionID) {
                    questionByID = q;
                    break;
                }
            }
            
            for(Answer a : questionByID.getAnswers()) {
                if (answerID == a.getId()) {
                    answer = a;
                    break;
                }
            }
            
        } catch(Exception e) {
            System.out.println("E = " + e.getMessage());
        }
        
        return answer;
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
