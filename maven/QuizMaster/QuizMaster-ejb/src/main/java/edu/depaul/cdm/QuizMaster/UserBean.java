/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author John
 */
@SessionScoped
@Named
public class UserBean implements Serializable {
    private static final Logger logger = Logger.getLogger(UserBean.class.getName());
    
    @PersistenceContext(unitName = "QuizMaster-WEBPU")
    private EntityManager entityManager;
     
    public List<User> getUserList() throws SQLException {
        logger.info("Before getting connection");
        List<User> list = new ArrayList<User>();
//        EntityManager em = this.entityManager;
//        logger.info("EM = " + em.toString());
//        logger.info("C = " + em.find(User.class, 1));
//        Query nm = em.createNamedQuery("getAllUsers", User.class);
//        List<User> list = nm.getResultList();
        list = entityManager.createNamedQuery("findAllUsers").getResultList();
        logger.log(Level.INFO, "Before returning: {0}", list.size());
        
        return list;
    }
}
