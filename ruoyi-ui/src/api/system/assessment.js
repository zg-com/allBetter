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
