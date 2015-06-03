/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

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
    
    @EJB
    private QuizBean quizBean;
    
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
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllQuizzes() throws Exception {
        
        
        
        QuizBeanRemote qbr = (QuizBeanRemote)ctx.lookup("java:global/classes/QuizBean");
        
        qbr.CreateQuiz("Quiz 1", 1);
        
        qbr.CreateQuiz("Quiz 2", 1);
        
        qbr.CreateQuiz("Quiz 3", 1);
        
        assert(qbr.GetAllQuizzes().size() > 0);
        
    }
    

    
    
}
