package com.gitsck.controller;

import com.gitsck.entity.PVEntity;
import com.gitsck.entity.Result;
import com.gitsck.service.StaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/count")
public class StatisticsController {

    @Autowired
    private StaService staService;


    @RequestMapping("/pv")
    public PVEntity getPVData(){
        return staService.findPVData();
    }

    @RequestMapping("/kindclick")
    public Result findKindClickData(){
        return new Result(true,"获取成功",staService.findKindClickData());
    }

    @RequestMapping("/articlepro")
    public Result findArticleProPieData(){
        return new Result(true,"获取成功",staService.findArticleProData());
    }

    @RequestMapping("/basedata")
    public Result findBaseData(){
        return new Result(true,"获取成功",staService.findBaseData());
    }
}
