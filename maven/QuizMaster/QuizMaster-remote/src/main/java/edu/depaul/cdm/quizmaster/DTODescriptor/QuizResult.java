/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.DTODescriptor;

import java.io.Serializable;

/**
 *
 * @author John
 */
public class QuizResult implements Serializable, Comparable {
    
    public int score;
    
    public String detail;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int compareTo(Object o) {
        QuizResult c2 = (QuizResult)o;
        return this.getScore() > c2.getScore() ? -1 : 1;
        
    }
    
    
    
}
