/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import javax.ejb.Remote;

/**
 *
 * @author John
 */
@Remote
public interface StatefulQuizBeanRemote {

    Long createQuiz(String QuizName, String QuizTypeString);

    Long addQuestion(String questionTitle);

    Long addAnswer(long questionID, String answerText);

    void setCorrectAnswer(long questionID, long answerID);

    public QuizDescriptor getCurrentQuiz();
    
}
