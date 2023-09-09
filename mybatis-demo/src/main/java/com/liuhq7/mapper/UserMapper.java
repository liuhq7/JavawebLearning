package com.liuhq7.mapper;

import com.liuhq7.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    // 查询
    List<User> selectAll();

    // 条件查询
    List<User> selectById(int id);

    // 散装参数：如果方法有多个参数，需要使用@Param("SQL参数占位符名称")
    // List<User> selectByCondition(@Param("name") String name, @Param("address") String address, @Param("age") int age);

    // 对象参数：对象的属性名称要和参数占位符名称一致
    // List<User> selectByCondition(User user);

    // Map集合参数
    List<User> selectByCondition(Map map);

    // 单条件动态查询
    List<User> selectByConditionSingle(User user);

    // 添加
    void add(User user);

    // 修改
    void update(User user);

    // 根据id删除
    void deleteById(int id);

    // 批量删除
    void deleteByIds(@Param("ids") int[] ids);
}
