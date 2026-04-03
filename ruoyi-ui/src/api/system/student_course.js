import request from '@/utils/request'

// 查询学生选课与成绩列表
export function listStudent_course(query) {
  return request({
    url: '/system/student_course/list',
    method: 'get',
    params: query
  })
}

// 查询学生选课与成绩详细
export function getStudent_course(id) {
  return request({
    url: '/system/student_course/' + id,
    method: 'get'
  })
}

// 新增学生选课与成绩
export function addStudent_course(data) {
  return request({
    url: '/system/student_course',
    method: 'post',
    data: data
  })
}

// 修改学生选课与成绩
export function updateStudent_course(data) {
  return request({
    url: '/system/student_course',
    method: 'put',
    data: data
  })
}

// 删除学生选课与成绩
export function delStudent_course(id) {
  return request({
    url: '/system/student_course/' + id,
    method: 'delete'
  })
}
