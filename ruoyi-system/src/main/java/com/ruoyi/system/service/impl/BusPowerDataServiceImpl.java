package com.ruoyi.system.service.impl;

import java.util.List;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusPowerDataMapper;
import com.ruoyi.system.domain.BusPowerData;
import com.ruoyi.system.service.IBusPowerDataService;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import com.alibaba.fastjson2.PropertyNamingStrategy;
import com.alibaba.fastjson2.writer.ObjectWriterProvider;

/**
 * 火电厂核心传感器工况Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
@Service
public class BusPowerDataServiceImpl implements IBusPowerDataService 
{
    @Autowired
    private BusPowerDataMapper busPowerDataMapper;

    @Override
    public JSONObject predictPowerLoad(Long dataId, Integer targetHorizon) {
        // 1. 从数据库查出这条历史传感器的全量数据
        BusPowerData data = selectBusPowerDataByDataId(dataId);
        if (data == null) {
            throw new RuntimeException("未能找到指定的传感器数据");
        }

        // 2. 驼峰转下划线 (保持原样)
        ObjectWriterProvider provider = new ObjectWriterProvider(PropertyNamingStrategy.SnakeCase);
        JSONWriter.Context context = new JSONWriter.Context(provider);
        String snakeCaseJsonStr = JSON.toJSONString(data, context);
        JSONObject snakeCaseJson = JSON.parseObject(snakeCaseJsonStr);

        // 3. 构建符合 Python Pydantic 契约的请求体
        JSONObject requestBody = new JSONObject();
        requestBody.put("sensors", snakeCaseJson);
        // 【新增】把 Vue3 传过来的档位参数，老老实实发给 Python
        requestBody.put("target_horizon", targetHorizon == null ? 0 : targetHorizon);


        // 4. 发送 HTTP 请求 (保持原样)
        RestTemplate restTemplate = new RestTemplate();
        String pythonApiUrl = "http://localhost:8000/api/predict/single";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody.toJSONString(), headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(pythonApiUrl, requestEntity, String.class);
            return JSON.parseObject(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("调用 AI 预测引擎失败: " + e.getMessage());
        }
    }

    /**
     * 查询火电厂核心传感器工况
     * 
     * @param dataId 火电厂核心传感器工况主键
     * @return 火电厂核心传感器工况
     */
    @Override
    public BusPowerData selectBusPowerDataByDataId(Long dataId)
    {
        return busPowerDataMapper.selectBusPowerDataByDataId(dataId);
    }

    /**
     * 查询火电厂核心传感器工况列表
     * 
     * @param busPowerData 火电厂核心传感器工况
     * @return 火电厂核心传感器工况
     */
    @Override
    public List<BusPowerData> selectBusPowerDataList(BusPowerData busPowerData)
    {
        return busPowerDataMapper.selectBusPowerDataList(busPowerData);
    }

    /**
     * 新增火电厂核心传感器工况
     * 
     * @param busPowerData 火电厂核心传感器工况
     * @return 结果
     */
    @Override
    public int insertBusPowerData(BusPowerData busPowerData)
    {
        busPowerData.setCreateTime(DateUtils.getNowDate());
        return busPowerDataMapper.insertBusPowerData(busPowerData);
    }

    /**
     * 修改火电厂核心传感器工况
     * 
     * @param busPowerData 火电厂核心传感器工况
     * @return 结果
     */
    @Override
    public int updateBusPowerData(BusPowerData busPowerData)
    {
        return busPowerDataMapper.updateBusPowerData(busPowerData);
    }

    /**
     * 批量删除火电厂核心传感器工况
     * 
     * @param dataIds 需要删除的火电厂核心传感器工况主键
     * @return 结果
     */
    @Override
    public int deleteBusPowerDataByDataIds(Long[] dataIds)
    {
        return busPowerDataMapper.deleteBusPowerDataByDataIds(dataIds);
    }

    /**
     * 删除火电厂核心传感器工况信息
     * 
     * @param dataId 火电厂核心传感器工况主键
     * @return 结果
     */
    @Override
    public int deleteBusPowerDataByDataId(Long dataId)
    {
        return busPowerDataMapper.deleteBusPowerDataByDataId(dataId);
    }


}
