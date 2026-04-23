<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="studentName">
        <el-input
          v-model="queryParams.studentName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业" prop="major">
        <el-input
          v-model="queryParams.major"
          placeholder="请输入专业"
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
          v-hasPermi="['system:comp_award:add']"
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
          v-hasPermi="['system:comp_award:edit']"
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
          v-hasPermi="['system:comp_award:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:comp_award:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="comp_awardList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="学号" align="center" prop="studentNo" />
      <el-table-column label="姓名" align="center" prop="studentName" />
      <el-table-column label="专业" align="center" prop="major" />
      <el-table-column label="年级/参赛年份" align="center" prop="compYear" />
      <el-table-column label="赛事名称" align="center" prop="compName" />
      <el-table-column label="主办单位" align="center" prop="organizer" />
      <el-table-column label="证书编号" align="center" prop="certNumber" />
      <el-table-column label="获奖时间(以主办方公布时间为准)" align="center" prop="awardDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.awardDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="获奖批文或官网公示网址" align="center" prop="certUrl" />
      <el-table-column label="获奖级别" align="center" prop="compLevel" />
      <el-table-column label="获奖等次" align="center" prop="awardGrade" />
      <el-table-column label="赛届" align="center" prop="compEdition" />
      <el-table-column label="赛类" align="center" prop="compCategory" />
      <el-table-column label="比赛科目" align="center" prop="compSubject" />
      <el-table-column label="比赛组别" align="center" prop="compGroup" />
      <el-table-column label="参赛类型" align="center" prop="isTeam" />
      <el-table-column label="团队人数" align="center" prop="teamSize" />
      <el-table-column label="个人位次" align="center" prop="myRank" />
      <el-table-column label="团队成员姓名" align="center" prop="teamMembers" />
      <el-table-column label="指导教师1姓名" align="center" prop="instructor1Name" />
      <el-table-column label="指导教师1所在学院" align="center" prop="instructor1College" />
      <el-table-column label="指导教师2姓名" align="center" prop="instructor2Name" />
      <el-table-column label="指导教师2所在学院" align="center" prop="instructor2College" />
      <el-table-column label="备注2" align="center" prop="remark" />
      <el-table-column label="用户名id" align="center" prop="userId" />
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

    <!-- 添加或修改学生竞赛获奖全纪录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="学号" prop="studentNo">
          <el-input v-model="form.studentNo" placeholder="请输入学号" />
        </el-form-item>
        <el-form-item label="姓名" prop="studentName">
          <el-input v-model="form.studentName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入专业" />
        </el-form-item>
        <el-form-item label="年级/参赛年份" prop="compYear">
          <el-input v-model="form.compYear" placeholder="请输入年级/参赛年份" />
        </el-form-item>
        <el-form-item label="赛事名称(含获批项目名称)" prop="compName">
          <el-input v-model="form.compName" placeholder="请输入赛事名称(含获批项目名称)" />
        </el-form-item>
        <el-form-item label="主办单位" prop="organizer">
          <el-input v-model="form.organizer" placeholder="请输入主办单位" />
        </el-form-item>
        <el-form-item label="证书编号" prop="certNumber">
          <el-input v-model="form.certNumber" placeholder="请输入证书编号" />
        </el-form-item>
        <el-form-item label="获奖时间(以主办方公布时间为准)" prop="awardDate">
          <el-date-picker clearable
                          v-model="form.awardDate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择获奖时间(以主办方公布时间为准)">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="获奖批文或官网公示网址" prop="certUrl">
          <el-input v-model="form.certUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="获奖级别(如:国创/省创等)" prop="compLevel">
          <el-input v-model="form.compLevel" placeholder="请输入获奖级别(如:国创/省创等)" />
        </el-form-item>
        <el-form-item label="获奖等次(如:一等奖/特等奖)" prop="awardGrade">
          <el-input v-model="form.awardGrade" placeholder="请输入获奖等次(如:一等奖/特等奖)" />
        </el-form-item>
        <el-form-item label="赛届(如:第十三届)" prop="compEdition">
          <el-input v-model="form.compEdition" placeholder="请输入赛届(如:第十三届)" />
        </el-form-item>
        <el-form-item label="赛类(如:软件类/电子类)" prop="compCategory">
          <el-input v-model="form.compCategory" placeholder="请输入赛类(如:软件类/电子类)" />
        </el-form-item>
        <el-form-item label="比赛科目(如:C/C++程序设计)" prop="compSubject">
          <el-input v-model="form.compSubject" placeholder="请输入比赛科目(如:C/C++程序设计)" />
        </el-form-item>
        <el-form-item label="比赛组别(如:研究生组/大学A组)" prop="compGroup">
          <el-input v-model="form.compGroup" placeholder="请输入比赛组别(如:研究生组/大学A组)" />
        </el-form-item>
        <el-form-item label="参赛类型(0个人 1团队)" prop="isTeam">
          <el-input v-model="form.isTeam" placeholder="请输入参赛类型(0个人 1团队)" />
        </el-form-item>
        <el-form-item label="团队人数" prop="teamSize">
          <el-input v-model="form.teamSize" placeholder="请输入团队人数" />
        </el-form-item>
        <el-form-item label="个人位次" prop="myRank">
          <el-input v-model="form.myRank" placeholder="请输入个人位次" />
        </el-form-item>
        <el-form-item label="团队成员姓名(顿号分隔)" prop="teamMembers">
          <el-input v-model="form.teamMembers" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="指导教师1姓名" prop="instructor1Name">
          <el-input v-model="form.instructor1Name" placeholder="请输入指导教师1姓名" />
        </el-form-item>
        <el-form-item label="指导教师1所在学院" prop="instructor1College">
          <el-input v-model="form.instructor1College" placeholder="请输入指导教师1所在学院" />
        </el-form-item>
        <el-form-item label="指导教师2姓名" prop="instructor2Name">
          <el-input v-model="form.instructor2Name" placeholder="请输入指导教师2姓名" />
        </el-form-item>
        <el-form-item label="指导教师2所在学院" prop="instructor2College">
          <el-input v-model="form.instructor2College" placeholder="请输入指导教师2所在学院" />
        </el-form-item>
        <el-form-item label="备注2" prop="remark">
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
import { listComp_award, getComp_award, delComp_award, addComp_award, updateComp_award, applyProfile, approveProfile, rejectProfile } from "@/api/system/comp_award"

export default {
  name: "Comp_award",
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
      // 学生竞赛获奖全纪录表格数据
      comp_awardList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        studentNo: null,
        studentName: null,
        major: null,
        compYear: null,
        compName: null,
        organizer: null,
        certNumber: null,
        awardDate: null,
        certUrl: null,
        compLevel: null,
        awardGrade: null,
        compEdition: null,
        compCategory: null,
        compSubject: null,
        compGroup: null,
        isTeam: null,
        teamSize: null,
        myRank: null,
        teamMembers: null,
        instructor1Name: null,
        instructor1College: null,
        instructor2Name: null,
        instructor2College: null,
        userId: null,
        status: null,
        cause: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        studentNo: [
          { required: true, message: "学号不能为空", trigger: "blur" }
        ],
        studentName: [
          { required: true, message: "姓名不能为空", trigger: "blur" }
        ],
        compName: [
          { required: true, message: "赛事名称(含获批项目名称)不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户名id不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.queryParams.status = 0
    this.getList()
  },
  methods: {
    /** 查询学生竞赛获奖全纪录列表 */
    getList() {
      this.loading = true
      listComp_award(this.queryParams).then(response => {
        this.comp_awardList = response.rows
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
        studentNo: null,
        studentName: null,
        major: null,
        compYear: null,
        compName: null,
        organizer: null,
        certNumber: null,
        awardDate: null,
        certUrl: null,
        compLevel: null,
        awardGrade: null,
        compEdition: null,
        compCategory: null,
        compSubject: null,
        compGroup: null,
        isTeam: null,
        teamSize: null,
        myRank: null,
        teamMembers: null,
        instructor1Name: null,
        instructor1College: null,
        instructor2Name: null,
        instructor2College: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null,
        userId: null,
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
      this.title = "添加学生竞赛获奖全纪录"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getComp_award(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改学生竞赛获奖全纪录"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateComp_award(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除学生竞赛获奖全纪录编号为"' + ids + '"的数据项？').then(function() {
        return delComp_award(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/comp_award/export', {
        ...this.queryParams
      }, `comp_award_${new Date().getTime()}.xlsx`)
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
