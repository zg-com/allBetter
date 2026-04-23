<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="论文题目" prop="paperTitle">
        <el-input
          v-model="queryParams.paperTitle"
          placeholder="请输入论文题目"
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
          v-hasPermi="['system:paper:add']"
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
          v-hasPermi="['system:paper:edit']"
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
          v-hasPermi="['system:paper:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:paper:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="paperList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="关联教师(申报人)" align="center" prop="userId" />
      <el-table-column label="论文类型(1:SCI论文 2:卓越期刊论文 3:CCF会议论文)" align="center" prop="paperType" />
      <el-table-column label="论文题目" align="center" prop="paperTitle" />
      <el-table-column label="发表期刊/会议名称" align="center" prop="journalOrConf" />
      <el-table-column label="作者信息/一作" align="center" prop="authorInfo" />
      <el-table-column label="通讯作者信息" align="center" prop="corrAuthorInfo" />
      <el-table-column label="青大是否第一单位(0否 1是)" align="center" prop="isFirstUnit" />
      <el-table-column label="论文归属" align="center" prop="attribution" />
      <el-table-column label="积分" align="center" prop="points" />
      <el-table-column label="SCI分区" align="center" prop="sciZone" />
      <el-table-column label="是否推荐期刊(0否 1是)" align="center" prop="isRecommended" />
      <el-table-column label="CCF分区/会议类型(CCF A等)" align="center" prop="ccfZone" />
      <el-table-column label="是否卓越领军期刊(0否 1是)" align="center" prop="isExcellentLeading" />
      <el-table-column label="是否高被引(0否 1是)" align="center" prop="isHighlyCited" />
      <el-table-column label="是否ESI论文(0否 1是)" align="center" prop="isEsi" />
      <el-table-column label="奖励级别" align="center" prop="awardLevel" />
      <el-table-column label="备注(所有论文专属备注列)" align="center" prop="remark" />
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

    <!-- 添加或修改科研论文全纪录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联教师工号(归属人)" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入关联教师工号" />
        </el-form-item>
        <el-form-item label="论文题目" prop="paperTitle">
          <el-input v-model="form.paperTitle" placeholder="请输入论文题目" />
        </el-form-item>
        <el-form-item label="发表期刊/会议名称" prop="journalOrConf">
          <el-input v-model="form.journalOrConf" placeholder="请输入发表期刊/会议名称" />
        </el-form-item>
        <el-form-item label="作者信息/一作" prop="authorInfo">
          <el-input v-model="form.authorInfo" placeholder="请输入作者信息/一作" />
        </el-form-item>
        <el-form-item label="通讯作者信息" prop="corrAuthorInfo">
          <el-input v-model="form.corrAuthorInfo" placeholder="请输入通讯作者信息" />
        </el-form-item>
        <el-form-item label="青大是否第一单位(0否 1是)" prop="isFirstUnit">
          <el-input v-model="form.isFirstUnit" placeholder="请输入青大是否第一单位(0否 1是)" />
        </el-form-item>
        <el-form-item label="论文归属" prop="attribution">
          <el-input v-model="form.attribution" placeholder="请输入论文归属" />
        </el-form-item>
        <el-form-item label="积分" prop="points">
          <el-input v-model="form.points" placeholder="请输入积分" />
        </el-form-item>
        <el-form-item label="SCI分区" prop="sciZone">
          <el-input v-model="form.sciZone" placeholder="请输入SCI分区" />
        </el-form-item>
        <el-form-item label="是否推荐期刊(0否 1是)" prop="isRecommended">
          <el-input v-model="form.isRecommended" placeholder="请输入是否推荐期刊(0否 1是)" />
        </el-form-item>
        <el-form-item label="CCF分区/会议类型(CCF A等)" prop="ccfZone">
          <el-input v-model="form.ccfZone" placeholder="请输入CCF分区/会议类型(CCF A等)" />
        </el-form-item>
        <el-form-item label="是否卓越领军期刊(0否 1是)" prop="isExcellentLeading">
          <el-input v-model="form.isExcellentLeading" placeholder="请输入是否卓越领军期刊(0否 1是)" />
        </el-form-item>
        <el-form-item label="是否高被引(0否 1是)" prop="isHighlyCited">
          <el-input v-model="form.isHighlyCited" placeholder="请输入是否高被引(0否 1是)" />
        </el-form-item>
        <el-form-item label="是否ESI论文(0否 1是)" prop="isEsi">
          <el-input v-model="form.isEsi" placeholder="请输入是否ESI论文(0否 1是)" />
        </el-form-item>
        <el-form-item label="奖励级别" prop="awardLevel">
          <el-input v-model="form.awardLevel" placeholder="请输入奖励级别" />
        </el-form-item>
        <el-form-item label="备注(所有论文专属备注列)" prop="remark">
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
import { listPaper, getPaper, delPaper, addPaper, updatePaper,applyProfile,approveProfile,rejectProfile } from "@/api/system/paper"

export default {
  name: "Paper",
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
      // 科研论文全纪录表格数据
      paperList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        paperType: null,
        paperTitle: null,
        journalOrConf: null,
        authorInfo: null,
        corrAuthorInfo: null,
        isFirstUnit: null,
        attribution: null,
        points: null,
        sciZone: null,
        isRecommended: null,
        ccfZone: null,
        isExcellentLeading: null,
        isHighlyCited: null,
        isEsi: null,
        awardLevel: null,
        status: null,
        cause: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        paperType: [
          { required: true, message: "论文类型(1:SCI论文 2:卓越期刊论文 3:CCF会议论文)不能为空", trigger: "change" }
        ],
        paperTitle: [
          { required: true, message: "论文题目不能为空", trigger: "blur" }
        ],
        journalOrConf: [
          { required: true, message: "发表期刊/会议名称不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.queryParams.status = 0
    this.getList()
  },
  methods: {
    /** 查询科研论文全纪录列表 */
    getList() {
      this.loading = true
      listPaper(this.queryParams).then(response => {
        this.paperList = response.rows
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
        paperType: null,
        paperTitle: null,
        journalOrConf: null,
        authorInfo: null,
        corrAuthorInfo: null,
        isFirstUnit: null,
        attribution: null,
        points: null,
        sciZone: null,
        isRecommended: null,
        ccfZone: null,
        isExcellentLeading: null,
        isHighlyCited: null,
        isEsi: null,
        awardLevel: null,
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
      this.title = "添加科研论文全纪录"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getPaper(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改科研论文全纪录"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePaper(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除科研论文全纪录编号为"' + ids + '"的数据项？').then(function() {
        return delPaper(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/paper/export', {
        ...this.queryParams
      }, `paper_${new Date().getTime()}.xlsx`)
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
