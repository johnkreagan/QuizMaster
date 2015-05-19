/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster;

import edu.depaul.cdm.quizmaster.QuizMatchRemote;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author John
 */
@Stateless
@Remote
public class QuizMatchBean implements  Serializable, QuizMatchRemote  {

    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
    
    @Override
    public long StartQuizMatch(long quizID, long playerID) {
        
        Quiz q = entityManager.find(Quiz.class, quizID);
        Player p = entityManager.find(Player.class, playerID);
        
        QuizMatch qm = new QuizMatch();
        qm.setQuiz(q);
        qm.setPlayer(p);
        qm.setDateCreated(new Date());
        
        this.entityManager.persist(qm);
        
        return qm.getId();
        
    }

    @Override
    public void AnswerQuestion(long quizMatchID, long questionID, long answerID) {
        QuizMatch qm = this.entityManager.find(QuizMatch.class, quizMatchID);
        Question q = this.entityManager.find(Question.class, questionID);
        Answer a = this.entityManager.find(Answer.class, answerID);
        
        qm.addAnswer(a);
        this.entityManager.merge(qm);
    }

    @Override
    public void AnswerQuestions(long quizMatchID, List<Long> answerIDs) {
        
        Answer a;
        QuizMatch qm = this.entityManager.find(QuizMatch.class, quizMatchID);
        for(Long l : answerIDs) {
            a = this.entityManager.find(Answer.class, l.longValue());
            if (a != null) {
                qm.addAnswer(a);
            }
        }
        
        this.entityManager.merge(qm);
    }

    @Override
    public long GetScore(long quizMatchID) {
        QuizMatch qm = this.entityManager.find(QuizMatch.class, quizMatchID);
        
        return qm.getScore();
    }

    @Override
    public List GetScores(long quizID) {
        
        Quiz q = this.entityManager.find(Quiz.class, quizID);
        
        Query o = this.entityManager.createQuery("SELECT qm FROM QuizMatch qm WHERE quiz = :q", Quiz.class);
        
        return o.setParameter("q", q).getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
