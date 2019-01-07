package com.gitsck.mapper;


import com.gitsck.entity.ArticleProEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GClickCountMapperCustom {

    @Select("SELECT\n" +
            "\tgk.k_text name,\n" +
            "\tROUND(\n" +
            "\t\tROUND(\n" +
            "\t\t\t(gcc.c_num) / (\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tsum(g_click_count.c_num)\n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\tg_click_count\n" +
            "\t\t\t),\n" +
            "\t\t\t4\n" +
            "\t\t),\n" +
            "\t\t2\n" +
            "\t) y\n" +
            "FROM\n" +
            "\tg_click_count gcc,\n" +
            "\tg_kind gk\n" +
            "WHERE\n" +
            "\tgk.k_id = gcc.k_id")
    List<ArticleProEntity> findArticleProEntity();
}