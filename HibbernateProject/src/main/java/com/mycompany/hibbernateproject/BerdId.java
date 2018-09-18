/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibbernateproject;

import javax.persistence.Embeddable;

/**
 *
 * @author kerch
 */
@Embeddable
public class BerdId {
    
    private int id;
    
    private String secondId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecondId() {
        return secondId;
    }

    public void setSecondId(String secondId) {
        this.secondId = secondId;
    }
    
    
}
