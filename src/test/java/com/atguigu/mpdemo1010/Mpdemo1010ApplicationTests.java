/**
 *  Copyright (C), 2015-2020
 * FileName: Mpdemo1010ApplicationTests
 * Author: hanlong
 * Date: 2020/4/30 3:44 下午
 * Description:
 */
package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/** Copyright (C), 2015-2020 
 * FileName: Mpdemo1010ApplicationTests 
 * Author: hanlong 
 * Date: 2020/4/30 3:44 下午 
 *Description: 
 */
@SpringBootTest
public class Mpdemo1010ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    //查询user表所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
    //添加操作
    @Test
    public void addUser() {
        User user = new User();
        user.setName("岳不群1007");
        user.setAge(70);
        user.setEmail("lucy@qq.com");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        int insert=userMapper.insert(user);
        System.out.println("insert:"+insert);
    }

    //修改操作
    @Test
    public void updateUser()
    {
      User user = new User();
     user.setId(1257854586813181954L);
     user.setAge(1008);

        int row = userMapper.updateById(user);
        System.out.println(row);
    }
    //根据Id 查询
    @Test
    public void testSelectById(){

        User user = userMapper.selectById(1L);
        System.out.println(user);
    }
    //多个id批量查询
    @Test
    public void testSelectBatchIds(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }



}
