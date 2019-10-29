package com.cry.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cry.o2o.entity.Shop;

/**
 * 
 * @author CRY
 * @since 2019-08-10
 */
public interface ShopDao {

    /** 
     * 分页查询店铺，可输入的条件有：店铺名(模糊)，店铺状态，店铺类别，区域Id，owner
     * 
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 返回的条数
     * @return
     * @author CRY
     * @since 2019-08-11
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
            @Param("pageSize") int pageSize);

    /** 
     * 返回queryShopList总数
     * @param shopCondition
     * @return
     * @author CRY
     * @since 2019-08-11
     */
    int queryShopCount(@Param("shopCondition") Shop shopCondition);

    /** 
     * 通过shop id 查询店铺
     * 
     * @param shopId
     * @return
     * @author CRY
     * @since 2019-08-11
     */
    Shop queryByShopId(long shopId);

    /** 
     * 新增店铺
     * 
     * @param shop
     * @return
     * @author CRY
     * @since 2019-08-11
     */
    int insertShop(Shop shop);

    /** 
     * 更新店铺信息
     * 
     * @param shop
     * @return
     * @author CRY
     * @since 2019-08-11
     */
    int updateShop(Shop shop);
}
