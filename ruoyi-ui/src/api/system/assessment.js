import request from '@/utils/request'

// 查询教师荣誉与历年考核记录列表
export function listAssessment(query) {
  return request({
    url: '/system/assessment/list',
    method: 'get',
    params: query
  })
}

// 查询教师荣誉与历年考核记录详细
export function getAssessment(id) {
  return request({
    url: '/system/assessment/' + id,
    method: 'get'
  })
}

// 新增教师荣誉与历年考核记录
export function addAssessment(data) {
  return request({
    url: '/system/assessment',
    method: 'post',
    data: data
  })
}

// 修改教师荣誉与历年考核记录
export function updateAssessment(data) {
  return request({
    url: '/system/assessment',
    method: 'put',
    data: data
  })
}

// 删除教师荣誉与历年考核记录
export function delAssessment(id) {
  return request({
    url: '/system/assessment/' + id,
    method: 'delete'
  })
}

//提交申请
export function applyProfile(data){
  return request({
    url: '/system/assessment/apply',
    method:'post',
    data:data
  })
}

//同意批准申请
export function approveProfile(id) {
  return request({
    url: '/system/assessment/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回申请
export function rejectProfile(data) {
  return request({
    url: '/system/assessment/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
