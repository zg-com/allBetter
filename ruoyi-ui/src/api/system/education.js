import request from '@/utils/request'

// 查询教师历年学习经历与证书列表
export function listEducation(query) {
  return request({
    url: '/system/education/list',
    method: 'get',
    params: query
  })
}

// 查询教师历年学习经历与证书详细
export function getEducation(id) {
  return request({
    url: '/system/education/' + id,
    method: 'get'
  })
}

// 新增教师历年学习经历与证书
export function addEducation(data) {
  return request({
    url: '/system/education',
    method: 'post',
    data: data
  })
}

// 修改教师历年学习经历与证书
export function updateEducation(data) {
  return request({
    url: '/system/education',
    method: 'put',
    data: data
  })
}

// 删除教师历年学习经历与证书
export function delEducation(id) {
  return request({
    url: '/system/education/' + id,
    method: 'delete'
  })
}
