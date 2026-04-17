<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="负责人姓名" prop="leaderName">
        <el-input
          v-model="queryParams.leaderName"
          placeholder="请输入负责人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="指导教师" prop="instructorName">
        <el-input
          v-model="queryParams.instructorName"
          placeholder="请输入指导教师"
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
          v-hasPermi="['system:innovation_project:add']"
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
          v-hasPermi="['system:innovation_project:edit']"
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
          v-hasPermi="['system:innovation_project:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:innovation_project:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="innovation_projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目编号" align="center" prop="projectNo" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="项目级别(国家级/省级/校级)" align="center" prop="projectLevel" />
      <el-table-column label="项目类型(创新/创业等)" align="center" prop="projectType" />
      <el-table-column label="负责人学号" align="center" prop="leaderNo" />
      <el-table-column label="负责人姓名" align="center" prop="leaderName" />
      <el-table-column label="团队其他成员" align="center" prop="teamMembers" />
      <el-table-column label="指导教师" align="center" prop="instructorName" />
      <el-table-column label="立项年份" align="center" prop="approvalYear" />
      <el-table-column label="项目状态(0进行中 1已结题)" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="用户名id" align="center" prop="userId" />
      <el-table-column label="当前状态" align="center" prop="status1" />
      <el-table-column label="驳回原因" align="center" prop="cause" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleApprove(scope.row)"
            style="color:#67C23A;"
            v-hasPermi="['system:profile:edit']"
          >同意</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleReject(scope.row)"
            style="color: #F56C6C;"
            v-hasPermi="['system:profile:remove']"
          >驳回</el-button>
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

    <!-- 添加或修改大创项目管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目编号" prop="projectNo">
          <el-input v-model="form.projectNo" placeholder="请输入项目编号" />
        </el-form-item>
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目级别(国家级/省级/校级)" prop="projectLevel">
          <el-input v-model="form.projectLevel" placeholder="请输入项目级别(国家级/省级/校级)" />
        </el-form-item>
        <el-form-item label="负责人学号" prop="leaderNo">
          <el-input v-model="form.leaderNo" placeholder="请输入负责人学号" />
        </el-form-item>
        <el-form-item label="负责人姓名" prop="leaderName">
          <el-input v-model="form.leaderName" placeholder="请输入负责人姓名" />
        </el-form-item>
        <el-form-item label="团队其他成员" prop="teamMembers">
          <el-input v-model="form.teamMembers" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="指导教师" prop="instructorName">
          <el-input v-model="form.instructorName" placeholder="请输入指导教师" />
        </el-form-item>
        <el-form-item label="立项年份" prop="approvalYear">
          <el-input v-model="form.approvalYear" placeholder="请输入立项年份" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户名id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户名id" />
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
import { listInnovation_project, getInnovation_project, delInnovation_project, addInnovation_project, updateInnovation_project ,approveProfile, rejectProfile} from "@/api/system/innovation_project"

export default {
  name: "Innovation_project",
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
      // 大创项目管理表格数据
      innovation_projectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectNo: null,
        projectName: null,
        projectLevel: null,
        projectType: null,
        leaderNo: null,
        leaderName: null,
        teamMembers: null,
        instructorName: null,
        approvalYear: null,
        status: null,
        userId: null,
        status1: null,
        cause: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectName: [
          { required: true, message: "项目名称不能为空", trigger: "blur" }
        ]
      }
    }
  },
  created() {
    this.queryParams.status1 = 0
    this.getList()
  },
  methods: {
    /** 查询大创项目管理列表 */
    getList() {
      this.loading = true
      listInnovation_project(this.queryParams).then(response => {
        this.innovation_projectList = response.rows
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
        projectNo: null,
        projectName: null,
        projectLevel: null,
        projectType: null,
        leaderNo: null,
        leaderName: null,
        teamMembers: null,
        instructorName: null,
        approvalYear: null,
        status: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        userId: null,
        status1: null,
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
      this.title = "添加大创项目管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getInnovation_project(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改大创项目管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateInnovation_project(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addInnovation_project(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除大创项目管理编号为"' + ids + '"的数据项？').then(function() {
        return delInnovation_project(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/innovation_project/export', {
        ...this.queryParams
      }, `innovation_project_${new Date().getTime()}.xlsx`)
    },
    /*批准请求*/
    handleApprove(row) {
      // 1. 弹出二次确认框，防止管理员手滑点错
      this.$modal.confirm('确定要通过教师 "' + row.realName + '" 的档案申请吗？').then(function() {
        // 2. 点击确定后，调用后端同意接口
        return approveProfile(row.id);
      }).then(() => {
        // 3. 接口调用成功后，刷新当前表格，并提示成功
        this.getList();
        this.$modal.msgSuccess("已成功通过申请！");
      }).catch(() => {});
    },
    handleReject(row) {
      // 1. 使用极其优雅的 $prompt 直接呼出一个带输入框的弹窗！
      this.$prompt('请输入驳回原因', '驳回申请', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /\S/, // 校验规则：不能为空
        inputErrorMessage: '驳回原因不能为空！'
      }).then(({ value }) => {
        // 2. value 就是管理员在弹窗里填写的驳回原因
        const data = {
          id: row.id,
          cause: value // 组装成后端需要的 JSON 格式
        };
        // 3. 调用后端驳回接口
        return rejectProfile(data);
      }).then(() => {
        // 4. 成功后刷新表格并提示
        this.getList();
        this.$modal.msgSuccess("已驳回该申请！");
      }).catch(() => {
        // 取消操作时不做任何事
      });
    }
  }
}
</script>
