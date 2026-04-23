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
    height: { type: String, default: '350px' },
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
        title: { text: '全院课程审批状态分布', left: 'center', textStyle: { fontSize: 16, color: '#666' } },
        tooltip: { trigger: 'item' },
        legend: { bottom: '10', left: 'center' },
        series: [
          {
            name: '课程数量',
            type: 'pie',
            radius: ['40%', '70%'], // 🎯 核心：内圆40%外圆70%形成环形
            avoidLabelOverlap: false,
            itemStyle: { borderRadius: 10, borderColor: '#fff', borderWidth: 2 },
            label: { show: false, position: 'center' },
            emphasis: {
              label: { show: true, fontSize: '20', fontWeight: 'bold' }
            },
            data: data,
            animationDuration: 2000
          }
        ]
      })
    }
  }
}
</script>
