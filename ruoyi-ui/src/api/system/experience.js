import request from '@/utils/request'

// 查询教师兼职与访学经历列表
export function listExperience(query) {
  return request({
    url: '/system/experience/list',
    method: 'get',
    params: query
  })
}

// 查询教师兼职与访学经历详细
export function getExperience(id) {
  return request({
    url: '/system/experience/' + id,
    method: 'get'
  })
}

// 新增教师兼职与访学经历
export function addExperience(data) {
  return request({
    url: '/system/experience',
    method: 'post',
    data: data
  })
}

// 修改教师兼职与访学经历
export function updateExperience(data) {
  return request({
    url: '/system/experience',
    method: 'put',
    data: data
  })
}

// 删除教师兼职与访学经历
export function delExperience(id) {
  return request({
    url: '/system/experience/' + id,
    method: 'delete'
  })
}

//老师提交申请
export function applyProfile(data){
  return request({
    url: '/system/experience/apply',
    method:'post',
    data:data
  })
}

//同意教师认识档案批准
export function approveProfile(id) {
  return request({
    url: '/system/experience/approve',
    method: 'put',
    data: { id : id}
  })
}


//  驳回教师档案申请
export function rejectProfile(data) {
  return request({
    url: '/system/experience/reject', // 这是你刚才测试的那个驳回接口
    method: 'put',
    data: data // 包含 id 和 cause
  })
}
