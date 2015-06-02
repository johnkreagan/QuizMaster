/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
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
    public static void setUpClass() {
        Properties props = new Properties();
        props.put(EJBContainer.MODULES, new File("target/classes"));
        props.put(EJBContainer.APP_NAME, "QuizMaster");
        
        ec = EJBContainer.createEJBContainer(props);

        //ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
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
    public void testGetId() throws NamingException {
        
        System.out.println(QuizBeanTest.ctx.getNameInNamespace());
        
        assert(true);
        
    }
    
    @Test
    public void testQuizBeanInstance() {
        
        
        //quizBean.GetAllPlayers().isEmpty();
        assert(true);
    }
    
    
}
