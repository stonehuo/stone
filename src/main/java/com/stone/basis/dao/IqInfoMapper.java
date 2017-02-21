package com.kpap.basis.dao;

import com.kpap.basis.model.IqInfo;
import com.kpap.basis.model.IqInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqInfoMapper {
    int countByExample(IqInfoExample example);

    int deleteByExample(IqInfoExample example);

    int deleteByPrimaryKey(String proCode);

    int insert(IqInfo record);

    int insertSelective(IqInfo record);

    List<IqInfo> selectByExample(IqInfoExample example);

    IqInfo selectByPrimaryKey(String proCode);

    int updateByExampleSelective(@Param("record") IqInfo record, @Param("example") IqInfoExample example);

    int updateByExample(@Param("record") IqInfo record, @Param("example") IqInfoExample example);

    int updateByPrimaryKeySelective(IqInfo record);

    int updateByPrimaryKey(IqInfo record);
}