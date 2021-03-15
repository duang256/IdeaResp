package com.easylife.dao.SecondHandCommunityDao;

import com.easylife.pojo.CommunityIdle;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommunityIdleMapper extends MyMapper<CommunityIdle> {
    List<CommunityIdle> selectList();

    List<CommunityIdle> selectByNameAndIdleId(@Param("name") String name, @Param("id") Integer id);

    List<CommunityIdle> selectByUserId(Integer user_id);

    CommunityIdle selectById(@Param("id") Integer id);

    List<CommunityIdle> selectByCategoryId(Integer category);

    List<CommunityIdle> selectIdleByName(@Param("name") String name);

}
