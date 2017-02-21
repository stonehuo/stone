package com.kpap.basis.dao;

import com.kpap.basis.model.ComProduct;
import com.kpap.basis.model.ComProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComProductMapper {
    int countByExample(ComProductExample example);

    int deleteByExample(ComProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComProduct record);

    int insertSelective(ComProduct record);

    List<ComProduct> selectByExample(ComProductExample example);

    ComProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComProduct record, @Param("example") ComProductExample example);

    int updateByExample(@Param("record") ComProduct record, @Param("example") ComProductExample example);

    int updateByPrimaryKeySelective(ComProduct record);

    int updateByPrimaryKey(ComProduct record);
}