package com.learningmplat.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learningmplat.backend.domain.BizStudent;
import com.learningmplat.backend.service.BizStudentService;
import com.learningmplat.backend.mapper.BizStudentMapper;
import org.springframework.stereotype.Service;

/**
* @author 13027
* @description 针对表【biz_student(学生业务信息表)】的数据库操作Service实现
* @createDate 2026-03-16 13:41:11
*/
@Service
public class BizStudentServiceImpl extends ServiceImpl<BizStudentMapper, BizStudent>
    implements BizStudentService{

}




