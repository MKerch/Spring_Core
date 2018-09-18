/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibbernateproject;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 *
 * @author kerch
 */

public class BerdListener {

    @PrePersist
    public void beforeSafe(Object o){
        System.out.println("Before safe");
    }   
    
    @PostPersist
    public void afterSafe(Object o){
        System.out.println("After safe");
    }   
    
    
    
}
