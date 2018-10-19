package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.BaseAttrInfo;
import com.atguigu.gmall.manager.BaseAttrInfoService;
import com.atguigu.gmall.manager.BaseAttrValue;
import com.atguigu.gmall.manager.vo.BaseAttrValueVO;
import com.atguigu.gmall.manager.vo.BaseAttrlnfoAndValueVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/attr")
@Controller
public class AttrManageController {

        @Reference
        BaseAttrInfoService baseAttrInfoService;

        /*
        RequestBody:自定义获取对象
        * */
        @ResponseBody
        @RequestMapping("/updaes")
        public String saveOrUpdateOrDeleteAttrInfoAndValue(@RequestBody BaseAttrlnfoAndValueVO baseAttrlnfoAndValueVO) {
                //判断是修改还是添加
                if(baseAttrlnfoAndValueVO.getId()!=null){
                        //就是修改
                        //修改这个属性所有的值
                        //修改这个属性对应的值
                        BaseAttrInfo baseAttrInfo=new BaseAttrInfo();
                        //把vo中的所有属性复制到bean
                        BeanUtils.copyProperties(baseAttrlnfoAndValueVO,baseAttrInfo);
                        List<BaseAttrValue> values=new ArrayList<>();
                        //遍历页面上的数据vo
                        for (BaseAttrValueVO baseAttrValueVO : baseAttrlnfoAndValueVO.getAttrValues()) {
                                //将这个vo里面的数据封装到baseAttrValueVO这个对象
                                BaseAttrValue baseAttrValue=  new BaseAttrValue();
                                BeanUtils.copyProperties(baseAttrValueVO,baseAttrValue);
                                values.add(baseAttrValue);
                        }
                        //将复制好的list设置在attrInfo中
                        baseAttrInfo.setAttrValues(values);

                        baseAttrInfoService.saveOrUpdateBaseInfo(baseAttrInfo);
                        return "";
                }else{
                        //就是添加
                }


                return "true";
        }

        @ResponseBody
        @RequestMapping("/value/{id}")
        public List<BaseAttrValue> getBeaseAttrValueByAttrId(@PathVariable("id") Integer id){
            return baseAttrInfoService.getBaseAttrValueByAttrId(id);
        }

        @RequestMapping("/listPage.html")
        public String getAttrListPage(){
            return "attr/attrListPage";
        }

 }
