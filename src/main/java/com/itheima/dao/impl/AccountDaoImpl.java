package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void out(Integer num,String name) {
        String sql="update account set money=money-? where username=?";
        jdbcTemplate.update(sql,num,name);
    }

    @Override
    public void in(Integer num,String name) {
        String sql="update account set money=money+? where username=?";
        jdbcTemplate.update(sql,num,name);
    }


}
