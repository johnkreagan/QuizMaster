/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.singleton;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizResult;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 *
 * @author johnreagan
 */
@Singleton
public class HighScoreSingletonBean implements HighScoreSingletonBeanRemote {

    
    public HighScoreSingletonBean() {
        results = new HashMap<>();
    }
    
    private Map<QuizDescriptor, SortedSet<QuizResult>> results;
    
    @Override
    public void addHighScore(QuizDescriptor qd, QuizResult result) {
        
        if (results.containsKey(qd)) {
            results.get(qd).add(result);
        } else {
            
            SortedSet<QuizResult> quizResults = new TreeSet<>();
            quizResults.add(result);
            results.put(qd, quizResults);
            
            
        }
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<QuizResult> getScoresForQuizID(long ID) {
        
        for(QuizDescriptor qd : results.keySet()) {
            if(qd.getId() == ID) {
                return new ArrayList<>(results.get(qd));
            }
        }
        return null;
    }
    
    
}
