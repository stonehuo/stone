package com.kpap.basis.dao;

import com.kpap.basis.model.ProVal;
import com.kpap.basis.model.ProValExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProValMapper {
    int countByExample(ProValExample example);

    int deleteByExample(ProValExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProVal record);

    int insertSelective(ProVal record);

    List<ProVal> selectByExample(ProValExample example);

    ProVal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProVal record, @Param("example") ProValExample example);

    int updateByExample(@Param("record") ProVal record, @Param("example") ProValExample example);

    int updateByPrimaryKeySelective(ProVal record);

    int updateByPrimaryKey(ProVal record);
}