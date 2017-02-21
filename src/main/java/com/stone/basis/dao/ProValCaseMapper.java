package com.kpap.basis.dao;

import com.kpap.basis.model.ProValCase;
import com.kpap.basis.model.ProValCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProValCaseMapper {
    int countByExample(ProValCaseExample example);

    int deleteByExample(ProValCaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProValCase record);

    int insertSelective(ProValCase record);

    List<ProValCase> selectByExample(ProValCaseExample example);

    ProValCase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProValCase record, @Param("example") ProValCaseExample example);

    int updateByExample(@Param("record") ProValCase record, @Param("example") ProValCaseExample example);

    int updateByPrimaryKeySelective(ProValCase record);

    int updateByPrimaryKey(ProValCase record);
}