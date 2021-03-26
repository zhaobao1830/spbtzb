package com.zhaobao.spbtzb.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.zhaobao.spbtzb.common.Const;
import com.zhaobao.spbtzb.dao.UserMapper;
import com.zhaobao.spbtzb.pojo.User;
import com.zhaobao.spbtzb.pojo.bo.UserBO;
import com.zhaobao.spbtzb.pojo.vo.UserVO;
import com.zhaobao.spbtzb.service.IUserService;
import com.zhaobao.spbtzb.service.impl.base.BaseService;
import com.zhaobao.spbtzb.utils.PagedGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/26 8:56
 */
@Service
public class UserServiceImpl extends BaseService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(UserBO userBO) {
        User user = new User();
        user.setUsername(userBO.getUsername());
        user.setPassword(userBO.getPassword());
        user.setRole(Const.Role.ROLE_CUSTOMER);
        int resultCount = userMapper.insert(user);
        if (resultCount == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean queryUsernameIsExist(String username) {
        int resultCount = userMapper.queryUsernameIsExist(username);
        if (resultCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    public PagedGridResult queryAll(int pageNum, int pageSize) {
        // 传入pageNum, pageSize参数
        PageHelper.startPage(pageNum, pageSize);
        // 获取userList
        List<User> userList = userMapper.queryUsersAll();
        // 对userList进行处理，获取对应的volist
        List<UserVO> userVoList = assembleUserVoList(userList);
        return setterPagedGrid(pageNum, pageSize, userVoList);
    }

    public List<UserVO> assembleUserVoList(List<User> userList) {
        List<UserVO> userVoList = Lists.newArrayList();
        for (User user : userList) {
            UserVO userVO = assembleUserVo(user);
            userVoList.add(userVO);
        }
        return userVoList;
    }

    public UserVO assembleUserVo(User user) {
        UserVO userVo = new UserVO();
        userVo.setId(user.getId());
        userVo.setUsername(user.getUsername());
        userVo.setRole(user.getRole());
        userVo.setPhone(user.getPhone());
        userVo.setEmail(user.getEmail());
        return userVo;
    }
}
