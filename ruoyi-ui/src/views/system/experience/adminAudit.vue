<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教师id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入教师的id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="兼职头衔或访学国家" prop="titleOrCountry">
        <el-input
          v-model="queryParams.titleOrCountry"
          placeholder="请输入兼职头衔或访学国家"
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
          v-hasPermi="['system:experience:add']"
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
          v-hasPermi="['system:experience:edit']"
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
          v-hasPermi="['system:experience:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:experience:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="experienceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="教师id" align="center" prop="userId" />
      <el-table-column label="记录类型(1社会兼职 2留学访学)" align="center" prop="expType" />
      <el-table-column label="兼职头衔或访学国家" align="center" prop="titleOrCountry" />
      <el-table-column label="研究领域" align="center" prop="researchField" />
      <el-table-column label="获得的荣誉或成果" align="center" prop="achievements" />
      <el-table-column label="起止时间-开始" align="center" prop="startDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="起止时间-结束" align="center" prop="endDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
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

    <!-- 添加或修改教师兼职与访学经历对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="兼职头衔或访学国家" prop="titleOrCountry">
          <el-input v-model="form.titleOrCountry" placeholder="请输入兼职头衔或访学国家" />
        </el-form-item>
        <el-form-item label="研究领域" prop="researchField">
          <el-input v-model="form.researchField" placeholder="请输入研究领域" />
        </el-form-item>
        <el-form-item label="获得的荣誉或成果" prop="achievements">
          <el-input v-model="form.achievements" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="起止时间-开始" prop="startDate">
          <el-date-picker clearable
                          v-model="form.startDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择起止时间-开始">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="起止时间-结束" prop="endDate">
          <el-date-picker clearable
                          v-model="form.endDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择起止时间-结束">
          </el-date-picker>
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
import { listExperience, getExperience, delExperience, addExperience, updateExperience} from "@/api/system/experience"
import {approveProfile, rejectProfile} from "@/api/system/experience";

export default {
  name: "Experience",
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
      // 教师兼职与访学经历表格数据
      experienceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        expType: null,
        titleOrCountry: null,
        researchField: null,
        achievements: null,
        startDate: null,
        endDate: null,
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
    this.queryParams.status = 0
    this.getList()
  },
  methods: {
    /** 查询教师兼职与访学经历列表 */
    getList() {
      this.loading = true
      listExperience(this.queryParams).then(response => {
        this.experienceList = response.rows
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
        expType: null,
        titleOrCountry: null,
        researchField: null,
        achievements: null,
        startDate: null,
        endDate: null,
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
      this.title = "添加教师兼职与访学经历"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getExperience(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改教师兼职与访学经历"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateExperience(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addExperience(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除教师兼职与访学经历编号为"' + ids + '"的数据项？').then(function() {
        return delExperience(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/experience/export', {
        ...this.queryParams
      }, `experience_${new Date().getTime()}.xlsx`)
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
