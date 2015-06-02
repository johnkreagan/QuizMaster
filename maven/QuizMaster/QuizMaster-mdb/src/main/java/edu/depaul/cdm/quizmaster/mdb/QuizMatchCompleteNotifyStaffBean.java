/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.quizmaster.mdb;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
import edu.depaul.cdm.QuizMaster.service.QuizBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

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
    
    private static final Logger logger = Logger.getLogger(QuizMatchCompleteNotifyStaffBean.class.getName());
    
    public QuizMatchCompleteNotifyStaffBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            
            ObjectMessage om = (ObjectMessage)message;
            QuizMatchDescriptor qmd = (QuizMatchDescriptor)om.getObject();
            
            //Notify the staff via email
            logger.log(Level.FINEST, "New QuizMatch complete message received: {0}  QN: {1} PN: {2}", new Object[]{qmd.getId(), qmd.getQuiz().getName(), qmd.getPlayer().getName()});
            
        } catch(Exception e) {
            logger.log(Level.FINEST, "Uh Oh! Couldnt notify the staff {0}", new Object[]{ e.getMessage() });
        }
        
    }
    
}
