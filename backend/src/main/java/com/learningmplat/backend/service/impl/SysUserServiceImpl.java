package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizStudent;
import com.learningmplat.backend.domain.BizTeacher;
import com.learningmplat.backend.domain.SysUser;
import com.learningmplat.backend.domain.SysUserRole;
import com.learningmplat.backend.domain.dto.StudentAddDTO;
import com.learningmplat.backend.domain.dto.TeacherAddDTO;
import com.learningmplat.backend.service.BizStudentService;
import com.learningmplat.backend.service.BizTeacherService;
import com.learningmplat.backend.service.SysUserRoleService;
import com.learningmplat.backend.service.SysUserService;
import com.learningmplat.backend.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
* @author 13027
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private BizStudentService bizStudentService;

    @Autowired
    private BizTeacherServiceImpl bizTeacherService;

    @Override
    @Transactional(rollbackFor = Exception.class) //这个方法里的所有数据库操作“要么全成功，要么全回滚（撤销）”
    public void addStudent(StudentAddDTO dto){
        //1.检查学号唯一性
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,dto.getUsername());
        if(this.count(wrapper) >0){
            throw new RuntimeException("学号已存在！");
        }
        //2.创建登陆账号
        SysUser newUser = new SysUser();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword("123456");
        newUser.setRealName(dto.getRealName());;
        this.save(newUser);

        //3.绑定学生角色
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(newUser.getId());
        userRole.setRoleId(2);

        sysUserRoleService.save(userRole);

        //4.创建学生信息
        BizStudent studentProfile = new BizStudent();
        studentProfile.setStudentNo(newUser.getId().toString());
        studentProfile.setMajor(dto.getMajor());
        studentProfile.setEnrollmentYear(dto.getEnrollmentYear());
        studentProfile.setUserId(newUser.getId());
        bizStudentService.save(studentProfile);
    }

    public void addTeacher(TeacherAddDTO dto){
        //检查工号唯一性
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername,dto.getUsername());
        if(this.count(wrapper) >0){
            throw new RuntimeException("工号已存在！");
        }
        //创建登录账号
        SysUser newUser = new SysUser();
        newUser.setUsername(dto.getUsername());
        newUser.setPassword("123456");
        newUser.setRealName(dto.getRealName());
        this.save(newUser);
        //绑定教师角色
        SysUserRole userRole = new SysUserRole();
        userRole.setUserId(newUser.getId());
        userRole.setRoleId(1);
        sysUserRoleService.save(userRole);
        //创建教师信息
        BizTeacher teacherProfile = new BizTeacher();
        teacherProfile.setTeacherNo(newUser.getId().toString());
        teacherProfile.setTitle(dto.getTitle());
        bizTeacherService.save(teacherProfile);

    }
}




