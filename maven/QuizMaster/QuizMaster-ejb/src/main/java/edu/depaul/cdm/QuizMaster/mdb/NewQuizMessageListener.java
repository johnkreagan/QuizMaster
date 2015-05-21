/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author John
 */
@MessageDriven(mappedName="jms/QuizMasterNewQuizTopic", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    //@ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QuizMasterNewQuizTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
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
        
        TextMessage m = (TextMessage)message;
        
        
        
    }
    
}
