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

//老师提交申请
export function applyProfile(data){
  return request({
    url: '/system/research_project/apply',
    method:'post',
    data:data
  })
}

//同意教师认识档案批准
export function approveProfile(id) {
  return request({
    url: '/system/research_project/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/research_project/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
