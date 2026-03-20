package com.learningmplat.backend.mapper;

import com.learningmplat.backend.domain.BizTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learningmplat.backend.domain.vo.TeacherVO;
import org.apache.ibatis.annotations.Param;

/**
* @author 13027
* @description 针对表【biz_teacher(教师业务信息表)】的数据库操作Mapper
* @createDate 2026-03-16 13:41:11
* @Entity com.learningmplat.backend.domain.BizTeacher
*/
public interface BizTeacherMapper extends BaseMapper<BizTeacher> {
    public TeacherVO getTeacherInfo(@Param("userId") Long userId);
}




