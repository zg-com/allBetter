<template>
  <div class="dashboard-container">
    <div class="header-status">
      <div class="status-box realtime">
        <span class="label">当前机组真实负荷 <span class="time-tag">{{ currentTimeDisplay }}</span></span>
        <span class="value">{{ currentActualLoad.toFixed(2) }} <small>MW</small></span>
      </div>
      <div class="status-box predict">
        <span class="label">{{selectedHorizon === 0 ? 15 : selectedHorizon}}min 基准预测值</span>
        <span class="value">{{ latestBasePredict.toFixed(2) }} <small>MW</small></span>
      </div>
      <div class="status-box delta" :class="loadDiff >= 0 ? 'text-up' : 'text-down'">
        <span class="label">当前预测偏差 (Delta)</span>
        <span class="value">{{ loadDiff > 0 ? '+' : ''}}{{ loadDiff.toFixed(2) }} <small>MW</small></span>
      </div>
      <div class="status-box target">
        <span class="label">唤醒特化探针挡位</span>
        <span class="value target-val">{{ selectedHorizon === 0 ? '未唤醒' : selectedHorizon + ' 分钟' }}</span>
      </div>
    </div>

    <div class="control-center">
      <div class="left-controls">
        <el-button
          :type="isPlaying ? 'danger' : 'success'"
          size="small"
          :icon="isPlaying ? 'el-icon-video-pause' : 'el-icon-video-play'"
          @click="toggleSimulation"
        >
          {{ isPlaying ? '急停断流' : '启动推流' }}
        </el-button>
        <span class="data-id-tag" v-if="isPlaying">ROW_{{ currentDataId }}</span>
      </div>

      <div class="center-controls">
        <div class="slider-item">
          <span class="ctrl-label">推流频率:</span>
          <el-slider v-model="refreshInterval" :min="0.1" :max="5" :step="0.1" @change="handleIntervalChange" style="width: 70px;"></el-slider>
          <span class="ctrl-val">{{ refreshInterval }}s</span>
        </div>
        <div class="slider-item">
          <span class="ctrl-label">快进倍速:</span>
          <el-slider v-model="dataStep" :min="1" :max="120" :step="1" style="width: 70px;"></el-slider>
          <span class="ctrl-val">x {{ dataStep }}</span>
        </div>
        <div class="slider-item ai-slider">
          <span class="ctrl-label">AI唤醒跨度:</span>
          <el-slider v-model="predictFrequency" :min="1" :max="120" :step="1" style="width: 70px;"></el-slider>
          <span class="ctrl-val">{{ predictFrequency }}步/次</span>
        </div>
      </div>

      <div class="right-controls">
        <span class="ctrl-label">精准探针:</span>
        <el-radio-group v-model="selectedHorizon" size="small" @change="triggerSpecialist">
          <el-radio-button :label="0">大一统</el-radio-button>
          <el-radio-button v-for="h in horizons" :key="h" :label="h">{{ h }}m</el-radio-button>
        </el-radio-group>
      </div>
    </div>

    <div class="chart-wrapper">
      <div ref="predictChart" class="predict-chart"></div>
    </div>
  </div>
</template>

<script>
import request from '@/utils/request'
import * as echarts from 'echarts'

export default {
  name: 'Index',
  data() {
    return {
      chartInstance: null,
      timer: null,
      isPlaying: false,
      currentDataId: 3000,

      refreshInterval: 1,
      dataStep: 1,
      predictFrequency: 5,

      tickCounter: 0,
      isFirstTick: true,

      selectedHorizon: 0,
      horizons: [3, 5, 10, 15, 30, 45, 60, 120],

      currentActualLoad: 0.00,
      latestBasePredict: 0.00,
      currentTimeDisplay: '--:--:--',

      realDataList: [],         // 历史真实蓝色生命线 [[timestamp, val], ...]
      predictDataList: [],      // 【回归纯净】全图唯一一条连贯预测粉线 [[timestamp, val], ...]
      specialistPoint: [],

      lastRecordTimeMs: 0
    }
  },
  computed: {
    loadDiff() {
      if (this.currentActualLoad === 0) return 0;
      return this.latestBasePredict - this.currentActualLoad;
    }
  },
  mounted() {
    this.initChart();
    window.addEventListener('resize', this.handleResize);
  },
  beforeDestroy() {
    this.stopSimulation();
    if (this.chartInstance) this.chartInstance.dispose();
    window.removeEventListener('resize', this.handleResize);
  },
  methods: {
    initChart() {
      this.chartInstance = echarts.init(this.$refs.predictChart);
      const option = {
        backgroundColor: 'transparent',
        tooltip: {
          trigger: 'axis',
          backgroundColor: 'rgba(16, 25, 42, 0.95)',
          borderColor: '#4a5568',
          textStyle: { color: '#e2e8f0' },
          axisPointer: { type: 'cross', lineStyle: { color: '#64748b', type: 'dashed' } }
        },
        legend: {
          data: ['历史真实负荷', 'AI未来推演趋势', '特化极限探针'],
          textStyle: { color: '#cbd5e1', fontSize: 13 },
          top: 0
        },
        grid: { top: '15%', left: '4%', right: '5%', bottom: '15%', containLabel: true },

        dataZoom: [
          {
            type: 'slider',
            show: true,
            xAxisIndex: [0],
            bottom: '2%',
            height: 20,
            borderColor: 'transparent',
            backgroundColor: 'rgba(15, 23, 42, 0.8)',
            fillerColor: 'rgba(0, 242, 254, 0.2)',
            handleStyle: { color: '#00f2fe', shadowBlur: 3, shadowColor: '#00f2fe' },
            textStyle: { color: '#cbd5e1' },
            start: 70,
            end: 100
          },
          {
            type: 'inside',
            xAxisIndex: [0],
            zoomOnMouseWheel: true,
            moveOnMouseMove: true
          }
        ],

        xAxis: {
          type: 'time',
          boundaryGap: false,
          axisLine: { lineStyle: { color: '#334155' } },
          axisLabel: { color: '#94a3b8' },
          splitLine: { show: false }
        },
        yAxis: {
          type: 'value',
          scale: true, // 极其敏锐的显微镜波动模式
          name: '负荷 (MW)',
          nameTextStyle: { color: '#94a3b8', padding: [0, 0, 0, 20] },
          splitLine: { lineStyle: { color: 'rgba(255, 255, 255, 0.08)', type: 'dashed' } },
          axisLabel: { color: '#cbd5e1' }
        },
        series: [
          {
            name: '历史真实负荷',
            type: 'line',
            showSymbol: false,
            smooth: true,
            lineStyle: { width: 3, color: '#00f2fe', shadowBlur: 10, shadowColor: '#00f2fe' },
            itemStyle: { color: '#00f2fe' },
            areaStyle: {
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                { offset: 0, color: 'rgba(0, 242, 254, 0.3)' },
                { offset: 1, color: 'rgba(0, 242, 254, 0.0)' }
              ])
            },
            data: []
          },
          {
            name: 'AI未来推演趋势',
            type: 'line',
            smooth: true,
            showSymbol: true,
            symbol: 'emptyCircle',
            symbolSize: 4,
            lineStyle: { width: 2, type: 'dashed', color: '#f72585', shadowBlur: 8, shadowColor: '#f72585' },
            itemStyle: { color: '#f72585' },
            data: []
          },
          {
            name: '特化极限探针',
            type: 'scatter',
            symbol: 'pin',
            symbolSize: 45,
            itemStyle: { color: '#FFD700', shadowBlur: 20, shadowColor: '#FFD700' },
            zlevel: 10,
            data: []
          }
        ]
      };
      this.chartInstance.setOption(option);
    },

    toggleSimulation() {
      if (this.isPlaying) this.stopSimulation();
      else this.startSimulation();
    },

    startSimulation() {
      this.isPlaying = true;
      this.fetchRealDataFlow();
      this.timer = setInterval(() => {
        this.currentDataId += Number(this.dataStep) || 1;
        this.fetchRealDataFlow();
      }, (Number(this.refreshInterval) || 1) * 1000);
    },

    stopSimulation() {
      this.isPlaying = false;
      clearInterval(this.timer);
    },

    handleIntervalChange() {
      if (this.isPlaying) {
        this.stopSimulation();
        this.startSimulation();
      }
    },

    triggerSpecialist() {
      if (!this.isPlaying && this.lastRecordTimeMs > 0) {
        this.fetchPredictData(this.lastRecordTimeMs);
      }
    },

    async fetchRealDataFlow() {
      try {
        const res = await request({
          url: `/system/data/current/${this.currentDataId}`,
          method: 'get'
        });

        if (res.code === 200 && res.data) {
          const realData = res.data;
          const rawTime = realData.recordTime || realData.record_time;
          const rawLoad = realData.actualLoad || realData.actual_load;

          if (!rawTime) return;

          let nowMs = typeof rawTime === 'number' ? rawTime : new Date(rawTime.replace(/-/g, '/')).getTime();

          // 保持你调通的历史 1 分钟物理时间步进
          if (nowMs <= this.lastRecordTimeMs) {
            nowMs = this.lastRecordTimeMs + 60000*this.dataStep;
          }
          this.lastRecordTimeMs = nowMs;

          const recordDate = new Date(nowMs);
          this.currentTimeDisplay = `${recordDate.getHours().toString().padStart(2, '0')}:${recordDate.getMinutes().toString().padStart(2, '0')}:${recordDate.getSeconds().toString().padStart(2, '0')}`;

          let load = rawLoad ? parseFloat(rawLoad) : 0;
          if (load > 0) {
            this.currentActualLoad = load;
            this.realDataList.push([nowMs, this.currentActualLoad]);
          }

          this.cleanMemory(nowMs);
          this.updateECharts();

          // 流控核心：首帧必测，后续交给你修复好的步长计数器管理
          const currentStep = Number(this.dataStep) || 1;
          const triggerFreq = Number(this.predictFrequency) || 5;

          if (this.isFirstTick) {
            this.isFirstTick = false;
            this.tickCounter = 0;
            this.fetchPredictData(nowMs);
            return;
          }

          this.tickCounter += currentStep;
          if (this.tickCounter >= triggerFreq) {
            this.tickCounter = 0;
            this.fetchPredictData(nowMs);
          }
        }
      } catch (error) {
        console.error("真实数据流读取异常:", error);
      }
    },

    async fetchPredictData(baseTimeMs) {
      try {
        const res = await request({
          url: `/system/data/predict/${this.currentDataId}`,
          method: 'post',
          data: { target_horizon: this.selectedHorizon }
        });

        if (res.code === 200 && res.data && res.data.data) {
          const aiResult = res.data.data;

          let time_level = this.selectedHorizon === 0 ? 15 : this.selectedHorizon;
          const p15 = aiResult.curve_points.find(p => p.time_offset === time_level);

          if (p15 && p15.predicted_load > 0) this.latestBasePredict = p15.predicted_load;

          // ==========================================
          // 🎯 【极简单线推进算法】
          // 锁住当前时刻之前的预测，擦除当前时刻之后的未来，拼入全新 8 点
          // ==========================================
          this.predictDataList = this.predictDataList.filter(p => p[0] < baseTimeMs);

          aiResult.curve_points.forEach(point => {
            if (point.predicted_load > 0) {
              this.predictDataList.push([baseTimeMs + point.time_offset * 60000, point.predicted_load]);
            }
          });
          // ==========================================

          this.specialistPoint = [];
          if (this.selectedHorizon > 0 && aiResult.specialist_result && aiResult.specialist_result > 0) {
            this.specialistPoint.push([baseTimeMs + this.selectedHorizon * 60000, aiResult.specialist_result]);
          }

          this.updateECharts();
        }
      } catch (error) {
        console.error("AI 引擎预测异常:", error);
      }
    },

    cleanMemory(nowMs) {
      const maxMemoryTime = nowMs - 24 * 3600 * 1000;
      this.realDataList = this.realDataList.filter(item => item[0] > maxMemoryTime);
      this.predictDataList = this.predictDataList.filter(item => item[0] > maxMemoryTime);
    },

    updateECharts() {
      if (!this.chartInstance) return;

      // 纯净的 3 个常驻数据系列，彻底告别配置冲突和重合断开
      this.chartInstance.setOption({
        series: [
          { data: this.realDataList },
          { data: this.predictDataList },
          { data: this.specialistPoint }
        ]
      });
    },

    handleResize() {
      if (this.chartInstance) this.chartInstance.resize();
    }
  }
}
</script>

<style scoped>
.dashboard-container { min-height: calc(100vh - 84px); background-color: #0b1120; padding: 15px; display: flex; flex-direction: column; gap: 15px; font-family: "Helvetica Neue", Helvetica, sans-serif; }
.header-status { display: flex; gap: 12px; }
.status-box { flex: 1; background: rgba(30, 41, 59, 0.6); border: 1px solid #334155; border-radius: 6px; padding: 10px 15px; display: flex; flex-direction: column; justify-content: center; }
.realtime { border-left: 3px solid #00f2fe; } .predict { border-left: 3px solid #f72585; } .delta { border-left: 3px solid #10b981; } .target { border-left: 3px solid #FFD700; }
.status-box .label { font-size: 12px; color: #94a3b8; margin-bottom: 4px; }
.time-tag { background: rgba(0,242,254,0.1); padding: 1px 5px; border-radius: 4px; margin-left: 6px; color: #00f2fe;}
.status-box .value { font-size: 24px; font-weight: bold; color: #f8fafc; }
.status-box .value small { font-size: 12px; color: #64748b; font-weight: normal; }
.text-up .value { color: #f72585; } .text-down .value { color: #00f2fe; }
.target-val { color: #FFD700 !important; }

.control-center { display: flex; justify-content: space-between; align-items: center; background: rgba(15, 23, 42, 0.8); border-radius: 6px; padding: 10px 20px; border: 1px solid #1e293b; }
.left-controls { display: flex; align-items: center; gap: 10px; }
.data-id-tag { color: #00f2fe; font-size: 12px; background: rgba(0,242,254,0.1); padding: 4px 8px; border-radius: 4px;}

.center-controls { display: flex; align-items: center; gap: 15px; background: #1e293b; padding: 5px 15px; border-radius: 20px; }
.slider-item { display: flex; align-items: center; gap: 5px; }
.ai-slider { border-left: 1px dashed #4a5568; padding-left: 10px; margin-left: 5px; }
.ctrl-label { color: #cbd5e1; font-size: 12px; }
.ctrl-val { color: #00f2fe; font-size: 12px; font-weight: bold; width: 45px; }

.right-controls { display: flex; align-items: center; gap: 10px; }
::v-deep .el-radio-button__inner { background-color: #1e293b; border-color: #334155; color: #94a3b8; padding: 8px 12px;}
::v-deep .el-radio-button__orig-radio:checked + .el-radio-button__inner { background-color: #FFD700; border-color: #FFD700; color: #000; font-weight: bold; }

.chart-wrapper { flex: 1; background: rgba(15, 23, 42, 0.6); border-radius: 8px; padding: 15px; border: 1px solid #1e293b; }
.predict-chart { width: 100%; height: 100%; min-height: 550px; }
</style>
