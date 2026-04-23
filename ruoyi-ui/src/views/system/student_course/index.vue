<template>
  <div class="app-container">
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-school"
          size="medium"
          @click="openSelectCourseDialog"
        >进入选课大厅</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loadingMyCourses" :data="myCourseList">
      <el-table-column label="课程代码" align="center" prop="courseCode" width="100" />
      <el-table-column label="课程名称" align="center" prop="courseName" show-overflow-tooltip />
      <el-table-column label="任课教师" align="center" prop="teacherName" width="100" />
      <el-table-column label="学期" align="center" prop="semester" width="120" />

      <el-table-column label="修读状态" align="center" width="100">
        <template slot-scope="scope">
          <el-tag type="success" v-if="scope.row.learnStatus === 0">未开始</el-tag>
          <el-tag type="warning" v-else-if="scope.row.learnStatus === 1">修读中</el-tag>
          <el-tag type="info" v-else-if="scope.row.learnStatus === 2">已结课</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="学分" align="center" prop="credits" width="60" />
      <el-table-column label="最终成绩" align="center" width="100">
        <template slot-scope="scope">
          <span v-if="scope.row.score !== null" :style="{ color: scope.row.score < 60 ? 'red' : '#606266', fontWeight: 'bold' }">
            {{ scope.row.score }}
          </span>
          <span v-else style="color: #909399">暂无</span>
        </template>
      </el-table-column>
      <el-table-column label="已获学分" align="center" width="80">
        <template slot-scope="scope">
          <span :style="{ color: scope.row.earnedCredits > 0 ? '#67C23A' : '#909399' }">
            {{ scope.row.earnedCredits }}
          </span>
        </template>
      </el-table-column>

      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="100">
        <template slot-scope="scope">
          <el-button
            v-if="scope.row.learnStatus === 0 && scope.row.score === null"
            size="mini"
            type="danger"
            plain
            icon="el-icon-delete"
            @click="handleDropCourse(scope.row)"
          >退选</el-button>
          <span v-else style="color: #c0c4cc; font-size: 12px;">不可退选</span>
        </template>
      </el-table-column>
    </el-table>


    <el-dialog title="全校选课大厅" :visible.sync="dialogVisible" width="85%" append-to-body>
      <el-form :model="allQueryParams" ref="queryForm" size="small" :inline="true">
        <el-form-item label="课程名称" prop="courseName">
          <el-input v-model="allQueryParams.courseName" placeholder="请输入课程名称" clearable @keyup.enter.native="getAllCourseList"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="getAllCourseList">搜索</el-button>
        </el-form-item>
      </el-form>

      <el-table v-loading="loadingAllCourses" :data="allCourseList">
        <el-table-column label="课程代码" align="center" prop="courseCode" width="100" />
        <el-table-column label="课程名称" align="center" prop="courseName" />
        <el-table-column label="任课教师" align="center" prop="teacherName" width="100" />
        <el-table-column label="学分" align="center" prop="credits" width="60" />
        <el-table-column label="容量情况" align="center" width="120">
          <template slot-scope="scope">
            <el-tag :type="scope.row.currentNumofpeople >= scope.row.volume ? 'danger' : 'success'">
              {{ scope.row.currentNumofpeople }} / {{ scope.row.volume }}
            </el-tag>
          </template>
        </el-table-column>

        <el-table-column label="操作" align="center" width="120">
          <template slot-scope="scope">
            <el-button v-if="selectedCourseIds.includes(scope.row.id)" size="mini" type="success" disabled plain>已选择</el-button>
            <el-button v-else-if="scope.row.currentNumofpeople >= scope.row.volume" size="mini" type="info" disabled>已满载</el-button>
            <el-button v-else size="mini" type="primary" icon="el-icon-thumb" @click="handleSelectCourse(scope.row)">立刻选课</el-button>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="allTotal>0" :total="allTotal" :page.sync="allQueryParams.pageNum" :limit.sync="allQueryParams.pageSize" @pagination="getAllCourseList" />
    </el-dialog>

  </div>
</template>

<script>
import { listStudent_course, addStudent_course, delStudent_course } from "@/api/system/student_course";
import { listCourse } from "@/api/system/course";

export default {
  name: "StudentCourseSelection",
  data() {
    return {
      // ==== 我的课表 ====
      loadingMyCourses: true,
      myCourseList: [],
      selectedCourseIds: [],
      myQueryParams: {
        pageNum: 1,
        pageSize: 100,
        userId: null,
      },

      // ==== 选课大厅 ====
      dialogVisible: false,
      loadingAllCourses: false,
      allTotal: 0,
      allCourseList: [],
      allQueryParams: {
        pageNum: 1,
        pageSize: 10,
        courseName: null,
        // 🎯 核心护城河：大厅绝对只查审核已通过(status=1)的课程！
        status: 1
      }
    };
  },
  created() {
    this.myQueryParams.userId = this.$store.state.user.id || this.$store.state.user.userId;
    this.getMyCourseList();
  },
  methods: {
    getMyCourseList() {
      this.loadingMyCourses = true;
      listStudent_course(this.myQueryParams).then(response => {
        this.myCourseList = response.rows;
        this.selectedCourseIds = this.myCourseList.map(item => item.courseId);
        this.loadingMyCourses = false;
      });
    },

    handleDropCourse(row) {
      this.$modal.confirm('确定要退选【' + row.courseName + '】吗？').then(() => {
        // 退选删除的是中间表的 ID
        return delStudent_course(row.id);
      }).then(() => {
        this.getMyCourseList();
        this.$modal.msgSuccess("退选成功");
      }).catch(() => {});
    },

    openSelectCourseDialog() {
      this.dialogVisible = true;
      this.getAllCourseList();
    },

    getAllCourseList() {
      this.loadingAllCourses = true;
      listCourse(this.allQueryParams).then(response => {
        this.allCourseList = response.rows;
        this.allTotal = response.total;
        this.loadingAllCourses = false;
      });
    },

    handleSelectCourse(row) {
      this.$modal.confirm('确定选择【' + row.courseName + '】吗？').then(() => {
        // 🎯 严格按照 SQL 字典组装提交数据
        const studentCourseData = {
          courseId: row.id,
          userId: this.myQueryParams.userId,
          studentNo: this.$store.state.user.userName,
          chooseStatus: 1, // 1：已选中
          learnStatus: 0,  // 0：未修读
          score: null,     // 初始没成绩
          earnedCredits: 0.0 // 初始没学分
        };
        return addStudent_course(studentCourseData);
      }).then(() => {
        this.$modal.msgSuccess("选课成功！");
        this.getAllCourseList();
        this.getMyCourseList();
      }).catch(() => {});
    }
  }
};
</script>
