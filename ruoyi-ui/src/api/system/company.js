import request from '@/utils/request'

// 查询教师个人创业情况列表
export function listCompany(query) {
  return request({
    url: '/system/company/list',
    method: 'get',
    params: query
  })
}

// 查询教师个人创业情况详细
export function getCompany(id) {
  return request({
    url: '/system/company/' + id,
    method: 'get'
  })
}

// 新增教师个人创业情况
export function addCompany(data) {
  return request({
    url: '/system/company',
    method: 'post',
    data: data
  })
}

// 修改教师个人创业情况
export function updateCompany(data) {
  return request({
    url: '/system/company',
    method: 'put',
    data: data
  })
}

// 删除教师个人创业情况
export function delCompany(id) {
  return request({
    url: '/system/company/' + id,
    method: 'delete'
  })
}

//老师提交申请
export function applyProfile(data){
  return request({
    url: '/system/company/apply',
    method:'post',
    data:data
  })
}

//同意教师认识档案批准
export function approveProfile(id) {
  return request({
    url: '/system/company/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/company/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
