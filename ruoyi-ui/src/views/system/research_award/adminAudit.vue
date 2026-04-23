<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="奖励名称" prop="awardName">
        <el-input
          v-model="queryParams.awardName"
          placeholder="请输入奖励名称"
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
          v-hasPermi="['system:research_award:add']"
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
          v-hasPermi="['system:research_award:edit']"
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
          v-hasPermi="['system:research_award:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:research_award:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="research_awardList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="申报人" align="center" prop="userId" />
      <el-table-column label="奖励名称" align="center" prop="awardName" />
      <el-table-column label="成果名称" align="center" prop="achievementName" />
      <el-table-column label="获奖级别" align="center" prop="awardLevel" />
      <el-table-column label="获奖日期" align="center" prop="awardDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.awardDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="所有完成人(逗号/顿号分隔)" align="center" prop="allContributors" />
      <el-table-column label="发证机关" align="center" prop="issuingAuthority" />
      <el-table-column label="获奖等级" align="center" prop="awardGrade" />
      <el-table-column label="单位排名" align="center" prop="unitRank" />
      <el-table-column label="证书号" align="center" prop="certNumber" />
      <el-table-column label="主要成果" align="center" prop="mainAchievement" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="当前状态" align="center" prop="status" />
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

    <!-- 添加或修改科研奖励管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联教师的主键(申报人)" prop="userId">
          <el-input v-model="form.userId" :placeholder = "this.queryParams.userId + '   默认绑定本账号为负责人'"/>
        </el-form-item>
        <el-form-item label="奖励名称" prop="awardName">
          <el-input v-model="form.awardName" placeholder="请输入奖励名称" />
        </el-form-item>
        <el-form-item label="成果名称" prop="achievementName">
          <el-input v-model="form.achievementName" placeholder="请输入成果名称" />
        </el-form-item>
        <el-form-item label="获奖级别" prop="awardLevel">
          <el-input v-model="form.awardLevel" placeholder="请输入获奖级别" />
        </el-form-item>
        <el-form-item label="获奖日期" prop="awardDate">
          <el-date-picker clearable
                          v-model="form.awardDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择获奖日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="所有完成人(逗号/顿号分隔)" prop="allContributors">
          <el-input v-model="form.allContributors" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="发证机关" prop="issuingAuthority">
          <el-input v-model="form.issuingAuthority" placeholder="请输入发证机关" />
        </el-form-item>
        <el-form-item label="获奖等级" prop="awardGrade">
          <el-input v-model="form.awardGrade" placeholder="请输入获奖等级" />
        </el-form-item>
        <el-form-item label="单位排名" prop="unitRank">
          <el-input v-model="form.unitRank" placeholder="请输入单位排名" />
        </el-form-item>
        <el-form-item label="证书号" prop="certNumber">
          <el-input v-model="form.certNumber" placeholder="请输入证书号" />
        </el-form-item>
        <el-form-item label="主要成果" prop="mainAchievement">
          <el-input v-model="form.mainAchievement" type="textarea" placeholder="请输入内容" />
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
import { listResearch_award, getResearch_award, delResearch_award, addResearch_award, updateResearch_award,applyProfile,rejectProfile,approveProfile} from "@/api/system/research_award"

export default {
  name: "Research_award",
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
      // 科研奖励管理表格数据
      research_awardList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        awardName: null,
        achievementName: null,
        awardLevel: null,
        awardDate: null,
        allContributors: null,
        issuingAuthority: null,
        awardGrade: null,
        unitRank: null,
        certNumber: null,
        mainAchievement: null,
        status: null,
        cause: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        awardName: [
          { required: true, message: "奖励名称不能为空", trigger: "blur" }
        ],
        achievementName: [
          { required: true, message: "成果名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.queryParams.status = 0
    this.getList()
  },
  methods: {
    /** 查询科研奖励管理列表 */
    getList() {
      this.loading = true
      listResearch_award(this.queryParams).then(response => {
        this.research_awardList = response.rows
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
        awardName: null,
        achievementName: null,
        awardLevel: null,
        awardDate: null,
        allContributors: null,
        issuingAuthority: null,
        awardGrade: null,
        unitRank: null,
        certNumber: null,
        mainAchievement: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
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
      this.title = "添加科研奖励管理"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getResearch_award(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改科研奖励管理"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateResearch_award(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            applyProfile(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除科研奖励管理编号为"' + ids + '"的数据项？').then(function() {
        return delResearch_award(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/research_award/export', {
        ...this.queryParams
      }, `research_award_${new Date().getTime()}.xlsx`)
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
