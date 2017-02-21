package com.kpap.basis.dao;

import com.kpap.basis.model.IqComPatent;
import com.kpap.basis.model.IqComPatentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IqComPatentMapper {
    int countByExample(IqComPatentExample example);

    int deleteByExample(IqComPatentExample example);

    int deleteByPrimaryKey(Long iq_com_id);

    int insert(IqComPatent record);

    int insertSelective(IqComPatent record);

    List<IqComPatent> selectByExample(IqComPatentExample example);

    IqComPatent selectByPrimaryKey(Long iq_com_id);

    int updateByExampleSelective(@Param("record") IqComPatent record, @Param("example") IqComPatentExample example);

    int updateByExample(@Param("record") IqComPatent record, @Param("example") IqComPatentExample example);

    int updateByPrimaryKeySelective(IqComPatent record);

    int updateByPrimaryKey(IqComPatent record);
}