<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联sys_user的ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入关联sys_user的ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学号(登录账号)" prop="studentNo">
        <el-input
          v-model="queryParams.studentNo"
          placeholder="请输入学号(登录账号)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="realName">
        <el-input
          v-model="queryParams.realName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别(0男 1女)" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别(0男 1女)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idCard">
        <el-input
          v-model="queryParams.idCard"
          placeholder="请输入身份证号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属学院" prop="college">
        <el-input
          v-model="queryParams.college"
          placeholder="请输入所属学院"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属专业" prop="major">
        <el-input
          v-model="queryParams.major"
          placeholder="请输入所属专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所属班级" prop="className">
        <el-input
          v-model="queryParams.className"
          placeholder="请输入所属班级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入学年份(如:2023级)" prop="enrollmentYear">
        <el-input
          v-model="queryParams.enrollmentYear"
          placeholder="请输入入学年份(如:2023级)"
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
          v-hasPermi="['system:student_profile:add']"
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
          v-hasPermi="['system:student_profile:edit']"
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
          v-hasPermi="['system:student_profile:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:student_profile:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="student_profileList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="关联sys_user的ID" align="center" prop="userId" />
      <el-table-column label="学号(登录账号)" align="center" prop="studentNo" />
      <el-table-column label="姓名" align="center" prop="realName" />
      <el-table-column label="性别(0男 1女)" align="center" prop="gender" />
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="所属学院" align="center" prop="college" />
      <el-table-column label="所属专业" align="center" prop="major" />
      <el-table-column label="所属班级" align="center" prop="className" />
      <el-table-column label="入学年份(如:2023级)" align="center" prop="enrollmentYear" />
      <el-table-column label="学籍状态(在读/毕业/休学)" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:student_profile:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:student_profile:remove']"
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

    <!-- 添加或修改学生基础学籍档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联sys_user的ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入关联sys_user的ID" />
        </el-form-item>
        <el-form-item label="学号(登录账号)" prop="studentNo">
          <el-input v-model="form.studentNo" placeholder="请输入学号(登录账号)" />
        </el-form-item>
        <el-form-item label="姓名" prop="realName">
          <el-input v-model="form.realName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别(0男 1女)" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别(0男 1女)" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="所属学院" prop="college">
          <el-input v-model="form.college" placeholder="请输入所属学院" />
        </el-form-item>
        <el-form-item label="所属专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入所属专业" />
        </el-form-item>
        <el-form-item label="所属班级" prop="className">
          <el-input v-model="form.className" placeholder="请输入所属班级" />
        </el-form-item>
        <el-form-item label="入学年份(如:2023级)" prop="enrollmentYear">
          <el-input v-model="form.enrollmentYear" placeholder="请输入入学年份(如:2023级)" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
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
import { listStudent_profile, getStudent_profile, delStudent_profile, addStudent_profile, updateStudent_profile } from "@/api/system/student_profile"

export default {
  name: "Student_profile",
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
      // 学生基础学籍档案表格数据
      student_profileList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        studentNo: null,
        realName: null,
        gender: null,
        idCard: null,
        college: null,
        major: null,
        className: null,
        enrollmentYear: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "关联sys_user的ID不能为空", trigger: "blur" }
        ],
        studentNo: [
          { required: true, message: "学号(登录账号)不能为空", trigger: "blur" }
        ],
        realName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询学生基础学籍档案列表 */
    getList() {
      this.loading = true
      listStudent_profile(this.queryParams).then(response => {
        this.student_profileList = response.rows
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
        userId: null,
        studentNo: null,
        realName: null,
        gender: null,
        idCard: null,
        college: null,
        major: null,
        className: null,
        enrollmentYear: null,
        status: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
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
      this.title = "添加学生基础学籍档案"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getStudent_profile(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改学生基础学籍档案"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateStudent_profile(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addStudent_profile(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除学生基础学籍档案编号为"' + ids + '"的数据项？').then(function() {
        return delStudent_profile(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/student_profile/export', {
        ...this.queryParams
      }, `student_profile_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
