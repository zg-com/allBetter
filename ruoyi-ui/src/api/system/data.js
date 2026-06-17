import request from '@/utils/request'

// 查询火电厂核心传感器工况列表
export function listData(query) {
  return request({
    url: '/system/data/list',
    method: 'get',
    params: query
  })
}

// 查询火电厂核心传感器工况详细
export function getData(dataId) {
  return request({
    url: '/system/data/' + dataId,
    method: 'get'
  })
}

// 新增火电厂核心传感器工况
export function addData(data) {
  return request({
    url: '/system/data',
    method: 'post',
    data: data
  })
}

// 修改火电厂核心传感器工况
export function updateData(data) {
  return request({
    url: '/system/data',
    method: 'put',
    data: data
  })
}

// 删除火电厂核心传感器工况
export function delData(dataId) {
  return request({
    url: '/system/data/' + dataId,
    method: 'delete'
  })
}
