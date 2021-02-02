package com.jali.service;

import com.jali.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lijiang
 * @create 2021-02-02 13:47
 */
public class BaseService<T> {

    @Autowired
    private BaseDao<T> baseDao;

    public void save(){
        baseDao.save();
    }
}
