package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.SupInfoService;
import com.atguigu.gmall.spu.BaseSaleAttr;
import com.atguigu.gmall.spu.SpuInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spu")
public class SpuManagerController {

    @Reference
    SupInfoService supInfoService;

    @ResponseBody
    @RequestMapping("/bigSave")
    public String saveAllApuInfos(@RequestBody SpuInfo spuInfo){
        supInfoService.saveBigSpuInfo(spuInfo);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("base_sale_attr")
    public List<BaseSaleAttr> getBaseSaleAttr(){
        return supInfoService.getBaseSaleAttr();
    }

    @ResponseBody
    @RequestMapping("/info.json")
    public List<SpuInfo> getSpuInfoByC3Id(@RequestParam("catalog3Id") Integer catalog3Id){
        return  supInfoService.getSpuInfoByC3Id(catalog3Id);
    }




    @RequestMapping("/listPage.html")
    public String spuListPage(){

        return "spu/spuListPage";
    }
}
