import request from '@/utils/request'

// 查询教师历年学习经历与证书列表
export function listEducation(query) {
  return request({
    url: '/system/education/list',
    method: 'get',
    params: query
  })
}

// 查询教师历年学习经历与证书详细
export function getEducation(id) {
  return request({
    url: '/system/education/' + id,
    method: 'get'
  })
}

// 新增教师历年学习经历与证书
export function addEducation(data) {
  return request({
    url: '/system/education',
    method: 'post',
    data: data
  })
}

// 修改教师历年学习经历与证书
export function updateEducation(data) {
  return request({
    url: '/system/education',
    method: 'put',
    data: data
  })
}

// 删除教师历年学习经历与证书
export function delEducation(id) {
  return request({
    url: '/system/education/' + id,
    method: 'delete'
  })
}

//老师提交申请
export function applyProfile(data){
  return request({
    url: '/system/education/apply',
    method:'post',
    data:data
  })
}

//同意教师认识档案批准
export function approveProfile(id) {
  return request({
    url: '/system/education/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/education/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}

