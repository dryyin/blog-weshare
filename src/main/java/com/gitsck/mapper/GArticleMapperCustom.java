package com.gitsck.mapper;


import com.gitsck.pojo.GArticle;
import com.gitsck.pojo.GArticleCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GArticleMapperCustom {

    List<GArticleCustom> findList(GArticle gArticle);


    @Select("SELECT\n" +
            "\tga.a_id aId,\n" +
            "\tga.a_title aTitle,\n" +
            "\tga.a_view aView\n" +
            "FROM\n" +
            "\tg_article ga\n" +
            "ORDER BY \n" +
            "\tga.a_view\n" +
            "DESC\n" +
            "LIMIT 0,6")
    List<GArticle> findHot();

    @Select("SELECT\n" +
            "\tga.a_id aId,\n" +
            "\tga.a_title aTitle,\n" +
            "\tga.a_view aView,\n" +
            "\tga.a_text aText,\n" +
            "\tga.a_cretime aCretime,\n" +
            "\tgu.u_username authorName,\n" +
            "\tgk.k_text,\n" +
            "\tga.k_id kId\n" +
            "\t\n" +
            "\t\n" +
            "FROM\n" +
            "\tg_article ga,\n" +
            "\tg_user gu,\n" +
            "\tg_user_article gua,\n" +
            "\tg_kind\tgk\n" +
            "WHERE \n" +
            "\tgua.u_i = gu.u_id\n" +
            "AND\n" +
            "\tgua.a_id = ga.a_id\n" +
            "AND\n" +
            "\tga.k_id = gk.k_id\n" +
            "and\n" +
            "\tgua.a_id = ${aId}")
    GArticleCustom finDesc(@Param("aId") long aId);

    @Select("SELECT\n" +
            "\tcount(*) count\n" +
            "FROM\n" +
            "\tg_article\n")
    int findTotalArticles();

    @Select("SELECT\n" +
            "\tga.a_id aId,\n" +
            "\tga.a_title aTitle,\n" +
            "\tga.a_view aView,\n" +
            "\tgu.u_username authorName,\n" +
            "\tgk.k_text kindText,\n" +
            "\tga.a_cretime aCretime\n" +
            "\t\n" +
            "FROM\n" +
            "\tg_user_article gua,\n" +
            "\tg_article ga,\n" +
            "\tg_user gu,\n" +
            "\tg_kind gk\n" +
            "where\n" +
            "\tgua.u_i = gu.u_id\n" +
            "AND\n" +
            "\tgua.a_id = ga.a_id\n" +
            "AND\n" +
            "\tga.k_id = gk.k_id")
    List<GArticleCustom> findAllArticles();

}