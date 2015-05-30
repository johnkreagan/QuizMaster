/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.soap;

import edu.depaul.cdm.QuizMaster.DTODescriptor.PlayerDescriptor;
import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author johnreagan
 */
@WebService(serviceName = "QuizService")
public class QuizService {
    @EJB
    private QuizBeanRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "CreateQuiz")
    public long CreateQuiz(@WebParam(name = "name") String name, @WebParam(name = "type") int type) {
        return ejbRef.CreateQuiz(name, type);
    }

    @WebMethod(operationName = "AddQuestion")
    public long AddQuestion(@WebParam(name = "quizID") long quizID, @WebParam(name = "questionTitle") String questionTitle, @WebParam(name = "questionWeight") float questionWeight) {
        return ejbRef.AddQuestion(quizID, questionTitle, questionWeight);
    }

    @WebMethod(operationName = "AddAnswer")
    public long AddAnswer(@WebParam(name = "questionID") long questionID, @WebParam(name = "answerText") String answerText, @WebParam(name = "answerValue") float answerValue) {
        return ejbRef.AddAnswer(questionID, answerText, answerValue);
    }

    @WebMethod(operationName = "SetCorrectAnswer")
    @Oneway
    public void SetCorrectAnswer(@WebParam(name = "questionID") long questionID, @WebParam(name = "answerID") long answerID) {
        ejbRef.SetCorrectAnswer(questionID, answerID);
    }

    @WebMethod(operationName = "GetQuiz")
    public QuizDescriptor GetQuiz(@WebParam(name = "quizID") long quizID) {
        return ejbRef.GetQuiz(quizID);
    }

    @WebMethod(operationName = "GetAllQuizzes")
    public List<QuizDescriptor> GetAllQuizzes() {
        return ejbRef.GetAllQuizzes();
    }

    @WebMethod(operationName = "GetAllPlayers")
    public List<PlayerDescriptor> GetAllPlayers() {
        return ejbRef.GetAllPlayers();
    }

    @WebMethod(operationName = "addDefaultQuestions")
    @Oneway
    public void addDefaultQuestions() {
        ejbRef.addDefaultQuestions();
    }
    
}
