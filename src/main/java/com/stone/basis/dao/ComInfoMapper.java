package com.kpap.basis.dao;

import com.kpap.basis.model.ComInfo;
import com.kpap.basis.model.ComInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComInfoMapper {
    int countByExample(ComInfoExample example);

    int deleteByExample(ComInfoExample example);

    int deleteByPrimaryKey(String proCode);

    int insert(ComInfo record);

    int insertSelective(ComInfo record);

    List<ComInfo> selectByExample(ComInfoExample example);

    ComInfo selectByPrimaryKey(String proCode);

    int updateByExampleSelective(@Param("record") ComInfo record, @Param("example") ComInfoExample example);

    int updateByExample(@Param("record") ComInfo record, @Param("example") ComInfoExample example);

    int updateByPrimaryKeySelective(ComInfo record);

    int updateByPrimaryKey(ComInfo record);
}