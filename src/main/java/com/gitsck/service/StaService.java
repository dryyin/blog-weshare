package com.gitsck.service;

import com.gitsck.entity.ArticleProEntity;
import com.gitsck.entity.BaseDataEntity;
import com.gitsck.entity.PVEntity;

import java.util.List;

public interface StaService {

    PVEntity findPVData();

    List<Integer> findKindClickData();

    List<ArticleProEntity> findArticleProData();

    BaseDataEntity findBaseData();
}
