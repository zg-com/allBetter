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
        title: { text: '论文成果级别分布', left: 'center', textStyle: { fontSize: 16, color: '#666' } },
        tooltip: { trigger: 'item', formatter: '{a} <br/>{b} : {c} ({d}%)' },
        legend: { left: 'center', bottom: '10' },
        series: [
          {
            name: '论文级别',
            type: 'pie',
            roseType: 'radius', // 南丁格尔玫瑰图效果
            radius: [30, 110],
            center: ['50%', '50%'],
            data: data,
            animationEasing: 'cubicInOut',
            animationDuration: 2600
          }
        ]
      })
    }
  }
}
</script>
