/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.entities.Answer;
import edu.depaul.cdm.QuizMaster.entities.Question;
import edu.depaul.cdm.QuizMaster.entities.Quiz;
import edu.depaul.cdm.QuizMaster.factories.QuizFactory;
import edu.depaul.cdm.QuizMaster.entities.ScoredQuiz;
import edu.depaul.cdm.QuizMaster.entities.SurveyQuestion;
import edu.depaul.cdm.QuizMaster.entities.SurveyQuiz;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Stateful proxy bean for QuizBeanRemote
 * @author John
 */
@Stateful
public class StatefulQuizBean implements StatefulQuizBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
    
    private QuizFactory quizFactory;
    
    private Quiz currentQuiz;
    
    @Override
    public Long createQuiz(String QuizName, String QuizTypeString) {
       quizFactory = new QuizFactory();
       
       QuizFactory.QuizType type = (QuizTypeString.equals("SCORED")) ? QuizFactory.QuizType.Scored : QuizFactory.QuizType.Survey;
       
       quizFactory.initiateQuiz(QuizName, type);
       
//       
//       Quiz q = QuizFactory.CreateQuiz(QuizName, QuizTypeString);
//       
//       this.entityManager.persist(q);
//       this.currentQuiz = q;
        
       return 1L;
    }

    @Override
    public Long addSurveyQuestion(String questionTitle, int weight, Map<String,Integer> answers) {
        
        quizFactory.addSurveyQuestion(questionTitle, weight, answers);
        
//        Question question = new SurveyQuestion();
//        
//        question.setQuestionText(questionTitle);
//        question.setQuiz(currentQuiz);
//        currentQuiz.addQuestion(question);
//        this.entityManager.persist(question);
        
        return 0L;
    }

    @Override
    public Long addAnswer(long questionID, String answerText) {
        
        Question question = this.entityManager.find(Question.class, questionID);

        Answer answer = new Answer();
        answer.setAnswerText(answerText);
        answer.setQuestion(question);
        
        this.entityManager.persist(answer);
        
        return answer.getId();
    }

    @Override
    public void setCorrectAnswer(long questionID, long answerID) {
        
        Question question = this.entityManager.find(Question.class, questionID);
        Answer answer = this.entityManager.find(Answer.class, answerID);
        
        question.setCorrectAnswer(answer);
        
        this.entityManager.merge(question);
        
    }
    
    @Override
    public QuizDescriptor getCurrentQuiz() {
        return this.currentQuiz.getDescriptor();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
