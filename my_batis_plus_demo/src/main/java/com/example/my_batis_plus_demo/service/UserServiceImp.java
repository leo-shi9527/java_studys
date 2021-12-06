package com.example.my_batis_plus_demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.my_batis_plus_demo.mappers.UserMapper;
import com.example.my_batis_plus_demo.po.User;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: King
 * @Date: 2021/12/06/10:50 PM
 * @Description:
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
}
