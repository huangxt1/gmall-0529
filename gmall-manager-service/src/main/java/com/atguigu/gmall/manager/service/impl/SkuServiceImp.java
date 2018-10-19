package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.manager.BaseAttrInfo;
import com.atguigu.gmall.manager.SkuService;
import com.atguigu.gmall.manager.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.manager.mapper.sku.SkuAttrValueMapper;
import com.atguigu.gmall.manager.mapper.sku.SkuImageMapper;
import com.atguigu.gmall.manager.mapper.sku.SkuInfoMapper;
import com.atguigu.gmall.manager.mapper.sku.SkuSaleAttrValueMapper;
import com.atguigu.gmall.manager.mapper.spu.SpuSaleAttrMapper;
import com.atguigu.gmall.sku.*;
import com.atguigu.gmall.spu.SpuInfo;
import com.atguigu.gmall.spu.SpuSaleAttr;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkuServiceImp implements SkuService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;

    @Autowired
    SkuInfoMapper skuInfoMapper;

    @Autowired
    SkuImageMapper skuImageMapper;

    @Autowired
    SkuAttrValueMapper skuAttrValueMapper;

    @Autowired
    SkuSaleAttrValueMapper skuSaleAttrValueMapper;
    @Override
    public List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(Integer catalog3Id) {
        return baseAttrInfoMapper.getBaseAttrInfoByCatalog3Id(catalog3Id);
    }

    @Override
    public List<SpuSaleAttr> getSpuSaleAttrBySpuId(Integer spuId) {
        return spuSaleAttrMapper.getSpuSaleAttrBySpuId(spuId);
    }



    @Transactional
    public void saveskuBigSave(SkuInfo skuInfo) {

        //1.保存sku信息
        skuInfoMapper.insert(skuInfo);

        //2.保存sku图片
        List<SkuImage> skuImages=skuInfo.getSkuImages();
        for (SkuImage skuImage : skuImages) {
            skuImage.setSkuId(skuInfo.getId());
            skuImageMapper.insert(skuImage);

        }

        //3.保存sku平台属性
        List<SkuAttrValue> skuAttrValues=skuInfo.getSkuAttrValues();
        for (SkuAttrValue skuAttrValue : skuAttrValues) {
            skuAttrValue.setSkuId(skuInfo.getId());
            skuAttrValueMapper.insert(skuAttrValue);
        }

        //4.保存sku销售属性
        List<SkuSaleAttrValue> skuSaleAttrValues = skuInfo.getSkuSaleAttrValues();
        for (SkuSaleAttrValue skuSaleAttrValue : skuSaleAttrValues) {
            skuSaleAttrValue.setId(skuInfo.getId());
            skuSaleAttrValueMapper.insert(skuSaleAttrValue);
        }

    }

    @Override
    public List<SkuInfo> getSkuInfoBySpuId(Integer spuId) {
        return skuInfoMapper.selectList(new QueryWrapper<SkuInfo>().eq("spu_id",spuId));
    }

    public SkuInfo getSkuInfoBySkuId(Integer skuId) {
        //1.查出sku的基本信息
        SkuInfo skuInfo = skuInfoMapper.selectById(skuId);
        //2.查出sku的图片信息
        List<SkuImage> skuImages = skuImageMapper.selectList(new QueryWrapper<SkuImage>().eq("sku_id", skuInfo.getId()));
        skuInfo.setSkuImages(skuImages);
        //3,查出skuAttrValue信息
        List<SkuAllSaveAttrAndValueTo> skuAllSaveAttrAndValueTos=skuImageMapper.getSkuAllSaveAttrAndValue(skuInfo.getSpuId(),skuInfo.getId());
        skuInfo.setSkuAllSaveAttrAndValueTos(skuAllSaveAttrAndValueTos);
        return skuInfo;
    }
}
