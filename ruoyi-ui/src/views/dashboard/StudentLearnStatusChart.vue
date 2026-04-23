<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
import * as echarts from 'echarts'
require('echarts/theme/macarons')

export default {
  props: {
    className: { type: String, default: 'chart' },
    width: { type: String, default: '100%' },
    height: { type: String, default: '400px' },
    chartData: { type: Array, default: () => [] }
  },
  data() { return { chart: null } },
  watch: {
    chartData: {
      deep: true,
      handler(val) { this.setOptions(val) }
    }
  },
  mounted() { this.$nextTick(() => { this.initChart() }) },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions(this.chartData)
    },
    setOptions(data) {
      this.chart.setOption({
        title: { text: '学生课程修读进度分布', left: 'center' },
        tooltip: { trigger: 'item' },
        legend: { bottom: '10', left: 'center' },
        series: [
          {
            name: '修读人数',
            type: 'pie',
            radius: ['40%', '70%'],
            center: ['50%', '55%'],
            // 使用颜色区分进度
            color: ['#909399', '#1890ff', '#52c41a'],
            data: data,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            },
            animationDuration: 2000
          }
        ]
      })
    }
  }
}
</script>
