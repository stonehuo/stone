package com.kpap.basis.dao;

import com.kpap.basis.model.ComPatentSum;
import com.kpap.basis.model.ComPatentSumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComPatentSumMapper {
    int countByExample(ComPatentSumExample example);

    int deleteByExample(ComPatentSumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComPatentSum record);

    int insertSelective(ComPatentSum record);

    List<ComPatentSum> selectByExample(ComPatentSumExample example);

    ComPatentSum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComPatentSum record, @Param("example") ComPatentSumExample example);

    int updateByExample(@Param("record") ComPatentSum record, @Param("example") ComPatentSumExample example);

    int updateByPrimaryKeySelective(ComPatentSum record);

    int updateByPrimaryKey(ComPatentSum record);
}