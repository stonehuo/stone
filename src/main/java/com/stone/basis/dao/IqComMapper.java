package com.kpap.basis.dao;

import com.kpap.basis.model.IqCom;
import com.kpap.basis.model.IqComExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqComMapper {
    int countByExample(IqComExample example);

    int deleteByExample(IqComExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IqCom record);

    int insertSelective(IqCom record);

    List<IqCom> selectByExample(IqComExample example);

    IqCom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IqCom record, @Param("example") IqComExample example);

    int updateByExample(@Param("record") IqCom record, @Param("example") IqComExample example);

    int updateByPrimaryKeySelective(IqCom record);

    int updateByPrimaryKey(IqCom record);
}