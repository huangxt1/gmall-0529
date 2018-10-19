package com.atguigu.gmall.manager.mapper;

import com.atguigu.gmall.manager.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

//根据三级分类id查出平台属性名和值
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {
    List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(Integer catalog3Id);
}
