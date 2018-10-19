package com.atguigu.gmall.manager.mapper.sku;

import com.atguigu.gmall.sku.SkuAllSaveAttrAndValueTo;
import com.atguigu.gmall.sku.SkuImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuImageMapper extends BaseMapper<SkuImage> {

    List<SkuAllSaveAttrAndValueTo> getSkuAllSaveAttrAndValue(@Param("spuId") Integer spuId,@Param("id") Integer id);
}
