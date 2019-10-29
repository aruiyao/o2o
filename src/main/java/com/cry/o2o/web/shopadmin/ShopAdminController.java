/**
 * @ClassName:     ShopAdminController.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * 
 * @author CRY 
 * @Date 2019-09-22
 */
package com.cry.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 主要用来解析路由并转发到相应的html中
 * @author CRY
 * @since 2019-09-22
 */

@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET })
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation() {
        // 转发至店铺注册/编辑页面
        return "shop/shopOperation";
    }
}
