package com.atguigu.gmall.manager.vo;

import lombok.Data;

import java.util.List;

@Data
public class BaseAttrlnfoAndValueVO {
    private  Integer id;
    private  String attrName;
    private List<BaseAttrValueVO> attrValues;

}
