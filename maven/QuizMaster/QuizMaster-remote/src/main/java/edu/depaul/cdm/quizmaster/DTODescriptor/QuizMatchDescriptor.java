/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.DTODescriptor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class QuizMatchDescriptor extends Descriptor {
    
    public QuizMatchDescriptor() {
        this.answers = new ArrayList<>();
    }
    
    private QuizDescriptor quiz;
    
    private PlayerDescriptor player;
    
    private List<AnswerDescriptor> answers;

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

    public List<AnswerDescriptor> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDescriptor> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(AnswerDescriptor answer) {
        this.answers.add(answer);
    }
    
    
    
}
