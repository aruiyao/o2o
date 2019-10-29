package com.cry.o2o.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cry.o2o.entity.ShopCategory;

@Service
public interface ShopCategoryService {
    /** 
     * 根据查询条件获取ShopCategory列表 
     * @param shopCategoryCondition
     * @return
     * @author CRY
     * @since 2019-09-23
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
