package com.liuhq7.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Connection接口的事务处理
public class JDBCDemo2_Connection {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String sql1 = "update user set password = '123abc' where name = 'LiuHongQi'";
        String sql2 = "update user set password = 'abc123' where name = 'MaSiKe'";

        Statement stmt = conn.createStatement();

        try {
            // 开启事务
            conn.setAutoCommit(false);

            int count1 = stmt.executeUpdate(sql1);
            System.out.println(count1);

            // 设置异常
            // int n = 2 / 0;

            int count2 = stmt.executeUpdate(sql2);
            System.out.println(count2);

            // 提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        stmt.close();
        conn.close();
    }
}
