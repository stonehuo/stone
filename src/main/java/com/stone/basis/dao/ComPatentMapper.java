package com.kpap.basis.dao;

import com.kpap.basis.model.ComPatent;
import com.kpap.basis.model.ComPatentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComPatentMapper {
    int countByExample(ComPatentExample example);

    int deleteByExample(ComPatentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ComPatent record);

    int insertSelective(ComPatent record);

    List<ComPatent> selectByExample(ComPatentExample example);

    ComPatent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ComPatent record, @Param("example") ComPatentExample example);

    int updateByExample(@Param("record") ComPatent record, @Param("example") ComPatentExample example);

    int updateByPrimaryKeySelective(ComPatent record);

    int updateByPrimaryKey(ComPatent record);
}