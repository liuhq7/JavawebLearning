package com.liuhq7.jdbc;

import com.liuhq7.pojo.Department;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// 用户登录
public class JDBCDemo5_UserLogin {

    // 用户正常登录
    @Test
    public void testLogin() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入用户名和密码
        String name = "LiuHongQi";
        String pwd = "123abc";

        String sql = "select * from user where name = '" + name + "' and password = '" + pwd + "'";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        // 判断是否登陆成功
        if (rs.next()) {
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    // 演示SQL注入
    @Test
    public void testLoginInject() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入用户名和密码
        String name = "wenadscna";
        String pwd = "' or '1' = '1";

        String sql = "select * from user where name = '" + name + "' and password = '" + pwd + "'";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        // 判断是否登陆成功
        if (rs.next()) {
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
