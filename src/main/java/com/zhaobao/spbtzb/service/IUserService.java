package com.zhaobao.spbtzb.service;

import com.zhaobao.spbtzb.pojo.bo.UserBO;
import com.zhaobao.spbtzb.utils.PagedGridResult;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/25 17:31
 */
public interface IUserService {

    /**
     * 用户注册
     * @param userBO
     * @return
     */
    public boolean register(UserBO userBO);

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    public PagedGridResult queryAll(int pageNum, int pageSize);
}
