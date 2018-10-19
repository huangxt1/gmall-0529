package com.atguigu.gmall.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.manager.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/basecatalog")
@RestController
public class BaseCatalogRestController {

    @Reference
    CatalogService catalogService;

    @Reference
    BaseAttrInfoService baseAttrInfoService;


    /**
     * 查询三级分类下的所有属性
     * @param id  三级分类id
     * @return
     */
    @RequestMapping("/attrs.json")
    public List<BaseAttrInfo> getBaseAttrInfos(Integer id){

        return baseAttrInfoService.getBaseAttrInfoByCatalog3Id(id);
    }

        @RequestMapping("/1/list.json")
    public List<BaseCatalog1> listBaseCatalog1(){
        List<BaseCatalog1> allBaseCatalog1 = catalogService.getAllBaseCatalog1();
        return allBaseCatalog1;
    }

    @RequestMapping("/2/list.json")
    public List<BaseCatalog2> listBaseCatalog2(Integer id){
        return catalogService.getBaseCatalog2ByC1id(id);
    }

    @RequestMapping("/3/list.json")
    public List<BaseCatalog3> listBaseCatalog3(Integer id){
        return catalogService.getBaseCatalog3ByC2id(id);
    }

}
