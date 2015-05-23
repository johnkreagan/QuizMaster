/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author John
 */
public class QuizTest {
    
    public QuizTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Quiz testQuiz;
    
    @Before
    public void setUp() {
        
        testQuiz = new ScoredQuiz();
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Quiz.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Quiz instance = testQuiz;
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Quiz.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Quiz instance = testQuiz;
        instance.setId(id);
    }

    /**
     * Test of getQuestions method, of class Quiz.
     */
    @Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        Quiz instance = testQuiz;
        List<Question> expResult = null;
        List<Question> result = instance.getQuestions();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestions method, of class Quiz.
     */
    @Test
    public void testSetQuestions() {
        System.out.println("setQuestions");
        List<Question> Questions = null;
        Quiz instance = testQuiz;
        instance.setQuestions(Questions);
    }

    /**
     * Test of getQuizName method, of class Quiz.
     */
    @Test
    public void testGetQuizName() {
        System.out.println("getQuizName");
        Quiz instance = testQuiz;
        String expResult = "QUIZNAME";
        instance.setQuizName(expResult);
        String result = instance.getQuizName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuizName method, of class Quiz.
     */
    @Test
    public void testSetQuizName() {
        System.out.println("setQuizName");
        String quizName = "";
        Quiz instance = testQuiz;
        instance.setQuizName(quizName);
    }

    /**
     * Test of getDescriptor method, of class Quiz.
     */
    @Test
    public void testGetDescriptor() {
        System.out.println("getDescriptor");
        Quiz instance = testQuiz;
        instance.setId(Long.MIN_VALUE);
        instance.setQuizName("QUIZNAME");
        
        QuizDescriptor result = instance.getDescriptor();
        assertEquals(instance.getId(), result.getId());
        assertEquals(instance.getQuizName(), result.getName());
    }

    /**
     * Test of hashCode method, of class Quiz.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Quiz instance = testQuiz;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Quiz.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Quiz instance = testQuiz;
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Quiz.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Quiz instance = testQuiz;
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
