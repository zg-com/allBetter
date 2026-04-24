<template>
  <div class="app-container">
    <el-card shadow="hover" header="👨‍🏫 我的教学课程">
      <el-table v-loading="loading" :data="courseList">
        <el-table-column label="课程编号" align="center" prop="id" width="80" />
        <el-table-column label="课程名称" align="center" prop="courseName" />
        <el-table-column label="学分" align="center" prop="credits" width="80" />
        <el-table-column label="最大容量" align="center" prop="volume" width="100" />
        <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button
              size="mini"
              type="primary"
              icon="el-icon-user-solid"
              @click="openStudentList(scope.row)"
              v-hasPermi="['system:teacherGrade:list']"
            >学生名单与成绩管理</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <el-dialog :title="dialogTitle" :visible.sync="studentOpen" width="850px" append-to-body>

      <div style="margin-bottom: 15px;">
        <el-button
          type="success"
          icon="el-icon-video-play"
          @click="handleStartCourse"
          :disabled="studentList.length === 0"
          v-hasPermi="['system:teacherGrade:edit']"
        >
          一键开启本课教学
        </el-button>
        <span style="color: #909399; font-size: 13px; margin-left: 15px;">
          (点击后，本课所有“未开始”的学生将进入“正在修读”状态)
        </span>
      </div>

      <el-table v-loading="studentLoading" :data="studentList" height="400">
        <el-table-column label="学号" align="center" prop="studentNo" width="100" />
        <el-table-column label="学生姓名" align="center" prop="studentName" />
        <el-table-column label="所属学院" align="center" prop="college" />

        <el-table-column label="修读状态" align="center">
          <template slot-scope="scope">
            <el-tag type="info" v-if="scope.row.learnStatus === 0 || scope.row.learnStatus === '0'">未开始</el-tag>
            <el-tag type="primary" v-if="scope.row.learnStatus === 1 || scope.row.learnStatus === '1'">正在修读</el-tag>
            <el-tag type="success" v-if="scope.row.learnStatus === 2 || scope.row.learnStatus === '2'">已结课</el-tag>
          </template>
        </el-table-column>

        <el-table-column label="成绩" align="center" prop="score">
          <template slot-scope="scope">
            <span v-if="scope.row.score !== null && scope.row.score !== undefined" style="font-weight: bold; color: #67C23A;">
              {{ scope.row.score }} 分
            </span>
            <span v-else style="color: #ccc;">待打分</span>
          </template>
        </el-table-column>

        <el-table-column label="操作" align="center">
          <template slot-scope="scope">
            <el-button
              v-if="scope.row.learnStatus === 1 || scope.row.learnStatus === '1'"
              size="mini"
              type="text"
              icon="el-icon-edit"
              @click="handleGrade(scope.row)"
              v-hasPermi="['system:teacherGrade:edit']"
            >录入成绩</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>

    <el-dialog title="学生成绩录入" :visible.sync="gradeOpen" width="350px" append-to-body>
      <el-form ref="gradeForm" :model="gradeForm" :rules="gradeRules" label-width="80px">
        <el-form-item label="最终分数" prop="score">
          <el-input-number
            v-model="gradeForm.score"
            :min="0"
            :max="100"
            :precision="2"
            placeholder="0-100分"
            style="width: 100%;"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitGrade">确 定</el-button>
        <el-button @click="gradeOpen = false">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
// 🎯 完美引入刚刚写好的 API
import { getTeacherCourseList, getCourseStudentList, startTeacherCourse, gradeTeacherStudent } from "@/api/system/teacherGrade";

export default {
  name: "TeacherGrade",
  data() {
    return {
      // 主表数据
      loading: true,
      courseList: [],

      // 子表（学生名单）数据
      studentOpen: false,
      studentLoading: false,
      studentList: [],
      currentCourseId: null,
      dialogTitle: "",

      // 打分表单数据
      gradeOpen: false,
      gradeForm: {
        id: undefined, // ⚠️ 请确保你的 biz_student_course 表的主键叫 id。如果叫 student_course_id，请在这里修改！
        score: undefined
      },
      gradeRules: {
        score: [{ required: true, message: "请录入有效的成绩", trigger: "blur" }]
      }
    };
  },
  created() {
    this.getCourseList();
  },
  methods: {
    /** 1. 获取当前登录教师的课程列表 */
    getCourseList() {
      this.loading = true;
      getTeacherCourseList().then(response => {
        this.courseList = response.rows;
        this.loading = false;
      });
    },

    /** 2. 打开学生名单子窗口 */
    openStudentList(row) {
      this.currentCourseId = row.id;
      this.dialogTitle = "《" + row.courseName + "》 - 学生修读名单";
      this.studentOpen = true;
      this.getStudentList();
    },

    /** 3. 加载指定课程的学生数据 */
    getStudentList() {
      this.studentLoading = true;
      getCourseStudentList({ courseId: this.currentCourseId }).then(response => {
        this.studentList = response.rows;
        this.studentLoading = false;
      });
    },

    /** 4. 触发一键开课 */
    handleStartCourse() {
      this.$modal.confirm('确认开启本课教学任务？这会将所有“未开始”的学生置为“正在修读”。').then(() => {
        return startTeacherCourse(this.currentCourseId);
      }).then(() => {
        this.getStudentList(); // 刷新学生列表，状态会变绿
        this.$modal.msgSuccess("教学任务已开启！");
      }).catch(() => {});
    },

    /** 5. 打开单人打分弹窗 */
    handleGrade(row) {
      // ⚠️ 极其关键：将当前行的主键赋给表单。如果你的主键不叫 id，请在这里修改！
      this.gradeForm.id = row.id;
      this.gradeForm.score = undefined; // 清空上次输入
      this.gradeOpen = true;
    },

    /** 6. 提交成绩到后端 */
    submitGrade() {
      this.$refs["gradeForm"].validate(valid => {
        if (valid) {
          gradeTeacherStudent(this.gradeForm).then(response => {
            this.$modal.msgSuccess("成绩录入成功，该生已结课！");
            this.gradeOpen = false;
            this.getStudentList(); // 刷新学生列表，成绩会显现，状态变成已结课
          });
        }
      });
    }
  }
};
</script>
