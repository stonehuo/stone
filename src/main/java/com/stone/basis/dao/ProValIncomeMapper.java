package com.kpap.basis.dao;

import com.kpap.basis.model.ProValIncome;
import com.kpap.basis.model.ProValIncomeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProValIncomeMapper {
    int countByExample(ProValIncomeExample example);

    int deleteByExample(ProValIncomeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProValIncome record);

    int insertSelective(ProValIncome record);

    List<ProValIncome> selectByExample(ProValIncomeExample example);

    ProValIncome selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProValIncome record, @Param("example") ProValIncomeExample example);

    int updateByExample(@Param("record") ProValIncome record, @Param("example") ProValIncomeExample example);

    int updateByPrimaryKeySelective(ProValIncome record);

    int updateByPrimaryKey(ProValIncome record);
}