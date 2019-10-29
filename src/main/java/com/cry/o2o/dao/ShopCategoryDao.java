package com.cry.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cry.o2o.entity.ShopCategory;

public interface ShopCategoryDao {
    /** 
     * 根据传入的查询条件返回店铺类别列表
     * @param shopCategoryCondition
     * @return
     * @author CRY
     * @since 2019-09-23
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
