<template>
  <div class="dashboard-editor-container">
    <div class="view-switcher" style="text-align: center; margin-bottom: 20px;">
      <el-radio-group v-model="currentView" size="medium">
        <el-radio-button label="Overview">🌟 全院概览</el-radio-button>
        <el-radio-button label="Research">🔬 科研与人才</el-radio-button>
        <el-radio-button label="Teaching">📚 教务与学工</el-radio-button>
      </el-radio-group>
    </div>

    <panel-group :view-type="currentView" />

    <el-row v-if="currentView === 'Research'" :gutter="32">
      <el-col :xs="24" :sm="24" :lg="16">
        <div class="chart-wrapper">
          <research-fund-chart :chart-data="researchChartData" />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="8">
        <div class="chart-wrapper">
          <paper-pie-chart :chart-data="paperChartData" />
        </div>
      </el-col>
    </el-row>

    <div v-else-if="currentView === 'Overview'">
      <el-row :gutter="32">
        <el-col :xs="24" :sm="24" :lg="12">
          <div class="chart-wrapper"><student-bar-chart :chart-data="studentChartData" /></div>
        </el-col>
        <el-col :xs="24" :sm="24" :lg="12">
          <div class="chart-wrapper"><course-status-pie-chart :chart-data="courseStatusChartData" /></div>
        </el-col>
      </el-row>
    </div>
    <div v-else>
      <el-row :gutter="32">
        <el-col :xs="24" :sm="24" :lg="14">
          <div class="chart-wrapper">
            <course-saturation-chart :chart-data="saturationChartData" />
          </div>
        </el-col>
        <el-col :xs="24" :sm="24" :lg="10">
          <div class="chart-wrapper">
            <student-learn-status-chart :chart-data="learnStatusChartData" />
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
import PanelGroup from './dashboard/PanelGroup'
import ResearchFundChart from './dashboard/ResearchFundChart'
// 👇 第一处：检查这里！你有没有把我们新建的饼图组件 import 进来？
import PaperPieChart from './dashboard/PaperPieChart.vue'
import StudentBarChart from './dashboard/StudentBarChart'
import { getResearchChart, getPaperChart, getStudentChart,getCourseStatusChart,getSaturationChart, getLearnStatusChart } from '@/api/dashboard/index'
import CourseStatusPieChart from './dashboard/CourseStatusPieChart'
import CourseSaturationChart from './dashboard/CourseSaturationChart'
import StudentLearnStatusChart from './dashboard/StudentLearnStatusChart'
export default {
  name: 'Index',
  components: {
    PanelGroup,
    ResearchFundChart,
    PaperPieChart,
    StudentBarChart,
    CourseStatusPieChart,
    CourseSaturationChart,
    StudentLearnStatusChart// 👉 注册组件
  },
  data() {
    return {
      // 默认选中全院概览
      currentView: 'Overview',
      researchChartData: [],   // 存放图表数据的数组
      paperChartData: [],
      studentChartData: [],
      courseStatusChartData: [],
      saturationChartData: [],
      learnStatusChartData: []
    };
  },

  computed: {
    currentViewText() {
      const map = {
        'Overview': '全院概览',
        'Research': '科研与人才',
        'Teaching': '教务与学工'
      }
      return map[this.currentView];
    }
  },
  created() {
    this.fetchCharts();
  },
  methods: {
    fetchCharts() {
      // 拉取图表真实数据
      getResearchChart().then(res => {
        this.researchChartData = res.data;
      });
      getPaperChart().then(res => { this.paperChartData = res.data }); // 新增
      getStudentChart().then(res => { this.studentChartData = res.data });
      getCourseStatusChart().then(res => { this.courseStatusChartData = res.data });
      getSaturationChart().then(res => { this.saturationChartData = res.data });
      getLearnStatusChart().then(res => { this.learnStatusChartData = res.data });
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: #f0f2f5; // 经典的后台高级灰背景
  position: relative;
  min-height: calc(100vh - 84px);
}
</style>
