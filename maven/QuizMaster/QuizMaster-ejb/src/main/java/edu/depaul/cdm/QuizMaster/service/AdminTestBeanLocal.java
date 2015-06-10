/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.depaul.cdm.QuizMaster.service;

import java.util.concurrent.Callable;
import javax.ejb.Local;

/**
 *
 * @author johnreagan
 */
@Local
public interface AdminTestBeanLocal {
    public <V> V call(Callable<V> callable) throws Exception;
}
