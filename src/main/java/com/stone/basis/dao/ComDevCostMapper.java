package com.kpap.basis.dao;

import com.kpap.basis.model.ComDevCost;
import com.kpap.basis.model.ComDevCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComDevCostMapper {
    int countByExample(ComDevCostExample example);

    int deleteByExample(ComDevCostExample example);

    int deleteByPrimaryKey(String proCode);

    int insert(ComDevCost record);

    int insertSelective(ComDevCost record);

    List<ComDevCost> selectByExample(ComDevCostExample example);

    ComDevCost selectByPrimaryKey(String proCode);

    int updateByExampleSelective(@Param("record") ComDevCost record, @Param("example") ComDevCostExample example);

    int updateByExample(@Param("record") ComDevCost record, @Param("example") ComDevCostExample example);

    int updateByPrimaryKeySelective(ComDevCost record);

    int updateByPrimaryKey(ComDevCost record);
}