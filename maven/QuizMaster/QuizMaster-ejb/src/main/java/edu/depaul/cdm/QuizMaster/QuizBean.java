/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 *
 * @author John
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
@Named
@Local
public class QuizBean implements Serializable {

   private static final Logger logger = Logger.getLogger(QuizBean.class.getName());
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;

    private Quiz lastBuiltQuiz;

    public Quiz getLastBuiltQuiz() {
        return lastBuiltQuiz;
    }

    public void setLastBuiltQuiz(Quiz lastBuiltQuiz) {
        this.lastBuiltQuiz = lastBuiltQuiz;
    }
    
    public QuizBean() {
       // lastBuiltQuiz = entityManager.find(Quiz.class, new Long(1));
    }
    
    
    //@Transactional
    public List<Quiz> GetAllQuizzes() throws SQLException  {
        logger.log(Level.INFO, "Pre Fetch all quizzes");
        //entityManager.getTransaction().begin();

        return entityManager.createQuery("SELECT q FROM Quiz q").getResultList();
        
    }
    
    //@Transactional
    public String addAQuestionToQuiz1() {
        

        Quiz q3 = new Quiz();
        q3.setQuizName("QUIZ3 BABY");
        entityManager.persist(q3);
        return q3.toString();

    } 
    
    //@Transactional
    public String setupHistoryQuiz() {
        
        try {
            logger.log(Level.INFO, "Pre findallquizzes");
            List<Quiz> quizzes = entityManager.createNamedQuery("findAllQuizzes").getResultList();
            logger.log(Level.INFO, "Quizzes size = " + quizzes.size());
            for (Quiz quiz1 : quizzes) {
                    quiz1.getQuestions().clear();

                    List<Question> questions = new ArrayList();

                    for(int k = 0; k < 5; k++) {
                        Question q1 = new Question();
                        q1.setQuiz(quiz1);
                        q1.setQuestionText("Who killed the radio star? --" + k + "--");
                        List<Answer> answers = new ArrayList();
                        for(int j = 0; j < 3; j++) {


                            Answer ans = new Answer();
                            ans.setQuestion(q1);
                            ans.setAnswerText("Video --" + j + "--" );
                            answers.add(ans);


                        }
                        q1.setAnswers(answers);

                        questions.add(q1);
                    }

                    quiz1.setQuestions(questions);

                    entityManager.persist(quiz1);

                    this.setLastBuiltQuiz(quiz1);
                }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
       
        
        return "";
    }
    
    public void AddQuestion(int quizID, Question question) {
        
       Quiz q = entityManager.find(Quiz.class, quizID);
       //q.addQuestion(question);
        
    }
    
    
    
    
}
