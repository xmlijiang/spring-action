package com.jali.service;

import com.jali.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class PersonService2 extends PersonService{

    @Autowired
    private PersonDao personDao;

    public void save(){
        System.out.println("personService2...");
        personDao.save();
    }
}
