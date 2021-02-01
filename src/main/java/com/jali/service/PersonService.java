package com.jali.service;

import com.jali.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public void save(){
        personDao.save();
    }
}
