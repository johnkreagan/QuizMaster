/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.singleton;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author John
 */
@Remote
public interface QuizMasterHighScoreTrackerSingletonRemote {

    void submitScoredQuizMatch(QuizMatchDescriptor scoredQuizMatch);

    List<QuizMatchDescriptor> getHighScores();
    
}
