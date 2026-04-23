import request from '@/utils/request'

// 查询课程信息列表
export function listCourse(query) {
  return request({
    url: '/system/course/list',
    method: 'get',
    params: query
  })
}

// 查询课程信息详细
export function getCourse(id) {
  return request({
    url: '/system/course/' + id,
    method: 'get'
  })
}

// 新增课程信息
export function addCourse(data) {
  return request({
    url: '/system/course',
    method: 'post',
    data: data
  })
}

// 修改课程信息
export function updateCourse(data) {
  return request({
    url: '/system/course',
    method: 'put',
    data: data
  })
}

// 删除课程信息
export function delCourse(id) {
  return request({
    url: '/system/course/' + id,
    method: 'delete'
  })
}

//提交申请
export function applyProfile(data){
  return request({
    url: '/system/course/apply',
    method:'post',
    data:data
  })
}

//同意批准申请
export function approveProfile(id) {
  return request({
    url: '/system/course/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回申请
export function rejectProfile(data) {
  return request({
    url: '/system/course/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
