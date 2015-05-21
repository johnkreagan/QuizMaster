/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import edu.depaul.cdm.QuizMaster.entities.Answer;
import edu.depaul.cdm.QuizMaster.entities.Player;
import edu.depaul.cdm.QuizMaster.entities.Question;
import edu.depaul.cdm.QuizMaster.entities.Quiz;
import edu.depaul.cdm.QuizMaster.entities.QuizMatch;
import java.util.ListIterator;
import java.util.logging.Logger;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John
 */
@Stateful
@Remote(StatefulQuizBeanRemote.class)
public class StatefulQuizBean implements StatefulQuizBeanRemote {

    private static final Logger logger = Logger.getLogger(StatefulQuizBean.class.getName());
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
    
    private QuizMatch activeQuizMatch;

    private ListIterator<Question> questionsIterator;
    
    private Question currentQuestion;
    
    @Override
    public long startQuiz(long quizID, long playerID) {
        
        Quiz q = this.entityManager.find(Quiz.class, quizID);
        Player p = this.entityManager.find(Player.class, playerID);
        this.activeQuizMatch = new QuizMatch();
        
        this.activeQuizMatch.setQuiz(q);
        this.activeQuizMatch.setPlayer(p);
        this.questionsIterator = q.getQuestions().listIterator();
        this.currentQuestion = this.questionsIterator.next();
        
        this.entityManager.persist(this.activeQuizMatch);
        return this.activeQuizMatch.getId();
    }

    @Override
    public QuestionDescriptor getCurrentQuestion() {
        return (QuestionDescriptor)this.currentQuestion.getDescriptor();
    }

    @Override
    public QuestionDescriptor goToNextQuestion() {
        Question next = this.questionsIterator.next();
        if (next != null) {
            this.currentQuestion = next;
        }
        return (QuestionDescriptor)this.currentQuestion.getDescriptor();
    }

    @Override
    public Long submitAnswer(Long answerID) {
        
        Answer a = this.entityManager.find(Answer.class, answerID);
        this.activeQuizMatch.addAnswer(a);
        this.entityManager.merge(this.activeQuizMatch);
        return a.getId();
    }
    
    
    
    
    
    
    
    
    
}
