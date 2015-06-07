/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
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
    
    @EJB
    private QuizBeanRemote proxyQuizBean;
    
    private QuizDescriptor currentQuiz;
    
    @Override
    public Long createQuiz(String QuizName, String QuizTypeString) {
        
//       Quiz q = QuizFactory.CreateQuiz(QuizName, QuizTypeString);
//       
//       this.entityManager.persist(q);
//       this.currentQuiz = q;
        
        
        Long quizID =proxyQuizBean.CreateQuiz(QuizName, "scored".equals(QuizTypeString) ? 0:1 );
        
        this.currentQuiz = proxyQuizBean.GetQuiz(quizID);
        
       return quizID;
    }

    @Override
    public Long addQuestion(String questionTitle) {
//        Question question = new Question();
//        
//        question.setQuestionText(questionTitle);
//        question.setQuiz(currentQuiz);
//        currentQuiz.addQuestion(question);
//        this.entityManager.persist(question);
        
        return proxyQuizBean.AddQuestion(this.currentQuiz.getId(), questionTitle);
        
        //return question.getId();
    }

    @Override
    public Long addAnswer(long questionID, String answerText) {
        
//        Question question = this.entityManager.find(Question.class, questionID);
//
//        Answer answer = new Answer();
//        answer.setAnswerText(answerText);
//        answer.setQuestion(question);
//        
//        this.entityManager.persist(answer);
//        
//        return answer.getId();
        return proxyQuizBean.AddAnswer(questionID, answerText);
    }

    @Override
    public void setCorrectAnswer(long questionID, long answerID) {
        
//        Question question = this.entityManager.find(Question.class, questionID);
//        Answer answer = this.entityManager.find(Answer.class, answerID);
//        
//        question.setCorrectAnswer(answer);
//        
//        this.entityManager.merge(question);
         proxyQuizBean.SetCorrectAnswer(questionID, answerID);
        
    }
    
    @Override
    public QuizDescriptor getCurrentQuiz() {
        
        return proxyQuizBean.GetQuiz(this.currentQuiz.getId());
    }

    @Override
    public Long addSurveyRange(String message, int low, int high) {
        
        return proxyQuizBean.AddSurveyRange(this.currentQuiz.getId(), message, low, high);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
