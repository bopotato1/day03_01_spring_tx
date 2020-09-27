package com.itheima.trans;

import com.itheima.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class test {
    @Autowired
    private IUserService userService;
    @Test
    public void test01(){
        userService.transfor(100,"jack","rose");
    }
}
