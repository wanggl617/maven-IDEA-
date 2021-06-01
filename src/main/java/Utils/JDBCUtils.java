/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @title JDBC的工具类 ，使用Druid连接池
 */
public class JDBCUtils {
    private static DataSource dataSource;
    private static InputStream resource;
    static{
        //加载配置文件
        Properties pro = new Properties();
        ClassLoader loader = JDBCUtils.class.getClassLoader();
        resource = loader.getResourceAsStream("properties/druid.properties");
        try {
            pro.load(resource);
            //获取DataSource
            dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }
    //获取连接池
    public static DataSource getDataSource(){
        return dataSource;
    }
}