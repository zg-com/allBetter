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
  beforeDestroy() {
    if (!this.chart) { return }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart() {
      this.chart = echarts.init(this.$el, 'macarons')
      this.setOptions(this.chartData)
    },
    setOptions(data) {
      if (!data || data.length === 0) return;

      const yAxisData = data.map(item => item.name);
      const seriesData = data.map(item => item.value);

      this.chart.setOption({
        title: { text: '平台各系部师生入驻分布', textStyle: { fontSize: 16, color: '#666' } },
        tooltip: { trigger: 'axis', axisPointer: { type: 'shadow' } },
        grid: { left: '3%', right: '10%', bottom: '3%', containLabel: true },
        xAxis: {
          type: 'value',
          boundaryGap: [0, 0.01],
          splitLine: { show: true, lineStyle: { type: 'dashed', color: '#eee' } }
        },
        yAxis: {
          type: 'category',
          data: yAxisData,
          axisLabel: { interval: 0, color: '#666', fontWeight: 'bold' }
        },
        series: [
          {
            name: '系统用户数',
            type: 'bar',
            barWidth: '50%', // 条形的宽度
            label: {
              show: true,
              position: 'right', // 数字显示在条形图右侧
              color: '#36a3f7',
              fontWeight: 'bold'
            },
            itemStyle: {
              borderRadius: [0, 5, 5, 0], // 右侧圆角
              // 极其酷炫的渐变色配置
              color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [
                { offset: 0, color: '#83bff6' },
                { offset: 0.5, color: '#188df0' },
                { offset: 1, color: '#188df0' }
              ])
            },
            data: seriesData,
            animationDuration: 2000
          }
        ]
      })
    }
  }
}
</script>
