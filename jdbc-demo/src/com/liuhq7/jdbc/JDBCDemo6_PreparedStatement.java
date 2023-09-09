package com.liuhq7.jdbc;

import org.junit.Test;

import java.sql.*;

// JDBC API PreparedStatement详解
public class JDBCDemo6_PreparedStatement {

    // 防止SQL注入
    @Test
    public void testPreparedStatement() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        // useServerPrepStmts=true参数开启预编译功能，若执行多个sql只需编译一次，提高性能
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&serverTimezone=UTC&useServerPrepStmts=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        String name = "wenadscna";
        String pwd = "' or '1' = '1";

        // 用?替换用户名和密码的值
        String sql = "select * from user where name = ? and password = ?";

        // 获取pstmt对象，在这里传递sql
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置?的值，并将敏感字符进行转义来防止SQL注入
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);

        // 不需要再传递sql
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            System.out.println("登录成功");
        }
        else {
            System.out.println("登录失败");
        }

        rs.close();
        pstmt.close();
        conn.close();
    }
}
