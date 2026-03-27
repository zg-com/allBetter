<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联教师的主键(负责人)" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入关联教师的主键(负责人)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目编号" prop="projectNo">
        <el-input
          v-model="queryParams.projectNo"
          placeholder="请输入项目编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目来源" prop="projectSource">
        <el-input
          v-model="queryParams.projectSource"
          placeholder="请输入项目来源"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人" prop="leaderName">
        <el-input
          v-model="queryParams.leaderName"
          placeholder="请输入负责人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目签署所属年度" prop="signYear">
        <el-input
          v-model="queryParams.signYear"
          placeholder="请输入项目签署所属年度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="合同签订日期" prop="contractStartDate">
        <el-date-picker clearable
          v-model="queryParams.contractStartDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择合同签订日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="合同截止日期" prop="contractEndDate">
        <el-date-picker clearable
          v-model="queryParams.contractEndDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择合同截止日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="合同金额(万元)" prop="contractAmount">
        <el-input
          v-model="queryParams.contractAmount"
          placeholder="请输入合同金额(万元)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="到账金额(万元)" prop="arrivedAmount">
        <el-input
          v-model="queryParams.arrivedAmount"
          placeholder="请输入到账金额(万元)"
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
          v-hasPermi="['system:research_project:add']"
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
          v-hasPermi="['system:research_project:edit']"
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
          v-hasPermi="['system:research_project:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:research_project:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="research_projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="关联教师的主键(负责人)" align="center" prop="userId" />
      <el-table-column label="项目编号" align="center" prop="projectNo" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="项目来源" align="center" prop="projectSource" />
      <el-table-column label="负责人" align="center" prop="leaderName" />
      <el-table-column label="项目签署所属年度" align="center" prop="signYear" />
      <el-table-column label="合同签订日期" align="center" prop="contractStartDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractStartDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同截止日期" align="center" prop="contractEndDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="合同金额(万元)" align="center" prop="contractAmount" />
      <el-table-column label="到账金额(万元)" align="center" prop="arrivedAmount" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:research_project:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:research_project:remove']"
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

    <!-- 添加或修改科研项目经费与周期管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联教师的主键(负责人)" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入关联教师的主键(负责人)" />
        </el-form-item>
        <el-form-item label="项目编号" prop="projectNo">
          <el-input v-model="form.projectNo" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目来源" prop="projectSource">
          <el-input v-model="form.projectSource" placeholder="请输入项目来源" />
        </el-form-item>
        <el-form-item label="负责人" prop="leaderName">
          <el-input v-model="form.leaderName" placeholder="请输入负责人" />
        </el-form-item>
        <el-form-item label="项目签署所属年度" prop="signYear">
          <el-input v-model="form.signYear" placeholder="请输入项目签署所属年度" />
        </el-form-item>
        <el-form-item label="合同签订日期" prop="contractStartDate">
          <el-date-picker clearable
            v-model="form.contractStartDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择合同签订日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合同截止日期" prop="contractEndDate">
          <el-date-picker clearable
            v-model="form.contractEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择合同截止日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="合同金额(万元)" prop="contractAmount">
          <el-input v-model="form.contractAmount" placeholder="请输入合同金额(万元)" />
        </el-form-item>
        <el-form-item label="到账金额(万元)" prop="arrivedAmount">
          <el-input v-model="form.arrivedAmount" placeholder="请输入到账金额(万元)" />
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
import { listResearch_project, getResearch_project, delResearch_project, addResearch_project, updateResearch_project } from "@/api/system/research_project"

export default {
  name: "Research_project",
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
      // 科研项目经费与周期管理表格数据
      research_projectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        projectNo: null,
        projectName: null,
        projectSource: null,
        leaderName: null,
        signYear: null,
        contractStartDate: null,
        contractEndDate: null,
        contractAmount: null,
        arrivedAmount: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectNo: [
          { required: true, message: "项目编号不能为空", trigger: "blur" }
        ],
        projectName: [
          { required: true, message: "项目名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询科研项目经费与周期管理列表 */
    getList() {
      this.loading = true
      listResearch_project(this.queryParams).then(response => {
        this.research_projectList = response.rows
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
        projectNo: null,
        projectName: null,
        projectSource: null,
        leaderName: null,
        signYear: null,
        contractStartDate: null,
        contractEndDate: null,
        contractAmount: null,
        arrivedAmount: null,
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
      this.title = "添加科研项目经费与周期管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getResearch_project(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改科研项目经费与周期管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateResearch_project(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addResearch_project(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除科研项目经费与周期管理编号为"' + ids + '"的数据项？').then(function() {
        return delResearch_project(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/research_project/export', {
        ...this.queryParams
      }, `research_project_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
