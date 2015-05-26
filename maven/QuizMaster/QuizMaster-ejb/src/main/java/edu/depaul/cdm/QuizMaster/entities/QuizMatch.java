/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.IDescriptable;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author John
 */
@Entity
public class QuizMatch implements IDescriptable, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE_CREATED")
    private Date dateCreated;
    
    @OneToOne
    private Player player;
    
    @OneToOne
    private Quiz quiz;
    
    @OneToMany
    private List<Answer> answers;
    
    @Temporal(TemporalType.DATE)
    @Column(name="DATE_SCORED")
    private Date dateScored;
    
    @Column
    private int score;
    
    public QuizMatch() {
        this.answers = new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public Date getDateScored() {
        return dateScored;
    }

    public void setDateScored(Date dateScored) {
        this.dateScored = dateScored;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
        if (!(object instanceof QuizMatch)) {
            return false;
        }
        QuizMatch other = (QuizMatch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.cdm.jreagan1.QuizMaster.QuizMatch[ id=" + id + " ]";
    }
    
    @Override
    public Descriptor getDescriptor() {
        QuizMatchDescriptor qmd = new QuizMatchDescriptor();
        
        qmd.setId(this.getId());
        qmd.setName("QuizMatchID: " + this.getId());
        
        for(Answer answer : this.getAnswers()) {
            qmd.addAnswer((AnswerDescriptor)answer.getDescriptor());
        }
        
        return qmd;
    }
    
}
