<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
// 引入 ECharts
import * as echarts from 'echarts'
require('echarts/theme/macarons') // 引入若依自带的主题

export default {
  props: {
    className: { type: String, default: 'chart' },
    width: { type: String, default: '100%' },
    height: { type: String, default: '350px' },
    // 接收父组件传来的真实数据
    chartData: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      chart: null
    }
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val)
      }
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initChart()
    })
  },
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

      // 提取横坐标(年份)和纵坐标(金额)
      const xAxisData = data.map(item => item.statYear + '年');
      const contractData = data.map(item => item.contractAmount);
      const arrivedData = data.map(item => item.arrivedAmount);

      this.chart.setOption({
        title: { text: '历年科研经费对比 (合同 vs 到账)', left: 'center', textStyle: { color: '#666', fontSize: 16 } },
        tooltip: { trigger: 'axis', axisPointer: { type: 'shadow' } },
        legend: { data: ['合同总额(万)', '到账总额(万)'], bottom: '0' },
        grid: { left: '3%', right: '4%', bottom: '15%', containLabel: true },
        xAxis: [{
          type: 'category',
          data: xAxisData,
          axisTick: { alignWithLabel: true }
        }],
        yAxis: [{
          type: 'value',
          name: '金额 (万元)',
          splitLine: { lineStyle: { type: 'dashed' } }
        }],
        series: [
          {
            name: '合同总额(万)',
            type: 'bar',
            barWidth: '20%',
            itemStyle: { borderRadius: [4, 4, 0, 0], color: '#36a3f7' },
            data: contractData,
            animationDuration: 2000 // 酷炫的入场动画时长
          },
          {
            name: '到账总额(万)',
            type: 'bar',
            barWidth: '20%',
            itemStyle: { borderRadius: [4, 4, 0, 0], color: '#f4516c' },
            data: arrivedData,
            animationDuration: 2000
          }
        ]
      })
    }
  }
}
</script>
