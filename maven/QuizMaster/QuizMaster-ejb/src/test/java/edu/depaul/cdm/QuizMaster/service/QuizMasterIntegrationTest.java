/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizResult;
import edu.depaul.cdm.QuizMaster.singleton.HighScoreSingletonBean;
import edu.depaul.cdm.QuizMaster.singleton.HighScoreSingletonBeanRemote;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import edu.depaul.cdm.QuizMasterRemote.QuizMatchRemote;
import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.ejb.Stateless;
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
public class QuizMasterIntegrationTest {
    
    public static interface Caller {
        public <V> V call(Callable<V> callable) throws Exception;
    }

    /**
     * This little bit of magic allows our test code to execute in
     * the desired security scope.
     */

    @Stateless
    @RunAs("admin")
    public class AdminBean implements Caller {

        public <V> V call(Callable<V> callable) throws Exception {
            return callable.call();
        }
    }
    
    public QuizMasterIntegrationTest() {
    }
    //@EJB(name = "AdminBean")
    private Caller admin = new AdminBean();
    
    private static EJBContainer ec;
    private static Context ctx;
    private QuizBeanRemote quizBean;
    private AdminTestBeanLocal adminBean;
    private HighScoreSingletonBeanRemote highScore;
    private QuizMatchRemote quizMatchBean;
    @BeforeClass
    public static void setUpClass() throws NamingException, Exception {
        
        
        
        Properties props = new Properties();
        props.put(EJBContainer.MODULES, new File("target/classes"));
//        props.put("org.glassfish.ejb.embedded.glassfish.installation.root", 
//                "/Applications/Netbeans/glassfish-4.0/glassfish");
        //props.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "/Applications/NetBeans/glassfish-4.0/glassfish/domains/domain1/config/domain.xml");
        props.put("javax.enterprise.systemcore.security.level", 
                "FINE");
//        
        //props.put("org.glassfish.ejb.embedded.glassfish.web.http.port","");
        props.put("org.glassfish.ejb.embedded.glassfish.configuration.file", "./src/test/resources/testing-domain/config/domain.xml");
        ec = EJBContainer.createEJBContainer(props);

        
        
        //ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
        
        NamingEnumeration<NameClassPair> list = ctx.list("");
        while (list.hasMore()) {
          System.out.println(list.next().getName());
        }
        
        ProgrammaticLogin l = new ProgrammaticLogin();
        l.login("john", "password".toCharArray());
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        try {
            ctx.close();
        } catch(Exception e) {
            
        }
        ec.close();
        
    }
    
    @Before
    public void setUp() throws NamingException, Exception {
        ctx.rebind("inject", this);
        quizBean = (QuizBeanRemote)ctx.lookup("java:global/classes/QuizBean");
        adminBean = (AdminTestBeanLocal)ctx.lookup("java:global/classes/AdminTestBean");
        highScore = (HighScoreSingletonBeanRemote)ctx.lookup("java:global/classes/HighScoreSingletonBean");
        quizMatchBean = (QuizMatchRemote)ctx.lookup("java:global/classes/QuizMatchBean");
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
        
        //assert(quizBean.GetAllQuizzes().isEmpty());
        int initialCount = quizBean.GetAllQuizzes().size();
        quizBean.CreateQuiz("Quiz 1", 1);
        
        quizBean.CreateQuiz("Quiz 2", 1);
        
        quizBean.CreateQuiz("Quiz 3", 1);
        
        assert(quizBean.GetAllQuizzes().size() == initialCount + 3);
        
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
    
    @Test(expected = EJBAccessException.class)
    public void testDeleteQuiz() {
        
        long quizID = quizBean.CreateQuiz("NAME", 1);
        
        QuizDescriptor qd = quizBean.GetQuiz(quizID);
        
        assert(quizID == qd.getId());
        
        quizBean.DeleteQuiz(quizID);
        
        qd = quizBean.GetQuiz(quizID);
        
        assert(qd == null);
 
    }
    
    @Test//(expected = EJBAccessException.class)
    public void testDeleteQuestion() throws Exception {
        
        
        adminBean.call(new Callable() {
            public Object call() throws Exception { 
                long quizID = quizBean.CreateQuiz("NAME", 1);
        
                long question1ID = quizBean.AddQuestion(quizID, "Question 1");
                long question2ID = quizBean.AddQuestion(quizID, "QUestion 2");


                QuizDescriptor qd = quizBean.GetQuiz(quizID);

                assert(qd.getQuestions().size() == 2);
                
            
                quizBean.DeleteQuestion(question1ID);

                qd = quizBean.GetQuiz(quizID);

                assert(qd.getQuestions().size() == 1);

                quizBean.DeleteQuestion(question2ID);

                qd = quizBean.GetQuiz(quizID);

                assert(qd.getQuestions().isEmpty());
                return null;

             }});
        
        
        
        
    }
    
    
    @Test
    public void TestSingletonHighScoreBean() {
        
        //repeat lookup and assert equal
        HighScoreSingletonBeanRemote rem = null;
        try {
            
            rem = (HighScoreSingletonBeanRemote)ctx.lookup("java:global/classes/HighScoreSingletonBean");
        } catch(NamingException ne) {
            
        }
        
        
        assert(highScore.equals(rem));
        
        QuizDescriptor qd = new QuizDescriptor();
        qd.setId(1L);
        qd.setName("QuizName");
        
        QuizResult qr1 = new QuizResult();
        qr1.setScore(100);
        qr1.setDetail("Detail");
        
        QuizResult qr2 = new QuizResult();
        qr2.setScore(100);
        qr2.setDetail("Detail");
        
        highScore.addHighScore(qd, qr1);
        
        assert(highScore.getScoresForQuizID(1L).size() == 1);
        highScore.addHighScore(qd, qr2);
        assert(highScore.getScoresForQuizID(1L).size() == 2);
    }
    
    @Test
    public void testQuizMatchCreate() {
        long qmID = quizMatchBean.StartQuizMatch(1L, 1L);
        assert(qmID > 0);
    }
    
    @Test
    public void testSubmitAnswer() {
        
        Long qdID = quizBean.CreateQuiz("Name 1", 1);
        
        Long question1ID = quizBean.AddQuestion(qdID, "Question 1");
        Long correctAnswerID = quizBean.AddAnswer(question1ID, "Answer 1");
        quizBean.AddAnswer(question1ID, "Answer 2");
        quizBean.AddAnswer(question1ID, "Answer 3");
        quizBean.AddAnswer(question1ID, "Answer 4");
        
        quizBean.SetCorrectAnswer(question1ID, correctAnswerID);
        
        QuizDescriptor qd = quizBean.GetQuiz(qdID);
        long qmID = quizMatchBean.StartQuizMatch(qdID, 1L);
        
        quizMatchBean.AnswerQuestion(qmID, question1ID, correctAnswerID);
        QuizResult res = quizMatchBean.GradeQuizMatch(qmID);
        assert(res.getScore() == 1);
        
    }
    
}   
    
    
    

    
    

