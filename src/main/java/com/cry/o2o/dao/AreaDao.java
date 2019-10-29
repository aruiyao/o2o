/**
 * 
 */
package com.cry.o2o.dao;

import java.util.List;

import com.cry.o2o.entity.Area;

/**
 * @author CRY
 *
 */
public interface AreaDao {
    /**   
     * 查询区域列表
     * 
     * @return 区域集合
     */
    List<Area> queryArea();
}
