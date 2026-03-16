package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizCourse;
import com.learningmplat.backend.service.BizCourseService;
import com.learningmplat.backend.mapper.BizCourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 13027
* @description 针对表【biz_course(课程实体表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizCourseServiceImpl extends ServiceImpl<BizCourseMapper, BizCourse>
    implements BizCourseService{
    @Override
    public List<BizCourse> getMySelectedCourses(Long studentId) {
        // 直接调用咱们刚才在 Mapper 里手写的那个大招！
        return this.baseMapper.selectCoursesByStudentId(studentId);
    }
}




