package com.gitsck.mapper;

import com.gitsck.pojo.GArticle;
import com.gitsck.pojo.GArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GArticleMapper {
    int countByExample(GArticleExample example);

    int deleteByExample(GArticleExample example);

    int deleteByPrimaryKey(Long aId);

    int insert(GArticle record);

    int insertSelective(GArticle record);

    List<GArticle> selectByExampleWithBLOBs(GArticleExample example);

    List<GArticle> selectByExample(GArticleExample example);

    GArticle selectByPrimaryKey(Long aId);

    int updateByExampleSelective(@Param("record") GArticle record, @Param("example") GArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") GArticle record, @Param("example") GArticleExample example);

    int updateByExample(@Param("record") GArticle record, @Param("example") GArticleExample example);

    int updateByPrimaryKeySelective(GArticle record);

    int updateByPrimaryKeyWithBLOBs(GArticle record);

    int updateByPrimaryKey(GArticle record);
}