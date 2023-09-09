package com.liuhq7;

import com.liuhq7.mapper.DepartmentMapper;
import com.liuhq7.pojo.Department;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// MyBatis代理开发
public class MyBatisDemo2 {

    public static void main(String[] args) throws IOException {

        // 1.加载MyBatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取SqlSession对象，用它来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取Department接口的代理对象
        DepartmentMapper DepartmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = DepartmentMapper.selectAll();

        System.out.println(departments);

        // 4.释放资源
        sqlSession.close();

    }
}
