/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.jreagan1.QuizMaster;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    
    @Transactional
    public List<Quiz> GetAllQuizzes() throws SQLException  {
        logger.log(Level.INFO, "Pre Fetch all quizzes");
        //entityManager.getTransaction().begin();

        return entityManager.createQuery("SELECT q FROM Quiz q").getResultList();
        
    }
    
    @Transactional
    public String addAQuestionToQuiz1() {
        

        Quiz q3 = new Quiz();
        q3.setQuizName("QUIZ3 BABY");
        entityManager.persist(q3);
        return q3.toString();

    } 
    
    @Transactional
    public String setupHistoryQuiz() {
        
        Quiz quiz1 = entityManager.find(Quiz.class, new Long(1));
        
        List<Question> questions = new ArrayList<Question>();
        
        for(int i = 0; i < 5; i++) {
            Question q1 = new Question();
            q1.setQuiz(quiz1);
            q1.setQuestionText("Who killed the radio star? --" + i + "--");
            List<Answer> answers = new ArrayList<Answer>();
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
        return quiz1.toString();
    }
    
    public void AddQuestion(int quizID, Question question) {
        
       Quiz q = entityManager.find(Quiz.class, quizID);
       //q.addQuestion(question);
        
    }
    
    
    
    
}
