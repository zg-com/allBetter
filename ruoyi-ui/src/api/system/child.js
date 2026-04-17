import request from '@/utils/request'

// 查询教师子女与妇幼档案列表
export function listChild(query) {
  return request({
    url: '/system/child/list',
    method: 'get',
    params: query
  })
}

// 查询教师子女与妇幼档案详细
export function getChild(id) {
  return request({
    url: '/system/child/' + id,
    method: 'get'
  })
}

// 新增教师子女与妇幼档案
export function addChild(data) {
  return request({
    url: '/system/child',
    method: 'post',
    data: data
  })
}

// 修改教师子女与妇幼档案
export function updateChild(data) {
  return request({
    url: '/system/child',
    method: 'put',
    data: data
  })
}

// 删除教师子女与妇幼档案
export function delChild(id) {
  return request({
    url: '/system/child/' + id,
    method: 'delete'
  })
}

//老师提交申请
export function applyProfile(data){
  return request({
    url: '/system/child/apply',
    method:'post',
    data:data
  })
}

//同意教师认识档案批准
export function approveProfile(id) {
  return request({
    url: '/system/child/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/child/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
