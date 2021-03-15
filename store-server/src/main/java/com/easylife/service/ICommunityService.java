package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.Community;
import com.easylife.pojo.CommunityIdle;
import com.easylife.vo.SecondHandCommunityVo.IdleAndUserVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by zf
 */
public interface ICommunityService {

    ServerResponse<List<Community>> getCommunityList();

    ServerResponse<PageInfo> getIdleByKeywordUserId(String keyword, Integer user_id, int pageNum, int pageSize, String orderBy);

    ServerResponse<PageInfo> selectByCategoryId(Integer category, int pageNum, int pageSize, String orderBy);

    ServerResponse<IdleAndUserVo> selectByIdleAndUserId(int userId, int idleId);

    ServerResponse<String> insertCommunityIdle(CommunityIdle communityIdle);

    /*通过店铺name查询商铺
     * zf*/
    ServerResponse<List<CommunityIdle>> selectIdleByName(String name);

    //添加收藏
    ServerResponse<String> favoritesAdd(Integer userId, Integer idleId);

    //取消收藏
    ServerResponse<String> deleteFavorites(Integer userId, Integer idleId);

    //用户个人收藏夹加载
    ServerResponse<PageInfo> selectUserFavorites(Integer user_id, int pageNum, int pageSize, String orderBy);


}
