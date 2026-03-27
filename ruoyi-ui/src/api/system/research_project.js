import request from '@/utils/request'

// 查询科研项目经费与周期管理列表
export function listResearch_project(query) {
  return request({
    url: '/system/research_project/list',
    method: 'get',
    params: query
  })
}

// 查询科研项目经费与周期管理详细
export function getResearch_project(id) {
  return request({
    url: '/system/research_project/' + id,
    method: 'get'
  })
}

// 新增科研项目经费与周期管理
export function addResearch_project(data) {
  return request({
    url: '/system/research_project',
    method: 'post',
    data: data
  })
}

// 修改科研项目经费与周期管理
export function updateResearch_project(data) {
  return request({
    url: '/system/research_project',
    method: 'put',
    data: data
  })
}

// 删除科研项目经费与周期管理
export function delResearch_project(id) {
  return request({
    url: '/system/research_project/' + id,
    method: 'delete'
  })
}
