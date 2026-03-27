import request from '@/utils/request'

// 查询教师子女与妇幼档案列表
export function listChild(query) {
  return request({
    url: '/system/child/list',
    method: 'get',
    params: query
  })
}

// 查询教师子女与妇幼档案详细
export function getChild(id) {
  return request({
    url: '/system/child/' + id,
    method: 'get'
  })
}

// 新增教师子女与妇幼档案
export function addChild(data) {
  return request({
    url: '/system/child',
    method: 'post',
    data: data
  })
}

// 修改教师子女与妇幼档案
export function updateChild(data) {
  return request({
    url: '/system/child',
    method: 'put',
    data: data
  })
}

// 删除教师子女与妇幼档案
export function delChild(id) {
  return request({
    url: '/system/child/' + id,
    method: 'delete'
  })
}
