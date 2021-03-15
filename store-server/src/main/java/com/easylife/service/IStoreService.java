package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.Store;
import com.easylife.vo.StoreDetailVo;

import java.util.List;

/**
 * Created by geely
 */
public interface IStoreService {

    ServerResponse addStore(String storeName, Integer id);
    ServerResponse updatestoreName(Integer id, String storeName);

    ServerResponse<List<Store>> selectStoreById(Integer id);
    ServerResponse<List<Store>> selectStoreByType(Integer type);

    /*通过店铺name查询商铺
     * hyy*/
    ServerResponse<List<Store>> selectStoreByName(String name);

   // ServerResponse<List<Integer>>  selectStoreById(Integer id);

    ServerResponse<List<Store>> getStoreList();

    ServerResponse<StoreDetailVo> getStoreDetail(Integer id);
    ServerResponse<List<Store>> selectStoreByCommunityId(Integer community_id);
}
