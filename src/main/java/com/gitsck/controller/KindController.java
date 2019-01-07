package com.gitsck.controller;

import com.gitsck.entity.PageResult;
import com.gitsck.entity.Result;
import com.gitsck.pojo.GKind;
import com.gitsck.service.KindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kind")
public class KindController {

    @Autowired
    private KindService kindService;

    @RequestMapping(value = "/findparent",method = RequestMethod.GET)
    public PageResult findAllParentKinds(int page,int rows,long pId){
        return  kindService.findAllParentKinds(page,rows,pId);
    }

    @RequestMapping(value = "/addkind",method = RequestMethod.POST)
    public Result addKind(@RequestBody GKind gKind,long pId){
        return kindService.addKind(gKind,pId);
    }

    @RequestMapping(value = "/po/findbyparent",method = RequestMethod.GET)
    public Result findByParentId(long pId){
        return kindService.findByParentId(pId);
    }

    @RequestMapping(value = "/findall",method = RequestMethod.GET)
    public Result findallchildbyparentId(){return kindService.findall();}
}
