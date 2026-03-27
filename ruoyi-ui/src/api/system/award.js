import request from '@/utils/request'

// 查询教研奖励列表
export function listAward(query) {
  return request({
    url: '/system/award/list',
    method: 'get',
    params: query
  })
}

// 查询教研奖励详细
export function getAward(id) {
  return request({
    url: '/system/award/' + id,
    method: 'get'
  })
}

// 新增教研奖励
export function addAward(data) {
  return request({
    url: '/system/award',
    method: 'post',
    data: data
  })
}

// 修改教研奖励
export function updateAward(data) {
  return request({
    url: '/system/award',
    method: 'put',
    data: data
  })
}

// 删除教研奖励
export function delAward(id) {
  return request({
    url: '/system/award/' + id,
    method: 'delete'
  })
}
