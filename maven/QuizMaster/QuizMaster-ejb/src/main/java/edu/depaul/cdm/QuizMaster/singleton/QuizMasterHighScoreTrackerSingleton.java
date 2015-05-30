/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.singleton;

import edu.depaul.cdm.QuizMaster.singleton.QuizMasterHighScoreTrackerSingletonRemote;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
import edu.depaul.cdm.QuizMaster.entities.QuizMatch;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateful;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author John
 */
@Stateful
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QuizMasterNewQuizMatchCompletedTopic"),
    //@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/QuizMasterNewQuizMatchCompletedTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/QuizMasterNewQuizMatchCompletedTopic")
})
public class QuizMasterHighScoreTrackerSingleton implements QuizMasterHighScoreTrackerSingletonRemote, MessageListener {

    
    private List<QuizMatchDescriptor> highScores;
    
    @Override
    public void onMessage(Message message) {
        
        try {
            
            ObjectMessage m = (ObjectMessage)message;
            
            QuizMatchDescriptor qm = (QuizMatchDescriptor)m.getObject();
            
            this.submitScoredQuizMatch(qm);
            
            
        } catch(Exception e) {
            
        }
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void submitScoredQuizMatch(QuizMatchDescriptor scoredQuizMatch) {
        
        if (highScores == null) {
            highScores = new ArrayList<QuizMatchDescriptor>();
        }
        if (highScores.contains(scoredQuizMatch)) {
            
            highScores.remove(scoredQuizMatch);
            
        }
        highScores.add(scoredQuizMatch);
    }

    @Override
    public List<QuizMatchDescriptor> getHighScores() {
        return highScores;
    }
    
    
    
}
