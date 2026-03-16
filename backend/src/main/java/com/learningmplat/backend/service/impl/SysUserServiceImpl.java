package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.SysUser;
import com.learningmplat.backend.service.SysUserService;
import com.learningmplat.backend.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




