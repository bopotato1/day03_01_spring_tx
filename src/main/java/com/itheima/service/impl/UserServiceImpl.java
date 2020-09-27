package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public void transfor(Integer money, String nameIn, String nameOut) {
        accountDao.in(money,nameIn);
        int i=1/0;
        accountDao.out(money,nameOut);
    }
}
