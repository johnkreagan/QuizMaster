/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
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
public class QuizBeanTest {
    
    public QuizBeanTest() {
    }
    
    private static EJBContainer ec;
    private static Context ctx;
    private QuizBeanRemote quizBean;
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        Properties props = new Properties();
        props.put(EJBContainer.MODULES, new File("target/classes"));
        ec = EJBContainer.createEJBContainer(props);

        
        
        //ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
        
        NamingEnumeration<NameClassPair> list = ctx.list("");
        while (list.hasMore()) {
          System.out.println(list.next().getName());
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws NamingException {
        quizBean = (QuizBeanRemote)ctx.lookup("java:global/classes/QuizBean");
        
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void testCreateQuiz() {
        
        String name = "New Quiz";
        
        long id = quizBean.CreateQuiz(name, 1);
        
        List<QuizDescriptor> quizzes = quizBean.GetAllQuizzes();
        
        assert(quizzes.isEmpty() == false);
        //assert(quizzes..getName().equals(name));
        assert(id > 0);
    }
    
    
    @Test
    public void testGetAllQuizzes() throws Exception {
        
        assert(quizBean.GetAllQuizzes().isEmpty());
        
        quizBean.CreateQuiz("Quiz 1", 1);
        
        quizBean.CreateQuiz("Quiz 2", 1);
        
        quizBean.CreateQuiz("Quiz 3", 1);
        
        assert(quizBean.GetAllQuizzes().size() > 0);
        
    }
    
    @Test
    public void testAddQuestion() {
        
        long quizID = quizBean.CreateQuiz("Quiz 1", 1);
        
        long question1ID = quizBean.AddQuestion(quizID, "Question 1");
        assert(question1ID > 0);
        
        long question2ID = quizBean.AddQuestion(quizID, "Question 1");
        
        assert(question2ID > 0);
        
        QuizDescriptor qd = quizBean.GetQuiz(quizID);
        
        assert(qd.getQuestions().isEmpty() == false);
        assert(qd.getQuestions().size() == 2);
        
    }
    
    @Test
    public void testAddAnswer() {
        
        long quizID = quizBean.CreateQuiz("Quiz 1", 1);
        
        long question1ID = quizBean.AddQuestion(quizID, "Question 1");
        
        long answer1ID = quizBean.AddAnswer(question1ID, "Answer Test 1");
        long answer2ID = quizBean.AddAnswer(question1ID, "Answer Test 2");
        
        QuizDescriptor qd = quizBean.GetQuiz(quizID);
        
        QuestionDescriptor questionD = qd.getQuestions().get(0);
        
        assert(questionD.getAnswers().isEmpty() == false);
        assert(questionD.getAnswers().size() == 2);
        
        
        
    }
    
}
    
    
    

    
    

