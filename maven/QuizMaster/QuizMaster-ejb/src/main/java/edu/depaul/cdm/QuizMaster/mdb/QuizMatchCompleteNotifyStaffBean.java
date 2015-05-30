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

/**
 *
 * @author John
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/QuizMasterNewQuizMatchCompletedTopic"),
    //@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "durable"),
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/QuizMasterNewQuizMatchCompletedTopic"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/QuizMasterNewQuizMatchCompletedTopic")
})
public class QuizMatchCompleteNotifyStaffBean implements MessageListener {
    
    public QuizMatchCompleteNotifyStaffBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        
        
    }
    
}
