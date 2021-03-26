package com.zhaobao.spbtzb.dao;

import com.zhaobao.spbtzb.pojo.User;

import java.util.List;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/25 17:30
 */
public interface UserMapper {

    /**
     * 新加user信息
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 查询用户名是否存在
     * @param name
     * @return
     */
    int queryUsernameIsExist(String name);

    /**
     * 获取用户列表
     * @return
     */
    List<User> queryUsersAll();
}
