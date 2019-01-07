package com.gitsck.mapper;

import com.gitsck.pojo.GUser;
import com.gitsck.pojo.GUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GUserMapper {
    int countByExample(GUserExample example);

    int deleteByExample(GUserExample example);

    int deleteByPrimaryKey(Long uId);

    int insert(GUser record);

    int insertSelective(GUser record);

    List<GUser> selectByExample(GUserExample example);

    GUser selectByPrimaryKey(Long uId);

    int updateByExampleSelective(@Param("record") GUser record, @Param("example") GUserExample example);

    int updateByExample(@Param("record") GUser record, @Param("example") GUserExample example);

    int updateByPrimaryKeySelective(GUser record);

    int updateByPrimaryKey(GUser record);
}