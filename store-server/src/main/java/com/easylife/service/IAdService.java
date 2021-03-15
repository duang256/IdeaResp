package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.Ad;


import java.util.List;

/**
 * Created by geely
 */
public interface IAdService {
    ServerResponse<List<Ad>> selectAdByType(Integer type);
    ServerResponse<List<Ad>> getAdList();

}
