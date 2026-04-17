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

//老师提交申请
export function applyProfile(data){
  return request({
    url: '/system/innovation_project/apply',
    method:'post',
    data:data
  })
}

//同意教师认识档案批准
export function approveProfile(id) {
  return request({
    url: '/system/innovation_project/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/innovation_project/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
