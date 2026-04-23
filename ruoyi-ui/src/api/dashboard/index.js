import request from '@/utils/request'

// 查询大屏顶部四个核心数据
export function getPanelData() {
  return request({
    url: '/system/dashboard/panelData',
    method: 'get'
  })
}

// 获取科研经费图表数据
export function getResearchChart() {
  return request({
    url: '/system/dashboard/researchChart',
    method: 'get'
  })
}

// 获取论文分布图表数据
export function getPaperChart() {
  return request({
    url: '/system/dashboard/paperChart',
    method: 'get'
  })
}

// 获取各学院学生人数分布图表数据
export function getStudentChart() {
  return request({
    url: '/system/dashboard/studentChart',
    method: 'get'
  })
}

// 获取课程状态分布数据
export function getCourseStatusChart() {
  return request({
    url: '/system/dashboard/courseStatusChart',
    method: 'get'
  })
}

// 获取课程饱和度排行数据
export function getSaturationChart() {
  return request({
    url: '/system/dashboard/saturationChart',
    method: 'get'
  })
}
// 获取学生修读状态分布数据
export function getLearnStatusChart() {
  return request({
    url: '/system/dashboard/learnStatusChart',
    method: 'get'
  })
}
