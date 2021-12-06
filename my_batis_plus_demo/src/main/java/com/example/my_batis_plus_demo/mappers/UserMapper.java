package com.example.my_batis_plus_demo.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.my_batis_plus_demo.po.User;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: King
 * @Date: 2021/12/06/7:05 PM
 * @Description:
 */

/**
 * mapper (n. 映射；制图人；字体映射程序)
 * Mapper CRUD (create read,update, delete)接口
 * 只需定义好实体类，然后创建一个接口，继承mp提供的BaseMapper即可。
 * mp会在mybatis启动时，自动解析实体类和表的映射关系，并注入带有通用CRUD方法的mapper
 * 所以在入口处需要配置 mappers 文件夹路径
 */

public interface UserMapper extends BaseMapper<User> { }