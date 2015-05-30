/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.servlet;

import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author John
 */
@WebServlet(name = "NewQuizMessageServlet", urlPatterns = {"/NewQuizMessageServlet"})
public class NewQuizMessageServlet extends HttpServlet {

    @Resource(mappedName = "jms/QuizMasterNewQuizTopic")
    private Topic topic;
    @Resource(mappedName = "jms/QuizMasterConnectionFactory")
    private TopicConnectionFactory topicConnectionFactory;
    
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            TopicConnection topicConnection = topicConnectionFactory.createTopicConnection();
            topicConnection.start();
            Session session = topicConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mp = session.createProducer(topic);

//            StringBuilder builder = new StringBuilder();
//            builder.append(request.getParameter("fromAccount"));
//            builder.append(";");
//            builder.append(request.getParameter("toAccount"));
//            builder.append(";");
//            builder.append(request.getParameter("amount"));
            
            ObjectMessage om = session.createObjectMessage();
            om.setObject(quizBean.GetQuiz(1L));
            mp.send(om);
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewQuizMessageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewQuizMessageServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>SENDER at " + mp + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch(JMSException exception) {
            
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
