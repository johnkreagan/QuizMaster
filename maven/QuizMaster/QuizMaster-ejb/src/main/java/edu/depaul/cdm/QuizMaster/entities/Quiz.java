/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.IDescriptable;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author johnreagan
 */
@Entity
@NamedQuery(name="findAllQuizzes", query="SELECT q FROM Quiz q")
@Inheritance
@DiscriminatorColumn(name="QUIZ_TYPE")
public abstract class Quiz implements Serializable, IDescriptable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="quiz", cascade=CascadeType.PERSIST)
    private List<Question> questions = new ArrayList<>();
    
    private String quizName;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the value of Questions
     *
     * @return the value of Questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Set the value of Questions
     *
     * @param Questions new value of Questions
     */
    public void setQuestions(List<Question> Questions) {
        this.questions = Questions;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
    @Override
    public QuizDescriptor getDescriptor() {
        
        QuizDescriptor qd = new QuizDescriptor();
        
        qd.id = this.getId();
        qd.name = this.getQuizName();

        for (Question question : this.getQuestions()) {
            qd.addQuestion((QuestionDescriptor)question.getDescriptor());
        }
        
        return qd;
        
    }
    
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    
    
    
//    public void addQuestion(Question q) {
//        this.questions.add(q);
//    }
//    
//    public void removeQuestion(Question q) {
//        this.questions.remove(q);
//    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.depaul.cdm.jreagan1.QuizMaster.Quiz[ id=" + id + " ]";
    }


    
}
