package com.liuhq7.jdbc;

import com.liuhq7.pojo.Department;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// JDBC API ResultSet详解
public class JDBCDemo4_ResultSet {

    // 执行DQL语句
    @Test
    public void testDQL() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql = "select * from dept";

        Statement stmt = conn.createStatement();

        // 使用ResultSet获取查询结果集
        ResultSet rs = stmt.executeQuery(sql);

        ArrayList<Department> dept_list = new ArrayList<>();

        // 处理结果，遍历rs中的所有数据
        // rs.next()方法让光标向下移动一行，并判断当前行为有效数据
        while (rs.next()) {

            Department dept = new Department();

            int id = rs.getInt(1);
            String name = rs.getString(2);
            String address = rs.getString(3);

            // 测试输出
            // System.out.println(id);
            // System.out.println(name);
            // System.out.println(address);
            // System.out.println("---------------");

            dept.setId(id);
            dept.setName(name);
            dept.setAddress(address);
            dept_list.add(dept);
        }

        System.out.println(dept_list);

        // 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
