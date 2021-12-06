package com.example.my_batis_plus_demo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.my_batis_plus_demo.mappers.UserMapper;
import com.example.my_batis_plus_demo.po.User;
import com.example.my_batis_plus_demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.Query;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
class MyBatisPlusDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;
    @Test
    public void testSelect() {
        List<User> list = userMapper.selectList(null);
        assertEquals(5, list.size());
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectMaps(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name","email").likeRight("name","黄");
        List<Map<String,Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void  testCount(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","黄");
        /**
         * 不需要进行 select查询,而是直接 selectCount 返回 count
         * */
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    public void  testServiceCRUD(){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        wrapper.gt(User::getAge,28);
        User one =userService.getOne(wrapper,false);
        System.out.println(one);
    }

    @Test
    public void  testServiceCRUDChain(){
       List<User> list = userService.lambdaQuery()
              .gt(User::getAge,29)
                .likeRight(User::getName,"黄")
                .list();
       list.forEach(System.out::println);
    }

    @Test
    public  void testServiceCRUDChainUpdate(){
        userService.lambdaUpdate()
                .gt(User::getAge,29)
                .likeRight(User::getName,"黄")
                .set(User::getEmail,"123311")
                .update();
    }



}
