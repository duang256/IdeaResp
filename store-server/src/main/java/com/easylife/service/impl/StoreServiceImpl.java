package com.easylife.service.impl;

import com.easylife.common.ResponseCode;
import com.easylife.common.ServerResponse;
import com.easylife.common.enums.StoreStatusEnum;
import com.easylife.dao.StoreMapper;
import com.easylife.pojo.Store;
import com.easylife.service.IStoreService;
import com.easylife.util.PropertiesUtil;
import com.easylife.vo.StoreDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by geely
 */
@Service("iStoreService")
@Slf4j
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;


    @Override
    public ServerResponse addStore(String storeName, Integer id) {
        return null;
    }

    @Override
    public ServerResponse updatestoreName(Integer id, String storeName) {
        return null;
    }

    @Override
    public ServerResponse<List<Store>> selectStoreById(Integer id) {
        List<Store> storeList = storeMapper.selectStoreById(id);
//        if(CollectionUtils.isEmpty(storeList)){
//            log.info("未找到当前分类的子分类");
//        }
        return ServerResponse.createBySuccess(storeList);
    }

    @Override
    public ServerResponse<List<Store>> selectStoreByType(Integer type) {
        List<Store> storeList = storeMapper.selectStoreByType(type);
//        if(CollectionUtils.isEmpty(storeList)){
//            log.info("未找到当前分类的子分类");
//        }
        return ServerResponse.createBySuccess(storeList);
    }

//hyy
    @Override
    public ServerResponse<List<Store>> selectStoreByName(String name){
        List<Store> storeList = storeMapper.selectStoreByName(name);
        if(CollectionUtils.isEmpty(storeList)){
            log.info("未查询到店铺数据");
        }
        return ServerResponse.createBySuccess(storeList);
    }


    @Override
    public ServerResponse<List<Store>> getStoreList() {
        List<Store> storeList = storeMapper.selectAll();
        return ServerResponse.createBySuccess(storeList);
    }

    @Override
    public ServerResponse<StoreDetailVo> getStoreDetail(Integer id) {
        if(id == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
       Store store = storeMapper.selectByPrimaryKey(id);
        if(store.getStatus() != StoreStatusEnum.ON_SALE.getCode()){
            return ServerResponse.createByErrorMessage("商铺已下架或者删除");
        }
       StoreDetailVo storeDetailVo = assembleStoreDetailVo(store);
        return ServerResponse.createBySuccess(storeDetailVo);
    }

    @Override
    public ServerResponse<List<Store>> selectStoreByCommunityId(Integer community_id) {
        List<Store> communityStoreList = storeMapper.selectStoreByCommunityId(community_id);
        return ServerResponse.createBySuccess(communityStoreList);
    }


    private StoreDetailVo assembleStoreDetailVo(Store store){
        StoreDetailVo storeDetailVo = new StoreDetailVo();
        storeDetailVo.setId(store.getId());
        storeDetailVo.setDetail(store.getDetail());
        storeDetailVo.setType(store.getType());
        storeDetailVo.setPlace(store.getPlace());
        storeDetailVo.setImage(store.getImage());
        storeDetailVo.setTel(store.getTel());
        storeDetailVo.setPost(store.getPost());
        storeDetailVo.setName(store.getName());
        storeDetailVo.setStatus(store.getStatus());
        storeDetailVo.setStime(store.getStime());
        storeDetailVo.setEtime(store.getEtime());
        storeDetailVo.setSelf(store.getSelf());
        storeDetailVo.setDelivery(store.getDelivery());
        storeDetailVo.setCommunity_id(store.getCommunity_id());

        storeDetailVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix","http://img.happymmall.com/"));

        return storeDetailVo;
    }



}
