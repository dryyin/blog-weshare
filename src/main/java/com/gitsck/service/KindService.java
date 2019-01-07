package com.gitsck.service;

import com.gitsck.entity.PageResult;
import com.gitsck.entity.Result;
import com.gitsck.pojo.GKind;

public interface KindService {

    PageResult findAllParentKinds(int page,int rows,long pId);

    Result addKind(GKind gKind,long pId);

    Result findByParentId(long pId);

    Result findall();

}
