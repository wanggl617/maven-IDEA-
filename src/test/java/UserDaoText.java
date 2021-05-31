/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */


import Dao.UserDao;
import Domain.User;
import org.junit.Test;

/**
 * @title 阳光正好，微风不燥
 * @data 2021/5/31
 */
public class UserDaoText {
    @Test
    public void testLogin(){
        UserDao dao = new UserDao() ;
        User loginUser = new User() ;
        loginUser.setUsername("wang");
        loginUser.setPassword("123456");
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}