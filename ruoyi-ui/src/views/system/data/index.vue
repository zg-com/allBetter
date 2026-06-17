<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="记录时间" prop="recordTime">
        <el-date-picker clearable
          v-model="queryParams.recordTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择记录时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际负荷(MW)" prop="actualLoad">
        <el-input
          v-model="queryParams.actualLoad"
          placeholder="请输入实际负荷(MW)"
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
          v-hasPermi="['system:data:add']"
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
          v-hasPermi="['system:data:edit']"
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
          v-hasPermi="['system:data:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:data:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="dataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="数据主键" align="center" prop="dataId" />
      <el-table-column label="记录时间" align="center" prop="recordTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.recordTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="目标特征: 实际负荷(MW)" align="center" prop="actualLoad" />
      <el-table-column label="A磨总一次风量149" align="center" prop="millAPriWind149" />
      <el-table-column label="B磨总一次风量164" align="center" prop="millBPriWind164" />
      <el-table-column label="C磨总一次风量175" align="center" prop="millCPriWind175" />
      <el-table-column label="磨煤机A一次风总风量183" align="center" prop="millAPriTotal183" />
      <el-table-column label="磨煤机B一次风总风量184" align="center" prop="millBPriTotal184" />
      <el-table-column label="一次粉管A11风速30" align="center" prop="pipeA11WindSpd30" />
      <el-table-column label="一次粉管A12煤粉浓度73" align="center" prop="pipeA12CoalCon73" />
      <el-table-column label="一次粉管A12风速31" align="center" prop="pipeA12WindSpd31" />
      <el-table-column label="一次粉管A13风速32" align="center" prop="pipeA13WindSpd32" />
      <el-table-column label="一次粉管A14风速33" align="center" prop="pipeA14WindSpd33" />
      <el-table-column label="一次粉管A21风速34" align="center" prop="pipeA21WindSpd34" />
      <el-table-column label="一次粉管A22风速35" align="center" prop="pipeA22WindSpd35" />
      <el-table-column label="一次粉管A23风速36" align="center" prop="pipeA23WindSpd36" />
      <el-table-column label="一次粉管A24风速37" align="center" prop="pipeA24WindSpd37" />
      <el-table-column label="一次粉管B11风速38" align="center" prop="pipeB11WindSpd38" />
      <el-table-column label="一次粉管B14风速41" align="center" prop="pipeB14WindSpd41" />
      <el-table-column label="一次粉管B21煤粉浓度95" align="center" prop="pipeB21CoalCon95" />
      <el-table-column label="一次粉管B22煤粉浓度2_96" align="center" prop="pipeB22CoalCon296" />
      <el-table-column label="一次粉管B22煤粉浓度97" align="center" prop="pipeB22CoalCon97" />
      <el-table-column label="一次粉管B23煤粉浓度99" align="center" prop="pipeB23CoalCon99" />
      <el-table-column label="一次粉管B24煤粉浓度101" align="center" prop="pipeB24CoalCon101" />
      <el-table-column label="一次粉管C11煤粉浓度103" align="center" prop="pipeC11CoalCon103" />
      <el-table-column label="一次粉管C12煤粉浓度105" align="center" prop="pipeC12CoalCon105" />
      <el-table-column label="一次粉管C13煤粉浓度107" align="center" prop="pipeC13CoalCon107" />
      <el-table-column label="一次粉管C14煤粉浓度109" align="center" prop="pipeC14CoalCon109" />
      <el-table-column label="屏式再热器横向第23片屏排＃1管管壁温度338" align="center" prop="reheaterScrTubeTemp338" />
      <el-table-column label="末级再热器入口烟气温度A 358" align="center" prop="reheaterInletGasTempA358" />
      <el-table-column label="末级再热器入口烟气温度B 359" align="center" prop="reheaterInletGasTempB359" />
      <el-table-column label="末级再热器横向第2排的＃1管管壁温度344" align="center" prop="reheaterEndTubeTempRow2344" />
      <el-table-column label="末级再热器横向第67排的＃1管管壁温度357" align="center" prop="reheaterEndTubeTempRow67357" />
      <el-table-column label="汽包压力均值234" align="center" prop="drumPressureAvg234" />
      <el-table-column label="汽包水位1239" align="center" prop="drumWaterLevel1239" />
      <el-table-column label="总一次风量199" align="center" prop="totalPriWind199" />
      <el-table-column label="总二次风量200" align="center" prop="totalSecWind200" />
      <el-table-column label="总风量198" align="center" prop="totalWind198" />
      <el-table-column label="摆角平均位置280" align="center" prop="swingAngleAvg280" />
      <el-table-column label="摆角调节上限284" align="center" prop="swingAngleUpper284" />
      <el-table-column label="摆角调节下限283" align="center" prop="swingAngleLower283" />
      <el-table-column label="给煤机B1给煤量信号120" align="center" prop="coalFeederB1120" />
      <el-table-column label="给煤机B1给煤量信号121" align="center" prop="coalFeederB1121" />
      <el-table-column label="给煤机B2给煤量信号126" align="center" prop="coalFeederB2126" />
      <el-table-column label="给煤机B2给煤量信号127" align="center" prop="coalFeederB2127" />
      <el-table-column label="给煤机C1给煤量信号122" align="center" prop="coalFeederC1122" />
      <el-table-column label="给煤机C1给煤量信号123" align="center" prop="coalFeederC1123" />
      <el-table-column label="送风机A出口风量1 177" align="center" prop="blowerAOut1177" />
      <el-table-column label="送风机A出口风量2 179" align="center" prop="blowerAOut2179" />
      <el-table-column label="送风机A出口风量3 181" align="center" prop="blowerAOut3181" />
      <el-table-column label="送风机B出口风量1 178" align="center" prop="blowerBOut1178" />
      <el-table-column label="送风机B出口风量2 180" align="center" prop="blowerBOut2180" />
      <el-table-column label="送风机B出口风量3 182" align="center" prop="blowerBOut3182" />
      <el-table-column label="非核心传感器全量快照(兜底扩展)" align="center" prop="otherSensors" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:data:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:data:remove']"
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

    <!-- 添加或修改火电厂核心传感器工况对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="记录时间" prop="recordTime">
              <el-date-picker clearable
                v-model="form.recordTime"
                type="date"
                value-format="yyyy-MM-dd"
                placeholder="请选择记录时间">
              </el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="目标特征: 实际负荷(MW)" prop="actualLoad">
              <el-input v-model="form.actualLoad" placeholder="请输入目标特征: 实际负荷(MW)" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="A磨总一次风量149" prop="millAPriWind149">
              <el-input v-model="form.millAPriWind149" placeholder="请输入A磨总一次风量149" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="B磨总一次风量164" prop="millBPriWind164">
              <el-input v-model="form.millBPriWind164" placeholder="请输入B磨总一次风量164" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="C磨总一次风量175" prop="millCPriWind175">
              <el-input v-model="form.millCPriWind175" placeholder="请输入C磨总一次风量175" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="磨煤机A一次风总风量183" prop="millAPriTotal183">
              <el-input v-model="form.millAPriTotal183" placeholder="请输入磨煤机A一次风总风量183" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="磨煤机B一次风总风量184" prop="millBPriTotal184">
              <el-input v-model="form.millBPriTotal184" placeholder="请输入磨煤机B一次风总风量184" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A11风速30" prop="pipeA11WindSpd30">
              <el-input v-model="form.pipeA11WindSpd30" placeholder="请输入一次粉管A11风速30" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A12煤粉浓度73" prop="pipeA12CoalCon73">
              <el-input v-model="form.pipeA12CoalCon73" placeholder="请输入一次粉管A12煤粉浓度73" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A12风速31" prop="pipeA12WindSpd31">
              <el-input v-model="form.pipeA12WindSpd31" placeholder="请输入一次粉管A12风速31" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A13风速32" prop="pipeA13WindSpd32">
              <el-input v-model="form.pipeA13WindSpd32" placeholder="请输入一次粉管A13风速32" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A14风速33" prop="pipeA14WindSpd33">
              <el-input v-model="form.pipeA14WindSpd33" placeholder="请输入一次粉管A14风速33" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A21风速34" prop="pipeA21WindSpd34">
              <el-input v-model="form.pipeA21WindSpd34" placeholder="请输入一次粉管A21风速34" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A22风速35" prop="pipeA22WindSpd35">
              <el-input v-model="form.pipeA22WindSpd35" placeholder="请输入一次粉管A22风速35" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A23风速36" prop="pipeA23WindSpd36">
              <el-input v-model="form.pipeA23WindSpd36" placeholder="请输入一次粉管A23风速36" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管A24风速37" prop="pipeA24WindSpd37">
              <el-input v-model="form.pipeA24WindSpd37" placeholder="请输入一次粉管A24风速37" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B11风速38" prop="pipeB11WindSpd38">
              <el-input v-model="form.pipeB11WindSpd38" placeholder="请输入一次粉管B11风速38" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B14风速41" prop="pipeB14WindSpd41">
              <el-input v-model="form.pipeB14WindSpd41" placeholder="请输入一次粉管B14风速41" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B21煤粉浓度95" prop="pipeB21CoalCon95">
              <el-input v-model="form.pipeB21CoalCon95" placeholder="请输入一次粉管B21煤粉浓度95" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B22煤粉浓度2_96" prop="pipeB22CoalCon296">
              <el-input v-model="form.pipeB22CoalCon296" placeholder="请输入一次粉管B22煤粉浓度2_96" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B22煤粉浓度97" prop="pipeB22CoalCon97">
              <el-input v-model="form.pipeB22CoalCon97" placeholder="请输入一次粉管B22煤粉浓度97" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B23煤粉浓度99" prop="pipeB23CoalCon99">
              <el-input v-model="form.pipeB23CoalCon99" placeholder="请输入一次粉管B23煤粉浓度99" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管B24煤粉浓度101" prop="pipeB24CoalCon101">
              <el-input v-model="form.pipeB24CoalCon101" placeholder="请输入一次粉管B24煤粉浓度101" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管C11煤粉浓度103" prop="pipeC11CoalCon103">
              <el-input v-model="form.pipeC11CoalCon103" placeholder="请输入一次粉管C11煤粉浓度103" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管C12煤粉浓度105" prop="pipeC12CoalCon105">
              <el-input v-model="form.pipeC12CoalCon105" placeholder="请输入一次粉管C12煤粉浓度105" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管C13煤粉浓度107" prop="pipeC13CoalCon107">
              <el-input v-model="form.pipeC13CoalCon107" placeholder="请输入一次粉管C13煤粉浓度107" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="一次粉管C14煤粉浓度109" prop="pipeC14CoalCon109">
              <el-input v-model="form.pipeC14CoalCon109" placeholder="请输入一次粉管C14煤粉浓度109" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="屏式再热器横向第23片屏排＃1管管壁温度338" prop="reheaterScrTubeTemp338">
              <el-input v-model="form.reheaterScrTubeTemp338" placeholder="请输入屏式再热器横向第23片屏排＃1管管壁温度338" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="末级再热器入口烟气温度A 358" prop="reheaterInletGasTempA358">
              <el-input v-model="form.reheaterInletGasTempA358" placeholder="请输入末级再热器入口烟气温度A 358" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="末级再热器入口烟气温度B 359" prop="reheaterInletGasTempB359">
              <el-input v-model="form.reheaterInletGasTempB359" placeholder="请输入末级再热器入口烟气温度B 359" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="末级再热器横向第2排的＃1管管壁温度344" prop="reheaterEndTubeTempRow2344">
              <el-input v-model="form.reheaterEndTubeTempRow2344" placeholder="请输入末级再热器横向第2排的＃1管管壁温度344" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="末级再热器横向第67排的＃1管管壁温度357" prop="reheaterEndTubeTempRow67357">
              <el-input v-model="form.reheaterEndTubeTempRow67357" placeholder="请输入末级再热器横向第67排的＃1管管壁温度357" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="汽包压力均值234" prop="drumPressureAvg234">
              <el-input v-model="form.drumPressureAvg234" placeholder="请输入汽包压力均值234" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="汽包水位1239" prop="drumWaterLevel1239">
              <el-input v-model="form.drumWaterLevel1239" placeholder="请输入汽包水位1239" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="总一次风量199" prop="totalPriWind199">
              <el-input v-model="form.totalPriWind199" placeholder="请输入总一次风量199" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="总二次风量200" prop="totalSecWind200">
              <el-input v-model="form.totalSecWind200" placeholder="请输入总二次风量200" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="总风量198" prop="totalWind198">
              <el-input v-model="form.totalWind198" placeholder="请输入总风量198" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="摆角平均位置280" prop="swingAngleAvg280">
              <el-input v-model="form.swingAngleAvg280" placeholder="请输入摆角平均位置280" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="摆角调节上限284" prop="swingAngleUpper284">
              <el-input v-model="form.swingAngleUpper284" placeholder="请输入摆角调节上限284" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="摆角调节下限283" prop="swingAngleLower283">
              <el-input v-model="form.swingAngleLower283" placeholder="请输入摆角调节下限283" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="给煤机B1给煤量信号120" prop="coalFeederB1120">
              <el-input v-model="form.coalFeederB1120" placeholder="请输入给煤机B1给煤量信号120" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="给煤机B1给煤量信号121" prop="coalFeederB1121">
              <el-input v-model="form.coalFeederB1121" placeholder="请输入给煤机B1给煤量信号121" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="给煤机B2给煤量信号126" prop="coalFeederB2126">
              <el-input v-model="form.coalFeederB2126" placeholder="请输入给煤机B2给煤量信号126" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="给煤机B2给煤量信号127" prop="coalFeederB2127">
              <el-input v-model="form.coalFeederB2127" placeholder="请输入给煤机B2给煤量信号127" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="给煤机C1给煤量信号122" prop="coalFeederC1122">
              <el-input v-model="form.coalFeederC1122" placeholder="请输入给煤机C1给煤量信号122" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="给煤机C1给煤量信号123" prop="coalFeederC1123">
              <el-input v-model="form.coalFeederC1123" placeholder="请输入给煤机C1给煤量信号123" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="送风机A出口风量1 177" prop="blowerAOut1177">
              <el-input v-model="form.blowerAOut1177" placeholder="请输入送风机A出口风量1 177" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="送风机A出口风量2 179" prop="blowerAOut2179">
              <el-input v-model="form.blowerAOut2179" placeholder="请输入送风机A出口风量2 179" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="送风机A出口风量3 181" prop="blowerAOut3181">
              <el-input v-model="form.blowerAOut3181" placeholder="请输入送风机A出口风量3 181" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="送风机B出口风量1 178" prop="blowerBOut1178">
              <el-input v-model="form.blowerBOut1178" placeholder="请输入送风机B出口风量1 178" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="送风机B出口风量2 180" prop="blowerBOut2180">
              <el-input v-model="form.blowerBOut2180" placeholder="请输入送风机B出口风量2 180" />
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="送风机B出口风量3 182" prop="blowerBOut3182">
              <el-input v-model="form.blowerBOut3182" placeholder="请输入送风机B出口风量3 182" />
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listData, getData, delData, addData, updateData } from "@/api/system/data"

export default {
  name: "Data",
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
      // 火电厂核心传感器工况表格数据
      dataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        recordTime: null,
        actualLoad: null,
        millAPriWind149: null,
        millBPriWind164: null,
        millCPriWind175: null,
        millAPriTotal183: null,
        millBPriTotal184: null,
        pipeA11WindSpd30: null,
        pipeA12CoalCon73: null,
        pipeA12WindSpd31: null,
        pipeA13WindSpd32: null,
        pipeA14WindSpd33: null,
        pipeA21WindSpd34: null,
        pipeA22WindSpd35: null,
        pipeA23WindSpd36: null,
        pipeA24WindSpd37: null,
        pipeB11WindSpd38: null,
        pipeB14WindSpd41: null,
        pipeB21CoalCon95: null,
        pipeB22CoalCon296: null,
        pipeB22CoalCon97: null,
        pipeB23CoalCon99: null,
        pipeB24CoalCon101: null,
        pipeC11CoalCon103: null,
        pipeC12CoalCon105: null,
        pipeC13CoalCon107: null,
        pipeC14CoalCon109: null,
        reheaterScrTubeTemp338: null,
        reheaterInletGasTempA358: null,
        reheaterInletGasTempB359: null,
        reheaterEndTubeTempRow2344: null,
        reheaterEndTubeTempRow67357: null,
        drumPressureAvg234: null,
        drumWaterLevel1239: null,
        totalPriWind199: null,
        totalSecWind200: null,
        totalWind198: null,
        swingAngleAvg280: null,
        swingAngleUpper284: null,
        swingAngleLower283: null,
        coalFeederB1120: null,
        coalFeederB1121: null,
        coalFeederB2126: null,
        coalFeederB2127: null,
        coalFeederC1122: null,
        coalFeederC1123: null,
        blowerAOut1177: null,
        blowerAOut2179: null,
        blowerAOut3181: null,
        blowerBOut1178: null,
        blowerBOut2180: null,
        blowerBOut3182: null,
        otherSensors: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        recordTime: [
          { required: true, message: "记录时间不能为空", trigger: "blur" }
        ],
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询火电厂核心传感器工况列表 */
    getList() {
      this.loading = true
      listData(this.queryParams).then(response => {
        this.dataList = response.rows
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
        dataId: null,
        recordTime: null,
        actualLoad: null,
        millAPriWind149: null,
        millBPriWind164: null,
        millCPriWind175: null,
        millAPriTotal183: null,
        millBPriTotal184: null,
        pipeA11WindSpd30: null,
        pipeA12CoalCon73: null,
        pipeA12WindSpd31: null,
        pipeA13WindSpd32: null,
        pipeA14WindSpd33: null,
        pipeA21WindSpd34: null,
        pipeA22WindSpd35: null,
        pipeA23WindSpd36: null,
        pipeA24WindSpd37: null,
        pipeB11WindSpd38: null,
        pipeB14WindSpd41: null,
        pipeB21CoalCon95: null,
        pipeB22CoalCon296: null,
        pipeB22CoalCon97: null,
        pipeB23CoalCon99: null,
        pipeB24CoalCon101: null,
        pipeC11CoalCon103: null,
        pipeC12CoalCon105: null,
        pipeC13CoalCon107: null,
        pipeC14CoalCon109: null,
        reheaterScrTubeTemp338: null,
        reheaterInletGasTempA358: null,
        reheaterInletGasTempB359: null,
        reheaterEndTubeTempRow2344: null,
        reheaterEndTubeTempRow67357: null,
        drumPressureAvg234: null,
        drumWaterLevel1239: null,
        totalPriWind199: null,
        totalSecWind200: null,
        totalWind198: null,
        swingAngleAvg280: null,
        swingAngleUpper284: null,
        swingAngleLower283: null,
        coalFeederB1120: null,
        coalFeederB1121: null,
        coalFeederB2126: null,
        coalFeederB2127: null,
        coalFeederC1122: null,
        coalFeederC1123: null,
        blowerAOut1177: null,
        blowerAOut2179: null,
        blowerAOut3181: null,
        blowerBOut1178: null,
        blowerBOut2180: null,
        blowerBOut3182: null,
        otherSensors: null,
        createTime: null
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
      this.ids = selection.map(item => item.dataId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = "添加火电厂核心传感器工况"
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const dataId = row.dataId || this.ids
      getData(dataId).then(response => {
        this.form = response.data
        this.open = true
        this.title = "修改火电厂核心传感器工况"
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.dataId != null) {
            updateData(this.form).then(response => {
              this.$modal.msgSuccess("修改成功")
              this.open = false
              this.getList()
            })
          } else {
            addData(this.form).then(response => {
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
      const dataIds = row.dataId || this.ids
      this.$modal.confirm('是否确认删除火电厂核心传感器工况编号为"' + dataIds + '"的数据项？').then(function() {
        return delData(dataIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess("删除成功")
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/data/export', {
        ...this.queryParams
      }, `data_${new Date().getTime()}.xlsx`)
    }
  }
}
</script>
