package com.gitsck.service.impl;

import com.gitsck.entity.ArticleProEntity;
import com.gitsck.entity.BaseDataEntity;
import com.gitsck.entity.PVEntity;
import com.gitsck.mapper.*;
import com.gitsck.pojo.GClickCount;
import com.gitsck.pojo.GPv;
import com.gitsck.pojo.GUser;
import com.gitsck.service.StaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StaServiceImpl implements StaService {


    @Autowired
    private GPvMapperCustom gPvMapperCustom;

    @Autowired
    private GClickCountMapper gClickCountMapper;

    @Autowired
    private GClickCountMapperCustom gClickCountMapperCustom;

    @Autowired
    private GKindMapperCustom gKindMapperCustom;

    @Autowired
    private GUserMapperCustom gUserMapperCustom;

    @Autowired
    private GArticleMapperCustom gArticleMapperCustom;

    @Override
    public PVEntity findPVData() {

        PVEntity pvEntity = new PVEntity();

        List<Integer> data = new ArrayList<>();

        List<GPv> pvData = gPvMapperCustom.findPVData();

        pvEntity.setStartDate(pvData.get(0).getPvDate());

        String[] split = pvEntity.getStartDate().split("-");

        pvEntity.setYear(Integer.parseInt(split[0]));

        pvEntity.setMonth(Integer.parseInt(split[1]));

        pvEntity.setDay(Integer.parseInt(split[2]));

        for (GPv gPv:
                pvData) {
            data.add(gPv.getPv());
        }
        pvEntity.setgPvs(data);

        return pvEntity;
    }

    @Override
    public List<Integer> findKindClickData() {

        List<Integer> data = new ArrayList<>();

        List<GClickCount> gClickCounts = gClickCountMapper.selectByExample(null);
        for (GClickCount gClickCount:
                gClickCounts) {
            data.add(gClickCount.getcNum());
        }
        return data;
    }

    @Override
    public List<ArticleProEntity> findArticleProData() {
        return gClickCountMapperCustom.findArticleProEntity();
    }

    @Override
    public BaseDataEntity findBaseData() {
        return new BaseDataEntity(gPvMapperCustom.findTotalPV(),gKindMapperCustom.findTotalKinds(),gUserMapperCustom.findTotalUsers(),gArticleMapperCustom.findTotalArticles());
    }
}
