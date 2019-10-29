package com.cry.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cry.o2o.dao.ShopCategoryDao;
import com.cry.o2o.entity.ShopCategory;
import com.cry.o2o.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        List<ShopCategory> queryShopCategory = shopCategoryDao.queryShopCategory(shopCategoryCondition);
        return queryShopCategory;
    }

}
