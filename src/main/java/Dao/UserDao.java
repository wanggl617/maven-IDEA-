/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package Dao;

import Domain.User;
import Utils.JDBCUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 王国林
 * @title 操作数据库中User表的类
 * @date 2021/5/29 18:07
 */
public class UserDao {
    /**
    * @Description: 阳光正好,微风不燥
    * @Param: [LoginUser]只包含用户名和密码
    * @return: Domain.User 包含所有的用户数据
    * @Author: Lin
    */

    //声明 JDBCTemplate对象共用
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User LoginUser) {
        String sql = "SELECT * FROM user WHERE USERNAME=? AND PASSWORD=?";
        User user = null;

        try {
            user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    LoginUser.getUsername(), LoginUser.getPassword());
        } catch (EmptyResultDataAccessException e) {
            return null;

        }
        return user;
        //测试代码
    }

}