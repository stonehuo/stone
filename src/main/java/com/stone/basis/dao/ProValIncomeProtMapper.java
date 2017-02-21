package com.kpap.basis.dao;

import com.kpap.basis.model.ProValIncomeProt;
import com.kpap.basis.model.ProValIncomeProtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProValIncomeProtMapper {
    int countByExample(ProValIncomeProtExample example);

    int deleteByExample(ProValIncomeProtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProValIncomeProt record);

    int insertSelective(ProValIncomeProt record);

    List<ProValIncomeProt> selectByExample(ProValIncomeProtExample example);

    ProValIncomeProt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProValIncomeProt record, @Param("example") ProValIncomeProtExample example);

    int updateByExample(@Param("record") ProValIncomeProt record, @Param("example") ProValIncomeProtExample example);

    int updateByPrimaryKeySelective(ProValIncomeProt record);

    int updateByPrimaryKey(ProValIncomeProt record);
}