package com.app.dao;

import com.app.model.Person;

public interface DAO {

    public void saveCorrect(Person p);

    public void saveIncorrect(Person p);

}
