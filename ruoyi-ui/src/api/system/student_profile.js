import request from '@/utils/request'

// 查询学生基础学籍档案列表
export function listStudent_profile(query) {
  return request({
    url: '/system/student_profile/list',
    method: 'get',
    params: query
  })
}

// 查询学生基础学籍档案详细
export function getStudent_profile(id) {
  return request({
    url: '/system/student_profile/' + id,
    method: 'get'
  })
}

// 新增学生基础学籍档案
export function addStudent_profile(data) {
  return request({
    url: '/system/student_profile',
    method: 'post',
    data: data
  })
}

// 修改学生基础学籍档案
export function updateStudent_profile(data) {
  return request({
    url: '/system/student_profile',
    method: 'put',
    data: data
  })
}

// 删除学生基础学籍档案
export function delStudent_profile(id) {
  return request({
    url: '/system/student_profile/' + id,
    method: 'delete'
  })
}
