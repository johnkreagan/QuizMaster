/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizResult;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John
 */
@Entity
@DiscriminatorValue(SurveyQuiz.DISCRIMINATOR_VALUE)
@XmlRootElement
public class SurveyQuiz extends Quiz implements Serializable {
    
    public static final String DISCRIMINATOR_VALUE = "SURVEY";
    
    public SurveyQuiz() {
        this.ranges = new ArrayList<>();
    }
    
    private List<SurveyQuizResultRange> ranges;

    public List<SurveyQuizResultRange> getRanges() {
        return ranges;
    }

    public void setRanges(List<SurveyQuizResultRange> ranges) {
        this.ranges = ranges;
    }
    
    public void addRange(SurveyQuizResultRange range) {
        this.ranges.add(range);
    }
    
    public void removeRange(SurveyQuizResultRange range) {
        this.ranges.remove(range);
    }
    
    @Override
    public QuizDescriptor.QuizType getDescriptorType() {
        return QuizDescriptor.QuizType.Survey;
    }

    @Override
    public String toString() {
        return "edu.depaul.cdm.QuizMaster.entities.SurveyQuiz[ id=" + this.getId() + " ]";
    }

    @Override
    public QuizResult getResults(List<Answer> answers) {
                List<Answer> correctAnswerList = new ArrayList<>();
        List<Answer> incorrectAnswerList = new ArrayList<>();
        
        for (Answer answer : answers) {
            if (answer.isCorrectAnswer()) {
                correctAnswerList.add(answer);
            } else {
                incorrectAnswerList.add(answer);
            }
        }
        
        int questionCount = this.getQuestions().size();

        QuizResult qr = new QuizResult();
        
        qr.setScore(correctAnswerList.size());
        
       qr.setDetail("Answered " + correctAnswerList.size() + " of " + questionCount + " correctly.");
        
        
        return qr;
    }
    
}
