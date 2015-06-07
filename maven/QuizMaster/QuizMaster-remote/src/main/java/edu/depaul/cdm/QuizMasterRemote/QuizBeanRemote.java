/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMasterRemote;

import edu.depaul.cdm.QuizMaster.DTODescriptor.PlayerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import java.io.Serializable;
import javax.ejb.Remote;
import java.util.List;


/**
 *
 * @author John
 */
@Remote
public interface QuizBeanRemote extends Serializable {

    long CreateQuiz(String name, int type);
    
    long AddQuestion(long quizID, String questionTitle);
    
    long AddAnswer(long questionID, String answerText);
    
    long AddSurveyRange(long quizID, String rangeText, int lowScore, int highScore);
    
    void SetCorrectAnswer(long questionID, long answerID);
    
    void DeleteQuiz(long quizID);
    
    void DeleteQuestion(long questionID);
    
    QuizDescriptor GetQuiz(long quizID);
    
    List<QuizDescriptor> GetAllQuizzes();
    
    List<PlayerDescriptor> GetAllPlayers();

    public void addDefaultQuestions();
}
