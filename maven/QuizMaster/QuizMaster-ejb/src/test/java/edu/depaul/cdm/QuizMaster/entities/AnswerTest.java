/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
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
public class AnswerTest {
    
    public AnswerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Answer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Answer instance = new Answer();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Answer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Answer instance = new Answer();
        instance.setId(id);
    }

    /**
     * Test of getAnswerText method, of class Answer.
     */
    @Test
    public void testGetAnswerText() {
        System.out.println("getAnswerText");
        Answer instance = new Answer();
        String sampleAnswerText = "Sample Text";
                instance.setAnswerText(sampleAnswerText);
        String result = instance.getAnswerText();
        assertEquals(sampleAnswerText, result);
    }

    /**
     * Test of setAnswerText method, of class Answer.
     */
    @Test
    public void testSetAnswerText() {
        System.out.println("setAnswerText");
        String answerText = "";
        Answer instance = new Answer();
        instance.setAnswerText(answerText);
    }

    /**
     * Test of getQuestion method, of class Answer.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        Answer instance = new Answer();
        Question expResult = null;
        Question result = instance.getQuestion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestion method, of class Answer.
     */
    @Test
    public void testSetQuestion() {
        System.out.println("setQuestion");
        Question question = null;
        Answer instance = new Answer();
        instance.setQuestion(question);
    }

    /**
     * Test of hashCode method, of class Answer.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Answer instance = new Answer();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Answer.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Answer instance = new Answer();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Answer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Answer instance = new Answer();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of isCorrectAnswer method, of class Answer.
     */
    @Test
    public void testIsCorrectAnswer() {
        System.out.println("isCorrectAnswer");
        Answer instance = new Answer();
        boolean expResult = false;
        boolean result = instance.isCorrectAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescriptor method, of class Answer.
     */
    @Test
    public void testGetDescriptor() {
        System.out.println("getDescriptor");
        
        Long id = 1L;
        String answerText = "questionText";
        
        Answer instance = new Answer();
        instance.setId(id);
        instance.setAnswerText(answerText);
        
        
        AnswerDescriptor result = (AnswerDescriptor)instance.getDescriptor();
        
        assertEquals(id, result.getId());
        assertEquals(answerText, result.getName());
        assertEquals(answerText, result.getAnswerText());
        
    }
    
}
