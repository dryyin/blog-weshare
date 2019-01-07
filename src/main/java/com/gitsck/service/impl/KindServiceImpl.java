package com.gitsck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gitsck.entity.GKindCustom;
import com.gitsck.entity.PageResult;
import com.gitsck.entity.Result;
import com.gitsck.mapper.GKindMapper;
import com.gitsck.pojo.GKind;
import com.gitsck.pojo.GKindExample;
import com.gitsck.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class KindServiceImpl implements KindService {


    @Autowired
    private GKindMapper gKindMapper;

    @Override
    public PageResult findAllParentKinds(int page, int rows,long pId) {

        //先判断该分类是否为父分类



        PageHelper.startPage(page,rows);

        GKindExample example = new GKindExample();
        GKindExample.Criteria criteria = example.createCriteria();
        criteria.andKParentEqualTo(pId);
        Page<GKind> list = (Page<GKind>) gKindMapper.selectByExample(example);

        return new PageResult(list.getTotal(),list.getResult());
    }

    @Override
    public Result addKind(GKind gKind,long pId) {
        if(pId == 0){
            return new Result(false,"未知错误");
        }

        if(gKind.getkText() == null || gKind.getkText().trim().equals("")){
            return new Result(false,"分类名不能为空");
        }

        gKind.setkIsparent(0);

        gKind.setkParent(pId);

        int insert = gKindMapper.insert(gKind);

        if(insert == 1){
            return new Result(true,"添加成功");
        }
        return new Result(false,"未知错误");
    }

    @Override
    public Result findByParentId(long pId) {

        GKindExample example = new GKindExample();
        GKindExample.Criteria criteria = example.createCriteria();
        criteria.andKParentEqualTo(pId);
        List<GKind> gKinds = gKindMapper.selectByExample(example);

        return new Result(true,"查找成功",gKinds);
    }

    @Override
    public Result findall() {

        /*List<GKindCustom> gKindCustomlist = new ArrayList<>();

        List<GKind> gKinds = gKindMapper.selectByExample(null);

        for(GKind gk:gKinds){
            if(gk.getkIsparent()==1 && gk.getkParent()==0){
                GKindCustom gKindCustom = this.GKindtoCustom(gk);
                gKindCustomlist.add(gKindCustom);
            }
        }
        for (GKind gk:gKinds){
            if(gk.getkIsparent()==0){
                for (GKindCustom gkl:gKindCustomlist){
                    if(gk.getkParent() == gkl.getkId()){
                        List<GKind> childList = gkl.getChildList();
                        childList.add(gk);
                        gkl.setChildList(childList);
                    }
                }
            }
        }*/

        GKindExample example = new GKindExample();
        GKindExample.Criteria criteria = example.createCriteria();
        criteria.andKIsparentEqualTo(1);
        List<GKind> parentKinds = gKindMapper.selectByExample(example);

        List<GKindCustom> parentkind = new ArrayList<>();

        for (GKind gKind:
                parentKinds) {
            GKindCustom gKindCustom = GKindtoCustom(gKind);
            parentkind.add(gKindCustom);
        }

        for (GKindCustom gKindCustom:
                parentkind) {
            GKindExample gKindExample = new GKindExample();
            GKindExample.Criteria criteria1 = gKindExample.createCriteria();
            criteria1.andKParentEqualTo(gKindCustom.getkId());
            List<GKind> gKinds1 = gKindMapper.selectByExample(gKindExample);


            gKindCustom.setChildList(gKinds1);
        }




        return new Result(true,"查找成功",parentkind);

    }

    public GKindCustom GKindtoCustom(GKind gKind){
        GKindCustom gKindCustom = new GKindCustom();
        gKindCustom.setkId(gKind.getkId());
        gKindCustom.setkIsparent(gKind.getkIsparent());
        gKindCustom.setkParent(gKind.getkParent());
        gKindCustom.setkText(gKind.getkText());

        return gKindCustom;

    }
}
