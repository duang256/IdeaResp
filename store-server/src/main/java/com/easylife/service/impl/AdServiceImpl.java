package com.easylife.service.impl;

import com.easylife.common.ServerResponse;
import com.easylife.dao.AdMapper;
import com.easylife.pojo.Ad;
import com.easylife.service.IAdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by geely
 */
@Service("iAdService")
@Slf4j
public class AdServiceImpl implements IAdService {

    @Autowired
    private AdMapper adMapper;


    @Override
    public ServerResponse<List<Ad>> selectAdByType(Integer type) {
        List<Ad> adList = adMapper.selectAdByType(type);
//        if(CollectionUtils.isEmpty(storeList)){
//            log.info("未找到当前分类的子分类");
//        }
        return ServerResponse.createBySuccess(adList);
    }




    @Override
    public ServerResponse<List<Ad>> getAdList() {
        List<Ad> adList = adMapper.selectAll();
        return ServerResponse.createBySuccess(adList);
    }



}
