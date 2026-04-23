<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="medium"
          @click="openSelectCourseDialog"
        >前往选课大厅</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loadingMyCourses" :data="myCourseList">
      <el-table-column label="课程代码" align="center" prop="courseCode" width="120" />
      <el-table-column label="课程名称" align="center" prop="courseName" show-overflow-tooltip />
      <el-table-column label="任课教师" align="center" prop="teacherName" width="120" />
      <el-table-column label="学分" align="center" prop="credits" width="80" />
      <el-table-column label="开课学期" align="center" prop="semester" width="150" />
      <el-table-column label="修读状态" align="center" width="100">
        <template slot-scope="scope">
          <el-tag type="success" v-if="scope.row.learnStatus === 0">未开始</el-tag>
          <el-tag type="warning" v-else-if="scope.row.learnStatus === 1">修读中</el-tag>
          <el-tag type="info" v-else>已结课</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="120">
        <template slot-scope="scope">
          <el-button
            size="small"
            type="danger"
            icon="el-icon-delete"
            @click="handleDropCourse(scope.row)"
          >退选</el-button>
        </template>
      </el-table-column>
    </el-table>


    <el-dialog title="选课大厅" :visible.sync="dialogVisible" width="80%" append-to-body>
      <el-form :model="allQueryParams" ref="queryForm" size="small" :inline="true">
        <el-form-item label="课程名称" prop="courseName">
          <el-input v-model="allQueryParams.courseName" placeholder="请输入课程名称" clearable @keyup.enter.native="getAllCourseList"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="getAllCourseList">搜索</el-button>
        </el-form-item>
      </el-form>

      <el-table v-loading="loadingAllCourses" :data="allCourseList">
        <el-table-column label="课程名称" align="center" prop="courseName" />
        <el-table-column label="任课教师" align="center" prop="teacherName" />
        <el-table-column label="学分" align="center" prop="credits" />
        <el-table-column label="容量" align="center">
          <template slot-scope="scope">
            <el-tag :type="scope.row.currentNumofpeople >= scope.row.volume ? 'danger' : 'success'">
              {{ scope.row.currentNumofpeople }} / {{ scope.row.volume }}
            </el-tag>
          </template>
        </el-table-column>

        <el-table-column label="操作" align="center" width="120">
          <template slot-scope="scope">
            <el-button
              v-if="selectedCourseIds.includes(scope.row.id)"
              size="small" type="success" disabled plain>已选择</el-button>

            <el-button
              v-else-if="scope.row.currentNumofpeople >= scope.row.volume"
              size="small" type="info" disabled>已满</el-button>

            <el-button
              v-else
              size="small" type="primary" icon="el-icon-thumb"
              @click="handleSelectCourse(scope.row)">立刻选课</el-button>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="allTotal>0" :total="allTotal" :page.sync="allQueryParams.pageNum" :limit.sync="allQueryParams.pageSize" @pagination="getAllCourseList" />
    </el-dialog>

  </div>
</template>

<script>
// 引入中间表接口（我的课表、选课、退选）
import { listStudent_course, addStudent_course, delStudent_course } from "@/api/system/student_course";
// 引入课程表接口（大厅查所有课）
import { listCourse } from "@/api/system/course";

export default {
  name: "StudentCourseSelection",
  data() {
    return {
      // ==== 我的课表相关状态 ====
      loadingMyCourses: true,
      myCourseList: [],
      selectedCourseIds: [], // 极其关键：存放我已经选过的课程 ID (courseId)
      myQueryParams: {
        pageNum: 1,
        pageSize: 100, // 假设一个学生最多选100门课，直接查全
        userId: null,  // 挂载时会赋予当前登录人ID
      },

      // ==== 选课大厅相关状态 ====
      dialogVisible: false,
      loadingAllCourses: false,
      allTotal: 0,
      allCourseList: [],
      allQueryParams: {
        pageNum: 1,
        pageSize: 10,
        courseName: null
      }
    };
  },
  created() {
    // 页面初始化时，必须拿到当前用户的ID，然后只查自己的课
    this.myQueryParams.userId = this.$store.state.user.id || this.$store.state.user.userId;
    this.getMyCourseList();
  },
  methods: {
    /** 1. 获取我的课表数据 */
    getMyCourseList() {
      this.loadingMyCourses = true;
      listStudent_course(this.myQueryParams).then(response => {
        this.myCourseList = response.rows;
        // 🎯 架构师魔法：把我的课表中所有的 courseId 提取出来，存成一个简单的数组 [1, 5, 8]
        // 这样在选课大厅里，只要判断课的 id 在不在这个数组里，就知道选没选过！
        this.selectedCourseIds = this.myCourseList.map(item => item.courseId);
        this.loadingMyCourses = false;
      });
    },

    /** 2. 点击退选按钮 */
    handleDropCourse(row) {
      this.$modal.confirm('确定要退选【' + row.courseName + '】吗？').then(() => {
        // 退选就是删除中间表的关联记录 (注意传的是中间表的主键 id)
        return delStudent_course(row.id);
      }).then(() => {
        this.getMyCourseList(); // 刷新我的课表
        this.$modal.msgSuccess("退选成功");
      }).catch(() => {});
    },

    /** 3. 打开选课大厅弹窗 */
    openSelectCourseDialog() {
      this.dialogVisible = true;
      this.getAllCourseList(); // 弹窗打开时，去拉取所有课程
    },

    /** 4. 获取所有课程列表 (用于大厅) */
    getAllCourseList() {
      this.loadingAllCourses = true;
      listCourse(this.allQueryParams).then(response => {
        this.allCourseList = response.rows;
        this.allTotal = response.total;
        this.loadingAllCourses = false;
      });
    },

    /** 5. 点击立刻选课 */
    handleSelectCourse(row) {
      this.$modal.confirm('确定选择【' + row.courseName + '】吗？').then(() => {
        const studentCourseData = {
          courseId: row.id,
          userId: this.myQueryParams.userId,
          studentNo: this.$store.state.user.userName, // 假设账号即学号
          chooseStatus: 1,
          learnStatus: 0,
          earnedCredits: 0
        };
        return addStudent_course(studentCourseData);
      }).then(() => {
        this.$modal.msgSuccess("选课成功！");
        this.getAllCourseList(); // 刷新大厅列表 (更新容量和按钮状态)
        this.getMyCourseList();  // 刷新我的主页列表 (把新课加进来)
      }).catch(() => {});
    }
  }
};
</script>
