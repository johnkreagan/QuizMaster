/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.jreagan1.QuizMaster;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 *
 * @author John
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@SessionScoped
@Named
public class QuizBean implements Serializable {

   private static final Logger logger = Logger.getLogger(QuizBean.class.getName());
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;

    
    @Transactional
    public List<Quiz> GetAllQuizzes() throws SQLException  {
        logger.log(Level.INFO, "Pre Fetch all quizzes");
        //entityManager.getTransaction().begin();

        return entityManager.createQuery("SELECT q FROM Quiz q").getResultList();
        
    }
    
    @Transactional
    public String addAQuestionToQuiz1() {
        
        
        
      // Quiz q1 = entityManager.find(Quiz.class, new Long(1));
        //entityManager.getTransaction().commit();
//        Question question = new Question();
//        question.setQuestionText("What was the name of the captial city of the Roman empire?");
//        question.setQuiz(q1);
//        question.setId(new Long(1));
//        Answer a = new Answer();
//        
//        a.setQuestion(question);
//        a.setAnswerText("Answer Text");
//        q1.addQuestion(question);
//        //entityManager.getTransaction().begin();
        //entityManager.persist(question);
        //entityManager.getTransaction().commit();
        
        //entityManager.getTransaction().begin();
       
      // q1.setQuizName("UPDATERD");
      //  entityManager.persist(q1);
        
        Quiz q3 = new Quiz();
        //q3.setId(new Long(3));
        q3.setQuizName("QUIZ3 BABY");
        //entityManager.getTransaction().commit();
       // this.addAQuestionToQuiz1(q1);
        entityManager.persist(q3);
        return q3.toString();
  

    } 
    
    public void AddQuestion(int quizID, Question question) {
        
       Quiz q = entityManager.find(Quiz.class, quizID);
       //q.addQuestion(question);
        
    }
    
    
    
    
}
