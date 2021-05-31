/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package servlet;

import Dao.UserDao;
import Domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 王国林
 * @title 阳光正好，微风不燥
 * @date 2021/5/28 15:56
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");

        //封装User对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        //获取所有请求参数、
        Map<String, String[]> para = req.getParameterMap();
        //封装为User对象，使用BeanUtils
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,para);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用UserDao中的login方法，判断登录条件
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        if(user == null){
            //登录失败
            //转发到失败servlet
            req.getRequestDispatcher("/failLogin").forward(req,resp);
        }else{
            //登陆成功
            //存储数据
            req.setAttribute("User",user);
            //转发
            req.getRequestDispatcher("/successfulLogin").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}