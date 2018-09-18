/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibbernateproject;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author kerch
 */
@Entity
@EntityListeners({BerdListener.class})
public class Berd {

    @EmbeddedId
    private BerdId bi;
    
    @Enumerated(EnumType.ORDINAL)
    private ColorEnum color;
    
    @Enumerated(EnumType.STRING)
    private ColorEnum color2;
    
    public BerdId getBi() {
        return bi;
    }

    public void setBi(BerdId bi) {
        this.bi = bi;
    }
    
    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public ColorEnum getColor2() {
        return color2;
    }

    public void setColor2(ColorEnum color2) {
        this.color2 = color2;
    }
    
    
    
//    @Id
//    private int id;
//
//    public String getSecondID() {
//        return secondID;
//    }
//
//    public void setSecondID(String secondID) {
//        this.secondID = secondID;
//    }
    
//    @Id
//    private String secondID;
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
    
    private String name;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
