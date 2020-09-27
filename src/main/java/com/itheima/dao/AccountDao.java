package com.itheima.dao;

public interface AccountDao {
    void out(Integer money,String name);
    void in(Integer money,String name);
}
