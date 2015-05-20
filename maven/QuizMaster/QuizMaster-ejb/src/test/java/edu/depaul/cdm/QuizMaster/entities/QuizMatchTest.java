/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.entities;

import edu.depaul.cdm.QuizMaster.DTODescriptor.Descriptor;
import java.util.Date;
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
public class QuizMatchTest {
    
    public QuizMatchTest() {
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
     * Test of getId method, of class QuizMatch.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        QuizMatch instance = new QuizMatch();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class QuizMatch.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        QuizMatch instance = new QuizMatch();
        instance.setId(id);
    }

    /**
     * Test of getPlayer method, of class QuizMatch.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        QuizMatch instance = new QuizMatch();
        Player expResult = null;
        Player result = instance.getPlayer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlayer method, of class QuizMatch.
     */
    @Test
    public void testSetPlayer() {
        System.out.println("setPlayer");
        Player player = null;
        QuizMatch instance = new QuizMatch();
        instance.setPlayer(player);
    }

    /**
     * Test of getQuiz method, of class QuizMatch.
     */
    @Test
    public void testGetQuiz() {
        System.out.println("getQuiz");
        QuizMatch instance = new QuizMatch();
        Quiz expResult = null;
        Quiz result = instance.getQuiz();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuiz method, of class QuizMatch.
     */
    @Test
    public void testSetQuiz() {
        System.out.println("setQuiz");
        Quiz quiz = null;
        QuizMatch instance = new QuizMatch();
        instance.setQuiz(quiz);
    }

    /**
     * Test of getDateCreated method, of class QuizMatch.
     */
    @Test
    public void testGetDateCreated() {
        System.out.println("getDateCreated");
        QuizMatch instance = new QuizMatch();
        Date expResult = null;
        Date result = instance.getDateCreated();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateCreated method, of class QuizMatch.
     */
    @Test
    public void testSetDateCreated() {
        System.out.println("setDateCreated");
        Date dateCreated = null;
        QuizMatch instance = new QuizMatch();
        instance.setDateCreated(dateCreated);
    }

    /**
     * Test of getAnswers method, of class QuizMatch.
     */
    @Test
    public void testGetAnswers() {
        System.out.println("getAnswers");
        QuizMatch instance = new QuizMatch();
        List<Answer> result = instance.getAnswers();
        assertEquals(0, result.size());
    }

    /**
     * Test of setAnswers method, of class QuizMatch.
     */
    @Test
    public void testSetAnswers() {
        System.out.println("setAnswers");
        List<Answer> answers = null;
        QuizMatch instance = new QuizMatch();
        instance.setAnswers(answers);
    }

    /**
     * Test of addAnswer method, of class QuizMatch.
     */
    @Test
    public void testAddAnswer() {
        System.out.println("addAnswer");
        Answer answer = null;
        QuizMatch instance = new QuizMatch();
        instance.addAnswer(answer);
    }

    /**
     * Test of getDateScored method, of class QuizMatch.
     */
    @Test
    public void testGetDateScored() {
        System.out.println("getDateScored");
        QuizMatch instance = new QuizMatch();
        Date expResult = null;
        Date result = instance.getDateScored();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateScored method, of class QuizMatch.
     */
    @Test
    public void testSetDateScored() {
        System.out.println("setDateScored");
        Date dateScored = null;
        QuizMatch instance = new QuizMatch();
        instance.setDateScored(dateScored);
    }

    /**
     * Test of getScore method, of class QuizMatch.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        QuizMatch instance = new QuizMatch();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScore method, of class QuizMatch.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        QuizMatch instance = new QuizMatch();
        instance.setScore(score);
    }

    /**
     * Test of hashCode method, of class QuizMatch.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        QuizMatch instance = new QuizMatch();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class QuizMatch.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        QuizMatch instance = new QuizMatch();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class QuizMatch.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        QuizMatch instance = new QuizMatch();
        String expResult = instance.toString();
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescriptor method, of class QuizMatch.
     */
    @Test
    public void testGetDescriptor() {
        System.out.println("getDescriptor");
        QuizMatch instance = new QuizMatch();
        instance.setId(1L);
        
        
        Descriptor result = instance.getDescriptor();
        assertEquals(instance.getId(), result.getId());
    }
    
}
