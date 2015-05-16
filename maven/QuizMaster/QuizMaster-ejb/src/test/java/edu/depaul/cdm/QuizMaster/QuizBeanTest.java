/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster;

import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
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
    
    
    @BeforeClass
    public static void setUpClass() {
        Properties props = new Properties();
        props.put(EJBContainer.MODULES, new File("target/classes"));

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
     * Test of getLastBuiltQuiz method, of class QuizBean.
     */
    @org.junit.Test
    public void testGetLastBuiltQuiz() throws Exception {
        System.out.println("getLastBuiltQuiz");

        QuizBean instance = (QuizBean)ctx.lookup("java:global/classes/QuizBean");
        Quiz expResult = null;
        Quiz result = instance.getLastBuiltQuiz();
        assertEquals(expResult, result);
        ec.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
