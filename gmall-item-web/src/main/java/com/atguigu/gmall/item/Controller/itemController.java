package com.atguigu.gmall.item.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.SkuService;
import com.atguigu.gmall.sku.SkuInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class itemController {
        @Reference
        SkuService skuService;

   /* @RequestMapping("/{skuId}.html")
    public String itemPage(@PathVariable("skuId") Integer skuId,Model model){
        skuService.getSkuInfoBySkuId(skuId);
        return ;
    }*/
    @RequestMapping("/{skuId}.html")
    public String itemPage(@PathVariable("skuId") Integer skuId, Model model){
        //1、查出sku的详细信息

        SkuInfo skuInfo = skuService.getSkuInfoBySkuId(skuId);
        model.addAttribute("skuInfo",skuInfo);
        return "item";
    }

}
