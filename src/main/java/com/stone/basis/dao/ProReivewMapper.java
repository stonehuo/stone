package com.kpap.basis.dao;

import com.kpap.basis.model.ProReivew;
import com.kpap.basis.model.ProReivewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProReivewMapper {
    int countByExample(ProReivewExample example);

    int deleteByExample(ProReivewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProReivew record);

    int insertSelective(ProReivew record);

    List<ProReivew> selectByExample(ProReivewExample example);

    ProReivew selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProReivew record, @Param("example") ProReivewExample example);

    int updateByExample(@Param("record") ProReivew record, @Param("example") ProReivewExample example);

    int updateByPrimaryKeySelective(ProReivew record);

    int updateByPrimaryKey(ProReivew record);
}