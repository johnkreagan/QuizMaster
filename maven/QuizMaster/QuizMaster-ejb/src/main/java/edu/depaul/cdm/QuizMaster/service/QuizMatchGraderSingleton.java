/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizResult;
import edu.depaul.cdm.QuizMaster.entities.QuizMatch;
import java.util.Date;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author John
 */
@Stateful
@Singleton
public class QuizMatchGraderSingleton implements QuizMatchGraderSingletonRemote {

    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
    
    
    
    @Override
    public QuizResult submitQuizMatchForGrading(Long quizMatchID) {
        
        QuizMatch qm = this.entityManager.find(QuizMatch.class, quizMatchID);
        
        qm.setDateScored(new Date());
        
        qm.processResults();
        
        this.entityManager.merge(qm);
        
        return qm.getResults();
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
