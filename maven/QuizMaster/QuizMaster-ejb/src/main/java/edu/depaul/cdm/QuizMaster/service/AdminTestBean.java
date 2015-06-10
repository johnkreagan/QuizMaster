/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import java.util.concurrent.Callable;
import javax.annotation.security.RunAs;
import javax.ejb.Stateless;

/**
 *
 * @author johnreagan
 */
@Stateless
@RunAs("admin")
public class AdminTestBean implements AdminTestBeanLocal {

    @Override
    public <V> V call(Callable<V> callable) throws Exception {
            return callable.call();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
