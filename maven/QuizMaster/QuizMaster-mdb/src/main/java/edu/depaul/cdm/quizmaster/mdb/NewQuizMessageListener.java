/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.quizmaster.mdb;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.entities.Quiz;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author John
 */
@MessageDriven(mappedName="jms/QuizMasterNewQuizTopic", 
        activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    //@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QuizMasterNewQuizTopic"),
    //@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "NewQuizMessageListener"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "NewQuizMessageListener")
    //@ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/QuizMasterNewQuizTopic"),
    //@ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/QuizMasterNewQuizTopic")
})
public class NewQuizMessageListener implements MessageListener {
    
    public NewQuizMessageListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        ObjectMessage m = (ObjectMessage)message;
        
        
        
        try {
            QuizDescriptor q = (QuizDescriptor)m.getObject();
            
            System.out.println(q);
        } catch (JMSException ex) {
            Logger.getLogger(NewQuizMessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
