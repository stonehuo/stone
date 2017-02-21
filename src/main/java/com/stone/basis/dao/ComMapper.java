package com.kpap.basis.dao;

import com.kpap.basis.model.Com;
import com.kpap.basis.model.ComExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComMapper {
    int countByExample(ComExample example);

    int deleteByExample(ComExample example);

    int deleteByPrimaryKey(String proCode);

    int insert(Com record);

    int insertSelective(Com record);

    List<Com> selectByExample(ComExample example);

    Com selectByPrimaryKey(String proCode);

    int updateByExampleSelective(@Param("record") Com record, @Param("example") ComExample example);

    int updateByExample(@Param("record") Com record, @Param("example") ComExample example);

    int updateByPrimaryKeySelective(Com record);

    int updateByPrimaryKey(Com record);
}