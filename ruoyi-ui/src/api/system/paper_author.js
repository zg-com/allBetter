import request from '@/utils/request'

// 查询论文作者关联列表
export function listPaper_author(query) {
  return request({
    url: '/system/paper_author/list',
    method: 'get',
    params: query
  })
}

// 查询论文作者关联详细
export function getPaper_author(id) {
  return request({
    url: '/system/paper_author/' + id,
    method: 'get'
  })
}

// 新增论文作者关联
export function addPaper_author(data) {
  return request({
    url: '/system/paper_author',
    method: 'post',
    data: data
  })
}

// 修改论文作者关联
export function updatePaper_author(data) {
  return request({
    url: '/system/paper_author',
    method: 'put',
    data: data
  })
}

// 删除论文作者关联
export function delPaper_author(id) {
  return request({
    url: '/system/paper_author/' + id,
    method: 'delete'
  })
}
