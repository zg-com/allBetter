import request from '@/utils/request'

// 查询教师兼职与访学经历列表
export function listExperience(query) {
  return request({
    url: '/system/experience/list',
    method: 'get',
    params: query
  })
}

// 查询教师兼职与访学经历详细
export function getExperience(id) {
  return request({
    url: '/system/experience/' + id,
    method: 'get'
  })
}

// 新增教师兼职与访学经历
export function addExperience(data) {
  return request({
    url: '/system/experience',
    method: 'post',
    data: data
  })
}

// 修改教师兼职与访学经历
export function updateExperience(data) {
  return request({
    url: '/system/experience',
    method: 'put',
    data: data
  })
}

// 删除教师兼职与访学经历
export function delExperience(id) {
  return request({
    url: '/system/experience/' + id,
    method: 'delete'
  })
}
