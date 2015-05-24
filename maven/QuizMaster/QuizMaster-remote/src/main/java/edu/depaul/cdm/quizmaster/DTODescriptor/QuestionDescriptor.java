/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.DTODescriptor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class QuestionDescriptor extends Descriptor implements Serializable {
    
    public QuestionDescriptor() {
        this.answers = new ArrayList<>();
    }
    
    private String questionText;

    private List<AnswerDescriptor> answers;
    
    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
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
