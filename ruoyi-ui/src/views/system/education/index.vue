<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教师的user_id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入教师的user_id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="学习阶段(大专/本科/硕士/博士)" prop="eduStage">
        <el-input
          v-model="queryParams.eduStage"
          placeholder="请输入学习阶段(大专/本科/硕士/博士)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="就读院校名称" prop="schoolName">
        <el-input
          v-model="queryParams.schoolName"
          placeholder="请输入就读院校名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所学专业" prop="major">
        <el-input
          v-model="queryParams.major"
          placeholder="请输入所学专业"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="开始日期" prop="startDate">
        <el-date-picker clearable
          v-model="queryParams.startDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择开始日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="毕业日期" prop="endDate">
        <el-date-picker clearable
          v-model="queryParams.endDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择毕业日期">
        </el-date-picker>
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
          v-hasPermi="['system:education:add']"
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
          v-hasPermi="['system:education:edit']"
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
          v-hasPermi="['system:education:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:education:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="educationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="教师的user_id" align="center" prop="userId" />
      <el-table-column label="学习阶段(大专/本科/硕士/博士)" align="center" prop="eduStage" />
      <el-table-column label="就读院校名称" align="center" prop="schoolName" />
      <el-table-column label="所学专业" align="center" prop="major" />
      <el-table-column label="开始日期" align="center" prop="startDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="毕业日期" align="center" prop="endDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="学位证书扫描件地址" align="center" prop="degreeCertUrl" />
      <el-table-column label="毕业证书扫描件地址" align="center" prop="gradCertUrl" />
      <el-table-column label="当前状态" align="center" prop="status" />
      <el-table-column label="驳回原因" align="center" prop="cause" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:education:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:education:remove']"
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

    <!-- 添加或修改教师历年学习经历与证书对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教师的user_id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入教师的user_id" />
        </el-form-item>
        <el-form-item label="学习阶段(大专/本科/硕士/博士)" prop="eduStage">
          <el-input v-model="form.eduStage" placeholder="请输入学习阶段(大专/本科/硕士/博士)" />
        </el-form-item>
        <el-form-item label="就读院校名称" prop="schoolName">
          <el-input v-model="form.schoolName" placeholder="请输入就读院校名称" />
        </el-form-item>
        <el-form-item label="所学专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入所学专业" />
        </el-form-item>
        <el-form-item label="开始日期" prop="startDate">
          <el-date-picker clearable
            v-model="form.startDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="毕业日期" prop="endDate">
          <el-date-picker clearable
            v-model="form.endDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择毕业日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="学位证书扫描件地址" prop="degreeCertUrl">
          <el-input v-model="form.degreeCertUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="毕业证书扫描件地址" prop="gradCertUrl">
          <el-input v-model="form.gradCertUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="驳回原因" prop="cause">
          <el-input v-model="form.cause" type="textarea" placeholder="请输入内容" />
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
import { listEducation, getEducation, delEducation, addEducation, updateEducation } from "@/api/system/education"

export default {
  name: "Education",
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
      // 教师历年学习经历与证书表格数据
      educationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        eduStage: null,
        schoolName: null,
        major: null,
        startDate: null,
        endDate: null,
        degreeCertUrl: null,
        gradCertUrl: null,
        status: null,
        cause: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "教师的user_id不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询教师历年学习经历与证书列表 */
    getList() {
      this.loading = true
      listEducation(this.queryParams).then(response => {
        this.educationList = response.rows
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
        eduStage: null,
        schoolName: null,
        major: null,
        startDate: null,
        endDate: null,
        degreeCertUrl: null,
        gradCertUrl: null,
        createTime: null,
        status: null,
        cause: null
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
      this.title = "添加教师历年学习经历与证书"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getEducation(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改教师历年学习经历与证书"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEducation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addEducation(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除教师历年学习经历与证书编号为"' + ids + '"的数据项？').then(function() {
        return delEducation(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/education/export', {
        ...this.queryParams
      }, `education_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
