package com.liuhq7;

import com.liuhq7.pojo.Department;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// MyBatis快速入门
public class MyBatisDemo {

    public static void main(String[] args) throws IOException {

        // 1.加载MyBatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取SqlSession对象，用它来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行sql
        List<Department> departments = sqlSession.selectList("com.liuhq7.mapper.DepartmentMapper.selectAll");

        System.out.println(departments);

        // 4.释放资源
        sqlSession.close();

    }
}
