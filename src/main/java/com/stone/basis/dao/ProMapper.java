package com.kpap.basis.dao;

import com.kpap.basis.model.Pro;
import com.kpap.basis.model.ProExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProMapper {
    int countByExample(ProExample example);

    int deleteByExample(ProExample example);

    int deleteByPrimaryKey(String proCode);

    int insert(Pro record);

    int insertSelective(Pro record);

    List<Pro> selectByExample(ProExample example);

    Pro selectByPrimaryKey(String proCode);

    int updateByExampleSelective(@Param("record") Pro record, @Param("example") ProExample example);

    int updateByExample(@Param("record") Pro record, @Param("example") ProExample example);

    int updateByPrimaryKeySelective(Pro record);

    int updateByPrimaryKey(Pro record);
}