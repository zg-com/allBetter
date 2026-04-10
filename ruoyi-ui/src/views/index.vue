<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <div class="welcome-box">
          <h1>欢迎使用科研教务综合管理系统</h1>
          <p class="subtitle">
            高效、智能、便捷的数字化校园基座
          </p>
          <el-divider />
          <div class="info-section">
            <p><i class="el-icon-s-custom"></i> <strong>当前登录身份：</strong> 请通过左侧菜单栏进行业务操作。</p>
            <p><i class="el-icon-message-solid"></i> <strong>系统公告：</strong> 平台已完成最新版本迭代，各模块运行平稳。</p>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 可以在这里写点 JS 逻辑，现在暂时留空
    };
  },
};
</script>

<style scoped lang="scss">
.home {
  padding: 40px;
  background-color: #f4f6f8;
  min-height: calc(100vh - 84px);
}
.welcome-box {
  background: #ffffff;
  padding: 50px;
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  text-align: center;

  h1 {
    font-size: 36px;
    color: #303133;
    font-weight: 600;
    margin-bottom: 15px;
  }

  .subtitle {
    font-size: 18px;
    color: #909399;
    margin-bottom: 30px;
  }

  .info-section {
    margin-top: 30px;
    font-size: 16px;
    color: #606266;
    line-height: 2;
    text-align: left;
    display: inline-block;
  }
}
</style>
