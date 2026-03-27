<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联sys_user表的user_id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入关联sys_user表的user_id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教职工号" prop="teacherNo">
        <el-input
          v-model="queryParams.teacherNo"
          placeholder="请输入教职工号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教职工姓名" prop="realName">
        <el-input
          v-model="queryParams.realName"
          placeholder="请输入教职工姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别(0女 1男)" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别(0女 1男)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="民族" prop="nation">
        <el-input
          v-model="queryParams.nation"
          placeholder="请输入民族"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生年月" prop="birthDate">
        <el-date-picker clearable
          v-model="queryParams.birthDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出生年月">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="来校时间" prop="comingTime">
        <el-date-picker clearable
          v-model="queryParams.comingTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择来校时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="拟退休年" prop="retireAge">
        <el-date-picker clearable
          v-model="queryParams.retireAge"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择拟退休年">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="所在部门" prop="department">
        <el-input
          v-model="queryParams.department"
          placeholder="请输入所在部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="籍贯" prop="nativePlace">
        <el-input
          v-model="queryParams.nativePlace"
          placeholder="请输入籍贯"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="宗教信仰" prop="religion">
        <el-input
          v-model="queryParams.religion"
          placeholder="请输入宗教信仰"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人" prop="emergencyContact">
        <el-input
          v-model="queryParams.emergencyContact"
          placeholder="请输入紧急联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="紧急联系人手机号" prop="emergencyPhone">
        <el-input
          v-model="queryParams.emergencyPhone"
          placeholder="请输入紧急联系人手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱"
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
      <el-form-item label="手机号" prop="phoneNumber">
        <el-input
          v-model="queryParams.phoneNumber"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="住址" prop="homeAddress">
        <el-input
          v-model="queryParams.homeAddress"
          placeholder="请输入住址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高学位" prop="highestDegree">
        <el-input
          v-model="queryParams.highestDegree"
          placeholder="请输入最高学位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高学历" prop="highestEducation">
        <el-input
          v-model="queryParams.highestEducation"
          placeholder="请输入最高学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高毕业院校" prop="highestGradSchool">
        <el-input
          v-model="queryParams.highestGradSchool"
          placeholder="请输入最高毕业院校"
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
      <el-form-item label="所属门类" prop="belongCategory">
        <el-input
          v-model="queryParams.belongCategory"
          placeholder="请输入所属门类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最高学历开始时间" prop="highestEducationBeginTime">
        <el-date-picker clearable
          v-model="queryParams.highestEducationBeginTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最高学历开始时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="最高学历毕业时间" prop="highestEducationEndTime">
        <el-date-picker clearable
          v-model="queryParams.highestEducationEndTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择最高学历毕业时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="第一学位" prop="firstDegree">
        <el-input
          v-model="queryParams.firstDegree"
          placeholder="请输入第一学位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="第一学历" prop="firstEducation">
        <el-input
          v-model="queryParams.firstEducation"
          placeholder="请输入第一学历"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="党派" prop="politicalParty">
        <el-input
          v-model="queryParams.politicalParty"
          placeholder="请输入党派"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="专业技术职务(职称)" prop="professionalTitle">
        <el-input
          v-model="queryParams.professionalTitle"
          placeholder="请输入专业技术职务(职称)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="人才称号" prop="talentTitle">
        <el-input
          v-model="queryParams.talentTitle"
          placeholder="请输入人才称号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否双肩挑(0否 1是)" prop="isDualShoulder">
        <el-input
          v-model="queryParams.isDualShoulder"
          placeholder="请输入是否双肩挑(0否 1是)"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入党时间" prop="joinPartyDate">
        <el-date-picker clearable
          v-model="queryParams.joinPartyDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入党时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="转正时间" prop="partyRegularDate">
        <el-date-picker clearable
          v-model="queryParams.partyRegularDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择转正时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="党政职务" prop="adminPost">
        <el-input
          v-model="queryParams.adminPost"
          placeholder="请输入党政职务"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任职时间" prop="postAppointDate">
        <el-date-picker clearable
          v-model="queryParams.postAppointDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任职时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="评聘时间" prop="titleEvalDate">
        <el-date-picker clearable
          v-model="queryParams.titleEvalDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择评聘时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="分类" prop="staffCategory">
        <el-input
          v-model="queryParams.staffCategory"
          placeholder="请输入分类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="岗位" prop="postName">
        <el-input
          v-model="queryParams.postName"
          placeholder="请输入岗位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="现岗位聘用时间" prop="currentPostDate">
        <el-date-picker clearable
          v-model="queryParams.currentPostDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择现岗位聘用时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="人才评聘时间" prop="talentEvalDate">
        <el-date-picker clearable
          v-model="queryParams.talentEvalDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择人才评聘时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="首聘期日期" prop="firstHireDate">
        <el-date-picker clearable
          v-model="queryParams.firstHireDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择首聘期日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="转正日期" prop="regularDate">
        <el-date-picker clearable
          v-model="queryParams.regularDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择转正日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="引进层次" prop="introLevel">
        <el-input
          v-model="queryParams.introLevel"
          placeholder="请输入引进层次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="特聘层次" prop="specialLevel">
        <el-input
          v-model="queryParams.specialLevel"
          placeholder="请输入特聘层次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="特聘合同日期" prop="contractDate">
        <el-date-picker clearable
          v-model="queryParams.contractDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择特聘合同日期">
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
          v-hasPermi="['system:profile:add']"
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
          v-hasPermi="['system:profile:edit']"
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
          v-hasPermi="['system:profile:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:profile:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="profileList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="关联sys_user表的user_id" align="center" prop="userId" />
      <el-table-column label="教职工号" align="center" prop="teacherNo" />
      <el-table-column label="教职工姓名" align="center" prop="realName" />
      <el-table-column label="性别(0女 1男)" align="center" prop="gender" />
      <el-table-column label="民族" align="center" prop="nation" />
      <el-table-column label="出生年月" align="center" prop="birthDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" />
      <el-table-column label="来校时间" align="center" prop="comingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.comingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="拟退休年" align="center" prop="retireAge" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.retireAge, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="所在部门" align="center" prop="department" />
      <el-table-column label="籍贯" align="center" prop="nativePlace" />
      <el-table-column label="婚否(0未婚 1已婚)" align="center" prop="maritalStatus" />
      <el-table-column label="宗教信仰" align="center" prop="religion" />
      <el-table-column label="紧急联系人" align="center" prop="emergencyContact" />
      <el-table-column label="紧急联系人手机号" align="center" prop="emergencyPhone" />
      <el-table-column label="邮箱" align="center" prop="email" />
      <el-table-column label="身份证号" align="center" prop="idCard" />
      <el-table-column label="手机号" align="center" prop="phoneNumber" />
      <el-table-column label="住址" align="center" prop="homeAddress" />
      <el-table-column label="最高学位" align="center" prop="highestDegree" />
      <el-table-column label="最高学历" align="center" prop="highestEducation" />
      <el-table-column label="最高毕业院校" align="center" prop="highestGradSchool" />
      <el-table-column label="所学专业" align="center" prop="major" />
      <el-table-column label="所属门类" align="center" prop="belongCategory" />
      <el-table-column label="最高学历开始时间" align="center" prop="highestEducationBeginTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.highestEducationBeginTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最高学历毕业时间" align="center" prop="highestEducationEndTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.highestEducationEndTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="第一学位" align="center" prop="firstDegree" />
      <el-table-column label="第一学历" align="center" prop="firstEducation" />
      <el-table-column label="党派" align="center" prop="politicalParty" />
      <el-table-column label="专业技术职务(职称)" align="center" prop="professionalTitle" />
      <el-table-column label="人才称号" align="center" prop="talentTitle" />
      <el-table-column label="是否双肩挑(0否 1是)" align="center" prop="isDualShoulder" />
      <el-table-column label="辅导员类别" align="center" prop="counselorType" />
      <el-table-column label="入党时间" align="center" prop="joinPartyDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.joinPartyDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="转正时间" align="center" prop="partyRegularDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.partyRegularDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="党政职务" align="center" prop="adminPost" />
      <el-table-column label="任职时间" align="center" prop="postAppointDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.postAppointDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="评聘时间" align="center" prop="titleEvalDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.titleEvalDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="分类" align="center" prop="staffCategory" />
      <el-table-column label="岗位" align="center" prop="postName" />
      <el-table-column label="现岗位聘用时间" align="center" prop="currentPostDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.currentPostDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="人才评聘时间" align="center" prop="talentEvalDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.talentEvalDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="首聘期日期" align="center" prop="firstHireDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.firstHireDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="转正日期" align="center" prop="regularDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.regularDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="引进层次" align="center" prop="introLevel" />
      <el-table-column label="特聘层次" align="center" prop="specialLevel" />
      <el-table-column label="特聘合同日期" align="center" prop="contractDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.contractDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="特聘合同附件地址" align="center" prop="contractFileUrl" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:profile:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:profile:remove']"
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

    <!-- 添加或修改教师人事基础档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联sys_user表的user_id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入关联sys_user表的user_id" />
        </el-form-item>
        <el-form-item label="教职工号" prop="teacherNo">
          <el-input v-model="form.teacherNo" placeholder="请输入教职工号" />
        </el-form-item>
        <el-form-item label="教职工姓名" prop="realName">
          <el-input v-model="form.realName" placeholder="请输入教职工姓名" />
        </el-form-item>
        <el-form-item label="性别(0女 1男)" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别(0女 1男)" />
        </el-form-item>
        <el-form-item label="民族" prop="nation">
          <el-input v-model="form.nation" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="出生年月" prop="birthDate">
          <el-date-picker clearable
            v-model="form.birthDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生年月">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="来校时间" prop="comingTime">
          <el-date-picker clearable
            v-model="form.comingTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择来校时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="拟退休年" prop="retireAge">
          <el-date-picker clearable
            v-model="form.retireAge"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择拟退休年">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="所在部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入所在部门" />
        </el-form-item>
        <el-form-item label="籍贯" prop="nativePlace">
          <el-input v-model="form.nativePlace" placeholder="请输入籍贯" />
        </el-form-item>
        <el-form-item label="宗教信仰" prop="religion">
          <el-input v-model="form.religion" placeholder="请输入宗教信仰" />
        </el-form-item>
        <el-form-item label="紧急联系人" prop="emergencyContact">
          <el-input v-model="form.emergencyContact" placeholder="请输入紧急联系人" />
        </el-form-item>
        <el-form-item label="紧急联系人手机号" prop="emergencyPhone">
          <el-input v-model="form.emergencyPhone" placeholder="请输入紧急联系人手机号" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="手机号" prop="phoneNumber">
          <el-input v-model="form.phoneNumber" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="住址" prop="homeAddress">
          <el-input v-model="form.homeAddress" placeholder="请输入住址" />
        </el-form-item>
        <el-form-item label="最高学位" prop="highestDegree">
          <el-input v-model="form.highestDegree" placeholder="请输入最高学位" />
        </el-form-item>
        <el-form-item label="最高学历" prop="highestEducation">
          <el-input v-model="form.highestEducation" placeholder="请输入最高学历" />
        </el-form-item>
        <el-form-item label="最高毕业院校" prop="highestGradSchool">
          <el-input v-model="form.highestGradSchool" placeholder="请输入最高毕业院校" />
        </el-form-item>
        <el-form-item label="所学专业" prop="major">
          <el-input v-model="form.major" placeholder="请输入所学专业" />
        </el-form-item>
        <el-form-item label="所属门类" prop="belongCategory">
          <el-input v-model="form.belongCategory" placeholder="请输入所属门类" />
        </el-form-item>
        <el-form-item label="最高学历开始时间" prop="highestEducationBeginTime">
          <el-date-picker clearable
            v-model="form.highestEducationBeginTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最高学历开始时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="最高学历毕业时间" prop="highestEducationEndTime">
          <el-date-picker clearable
            v-model="form.highestEducationEndTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择最高学历毕业时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="第一学位" prop="firstDegree">
          <el-input v-model="form.firstDegree" placeholder="请输入第一学位" />
        </el-form-item>
        <el-form-item label="第一学历" prop="firstEducation">
          <el-input v-model="form.firstEducation" placeholder="请输入第一学历" />
        </el-form-item>
        <el-form-item label="党派" prop="politicalParty">
          <el-input v-model="form.politicalParty" placeholder="请输入党派" />
        </el-form-item>
        <el-form-item label="专业技术职务(职称)" prop="professionalTitle">
          <el-input v-model="form.professionalTitle" placeholder="请输入专业技术职务(职称)" />
        </el-form-item>
        <el-form-item label="人才称号" prop="talentTitle">
          <el-input v-model="form.talentTitle" placeholder="请输入人才称号" />
        </el-form-item>
        <el-form-item label="是否双肩挑(0否 1是)" prop="isDualShoulder">
          <el-input v-model="form.isDualShoulder" placeholder="请输入是否双肩挑(0否 1是)" />
        </el-form-item>
        <el-form-item label="入党时间" prop="joinPartyDate">
          <el-date-picker clearable
            v-model="form.joinPartyDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入党时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="转正时间" prop="partyRegularDate">
          <el-date-picker clearable
            v-model="form.partyRegularDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择转正时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="党政职务" prop="adminPost">
          <el-input v-model="form.adminPost" placeholder="请输入党政职务" />
        </el-form-item>
        <el-form-item label="任职时间" prop="postAppointDate">
          <el-date-picker clearable
            v-model="form.postAppointDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任职时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="评聘时间" prop="titleEvalDate">
          <el-date-picker clearable
            v-model="form.titleEvalDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择评聘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="分类" prop="staffCategory">
          <el-input v-model="form.staffCategory" placeholder="请输入分类" />
        </el-form-item>
        <el-form-item label="岗位" prop="postName">
          <el-input v-model="form.postName" placeholder="请输入岗位" />
        </el-form-item>
        <el-form-item label="现岗位聘用时间" prop="currentPostDate">
          <el-date-picker clearable
            v-model="form.currentPostDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择现岗位聘用时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="人才评聘时间" prop="talentEvalDate">
          <el-date-picker clearable
            v-model="form.talentEvalDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择人才评聘时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="首聘期日期" prop="firstHireDate">
          <el-date-picker clearable
            v-model="form.firstHireDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择首聘期日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="转正日期" prop="regularDate">
          <el-date-picker clearable
            v-model="form.regularDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择转正日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="引进层次" prop="introLevel">
          <el-input v-model="form.introLevel" placeholder="请输入引进层次" />
        </el-form-item>
        <el-form-item label="特聘层次" prop="specialLevel">
          <el-input v-model="form.specialLevel" placeholder="请输入特聘层次" />
        </el-form-item>
        <el-form-item label="特聘合同日期" prop="contractDate">
          <el-date-picker clearable
            v-model="form.contractDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择特聘合同日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="特聘合同附件地址" prop="contractFileUrl">
          <el-input v-model="form.contractFileUrl" type="textarea" placeholder="请输入内容" />
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
import { listProfile, getProfile, delProfile, addProfile, updateProfile } from "@/api/system/profile"

export default {
  name: "Profile",
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
      // 教师人事基础档案表格数据
      profileList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        teacherNo: null,
        realName: null,
        gender: null,
        nation: null,
        birthDate: null,
        age: null,
        comingTime: null,
        retireAge: null,
        department: null,
        nativePlace: null,
        maritalStatus: null,
        religion: null,
        emergencyContact: null,
        emergencyPhone: null,
        email: null,
        idCard: null,
        phoneNumber: null,
        homeAddress: null,
        highestDegree: null,
        highestEducation: null,
        highestGradSchool: null,
        major: null,
        belongCategory: null,
        highestEducationBeginTime: null,
        highestEducationEndTime: null,
        firstDegree: null,
        firstEducation: null,
        politicalParty: null,
        professionalTitle: null,
        talentTitle: null,
        isDualShoulder: null,
        counselorType: null,
        joinPartyDate: null,
        partyRegularDate: null,
        adminPost: null,
        postAppointDate: null,
        titleEvalDate: null,
        staffCategory: null,
        postName: null,
        currentPostDate: null,
        talentEvalDate: null,
        firstHireDate: null,
        regularDate: null,
        introLevel: null,
        specialLevel: null,
        contractDate: null,
        contractFileUrl: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "关联sys_user表的user_id不能为空", trigger: "blur" }
        ],
        nation: [
          { required: true, message: "民族不能为空", trigger: "blur" }
        ],
        age: [
          { required: true, message: "年龄不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询教师人事基础档案列表 */
    getList() {
      this.loading = true
      listProfile(this.queryParams).then(response => {
        this.profileList = response.rows
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
        teacherNo: null,
        realName: null,
        gender: null,
        nation: null,
        birthDate: null,
        age: null,
        comingTime: null,
        retireAge: null,
        department: null,
        nativePlace: null,
        maritalStatus: null,
        religion: null,
        emergencyContact: null,
        emergencyPhone: null,
        email: null,
        idCard: null,
        phoneNumber: null,
        homeAddress: null,
        highestDegree: null,
        highestEducation: null,
        highestGradSchool: null,
        major: null,
        belongCategory: null,
        highestEducationBeginTime: null,
        highestEducationEndTime: null,
        firstDegree: null,
        firstEducation: null,
        politicalParty: null,
        professionalTitle: null,
        talentTitle: null,
        isDualShoulder: null,
        counselorType: null,
        joinPartyDate: null,
        partyRegularDate: null,
        adminPost: null,
        postAppointDate: null,
        titleEvalDate: null,
        staffCategory: null,
        postName: null,
        currentPostDate: null,
        talentEvalDate: null,
        firstHireDate: null,
        regularDate: null,
        introLevel: null,
        specialLevel: null,
        contractDate: null,
        contractFileUrl: null,
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
      this.title = "添加教师人事基础档案"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const id = row.id || this.ids
      getProfile(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改教师人事基础档案"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateProfile(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addProfile(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除教师人事基础档案编号为"' + ids + '"的数据项？').then(function() {
        return delProfile(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/profile/export', {
        ...this.queryParams
      }, `profile_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
