package com.kpap.basis.dao;

import com.kpap.basis.model.IqRatios;
import com.kpap.basis.model.IqRatiosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqRatiosMapper {
    int countByExample(IqRatiosExample example);

    int deleteByExample(IqRatiosExample example);

    int deleteByPrimaryKey(String proCode);

    int insert(IqRatios record);

    int insertSelective(IqRatios record);

    List<IqRatios> selectByExample(IqRatiosExample example);

    IqRatios selectByPrimaryKey(String proCode);

    int updateByExampleSelective(@Param("record") IqRatios record, @Param("example") IqRatiosExample example);

    int updateByExample(@Param("record") IqRatios record, @Param("example") IqRatiosExample example);

    int updateByPrimaryKeySelective(IqRatios record);

    int updateByPrimaryKey(IqRatios record);
}