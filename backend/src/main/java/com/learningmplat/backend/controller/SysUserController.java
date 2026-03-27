package com.learningmplat.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.learningmplat.backend.common.Result; // 导入刚刚写的包装盒
import com.learningmplat.backend.domain.SysUser;
import com.learningmplat.backend.domain.dto.LoginDTO;
import com.learningmplat.backend.service.SysUserService;
import com.learningmplat.backend.utils.JwtUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "用户接口", description = "提供用户相关的接口")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    // 【变化1】：返回值变成了 Result<List<SysUser>>
    public Result<List<SysUser>> getAllUsers() {
        List<SysUser> list = sysUserService.list();

        // 【变化2】：用 Result.success() 把数据包装起来再返回！
        return Result.success(list);
    }

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO) {

        // 1. 【MyBatis-Plus 终极大招】：构造查询条件
        // 这行代码的意思是：准备生成一个 SELECT * FROM sys_user WHERE ...
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();

        // 接着写条件：要求表里的 username 字段，等于前端传过来的 username
        wrapper.eq(SysUser::getUsername, loginDTO.getUsername());

        // 2. 去数据库里查出这个用户（getOne 代表只查一条数据）
        SysUser user = sysUserService.getOne(wrapper);

        // 3. 开始极其严密的逻辑判断
        if (user == null) {
            // 连账号都查不到，直接无情拒绝
            return Result.error("账号不存在，请检查后重试！");
        }

        // 账号查到了，比对密码 (这里咱们先用最简单的明文比对，跑通为主)
        if (!user.getPassword().equals(loginDTO.getPassword())) {
            return Result.error("密码错误！");
        }

        // 4. 账号密码全对！验明正身，发放 VIP 手环 (Token)
        String token = JwtUtils.generateToken(user.getId(), user.getUsername());

        // 5. 把长长的手环字符串，装进包装盒，优雅地扔给前端！
        return Result.success(token);
    }

}