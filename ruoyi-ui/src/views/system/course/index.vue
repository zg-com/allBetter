<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程代码" prop="courseCode">
        <el-input
          v-model="queryParams.courseCode"
          placeholder="请输入课程代码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程名称" prop="courseName">
        <el-input
          v-model="queryParams.courseName"
          placeholder="请输入课程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程学分(如:2.5)" prop="credits">
        <el-input
          v-model="queryParams.credits"
          placeholder="请输入课程学分(如:2.5)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任课教师" prop="teacherName">
        <el-input
          v-model="queryParams.teacherName"
          placeholder="请输入任课教师"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开课学期(如:2025-2026-1)" prop="semester">
        <el-input
          v-model="queryParams.semester"
          placeholder="请输入开课学期(如:2025-2026-1)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任课教师id" prop="teacherNo">
        <el-input
          v-model="queryParams.teacherNo"
          placeholder="请输入任课教师id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程容量" prop="volume">
        <el-input
          v-model="queryParams.volume"
          placeholder="请输入课程容量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="当前选课人数" prop="currentNumofpeople">
        <el-input
          v-model="queryParams.currentNumofpeople"
          placeholder="请输入当前选课人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:course:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:course:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:course:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:course:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="课程ID" align="center" prop="id" />
      <el-table-column label="课程代码" align="center" prop="courseCode" />
      <el-table-column label="课程名称" align="center" prop="courseName" />
      <el-table-column label="课程学分(如:2.5)" align="center" prop="credits" />
      <el-table-column label="任课教师" align="center" prop="teacherName" />
      <el-table-column label="开课学期(如:2025-2026-1)" align="center" prop="semester" />
      <el-table-column label="课程描述" align="center" prop="remark" />
      <el-table-column label="任课教师id" align="center" prop="teacherNo" />
      <el-table-column label="课程当前状态" align="center" prop="status" />
      <el-table-column label="课程驳回原因" align="center" prop="cause" />
      <el-table-column label="课程容量" align="center" prop="volume" />
      <el-table-column label="当前选课人数" align="center" prop="currentNumofpeople" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:course:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:course:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改课程信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程代码" prop="courseCode">
          <el-input v-model="form.courseCode" placeholder="请输入课程代码" />
        </el-form-item>
        <el-form-item label="课程名称" prop="courseName">
          <el-input v-model="form.courseName" placeholder="请输入课程名称" />
        </el-form-item>
        <el-form-item label="课程学分(如:2.5)" prop="credits">
          <el-input v-model="form.credits" placeholder="请输入课程学分(如:2.5)" />
        </el-form-item>
        <el-form-item label="任课教师" prop="teacherName">
          <el-input v-model="form.teacherName" placeholder="请输入任课教师" />
        </el-form-item>
        <el-form-item label="开课学期(如:2025-2026-1)" prop="semester">
          <el-input v-model="form.semester" placeholder="请输入开课学期(如:2025-2026-1)" />
        </el-form-item>
        <el-form-item label="课程描述" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="任课教师id" prop="teacherNo">
          <el-input v-model="form.teacherNo" placeholder="请输入任课教师id" />
        </el-form-item>
        <el-form-item label="课程驳回原因" prop="cause">
          <el-input v-model="form.cause" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="课程容量" prop="volume">
          <el-input v-model="form.volume" placeholder="请输入课程容量" />
        </el-form-item>
        <el-form-item label="当前选课人数" prop="currentNumofpeople">
          <el-input v-model="form.currentNumofpeople" placeholder="请输入当前选课人数" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/system/course"

export default {
  name: "Course",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 课程信息表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        courseCode: null,
        courseName: null,
        credits: null,
        teacherName: null,
        semester: null,
        teacherNo: null,
        status: null,
        cause: null,
        volume: null,
        currentNumofpeople: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        courseCode: [
          { required: true, message: "课程代码不能为空", trigger: "blur" }
        ],
        courseName: [
          { required: true, message: "课程名称不能为空", trigger: "blur" }
        ],
        credits: [
          { required: true, message: "课程学分(如:2.5)不能为空", trigger: "blur" }
        ],
        teacherNo: [
          { required: true, message: "任课教师id不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询课程信息列表 */
    getList() {
      this.loading = true
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        courseCode: null,
        courseName: null,
        credits: null,
        teacherName: null,
        semester: null,
        createTime: null,
        remark: null,
        teacherNo: null,
        status: null,
        cause: null,
        volume: null,
        currentNumofpeople: null
      }
      this.resetForm("form")
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm")
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加课程信息"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getCourse(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改课程信息"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addCourse(this.form).then(response => {
              this.$modal.msgSuccess("新增成功")
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除课程信息编号为"' + ids + '"的数据项？').then(function() {
        return delCourse(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
