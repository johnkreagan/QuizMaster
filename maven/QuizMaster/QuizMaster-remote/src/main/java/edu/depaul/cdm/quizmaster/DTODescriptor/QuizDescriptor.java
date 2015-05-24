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
public class QuizDescriptor extends Descriptor implements Serializable {
    
    public QuizDescriptor() {
        this.questions = new ArrayList<>();
    }
    
    private List<QuestionDescriptor> questions;

    public List<QuestionDescriptor> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDescriptor> questions) {
        this.questions = questions;
    }
    
    public void addQuestion(QuestionDescriptor question) {
        this.questions.add(question);
    }
    
    
}
