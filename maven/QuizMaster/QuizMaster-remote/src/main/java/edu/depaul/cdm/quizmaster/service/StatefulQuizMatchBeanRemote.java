/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import javax.ejb.Remote;

/**
 *
 * @author John
 */
@Remote
public interface StatefulQuizMatchBeanRemote  {

    long startQuiz(long quizID, long playerID);

    QuestionDescriptor getCurrentQuestion();

    QuestionDescriptor goToNextQuestion();

    Long submitAnswer(Long answerID);
    
}
