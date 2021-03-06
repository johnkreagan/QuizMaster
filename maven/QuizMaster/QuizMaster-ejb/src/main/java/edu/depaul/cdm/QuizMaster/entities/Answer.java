/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.IDescriptable;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnreagan
 */
@Entity
@XmlRootElement
public class Answer implements IDescriptable, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="QUESTION_ID")
    private Question question;
    
    private String answerText;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.cdm.jreagan1.QuizMaster.Answer[ id=" + id + " ]";
    }

    public boolean isCorrectAnswer() {
        try {
           return this.getQuestion().getCorrectAnswer().equals(this); 
        } catch(Exception e) {
            //assume we have no quiz or question. If so, we arent the correct answer. Return false
        }
        return false;
    }

    @Override
    public Descriptor getDescriptor() {
        
        AnswerDescriptor ans = new AnswerDescriptor();
        ans.setId(this.getId());
        ans.setName(this.getAnswerText());
        ans.setAnswerText(this.getAnswerText());
        
        return ans;
    }
    
}
