package com.atguigu.gmall.spu;

import com.atguigu.gmall.SuperBean;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * Spu信息
 */
@Data
public class SpuInfo extends SuperBean {
    //spu_name  description  catalog3_id   tm_id
    private String spuName;//商品名字
    private String description;//描述
    private Integer catalog3Id;//三级分类id
    private Integer tmId; //品牌id

    //spu图片
    @TableField(exist = false)
    private List<SpuImage> spuImages;

    //spu的所有销售属性，以及所有的值
    @TableField(exist = false)
    private  List<SpuSaleAttr> spuSaleAttrs;

}
