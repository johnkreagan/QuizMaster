/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
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
public class QuestionTest {
    
    public QuestionTest() {
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
     * Test of getId method, of class Question.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Question instance = new Question();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Question.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Question instance = new Question();
        instance.setId(id);
    }

    /**
     * Test of getQuiz method, of class Question.
     */
    @Test
    public void testGetQuiz() {
        System.out.println("getQuiz");
        Question instance = new Question();
        Quiz expResult = null;
        Quiz result = instance.getQuiz();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuiz method, of class Question.
     */
    @Test
    public void testSetQuiz() {
        System.out.println("setQuiz");
        Quiz quiz = null;
        Question instance = new Question();
        instance.setQuiz(quiz);
    }

    /**
     * Test of getQuestionText method, of class Question.
     */
    @Test
    public void testGetQuestionText() {
        System.out.println("getQuestionText");
        Question instance = new Question();
        String expResult = "QUESTIONTEXT";
        instance.setQuestionText(expResult);
        String result = instance.getQuestionText();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuestionText method, of class Question.
     */
    @Test
    public void testSetQuestionText() {
        System.out.println("setQuestionText");
        String text = "";
        Question instance = new Question();
        instance.setQuestionText(text);
    }

    /**
     * Test of getAnswers method, of class Question.
     */
    @Test
    public void testGetAnswers() {
        System.out.println("getAnswers");
        Question instance = new Question();
        int expResult = 0;
        List<Answer> result = instance.getAnswers();
        assertEquals(expResult, result.size());
    }

    /**
     * Test of setAnswers method, of class Question.
     */
    @Test
    public void testSetAnswers() {
        System.out.println("setAnswers");
        List<Answer> answers = null;
        Question instance = new Question();
        instance.setAnswers(answers);
    }

    /**
     * Test of getCorrectAnswer method, of class Question.
     */
    @Test
    public void testGetCorrectAnswer() {
        System.out.println("getCorrectAnswer");
        Question instance = new Question();
        Answer expResult = null;
        Answer result = instance.getCorrectAnswer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCorrectAnswer method, of class Question.
     */
    @Test
    public void testSetCorrectAnswer() {
        System.out.println("setCorrectAnswer");
        Answer correctAnswer = null;
        Question instance = new Question();
        instance.setCorrectAnswer(correctAnswer);
    }

    /**
     * Test of hashCode method, of class Question.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Question instance = new Question();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Question.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Question instance = new Question();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Question.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Question instance = new Question();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescriptor method, of class Question.
     */
    @Test
    public void testGetDescriptor() {
        System.out.println("getDescriptor");
        Question instance = new Question();
        Long id = 1L;
        String questionText = "QuestionTExt";
        instance.setId(id);
        instance.setQuestionText(questionText);
        
        Descriptor result = instance.getDescriptor();
        assertEquals(id, result.getId());
        assertEquals(questionText, result.getName());
    }
    
}
