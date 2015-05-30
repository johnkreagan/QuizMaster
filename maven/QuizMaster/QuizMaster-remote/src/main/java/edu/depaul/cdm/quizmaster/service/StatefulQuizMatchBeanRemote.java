/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
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

    boolean hasNextQuestion();
    
    Long submitAnswer(Long answerID);

    public QuizMatchDescriptor getQuizMatch();

    void submitQuizMatchForGrading();
    
    void notifyQuizMatchCompleteObservers(); 
    
}
