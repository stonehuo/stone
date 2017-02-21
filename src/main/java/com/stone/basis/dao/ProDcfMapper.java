package com.kpap.basis.dao;

import com.kpap.basis.model.ProDcf;
import com.kpap.basis.model.ProDcfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProDcfMapper {
    int countByExample(ProDcfExample example);

    int deleteByExample(ProDcfExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProDcf record);

    int insertSelective(ProDcf record);

    List<ProDcf> selectByExample(ProDcfExample example);

    ProDcf selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProDcf record, @Param("example") ProDcfExample example);

    int updateByExample(@Param("record") ProDcf record, @Param("example") ProDcfExample example);

    int updateByPrimaryKeySelective(ProDcf record);

    int updateByPrimaryKey(ProDcf record);
}