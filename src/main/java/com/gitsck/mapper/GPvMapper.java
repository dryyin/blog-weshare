package com.gitsck.mapper;

import com.gitsck.pojo.GPv;
import com.gitsck.pojo.GPvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GPvMapper {
    int countByExample(GPvExample example);

    int deleteByExample(GPvExample example);

    int deleteByPrimaryKey(Long pvId);

    int insert(GPv record);

    int insertSelective(GPv record);

    List<GPv> selectByExample(GPvExample example);

    GPv selectByPrimaryKey(Long pvId);

    int updateByExampleSelective(@Param("record") GPv record, @Param("example") GPvExample example);

    int updateByExample(@Param("record") GPv record, @Param("example") GPvExample example);

    int updateByPrimaryKeySelective(GPv record);

    int updateByPrimaryKey(GPv record);
}