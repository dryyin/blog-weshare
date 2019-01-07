package com.gitsck.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gitsck.entity.PageResult;
import com.gitsck.entity.Result;
import com.gitsck.mapper.*;
import com.gitsck.pojo.*;
import com.gitsck.service.ArticleService;
import com.gitsck.util.IDUtils;
import com.gitsck.util.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private GArticleMapper gArticleMapper;

    @Autowired
    private GUserArticleMapper gUserArticleMapper;

    @Autowired
    private GArticleMapperCustom gArticleMapperCustom;

    @Autowired
    private GKindMapper gKindMapper;

    @Autowired
    private GClickCountMapper gClickCountMapper;

    @Override
    public Result addArticle(GArticle gArticle, HttpSession session) {

        GUser unuser = (GUser) session.getAttribute("unuser");
        if(unuser == null){
            return new Result(false,"登录信息已失效，请重新登录");
        }

        if(gArticle.getaTitle() == null || gArticle.getaTitle().trim().equals("")){
            return new Result(false,"请填写标题！");
        }
        if(gArticle.getaText() == null || gArticle.getaText().trim().equals("<p><br></p>")){
            return new Result(false,"请填写内容！");
        }
        if(gArticle.getkId() == null){
            return new Result(false,"请填写父分类！");
        }
        long articlId = IDUtils.genItemId();

        gArticle.setaId(articlId);

        gArticle.setaView(0);

        gArticle.setaCretime(TimeUtils.getTime());

        GUserArticle gUserArticle = new GUserArticle();

        gUserArticle.setaId(articlId);

        gUserArticle.setuI(unuser.getuId());

        gArticleMapper.insert(gArticle);

        gUserArticleMapper.insert(gUserArticle);

        return new Result(true,"发表成功");
    }

    @Override
    public PageResult initList(int page,int rows,GArticle gArticle) {

        PageHelper.startPage(page,rows);

        Page<GArticleCustom> list = (Page<GArticleCustom>) gArticleMapperCustom.findList(gArticle);

        List<GArticleCustom> result = list.getResult();

        for (GArticleCustom gArticleCustom:
             result) {
            Long kId = gArticleCustom.getkId();

            GKindExample example = new GKindExample();
            GKindExample.Criteria criteria = example.createCriteria();
            criteria.andKIdEqualTo(kId);
            List<GKind> gKinds = gKindMapper.selectByExample(example);
            GKind gKind = gKinds.get(0);
            if(gKind.getkIsparent() == 1){
                gArticleCustom.setKindText(gKind.getkText());
            }else{
                GKindExample example1 = new GKindExample();
                GKindExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andKIdEqualTo(gKind.getkParent());
                List<GKind> gKinds1 = gKindMapper.selectByExample(example1);
                String parent = gKinds1.get(0).getkText();
                String kind = parent +"/"+gKind.getkText();
                gArticleCustom.setKindText(kind);
            }
        }

        return new PageResult(list.getTotal(),result);
    }

    @Override
    public Result findHot() {
        return new Result(true,"查找成功",gArticleMapperCustom.findHot());
    }

    @Override
    public Result findDesc(long aId) {

        GArticle gArticle = gArticleMapper.selectByPrimaryKey(aId);
        gArticle.setaView(gArticle.getaView()+1);
        gArticleMapper.updateByPrimaryKey(gArticle);

        GArticleCustom gArticleCustom = gArticleMapperCustom.finDesc(aId);



        Long aLong = gArticleCustom.getkId();
        GKindExample example = new GKindExample();
        GKindExample.Criteria criteria = example.createCriteria();
        criteria.andKIdEqualTo(aLong);
        List<GKind> gKinds = gKindMapper.selectByExample(example);
        GKind gKind = gKinds.get(0);

        if(gKind.getkIsparent() == 1){
            //是父分类直接设置
            gArticleCustom.setKindText(gKind.getkText());
            //将表里点击次数加1
            GClickCountExample exa = new GClickCountExample();
            GClickCountExample.Criteria criteria1 = exa.createCriteria();
            criteria1.andKIdEqualTo(gKind.getkId());
            List<GClickCount> gClickCounts = gClickCountMapper.selectByExample(exa);
            GClickCount gClickCount1 = gClickCounts.get(0);
            gClickCount1.setcNum(gClickCount1.getcNum()+1);
            gClickCountMapper.updateByExample(gClickCount1,exa);
        }else{
            //是子分类，根据父分类Id找出父分类
            GKindExample ex = new GKindExample();
            GKindExample.Criteria criteria1 = ex.createCriteria();
            criteria1.andKIdEqualTo(gKind.getkParent());
            List<GKind> gKinds1 = gKindMapper.selectByExample(ex);
            GKind gKind1 = gKinds1.get(0);
            String kind = gKind1.getkText() +"/"+ gKind.getkText();
            gArticleCustom.setKindText(kind);

            //将表里点击次数加1
            GClickCountExample exa = new GClickCountExample();
            GClickCountExample.Criteria criteria2 = exa.createCriteria();
            criteria2.andKIdEqualTo(gKind1.getkId());
            List<GClickCount> gClickCounts = gClickCountMapper.selectByExample(exa);
            GClickCount gClickCount1 = gClickCounts.get(0);
            gClickCount1.setcNum(gClickCount1.getcNum()+1);
            gClickCountMapper.updateByExample(gClickCount1,exa);

        }


        return new Result(true,"查找成功",gArticleCustom);
    }


    @Override
    public Page<GArticleCustom> findALl(int page,int rows) {
        PageHelper.startPage(page,rows);

        Page<GArticleCustom> allArticles = (Page<GArticleCustom>) gArticleMapperCustom.findAllArticles();

        return allArticles;
    }

    @Override
    public Result del(long id) {

        gArticleMapper.deleteByPrimaryKey(id);

        GUserArticleExample example = new GUserArticleExample();
        GUserArticleExample.Criteria criteria = example.createCriteria();
        criteria.andAIdEqualTo(id);
        gUserArticleMapper.deleteByExample(example);

        return new Result(true,"删除成功！");
    }
}
