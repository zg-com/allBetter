<template>
  <el-row :gutter="40" class="panel-group">

    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel">
        <div class="card-panel-icon-wrapper icon-people">
          <i class="el-icon-user-solid card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">在校生总数</div>
          <count-to :start-val="0" :end-val="panelData.studentCount" :duration="2600" class="card-panel-num" />
        </div>
      </div>
    </el-col>

    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel">
        <div class="card-panel-icon-wrapper icon-message">
          <i class="el-icon-reading card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">当前开课总数</div>
          <count-to :start-val="0" :end-val="panelData.courseCount" :duration="3000" class="card-panel-num" />
        </div>
      </div>
    </el-col>

    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel">
        <div class="card-panel-icon-wrapper icon-money">
          <i class="el-icon-money card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">年度科研到账(万元)</div>
          <count-to :start-val="0" :end-val="panelData.researchFund" :duration="3200" class="card-panel-num" />
        </div>
      </div>
    </el-col>

    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel">
        <div class="card-panel-icon-wrapper icon-shopping">
          <i class="el-icon-document-checked card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">高水平论文发表数</div>
          <count-to :start-val="0" :end-val="panelData.paperCount" :duration="3600" class="card-panel-num" />
        </div>
      </div>
    </el-col>

  </el-row>
</template>

<script>
// 引入若依自带的数字滚动组件
import CountTo from 'vue-count-to'
import { getPanelData } from '@/api/dashboard/index'
export default {
  components: {
    CountTo
  },
  props: {
    viewType: {
      type: String,
      default: 'Overview'
    }
  },
  data() {
    return {
      // 2. 初始化一个装载真实数据的对象，全部默认设为 0
      panelData: {
        studentCount: 0,
        courseCount: 0,
        researchFund: 0,
        paperCount: 0
      }
    }
  },
  created() {
    // 3. 页面一创建，立刻去后端拉取真实数据
    this.fetchData();
  },
  methods: {
    fetchData() {
      getPanelData().then(response => {
        // 后端传回来的就是那个 Map，直接赋值给前端！
        this.panelData = response.data;
      });
    }
  }
}
</script>

<style lang="scss" scoped>
.panel-group {
  margin-top: 18px;

  .card-panel-col {
    margin-bottom: 32px;
  }

  .card-panel {
    height: 108px;
    cursor: pointer;
    font-size: 12px;
    position: relative;
    overflow: hidden;
    color: #666;
    background: #fff;
    box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
    border-color: rgba(0, 0, 0, .05);
    border-radius: 8px; // 增加圆角，更现代化
    transition: all 0.3s;

    &:hover {
      box-shadow: 0 4px 15px rgba(0, 0, 0, .15);
      transform: translateY(-3px);
      .card-panel-icon-wrapper {
        color: #fff;
      }
      .icon-people { background: #40c9c6; }
      .icon-message { background: #36a3f7; }
      .icon-money { background: #f4516c; }
      .icon-shopping { background: #34bfa3; }
    }

    .icon-people { color: #40c9c6; }
    .icon-message { color: #36a3f7; }
    .icon-money { color: #f4516c; }
    .icon-shopping { color: #34bfa3; }

    .card-panel-icon-wrapper {
      float: left;
      margin: 14px 0 0 14px;
      padding: 16px;
      transition: all 0.3s;
      border-radius: 6px;
    }

    .card-panel-icon {
      float: left;
      font-size: 48px;
    }

    .card-panel-description {
      float: right;
      font-weight: bold;
      margin: 26px;
      margin-left: 0px;

      .card-panel-text {
        line-height: 18px;
        color: #8c8c8c;
        font-size: 14px;
        margin-bottom: 12px;
      }

      .card-panel-num {
        font-size: 24px;
        color: #333;
      }
    }
  }
}
</style>
