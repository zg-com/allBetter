package com.learningmplat.backend.service;

import com.learningmplat.backend.domain.BizTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learningmplat.backend.domain.vo.TeacherVO;

/**
* @author 13027
* @description 针对表【biz_teacher(教师业务信息表)】的数据库操作Service
* @createDate 2026-03-16 13:41:11
*/
public interface BizTeacherService extends IService<BizTeacher> {
    public TeacherVO getTeacherInfo(Long teacherId);
}
