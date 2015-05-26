/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.factories;

import edu.depaul.cdm.QuizMaster.entities.Answer;
import edu.depaul.cdm.QuizMaster.entities.Quiz;
import edu.depaul.cdm.QuizMaster.entities.ScoredQuestion;
import edu.depaul.cdm.QuizMaster.entities.ScoredQuiz;
import edu.depaul.cdm.QuizMaster.entities.SurveyQuestion;
import edu.depaul.cdm.QuizMaster.entities.SurveyQuiz;
import edu.depaul.cdm.QuizMaster.entities.WeightedAnswer;
import java.util.Map;

/**
 *
 * @author John
 */
public class QuizFactory {
    
    public enum QuizType {
        Scored,
        Survey
    }
    
    public static Quiz CreateQuiz(String quizName, QuizType quizType) {
        
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
        
        return (SurveyQuiz)QuizFactory.CreateQuiz(quizName, QuizType.Survey);
        
    }
    
    public static ScoredQuiz CreateScoredQuiz(String quizName) {
        
        return (ScoredQuiz)QuizFactory.CreateQuiz(quizName, QuizType.Scored);
        
    }
    
    private Quiz currentQuiz;
    
    public void initiateQuiz(String quizName, QuizType quizType) {
        currentQuiz = QuizFactory.CreateQuiz(quizName, quizType);
    }
    
    public void addSurveyQuestion(String questionText, int weight, Map<String,Integer> answersWithWeight) {
        SurveyQuestion sq = new SurveyQuestion();
        sq.setQuiz(currentQuiz);
        currentQuiz.addQuestion(sq);
        sq.setQuestionText(questionText);
        sq.setWeight(weight);
        
        if (answersWithWeight != null) {
            WeightedAnswer wa;
            for (String answerText : answersWithWeight.keySet()) {
                wa = new WeightedAnswer();
                wa.setAnswerText(answerText);
                wa.setQuestion(sq);
                sq.addAnswer(wa);
                wa.setWeight(answersWithWeight.get(answerText));
                
            }
        }
        
    }
    
    public void addQuestion(String questionText,  Map<String,Boolean> answersWithCorrectFlag) {
        ScoredQuestion sq = new ScoredQuestion();
        sq.setQuiz(currentQuiz);
        currentQuiz.addQuestion(sq);
        sq.setQuestionText(questionText);
        
        if (answersWithCorrectFlag != null) {
            Answer wa;
            for (String answerText : answersWithCorrectFlag.keySet()) {
                wa = new Answer();
                wa.setAnswerText(answerText);
                wa.setQuestion(sq);
                sq.addAnswer(wa);
                
            }
        }
        
    }
    
    public Quiz getQuiz() {
        return this.currentQuiz;
    }
    
}
