package com.cry.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cry.o2o.BaseTest;
import com.cry.o2o.dto.ShopExecution;
import com.cry.o2o.entity.Area;
import com.cry.o2o.entity.PersonInfo;
import com.cry.o2o.entity.Shop;
import com.cry.o2o.entity.ShopCategory;
import com.cry.o2o.enums.ShopStateEnum;
import com.cry.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺2");
        shop.setShopDesc("test2");
        shop.setShopAddr("test2");
        shop.setPhone("test2");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("D:/bishePic/1_1.jpg");
        InputStream ins = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, ins, shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }

}
