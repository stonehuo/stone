package com.kpap.basis.dao;

import com.kpap.basis.model.ComCase;
import com.kpap.basis.model.ComCaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComCaseMapper {
    int countByExample(ComCaseExample example);

    int deleteByExample(ComCaseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComCase record);

    int insertSelective(ComCase record);

    List<ComCase> selectByExample(ComCaseExample example);

    ComCase selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComCase record, @Param("example") ComCaseExample example);

    int updateByExample(@Param("record") ComCase record, @Param("example") ComCaseExample example);

    int updateByPrimaryKeySelective(ComCase record);

    int updateByPrimaryKey(ComCase record);
}