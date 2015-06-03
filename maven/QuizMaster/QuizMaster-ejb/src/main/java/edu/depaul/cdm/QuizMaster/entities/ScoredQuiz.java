/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor.QuizType;
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
@DiscriminatorValue(ScoredQuiz.DISCRIMINATOR_VALUE)
@XmlRootElement
public class ScoredQuiz extends Quiz implements Serializable {
    
    public static final String DISCRIMINATOR_VALUE = "SCORED";
    
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof ScoredQuiz)) {
//            return false;
//        }
//        ScoredQuiz other = (ScoredQuiz) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "edu.depaul.cdm.QuizMaster.entities.ScoredQuiz[ id=" + this.getId() + " ]";
    }

    @Override
    public QuizDescriptor.QuizType getDescriptorType() {
        return QuizType.Scored;
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
