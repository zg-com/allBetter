package com.ruoyi.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.BusPowerData;

/**
 * 火电厂核心传感器工况Service接口
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
public interface IBusPowerDataService 
{
    public JSONObject predictPowerLoad(Long dataId, Integer targetHorizon);

    /**
     * 查询火电厂核心传感器工况
     * 
     * @param dataId 火电厂核心传感器工况主键
     * @return 火电厂核心传感器工况
     */
    public BusPowerData selectBusPowerDataByDataId(Long dataId);

    /**
     * 查询火电厂核心传感器工况列表
     * 
     * @param busPowerData 火电厂核心传感器工况
     * @return 火电厂核心传感器工况集合
     */
    public List<BusPowerData> selectBusPowerDataList(BusPowerData busPowerData);

    /**
     * 新增火电厂核心传感器工况
     * 
     * @param busPowerData 火电厂核心传感器工况
     * @return 结果
     */
    public int insertBusPowerData(BusPowerData busPowerData);

    /**
     * 修改火电厂核心传感器工况
     * 
     * @param busPowerData 火电厂核心传感器工况
     * @return 结果
     */
    public int updateBusPowerData(BusPowerData busPowerData);

    /**
     * 批量删除火电厂核心传感器工况
     * 
     * @param dataIds 需要删除的火电厂核心传感器工况主键集合
     * @return 结果
     */
    public int deleteBusPowerDataByDataIds(Long[] dataIds);

    /**
     * 删除火电厂核心传感器工况信息
     * 
     * @param dataId 火电厂核心传感器工况主键
     * @return 结果
     */
    public int deleteBusPowerDataByDataId(Long dataId);
}
