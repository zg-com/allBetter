import request from '@/utils/request'

// 1. 查询当前老师的课程列表
export function getTeacherCourseList(query) {
  return request({
    url: '/system/teacherGrade/courseList',
    method: 'get',
    params: query
  })
}

// 2. 查询指定课程下的学生名单
export function getCourseStudentList(query) {
  return request({
    url: '/system/teacherGrade/studentList',
    method: 'get',
    params: query
  })
}

// 3. 一键开启课程教学
export function startTeacherCourse(courseId) {
  return request({
    url: '/system/teacherGrade/start/' + courseId,
    method: 'put'
  })
}

// 4. 录入成绩并结课
export function gradeTeacherStudent(data) {
  return request({
    url: '/system/teacherGrade/grade',
    method: 'put',
    data: data
  })
}
