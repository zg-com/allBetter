import request from '@/utils/request'

// 查询科研奖励管理列表
export function listResearch_award(query) {
  return request({
    url: '/system/research_award/list',
    method: 'get',
    params: query
  })
}

// 查询科研奖励管理详细
export function getResearch_award(id) {
  return request({
    url: '/system/research_award/' + id,
    method: 'get'
  })
}

// 新增科研奖励管理
export function addResearch_award(data) {
  return request({
    url: '/system/research_award',
    method: 'post',
    data: data
  })
}

// 修改科研奖励管理
export function updateResearch_award(data) {
  return request({
    url: '/system/research_award',
    method: 'put',
    data: data
  })
}

// 删除科研奖励管理
export function delResearch_award(id) {
  return request({
    url: '/system/research_award/' + id,
    method: 'delete'
  })
}


//提交申请
export function applyProfile(data){
  return request({
    url: '/system/research_award/apply',
    method:'post',
    data:data
  })
}

//同意批准申请
export function approveProfile(id) {
  return request({
    url: '/system/research_award/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回申请
export function rejectProfile(data) {
  return request({
    url: '/system/research_award/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}

