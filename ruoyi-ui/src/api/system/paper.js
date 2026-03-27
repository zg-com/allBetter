import request from '@/utils/request'

// 查询科研论文全纪录列表
export function listPaper(query) {
  return request({
    url: '/system/paper/list',
    method: 'get',
    params: query
  })
}

// 查询科研论文全纪录详细
export function getPaper(id) {
  return request({
    url: '/system/paper/' + id,
    method: 'get'
  })
}

// 新增科研论文全纪录
export function addPaper(data) {
  return request({
    url: '/system/paper',
    method: 'post',
    data: data
  })
}

// 修改科研论文全纪录
export function updatePaper(data) {
  return request({
    url: '/system/paper',
    method: 'put',
    data: data
  })
}

// 删除科研论文全纪录
export function delPaper(id) {
  return request({
    url: '/system/paper/' + id,
    method: 'delete'
  })
}
