/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.entities.Player;
import edu.depaul.cdm.QuizMaster.entities.Quiz;
import edu.depaul.cdm.QuizMaster.entities.QuizMatch;
import edu.depaul.cdm.QuizMaster.entities.Answer;
import edu.depaul.cdm.QuizMaster.entities.Question;
import edu.depaul.cdm.QuizMaster.DTODescriptor.PlayerDescriptor;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.entities.ScoredQuiz;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;

/**
 *
 * @author John
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
//@Named("quizBean")
@Remote(QuizBeanRemote.class)
public class QuizBean implements QuizBeanRemote {

   private static final Logger logger = Logger.getLogger(QuizBean.class.getName());
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
    
    public QuizBean() {
       // lastBuiltQuiz = entityManager.find(Quiz.class, new Long(1));
    }
    
    
    //@Transactional
   @Override
    public List<QuizDescriptor> GetAllQuizzes()  {
        logger.log(Level.INFO, "Pre Fetch all quizzes");
        //entityManager.getTransaction().begin();
        List<QuizDescriptor> returnedQuizzes = new ArrayList<QuizDescriptor>();
        try     {
            List<Quiz> quizzes = entityManager.createQuery("SELECT q FROM Quiz q").getResultList();
            for(Quiz q : quizzes) {
                returnedQuizzes.add(q.getDescriptor());
            }
            
        } catch(Exception e) {
           logger.log(Level.INFO, "EEE" + e.getMessage());     
        }
        
        return returnedQuizzes;
    }
    
    @Override
    public List<PlayerDescriptor> GetAllPlayers() {
        //return entityManager.createNamedQuery("findAllPlayers", Player.class).getResultList();
        List<PlayerDescriptor> playerDTOs = new ArrayList<>();
        List<Player> players =  entityManager.createQuery("SELECT p FROM Player p").getResultList();
        for(Player p : players) {
            playerDTOs.add((PlayerDescriptor)p.getDescriptor());
        }
        
        return playerDTOs;
    }
    
    //@Transactional
    public Quiz GetQuizByID(long id) {
        return entityManager.find(Quiz.class, id);
    }
    
    //@Transactional

    public String setupHistoryQuiz() {
        
        try {
            logger.log(Level.INFO, "Pre findallquizzes");
            List<Quiz> quizzes = entityManager.createNamedQuery("findAllQuizzes").getResultList();
            logger.log(Level.INFO, "Quizzes size = " + quizzes.size());
            if(quizzes.isEmpty()) {
                Quiz newQuiz = new ScoredQuiz();
                newQuiz.setQuizName("Default Quiz");
                quizzes.add(newQuiz);
            }
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
                        q1.setCorrectAnswer(answers.get(0));
                        questions.add(q1);
                    }

                    quiz1.setQuestions(questions);

                    entityManager.persist(quiz1);

                    //this.setLastBuiltQuiz(quiz1);
                }
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
        
       
        
        return "";
    }
    
    public void AddQuestion(int quizID, Question question) {
        
       Quiz q = entityManager.find(Quiz.class, quizID);
       q.addQuestion(question);
       this.entityManager.merge(question);
    }
    
    @Override
    public long CreateQuiz(String name, int type) {
        
        Quiz quiz = new ScoredQuiz();
        quiz.setQuizName(name);
        
        this.entityManager.persist(quiz);
        
        return quiz.getId();
        
        
    }

    @Override
    public long AddQuestion(long quizID, String questionTitle) {
       
        Quiz q = this.entityManager.find(Quiz.class, quizID);
        
        Question question = new Question();
        question.setQuestionText(questionTitle);
        question.setQuiz(q);
        q.addQuestion(question);
        
        this.entityManager.persist(question);
        return question.getId();
        
    }

    @Override
    public long AddAnswer(long questionID, String answerText) {
        Question q = this.entityManager.find(Question.class, questionID);
        
        Answer aw = new Answer();
        aw.setAnswerText(answerText);
        aw.setQuestion(q);
        
        q.addAnswer(aw);
        
        this.entityManager.persist(aw);
        
        return aw.getId();
        
    }

    @Override
    public void SetCorrectAnswer(long questionID, long answerID) {
        
        Question q = this.entityManager.find(Question.class, questionID);
        Answer a = this.entityManager.find(Answer.class, answerID);
        
        q.setCorrectAnswer(a);
        this.entityManager.merge(q);
        
    }

    @Override
    public void addDefaultQuestions() {
        this.setupHistoryQuiz();
    }

    @Override
    public QuizDescriptor GetQuiz(long quizID) {
        Quiz q = this.entityManager.find(Quiz.class, quizID);
        
        return (q == null) ? null :q.getDescriptor();
    }

    @Override
    public void DeleteQuiz(long quizID) {
       
        Quiz q = this.entityManager.find(Quiz.class, quizID);
        
        this.entityManager.remove(q);
    }

    @Override
    public void DeleteQuestion(long questionID) {
       
        Question question = this.entityManager.find(Question.class, questionID);
        Long quizID = question.getQuiz().getId();
        this.entityManager.remove(question);
        
        Quiz q = this.entityManager.find(Quiz.class, quizID);
        q.getQuestions().remove(question);
        this.entityManager.merge(q);
        
        
    }
    
}
