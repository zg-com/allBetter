import request from '@/utils/request'

// 查询学生竞赛获奖全纪录列表
export function listComp_award(query) {
  return request({
    url: '/system/comp_award/list',
    method: 'get',
    params: query
  })
}

// 查询学生竞赛获奖全纪录详细
export function getComp_award(id) {
  return request({
    url: '/system/comp_award/' + id,
    method: 'get'
  })
}

// 新增学生竞赛获奖全纪录
export function addComp_award(data) {
  return request({
    url: '/system/comp_award',
    method: 'post',
    data: data
  })
}

// 修改学生竞赛获奖全纪录
export function updateComp_award(data) {
  return request({
    url: '/system/comp_award',
    method: 'put',
    data: data
  })
}

// 删除学生竞赛获奖全纪录
export function delComp_award(id) {
  return request({
    url: '/system/comp_award/' + id,
    method: 'delete'
  })
}
