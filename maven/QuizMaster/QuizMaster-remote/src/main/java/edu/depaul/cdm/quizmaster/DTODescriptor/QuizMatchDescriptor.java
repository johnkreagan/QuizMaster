/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.DTODescriptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author John
 */
public class QuizMatchDescriptor extends Descriptor {
    
    public QuizMatchDescriptor() {
        this.answers = new HashMap<>();
    }
    
    private QuizDescriptor quiz;
    
    private PlayerDescriptor player;
    
    private Map<QuestionDescriptor,AnswerDescriptor> answers;

    private QuizResult result;
    
    public QuizDescriptor getQuiz() {
        return quiz;
    }

    public void setQuiz(QuizDescriptor quiz) {
        this.quiz = quiz;
    }

    public PlayerDescriptor getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDescriptor player) {
        this.player = player;
    }

    public Map<QuestionDescriptor,AnswerDescriptor> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<QuestionDescriptor,AnswerDescriptor> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(QuestionDescriptor question, AnswerDescriptor answer) {
        this.answers.put(question, answer);
    }

    public QuizResult getResult() {
        return result;
    }

    public void setResult(QuizResult result) {
        this.result = result;
    }
    
    
    
}
