package com.kpap.basis.dao;

import com.kpap.basis.model.IqComPatentSum;
import com.kpap.basis.model.IqComPatentSumExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqComPatentSumMapper {
    int countByExample(IqComPatentSumExample example);

    int deleteByExample(IqComPatentSumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(IqComPatentSum record);

    int insertSelective(IqComPatentSum record);

    List<IqComPatentSum> selectByExample(IqComPatentSumExample example);

    IqComPatentSum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") IqComPatentSum record, @Param("example") IqComPatentSumExample example);

    int updateByExample(@Param("record") IqComPatentSum record, @Param("example") IqComPatentSumExample example);

    int updateByPrimaryKeySelective(IqComPatentSum record);

    int updateByPrimaryKey(IqComPatentSum record);
}