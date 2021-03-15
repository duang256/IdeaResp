package com.easylife.dao.SecondHandCommunityDao;

import com.easylife.pojo.Favorites;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoritesMapper extends MyMapper<Favorites> {

    Favorites selectFavoritesByUserIdAndIdleId(@Param("user_id") Integer user_id, @Param("idle_id") Integer idle_id);

    int deleteByUserIdAndIdleId(@Param("user_id") Integer user_id, @Param("idle_id") Integer idle_id);

    List<Favorites> selectFavoritesByUserId(@Param("user_id") Integer user_id);

}