package com.liuhq7.test;

import com.liuhq7.mapper.UserMapper;
import com.liuhq7.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.omg.CORBA.UserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = UserMapper.selectAll();

        System.out.println(users);

        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {

        // 模拟接收数据
        int id = 4;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = UserMapper.selectById(id);

        System.out.println(users);

        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws IOException {

        // 模拟接收数据
        String name = "Ma";
        String address = "Shanghai";
        int age = 23;

        // 处理参数实现模糊查询
        name = "%" + name + "%";

        // 封装对象
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setAge(age);

        // 构造Map集合
        Map map = new HashMap();
        map.put("name", name);
        map.put("address", address);
        map.put("age", age);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);

        // 使用散装参数
        // List<User> users = UserMapper.selectByCondition(name, address, age);

        // 使用对象参数
        // List<User> users = UserMapper.selectByCondition(user);

        // 使用Map集合
        List<User> users = UserMapper.selectByCondition(map);

        System.out.println(users);

        sqlSession.close();

    }

    @Test
    public void testSelectByConditionSingle() throws IOException {

        // 模拟接收数据
        String name = "Ma";
        String address = "Shanghai";
        int age = 20;

        // 处理参数实现模糊查询
        name = "%" + name + "%";

        // 封装对象
        User user = new User();
        user.setName(name);
        // user.setAddress(address);
        // user.setAge(age);

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = UserMapper.selectByConditionSingle(user);

        System.out.println(users);

        sqlSession.close();

    }

    @Test
    public void testAdd() throws IOException {

        // 模拟接收数据
        String name = "Guofucheng";
        String password = "999666";
        String address = "Beijing";
        int age = 22;
        String sex = "男";
        int deptId = 3;

        // 封装对象
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setAddress(address);
        user.setAge(age);
        user.setSex(sex);
        user.setDeptId(deptId);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 参数为true设置自动提交，false关闭自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);

        UserMapper.add(user);

        // 需要提交事务
        sqlSession.commit();

        // 测试主键返回
        Integer id = user.getId();
        System.out.println(id);

        sqlSession.close();

    }

    @Test
    public void testUpdate() throws IOException {

        // 模拟接收数据
        int id = 9;
        String name = "Guofucheng";
        String password = "999qqq";
        String address = "Beijing";
        int age = 19;
        String sex = "男";
        int deptId = 3;

        // 封装对象
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        // user.setAddress(address);
        // user.setAge(age);
        // user.setSex(sex);
        // user.setDeptId(deptId);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);

        UserMapper.update(user);

        // 需要提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void testDeleteById() throws IOException {

        // 模拟接收数据
        int id = 9;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);

        UserMapper.deleteById(id);

        // 需要提交事务
        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void testDeleteByIds() throws IOException {

        // 模拟接收数据
        int[] ids = {5, 7, 8};

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper UserMapper = sqlSession.getMapper(UserMapper.class);

        UserMapper.deleteByIds(ids);

        // 需要提交事务
        sqlSession.commit();

        sqlSession.close();

    }
}
