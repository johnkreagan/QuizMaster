/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaulcdm.rest;

import edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor;
import edu.depaul.cdm.QuizMasterRemote.QuizBeanRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author johnreagan
 */
@Path("/QuizREST")
@Stateless
public class QuizResource {
    
    @EJB
    private QuizBeanRemote quizBean;
    
    @Context
    private UriInfo context;
    private Object MeidaType;
    
    public QuizResource() {
        
    }
    
    
    @GET
    @Path("/{quiz-id}")
    public Response getQuiz(@PathParam("quiz-id") long id ) {
        
        ResponseBuilder rb = Response.status(Response.Status.OK);
        
        QuizDescriptor qd = this.quizBean.GetQuiz(id);
        
        
        return rb.type(MediaType.APPLICATION_JSON_TYPE).entity(qd).build();
        
    }
    
    @POST
    @Path("create")
    public Response createQuiz(@FormParam("quizName") String quizName) {
        return Response.status(Response.Status.OK).entity(this.quizBean.CreateQuiz(quizName, 1)).build();
    }
    
    @POST
    @Path("addQuestion/{quiz-id}/")
    public Response addQuestion(@PathParam("quiz-id") long quizID, @FormParam("questionText") String questionText ) {
        
        Long answerID = this.quizBean.AddQuestion(quizID, questionText);
        return Response.status(Response.Status.OK).entity(answerID).build();
    }
    
    @DELETE
    @Path("/delete/{quiz-id}")
    public Response deleteQuiz(@PathParam("quiz-id") long quizID) {
        quizBean.DeleteQuiz(quizID);
        return Response.status(Response.Status.OK).entity("quiz deleted").build();
        
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ViewAll")
    public List<QuizDescriptor> viewAll() {
        
        return this.quizBean.GetAllQuizzes();
        
    }
    
    
}
