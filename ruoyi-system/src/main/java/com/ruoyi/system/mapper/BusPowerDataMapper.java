package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BusPowerData;

/**
 * 火电厂核心传感器工况Mapper接口
 * 
 * @author ruoyi
 * @date 2026-06-10
 */
public interface BusPowerDataMapper 
{
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
     * 删除火电厂核心传感器工况
     * 
     * @param dataId 火电厂核心传感器工况主键
     * @return 结果
     */
    public int deleteBusPowerDataByDataId(Long dataId);

    /**
     * 批量删除火电厂核心传感器工况
     * 
     * @param dataIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBusPowerDataByDataIds(Long[] dataIds);
}
