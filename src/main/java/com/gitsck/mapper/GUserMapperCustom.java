package com.gitsck.mapper;


import org.apache.ibatis.annotations.Select;

public interface GUserMapperCustom {

    @Select("SELECT\n" +
            "\tcount(*) count\n" +
            "FROM\n" +
            "\tg_user\n" +
            "WHERE\n" +
            "\tg_user.u_role = 0")
    int findTotalUsers();
}