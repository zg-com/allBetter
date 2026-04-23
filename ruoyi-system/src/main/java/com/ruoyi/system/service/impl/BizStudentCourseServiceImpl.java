package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.BizCourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BizStudentCourseMapper;
import com.ruoyi.system.domain.BizStudentCourse;
import com.ruoyi.system.service.IBizStudentCourseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 学生选课与成绩Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-10
 */
@Service
public class BizStudentCourseServiceImpl implements IBizStudentCourseService 
{
    @Autowired
    private BizStudentCourseMapper bizStudentCourseMapper;
    // 👇 新增：把课程表的 Mapper 注入进来，因为我们要跨表改人数！
    @Autowired
    private BizCourseMapper bizCourseMapper;

    /**
     * 查询学生选课与成绩
     * 
     * @param id 学生选课与成绩主键
     * @return 学生选课与成绩
     */
    @Override
    public BizStudentCourse selectBizStudentCourseById(Long id)
    {
        return bizStudentCourseMapper.selectBizStudentCourseById(id);
    }

    /**
     * 查询学生选课与成绩列表
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 学生选课与成绩
     */
    @Override
    public List<BizStudentCourse> selectBizStudentCourseList(BizStudentCourse bizStudentCourse)
    {
        return bizStudentCourseMapper.selectBizStudentCourseList(bizStudentCourse);
    }

    /**
     * 新增选课记录 (包含核心并发防超卖逻辑)
     */
    @Override
    @Transactional(rollbackFor = Exception.class) // 🎯 极其关键：发生异常立刻回滚，一条脏数据都别想进数据库
    public int insertBizStudentCourse(BizStudentCourse bizStudentCourse) {

        // 1. 让 MySQL 自己去尝试人数 +1
        int updatedRows = bizCourseMapper.incrementCourseNum(bizStudentCourse.getCourseId());

        // 2. 如果 updatedRows 是 0，说明什么？
        // 说明刚才在 XML 里的 WHERE 条件 `current_numofpeople < volume` 没有满足！课程已经满了！
        if (updatedRows == 0) {
            // 直接抛出若依自带的业务异常，前端会自动弹出红色错误提示，并且事务直接回滚
            throw new ServiceException("手慢了，该课程名额已满！");
        }

        // 3. 如果没满（+1 成功了），正常把学生的选课记录写进中间表
        return bizStudentCourseMapper.insertBizStudentCourse(bizStudentCourse);
    }

    /**
     * 修改学生选课与成绩
     * 
     * @param bizStudentCourse 学生选课与成绩
     * @return 结果
     */
    @Override
    public int updateBizStudentCourse(BizStudentCourse bizStudentCourse)
    {
        bizStudentCourse.setUpdateTime(DateUtils.getNowDate());
        return bizStudentCourseMapper.updateBizStudentCourse(bizStudentCourse);
    }

    /**
     * 批量删除学生选课与成绩
     * 
     * @param ids 需要删除的学生选课与成绩主键
     * @return 结果
     */
    @Override
    public int deleteBizStudentCourseByIds(Long[] ids)
    {
        // 1. 遍历每一个要删除的中间表 ID
        for (Long id : ids) {
            // 2. 先查出这条选课记录。注意：必须在删除前查，否则删了就拿不到 courseId 了
            BizStudentCourse sc = bizStudentCourseMapper.selectBizStudentCourseById(id);

            if (sc != null && sc.getCourseId() != null) {
                // 3. 调用我们之前在 BizCourseMapper 里写的原子减人 SQL
                // 对应 SQL: UPDATE biz_course SET current_numofpeople = current_numofpeople - 1 ...
                bizCourseMapper.decrementCourseNum(sc.getCourseId());
            }
        }

        // 4. 最后执行真正的物理删除（删除中间表的关联记录）
        return bizStudentCourseMapper.deleteBizStudentCourseByIds(ids);
    }

    /**
     * 退选：删除选课记录并同步人数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBizStudentCourseById(Long id) {
        // 1. 先把这条选课记录查出来，因为我们需要知道退的是哪门课 (courseId)
        BizStudentCourse sc = bizStudentCourseMapper.selectBizStudentCourseById(id);

        if (sc != null) {
            // 2. 课程表人数 -1
            bizCourseMapper.decrementCourseNum(sc.getCourseId());

            // 3. 删除中间表的关联记录
            return bizStudentCourseMapper.deleteBizStudentCourseById(id);
        }
        return 0;
    }




}
