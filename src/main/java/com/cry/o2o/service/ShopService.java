package com.cry.o2o.service;
/**
 * 
 * @author CRY
 * @since 2019-08-11
 */

import java.io.InputStream;

import com.cry.o2o.dto.ShopExecution;
import com.cry.o2o.entity.Shop;
import com.cry.o2o.exceptions.ShopOperationException;

public interface ShopService {
    /**
     * 根据shopCondition分页返回相应店铺列表
     * 
     * @param shopCondition
     * @param pageIndex
     * @param pageSize
     * @return
     * @author CRY
     * @since 2019-10-06
     */
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 通过店铺Id获取店铺信息
     * 
     * @param shopId
     * @return
     * @author CRY
     * @since 2019-10-06
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括对图片的处理
     * 
     * @param shop
     * @param shopImg
     * @return
     * @throws ShopOperationException
     * @author CRY
     * @since 2019-10-06
     */
    ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

    /** 
     *  注册店铺信息，包括图片处理
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     * @author CRY
     * @since 2019-10-06
     */
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
