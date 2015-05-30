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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("ViewAll")
    public List<QuizDescriptor> viewAll() {
        
        
        return this.quizBean.GetAllQuizzes();
        
    }
}
