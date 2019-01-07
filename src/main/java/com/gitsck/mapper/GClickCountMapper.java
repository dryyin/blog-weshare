package com.gitsck.mapper;

import com.gitsck.pojo.GClickCount;
import com.gitsck.pojo.GClickCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GClickCountMapper {
    int countByExample(GClickCountExample example);

    int deleteByExample(GClickCountExample example);

    int insert(GClickCount record);

    int insertSelective(GClickCount record);

    List<GClickCount> selectByExample(GClickCountExample example);

    int updateByExampleSelective(@Param("record") GClickCount record, @Param("example") GClickCountExample example);

    int updateByExample(@Param("record") GClickCount record, @Param("example") GClickCountExample example);
}