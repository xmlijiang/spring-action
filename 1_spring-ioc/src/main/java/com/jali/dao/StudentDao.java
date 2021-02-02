package com.jali.dao;

import com.jali.bean.Student;
import org.springframework.stereotype.Repository;

/**
 * @author lijiang
 * @create 2021-02-02 10:22
 */
@Repository
public class StudentDao extends BaseDao<Student>{

    public void save(){
        System.out.println("保存student");
    }
}
