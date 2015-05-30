/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.IDescriptable;
import edu.depaul.cdm.QuizMaster.DTODescriptor.PlayerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johnreagan
 */
@Entity
@XmlRootElement
public class Question implements IDescriptable, Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;

    @Column(name="question_text")
    private String questionText;
    
    @OneToMany(mappedBy="question", cascade=CascadeType.PERSIST)
    private List<Answer> answers = new ArrayList<>();
    
    @OneToOne
    private Answer correctAnswer;
    
    /**
     * Get the value of quiz
     *
     * @return the value of quiz
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Set the value of quiz
     *
     * @param quiz new value of quiz
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * Get the value of questionText
     *
     * @return the value of questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * Set the value of questionText
     *
     * @param text new value of questionText
     */
    public void setQuestionText(String text) {
        this.questionText = text;
    }

    @XmlTransient
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
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
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.cdm.jreagan1.QuizMaster.Question[ id=" + id + " ]";
    }
    
   @Override
    public Descriptor getDescriptor() {
        
        QuestionDescriptor ques = new QuestionDescriptor();
        ques.setId(this.getId());
        ques.setName(this.getQuestionText());
        ques.setQuestionText(this.getQuestionText());
        
        for (Answer answer : this.getAnswers()) {
            ques.addAnswer((AnswerDescriptor)answer.getDescriptor());
        }
        
        return ques;
    }
    
}
