package com.jali.dao;

import com.jali.vo.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author lijiang
 * @create 2021-03-07 21:58
 */
@Repository
public class ModelDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Model model){
        String sql = "insert into act_re_model(ID_,NAME_,KEY_) values(?,?,?)";
        int update = jdbcTemplate.update(sql, model.getId_(), model.getName_(), model.getKey_());
        System.out.println(update);
    }
}
