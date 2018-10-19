package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.BaseAttrInfo;
import com.atguigu.gmall.manager.SkuService;
import com.atguigu.gmall.manager.SupInfoService;
import com.atguigu.gmall.sku.SkuInfo;
import com.atguigu.gmall.spu.SpuImage;
import com.atguigu.gmall.spu.SpuInfo;
import com.atguigu.gmall.spu.SpuSaleAttr;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sku")
public class SkuController {

    @Reference
    SkuService skuService;

    @Reference
    SupInfoService supInfoService;


    @RequestMapping("/skuinfo")
    public List<SkuInfo> getSkuInfoBySpuId(@RequestParam("id")Integer spuId){
        return skuService.getSkuInfoBySpuId(spuId);
    }

    //sku大保存
    @RequestMapping("/bigSave")
    public String skuBigSave(@RequestBody SkuInfo skuInfo){
        skuService.saveskuBigSave(skuInfo);
        return "ok";
    }


    //查询spu下所有图片
    @RequestMapping("/spuImgaes")
    public  List<SpuImage> getSpuImage(@RequestParam("id") Integer spuId){
        return  supInfoService.getSpuImage(spuId);
    }


    @RequestMapping("/base_attr_info.json")
    public List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(@RequestParam("id") Integer catalog3Id){

        return skuService.getBaseAttrInfoByCatalog3Id(catalog3Id);
    }

    /**
     * 查询spuId对应的所有可供选择的sku
     * @param spuId
     * @return
     */
    @RequestMapping("/spu_sale_attr.json")
    public List<SpuSaleAttr> getSpuSaleAttrBySpuId(@RequestParam("id") Integer spuId){
        return skuService.getSpuSaleAttrBySpuId(spuId);
    }

}
