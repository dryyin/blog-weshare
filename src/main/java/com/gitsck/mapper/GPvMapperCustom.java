package com.gitsck.mapper;

import com.gitsck.pojo.GPv;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface GPvMapperCustom {

    @Select("SELECT\n" +
            "\ta.pv pv,\n" +
            "\ta.pv_date pvDate\n" +
            "FROM\n" +
            "\t(\n" +
            "\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\t*\n" +
            "\t\t\tFROM\n" +
            "\t\t\t\tg_pv\n" +
            "\t\t\tORDER BY\n" +
            "\t\t\t\tg_pv.pv_date DESC\n" +
            "\t\t)\n" +
            "\t\tLIMIT 0,\n" +
            "\t\t7\n" +
            "\t) a\n" +
            "ORDER BY\n" +
            "\ta.pv_date ")
    List<GPv> findPVData();

    @Select("SELECT\n" +
            "\tsum(g_pv.pv) pv\n" +
            "FROM\n" +
            "\tg_pv")
    int findTotalPV();
}