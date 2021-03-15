package com.easylife.dao;

import com.easylife.pojo.Ad;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2020.12.9
 * hua
 */

public interface AdMapper extends MyMapper<Ad> {

    List<Ad> selectList();
    List<Ad> selectAdByType(@Param("type") Integer type);
}