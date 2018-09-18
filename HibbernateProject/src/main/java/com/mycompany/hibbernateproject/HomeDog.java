/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibbernateproject;

import javax.persistence.Entity;

/**
 *
 * @author kerch
 */
@Entity
public class HomeDog extends Dog{

    private String home;
    
    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
    
    
    
}
