package com.gitsck.mapper;

import com.gitsck.pojo.GKind;
import com.gitsck.pojo.GKindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GKindMapper {
    int countByExample(GKindExample example);

    int deleteByExample(GKindExample example);

    int deleteByPrimaryKey(Long kId);

    int insert(GKind record);

    int insertSelective(GKind record);

    List<GKind> selectByExample(GKindExample example);

    GKind selectByPrimaryKey(Long kId);

    int updateByExampleSelective(@Param("record") GKind record, @Param("example") GKindExample example);

    int updateByExample(@Param("record") GKind record, @Param("example") GKindExample example);

    int updateByPrimaryKeySelective(GKind record);

    int updateByPrimaryKey(GKind record);
}