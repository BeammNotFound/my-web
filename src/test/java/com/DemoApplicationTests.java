package com;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.sql.Wrapper;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService service;

    @Test
    void contextLoads() {
        Page<User> page = new Page<>(10,1);
        Page<User> list = service.page(page);
        System.out.println("一共有：" + list.getTotal() + "页");
        list.getRecords().forEach(System.out::println);
//        list.forEach(System.out::println);

        service.list().forEach(System.out::println);
    }

    @Test
    void insert(){
        User user = new User();
        user.setName("Beam");
        user.setEmail("BeammStark@gmail.com");
        user.setAge(21);
        boolean save = service.save(user);
        if (save) {
            System.out.println("插入成功" + user.getId());
        }else
            System.out.println("插入失败");
    }

    @Test
    void del(){
        service.removeById(1401043000561274882L);
    }

    @Test
    void change(){

        User user = new User();
        user.setId(2L);
        user.setAge(11);

        service.updateById(user);
    }

    @Test
    void WrapperTest(){
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper
                .isNotNull("name")
                .ge("age", 20);
        service.list(objectQueryWrapper).forEach(System.out::println);
    }


}
