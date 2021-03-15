package com.easylife.dao;

import com.easylife.pojo.Store;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2020.12.9
 * hua
 */

public interface StoreMapper extends MyMapper<Store> {

    List<Store> selectList();
    List<Store> selectStoreById(@Param("id")Integer id);
    List<Store> selectStoreByType(@Param("type")Integer type);
    List<Store> selectStoreByName(@Param("name")String name);
    List<Store> selectStoreByIds(@Param("storeIdList")List<Integer> storeIdList);
    List<Store> selectStoreByCommunityId(@Param("community_id")Integer community_id);
}