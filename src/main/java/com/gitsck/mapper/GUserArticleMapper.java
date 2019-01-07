package com.gitsck.mapper;

import com.gitsck.pojo.GUserArticle;
import com.gitsck.pojo.GUserArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GUserArticleMapper {
    int countByExample(GUserArticleExample example);

    int deleteByExample(GUserArticleExample example);

    int insert(GUserArticle record);

    int insertSelective(GUserArticle record);

    List<GUserArticle> selectByExample(GUserArticleExample example);

    int updateByExampleSelective(@Param("record") GUserArticle record, @Param("example") GUserArticleExample example);

    int updateByExample(@Param("record") GUserArticle record, @Param("example") GUserArticleExample example);
}