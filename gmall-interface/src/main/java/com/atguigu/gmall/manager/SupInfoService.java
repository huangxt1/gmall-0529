package com.atguigu.gmall.manager;

import com.atguigu.gmall.spu.BaseSaleAttr;
import com.atguigu.gmall.spu.SpuImage;
import com.atguigu.gmall.spu.SpuInfo;

import java.util.List;

public interface SupInfoService {
    List<SpuInfo> getSpuInfoByC3Id(Integer catalog3Id);

    List<BaseSaleAttr> getBaseSaleAttr();

    void saveBigSpuInfo(SpuInfo spuInfo);

    List<SpuImage> getSpuImage(Integer spuId);
}
