/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMasterRemote;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizResult;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author John
 */
@Remote
public interface QuizMatchRemote extends Serializable {
    
    long StartQuizMatch(long quizID, long playerID);
    
    void AnswerQuestion(long quizMatchID, long questionID, long answerID);
    
    void AnswerQuestions(long quizMatchID, List<Long> answerIDs);
    
    QuizResult GradeQuizMatch(long quizMatchID);
    
    long GetScore(long quizMatchID);
    
    List GetScores(long quizID);
    
}
