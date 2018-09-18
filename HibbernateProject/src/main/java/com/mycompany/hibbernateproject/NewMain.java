/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibbernateproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author kerch
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_HibbernateProject");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //Dog dog = new Dog();
//        StreetDog sdog = new StreetDog();
//        sdog.setAge(2);
//        sdog.setName("bill");
//        sdog.setStreat("lenina");
//        HomeDog hdog = new HomeDog();
//        hdog.setAge(2);
//        hdog.setName("max");
//        hdog.setHome("house");
//        Dog dog = new Dog();
//        dog.setAge(2);
//        dog.setName("jo");
//        entityManager.persist(dog);
//        entityManager.persist(sdog);
//        entityManager.persist(hdog);
//        Cat cat = new Cat();
//        cat.setName("vasya");
//        Friends fr = new Friends();
//        fr.setTitle("fine");
//        cat.setFr(fr);
        Berd berd = new Berd();
        berd.setName("goga");
        BerdId bi = new BerdId();
        bi.setId(1);
        bi.setSecondId("one");
        berd.setBi(bi);
        berd.setColor(ColorEnum.RED);
        berd.setColor2(ColorEnum.WHITE);
        
        entityManager.persist(berd);
        transaction.commit();
        
    }
    
}
