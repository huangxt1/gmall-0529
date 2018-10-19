package com.atguigu.gmall.manager.mapper.spu;

import com.atguigu.gmall.spu.SpuSaleAttr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface SpuSaleAttrMapper extends BaseMapper<SpuSaleAttr> {

    List<SpuSaleAttr> getSpuSaleAttrBySpuId(Integer spuId);
}
