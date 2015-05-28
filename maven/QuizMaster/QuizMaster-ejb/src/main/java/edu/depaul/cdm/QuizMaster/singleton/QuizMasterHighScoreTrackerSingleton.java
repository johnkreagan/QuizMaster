/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.singleton;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
import edu.depaul.cdm.QuizMaster.entities.QuizMatch;
import java.util.List;
import javax.ejb.Stateful;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author John
 */
@Stateful
public class QuizMasterHighScoreTrackerSingleton implements QuizMasterHighScoreTrackerSingletonRemote, MessageListener {

    
    private List<QuizMatchDescriptor> highScores;
    
    @Override
    public void onMessage(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void submitScoredQuizMatch(QuizMatchDescriptor scoredQuizMatch) {
        
        
        
    }

    @Override
    public List<QuizMatchDescriptor> getHighScores() {
        return null;
    }
    
    
    
}
