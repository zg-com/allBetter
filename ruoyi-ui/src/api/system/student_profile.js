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

//学生提交申请
export function applyProfile(data){
  return request({
    url: '/system/student_profile/apply',
    method:'post',
    data:data
  })
}

// 同意学生档案批准
export function approveProfile(id) {
  return request({
    url: '/system/student_profile/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/student_profile/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
