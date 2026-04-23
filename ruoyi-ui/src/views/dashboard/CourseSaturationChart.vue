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
      if (!data || data.length === 0) return;

      const yData = data.map(item => item.name).reverse(); // 课程名
      const xData = data.map(item => item.value).reverse(); // 饱和度%

      this.chart.setOption({
        title: { text: '课程选课饱和度排行 (TOP 15)', left: 'center' },
        tooltip: {
          trigger: 'axis',
          formatter: function(params) {
            const item = data.find(i => i.name === params[0].name);
            return `${item.name}<br/>饱和度: ${item.value}%<br/>实选/容量: ${item.current}/${item.volume}`;
          }
        },
        grid: { left: '3%', right: '10%', bottom: '3%', containLabel: true },
        xAxis: { type: 'value', max: 100, axisLabel: { formatter: '{value}%' } },
        yAxis: { type: 'category', data: yData, axisLabel: { fontSize: 11 } },
        series: [{
          name: '饱和度',
          type: 'bar',
          data: xData,
          label: { show: true, position: 'right', formatter: '{c}%' },
          itemStyle: {
            // 🎯 核心逻辑：根据数值动态变色
            color: function(params) {
              if (params.value >= 90) return '#f4516c'; // 爆满-红
              if (params.value <= 20) return '#909399'; // 冷清-灰
              return '#36a3f7'; // 正常-蓝
            },
            borderRadius: [0, 4, 4, 0]
          }
        }]
      })
    }
  }
}
</script>
