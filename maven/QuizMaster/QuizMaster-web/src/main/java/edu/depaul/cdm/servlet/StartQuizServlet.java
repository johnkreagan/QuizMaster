/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.servlet;

//import edu.depaul.cdm.QuizMaster.Quiz;
//import edu.depaul.cdm.QuizMaster.QuizBean;
//import edu.depaul.cdm.QuizMaster.QuizMatch;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
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
@WebServlet(name = "StartQuiz", urlPatterns = {"/StartQuiz"})
public class StartQuizServlet extends HttpServlet {

    
    @EJB
    private QuizBeanRemote quizBean;
    
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
                String begin = request.getParameter("startQuiz");
                String formatType = request.getParameter("quizFormat");
                if(begin != null && begin.equals("Begin")) {
                    
//                    Long quizMatchID = quizBean.(Long.parseLong(request.getParameter("playerID")), Long.parseLong(request.getParameter("quizID")));
//                    
//                    request.getSession().setAttribute("activeQuizMatch", quizMatch);
                    request.setAttribute("quizID", Long.parseLong(request.getParameter("quizID")));
                    request.setAttribute("playerID", Long.parseLong(request.getParameter("playerID")));
                    request.setAttribute("startQuiz", true);
                    if (formatType.equals("stateless")) {
                        request.getServletContext().getRequestDispatcher("/TakeQuiz").forward(request, response);
                    } else {
                        request.getServletContext().getRequestDispatcher("/TakeQuizStateful").forward(request, response);
                    }
                    
                    return;
                } 
                request.setAttribute("quizzes", quizBean.GetAllQuizzes());
                request.setAttribute("players", quizBean.GetAllPlayers());
                
            } catch(Exception e) {
                System.out.println("EX: " + e.getMessage());
            }
        
            request.getServletContext().getRequestDispatcher("/StartQuiz.jsp").forward(request, response);
            
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
