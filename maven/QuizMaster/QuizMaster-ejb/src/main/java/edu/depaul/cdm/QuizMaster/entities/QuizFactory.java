/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

/**
 *
 * @author John
 */
public class QuizFactory {
    
    public static Quiz CreateQuiz(String quizName, String quizType) {
        
        Quiz q;
        
        //first determine type of object to create. Use a factory instead?
        if(quizType.equals(SurveyQuiz.DISCRIMINATOR_VALUE)) {
            q = new SurveyQuiz();
        } else {
            q = new ScoredQuiz();
        }
        
        q.setQuizName(quizName);
        
        return q;
        
    }
    
    public static SurveyQuiz CreateSurvey(String quizName) {
        
        return (SurveyQuiz)QuizFactory.CreateQuiz(quizName, SurveyQuiz.DISCRIMINATOR_VALUE);
        
    }
    
    public static ScoredQuiz CreateScoredQuiz(String quizName) {
        
        return (ScoredQuiz)QuizFactory.CreateQuiz(quizName, ScoredQuiz.DISCRIMINATOR_VALUE);
        
    }
    
}
