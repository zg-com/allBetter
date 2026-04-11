import request from '@/utils/request'

// 查询科研奖励关联列表
export function listAward_people(query) {
  return request({
    url: '/system/award_people/list',
    method: 'get',
    params: query
  })
}

// 查询科研奖励关联详细
export function getAward_people(id) {
  return request({
    url: '/system/award_people/' + id,
    method: 'get'
  })
}

// 新增科研奖励关联
export function addAward_people(data) {
  return request({
    url: '/system/award_people',
    method: 'post',
    data: data
  })
}

// 修改科研奖励关联
export function updateAward_people(data) {
  return request({
    url: '/system/award_people',
    method: 'put',
    data: data
  })
}

// 删除科研奖励关联
export function delAward_people(id) {
  return request({
    url: '/system/award_people/' + id,
    method: 'delete'
  })
}
