import request from '@/utils/request'

// 查询教师人事基础档案列表
export function listProfile(query) {
  return request({
    url: '/system/profile/list',
    method: 'get',
    params: query
  })
}

// 查询教师人事基础档案详细
export function getProfile(id) {
  return request({
    url: '/system/profile/' + id,
    method: 'get'
  })
}

// 新增教师人事基础档案
export function addProfile(data) {
  return request({
    url: '/system/profile',
    method: 'post',
    data: data
  })
}

// 修改教师人事基础档案
export function updateProfile(data) {
  return request({
    url: '/system/profile',
    method: 'put',
    data: data
  })
}

// 删除教师人事基础档案
export function delProfile(id) {
  return request({
    url: '/system/profile/' + id,
    method: 'delete'
  })
}
