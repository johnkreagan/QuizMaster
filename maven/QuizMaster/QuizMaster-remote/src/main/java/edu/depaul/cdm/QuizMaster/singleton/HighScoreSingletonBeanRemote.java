/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.singleton;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizResult;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author johnreagan
 */
@Remote
public interface HighScoreSingletonBeanRemote {

    void addHighScore(QuizDescriptor qd, QuizResult result);
    
    List<QuizResult> getScoresForQuizID(long ID);
    
}
