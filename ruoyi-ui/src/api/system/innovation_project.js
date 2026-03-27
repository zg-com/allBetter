import request from '@/utils/request'

// 查询大创项目管理列表
export function listInnovation_project(query) {
  return request({
    url: '/system/innovation_project/list',
    method: 'get',
    params: query
  })
}

// 查询大创项目管理详细
export function getInnovation_project(id) {
  return request({
    url: '/system/innovation_project/' + id,
    method: 'get'
  })
}

// 新增大创项目管理
export function addInnovation_project(data) {
  return request({
    url: '/system/innovation_project',
    method: 'post',
    data: data
  })
}

// 修改大创项目管理
export function updateInnovation_project(data) {
  return request({
    url: '/system/innovation_project',
    method: 'put',
    data: data
  })
}

// 删除大创项目管理
export function delInnovation_project(id) {
  return request({
    url: '/system/innovation_project/' + id,
    method: 'delete'
  })
}
