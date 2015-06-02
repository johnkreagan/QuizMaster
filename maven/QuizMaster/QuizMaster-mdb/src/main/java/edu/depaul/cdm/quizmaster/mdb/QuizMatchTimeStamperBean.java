/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.quizmaster.mdb;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
import edu.depaul.cdm.QuizMaster.entities.QuizMatch;
import edu.depaul.cdm.QuizMasterRemote.QuizMatchRemote;
import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johnreagan
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QuizMasterQuizMatchTimeStampQueue"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/QuizMasterQuizMatchTimeStampQueue")
})
public class QuizMatchTimeStamperBean implements MessageListener {
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
    
    public QuizMatchTimeStamperBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            
            ObjectMessage om = (ObjectMessage)message;
            QuizMatchDescriptor qmd = (QuizMatchDescriptor)om.getObject();
            
            this.stampQuizMatch(qmd.getId());
            
        } catch(Exception e) {
            
        }
        
    }
    
    private void stampQuizMatch(Long qmID) {
        
        QuizMatch qm = this.entityManager.find(QuizMatch.class, qmID);
        
        qm.setDateScored(new Date());
        
        this.entityManager.merge(qm);
        
    }
    
}
