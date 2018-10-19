package com.atguigu.gmall.manager;

import com.atguigu.gmall.sku.SkuInfo;
import com.atguigu.gmall.spu.SpuInfo;
import com.atguigu.gmall.spu.SpuSaleAttr;

import java.util.List;

public interface SkuService {
    List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(Integer catalog3Id);

    List<SpuSaleAttr> getSpuSaleAttrBySpuId(Integer spuId);


    void saveskuBigSave(SkuInfo skuInfo);

    List<SkuInfo> getSkuInfoBySpuId(Integer spuId);

    SkuInfo getSkuInfoBySkuId(Integer skuId);
}
