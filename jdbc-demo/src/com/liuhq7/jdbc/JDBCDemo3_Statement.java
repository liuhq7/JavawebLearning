package com.liuhq7.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// JDBC API Statement详解
public class JDBCDemo3_Statement {

    // 执行DML语句
    @Test
    public void testDML() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "update user set password = '123abc' where name = 'LiuHongQi'";

        Statement stmt = conn.createStatement();

        // 返回值为执行成功的行数
        int count = stmt.executeUpdate(sql);

        if (count > 0) {
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }

        stmt.close();
        conn.close();
    }

    // 执行DDL语句
    @Test
    public void testDDL() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "create database db2";

        Statement stmt = conn.createStatement();

        // 返回值不一定为执行成功的行数，某些语句执行成功会返回0
        int count = stmt.executeUpdate(sql);

        System.out.println(count);

        stmt.close();
        conn.close();
    }
}
