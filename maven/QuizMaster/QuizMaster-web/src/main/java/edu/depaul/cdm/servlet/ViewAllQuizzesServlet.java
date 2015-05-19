/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.servlet;

//import edu.depaul.cdm.QuizMaster.Answer;
//import edu.depaul.cdm.QuizMaster.Question;
import edu.depaul.cdm.QuizMaster.Quiz;
//import edu.depaul.cdm.QuizMaster.QuizBean;
import edu.depaul.cdm.quizmaster.QuizBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ViewAllQuizzes", urlPatterns = {"/ViewAllQuizzes"})
public class ViewAllQuizzesServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ViewAllQuizzesServlet.class.getName());
    
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

//            try {
//                //quizBean.setupHistoryQuiz();
//                List<Quiz> quizzes = quizBean.GetAllQuizzes();
//                Quiz q;
//                for(int i = 0; i < quizzes.size(); i++) {
//                   q = quizzes.get(i);
//                   out.println("<h1>Quiz: " + q.getQuizName() + "</h1>");
//                    List<Question> questions = q.getQuestions();
//                    Question question;
//                    Answer answer;
//                    for(int j = 0; j< questions.size(); j++) {
//                        question = questions.get(j);
//                        out.println("<h2>" + question.getQuestionText() + " " + question.getId() + "</h2>");
//                        out.println("<h3>" + question.getQuiz().getId() + "</h3>");
//                        for (int k = 0; k < question.getAnswers().size(); k++) {
//                            answer = question.getAnswers().get(k);
//                            out.println("<p>" + answer.getAnswerText() + "</p>");
//                        }
//                    } 
//                }
//                
//                out.println("");
//                
//                out.println("<h1>Quizzes:" +quizBean.GetAllQuizzes() + "</h1");
//            } catch(Exception e) {
//                out.println("<h1>Quizzes Exception:" + e.getMessage()+ "</h1");
//            }

//        try {
            
            logger.log(Level.INFO, "PRE");
        Quiz q = new Quiz();
            //return quizBean.GetAllQuizzes();
//            logger.log(Level.INFO, "PRE2");
                request.setAttribute("quizzes", quizBean.GetAllQuizzes());
//            request.setAttribute("quizCount", quizBean.toString());
//            logger.log(Level.INFO, "PRE3");
//        } catch(Exception e) {
//            logger.log(Level.INFO, "PREEX: " + e.getMessage());
//        }
        
        
        request.getServletContext().getRequestDispatcher("/ViewAllQuizzes.jsp").forward(request, response);
        
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
