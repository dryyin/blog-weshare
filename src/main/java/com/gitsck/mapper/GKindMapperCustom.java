package com.gitsck.mapper;


import org.apache.ibatis.annotations.Select;

public interface GKindMapperCustom {

    @Select("SELECT\n" +
            "\tcount(*) count\n" +
            "FROM\n" +
            "\tg_kind\n" +
            "WHERE\n" +
            "\tg_kind.k_isparent != 1")
    int findTotalKinds();
}