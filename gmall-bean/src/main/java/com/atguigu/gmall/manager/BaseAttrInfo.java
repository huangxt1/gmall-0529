package com.atguigu.gmall.manager;

import com.atguigu.gmall.SuperBean;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * 平台属性名信息
 */
@Data
public class BaseAttrInfo extends SuperBean {


    private String attrName;

    private Integer catalog3Id;

    //临时保存字段，不是数据库的字段(exist数据库并不在此字段)
    @TableField(exist = false)
    private List<BaseAttrValue> attrValues;



}
