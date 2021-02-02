package com.jali.dao;

import com.jali.bean.Teacher;
import org.springframework.stereotype.Repository;

/**
 * @author lijiang
 * @create 2021-02-02 10:23
 */
@Repository
public class TeacherDao extends BaseDao<Teacher>{

    public void save(){
        System.out.println("保存teacher");
    }
}