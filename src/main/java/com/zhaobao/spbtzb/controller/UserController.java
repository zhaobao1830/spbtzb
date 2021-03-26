package com.zhaobao.spbtzb.controller;

import com.zhaobao.spbtzb.common.ServerResponseJsonResult;
import com.zhaobao.spbtzb.pojo.bo.UserBO;
import com.zhaobao.spbtzb.service.IUserService;
import com.zhaobao.spbtzb.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhaobao1830
 * @Date: 2021/3/26 8:47
 */

@Api(value = "用户", tags = {"用户相关接口"}, consumes = "application/json")
@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @ApiOperation(value = "注册", notes = "注册", httpMethod = "POST")
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponseJsonResult register(@RequestBody UserBO userBO) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 0、判断用户名和密码不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPassword)
        ) {
            return ServerResponseJsonResult.errorMsg("用户名或密码不能为空");
        }
        // 1、查询用户名是否存在
        boolean isExist = iUserService.queryUsernameIsExist(username);
        if (isExist) {
            return ServerResponseJsonResult.errorMsg("用户名已存在");
        }
        // 2、密码长度不能少于6位
        if (password.length() < 6) {
            return ServerResponseJsonResult.errorMsg("密码长度不能少于6");
        }
        // 3、判断俩次密码是否一致
        if (!password.equals(confirmPassword)) {
            return ServerResponseJsonResult.errorMsg("两次密码输入不一致");
        }
        // 4、实现注册
        boolean isRegister = iUserService.register(userBO);
        System.out.println(isRegister);
        if (isRegister) {
            return ServerResponseJsonResult.ok("注册成功");
        } else {
            return ServerResponseJsonResult.ok("注册失败");
        }
    }

    @ApiOperation(value = "列表", notes = "列表", httpMethod = "POST")
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponseJsonResult list(@RequestBody UserBO userBO) {
        Integer pageNum = 1;
        if (userBO.getPageNum() != null) {
            pageNum = userBO.getPageNum();
        }
        Integer pageSize = 10;
        if (userBO.getPageSize() != null) {
            pageSize = userBO.getPageSize();
        }
        PagedGridResult grid = iUserService.queryAll(pageNum, pageSize);
        return ServerResponseJsonResult.ok(grid);
    }
}
