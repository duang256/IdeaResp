package com.easylife.service.impl;

import com.easylife.common.ResponseCode;
import com.easylife.common.ServerResponse;
import com.easylife.dao.SecondHandCommunityDao.CommunityIdleMapper;
import com.easylife.dao.SecondHandCommunityDao.CommunityMapper;
import com.easylife.dao.SecondHandCommunityDao.FavoritesMapper;
import com.easylife.dao.UserMapper;
import com.easylife.pojo.Community;
import com.easylife.pojo.CommunityIdle;
import com.easylife.pojo.Favorites;
import com.easylife.pojo.User;
import com.easylife.service.ICommunityService;
import com.easylife.util.PropertiesUtil;
import com.easylife.vo.SecondHandCommunityVo.IdleAndUserVo;
import com.easylife.vo.SecondHandCommunityVo.IdleListVo;
import com.easylife.vo.SecondHandCommunityVo.IdleUserBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iCommunityService")
@Slf4j
public class CommunityServiceImpl implements ICommunityService {
    @Autowired
    private CommunityMapper communityMapper;
    @Autowired
    private CommunityIdleMapper communityIdleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FavoritesMapper favoritesMapper;

    @Override
    public ServerResponse<List<Community>> getCommunityList() {
        List<Community> communityList = communityMapper.selectAll();
        return ServerResponse.createBySuccess(communityList);
    }

    @Override
    public ServerResponse<PageInfo> getIdleByKeywordUserId(String keyword, Integer user_id, int pageNum, int pageSize, String orderBy) {
        if (StringUtils.isBlank(keyword) && user_id == null) {
            //没参数，查全部
            PageHelper.startPage(pageNum, pageSize);
            List<CommunityIdle> communityIdleList = communityIdleMapper.selectAll();
            List<IdleListVo> idleListVoList = Lists.newArrayList();
            for (CommunityIdle communityIdle : communityIdleList) {
                IdleListVo idleListVo = assembleIdleListVo(communityIdle);
                idleListVoList.add(idleListVo);
            }
            PageInfo pageResult = new PageInfo(communityIdleList);
            pageResult.setList(idleListVoList);
            return ServerResponse.createBySuccess(pageResult);
        }
        if (user_id != null) {
            List<CommunityIdle> communityIdles = communityIdleMapper.selectByUserId(user_id);
            PageHelper.startPage(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(communityIdles);
            return ServerResponse.createBySuccess(pageInfo);
        } else {
            return searchIdle(keyword, null, pageNum, pageSize);
        }

    }

    @Override
    public ServerResponse<PageInfo> selectByCategoryId(Integer category, int pageNum, int pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize);
        List<CommunityIdle> communityIdleCategory = communityIdleMapper.selectByCategoryId(category);
        PageInfo pageInfo = new PageInfo(communityIdleCategory);
        return ServerResponse.createBySuccess(pageInfo);
    }

    @Override
    public ServerResponse<IdleAndUserVo> selectByIdleAndUserId(int userId, int idleId) {
        CommunityIdle communityIdle = communityIdleMapper.selectById(idleId);
        User user = userMapper.selectByPrimaryKey(userId);
        IdleUserBean idleUserBean = assembleIdleUserVo(user);
        IdleAndUserVo idleAndUserVo = new IdleAndUserVo();
        idleAndUserVo.setCommunityIdle(communityIdle);
        idleAndUserVo.setIdleUserBean(idleUserBean);
        return ServerResponse.createBySuccess(idleAndUserVo);
    }

    @Override
    public ServerResponse<String> insertCommunityIdle(CommunityIdle communityIdle) {
        int resultCount = communityIdleMapper.insert(communityIdle);

        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("发布失败！");
        }
        return ServerResponse.createBySuccessMessage("发布成功！");
    }

    @Override
    public ServerResponse<List<CommunityIdle>> selectIdleByName(String name) {
        List<CommunityIdle> communityIdleList = communityIdleMapper.selectIdleByName(name);
        if (CollectionUtils.isEmpty(communityIdleList)) {
            log.info("未查询到店铺数据");
        }
        return ServerResponse.createBySuccess(communityIdleList);
    }

    @Override
    public ServerResponse favoritesAdd(Integer userId, Integer idleId) {
        if (idleId == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Favorites favorites = favoritesMapper.selectFavoritesByUserIdAndIdleId(userId, idleId);
        if (favorites == null) {
            Favorites favoritesItem = new Favorites();
            favoritesItem.setUser_id(userId);
            favoritesItem.setIdle_id(idleId);
            favoritesMapper.insert(favoritesItem);
            return ServerResponse.createBySuccessMessage("已添加到收藏夹!");
        } else {
            return ServerResponse.createBySuccessMessage("收藏夹中已存在!");
        }
    }

    @Override
    public ServerResponse deleteFavorites(Integer userId, Integer idleId) {
        int resultCount = favoritesMapper.deleteByUserIdAndIdleId(userId, idleId);
        if (resultCount > 0) {
            return ServerResponse.createBySuccess("取消收藏成功！");
        }
        return ServerResponse.createBySuccess("取消收藏失败！");
    }

    @Override
    public ServerResponse<PageInfo> selectUserFavorites(Integer user_id, int pageNum, int pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize);
        List<Favorites> favoritesList = favoritesMapper.selectFavoritesByUserId(user_id);
        List<CommunityIdle> communityIdles = Lists.newArrayList();

        if (favoritesList == null) {
            //如果为空，返回空数据
            return ServerResponse.createByError();
        }
        for (Favorites favorites : favoritesList) {
            CommunityIdle communityIdleList = communityIdleMapper.selectById(favorites.getIdle_id());
            communityIdles.add(communityIdleList);
        }
        PageInfo pageInfo = new PageInfo(communityIdles);
        return ServerResponse.createBySuccess(pageInfo);
    }

    private IdleUserBean assembleIdleUserVo(User user) {
        //只需要用户信息的一部分，所以单独为user创建一个IdleUserVo装部分信息
        IdleUserBean idleUser = new IdleUserBean();
        idleUser.setId(user.getId());
        idleUser.setPhone(user.getPhone());
        idleUser.setUsername(user.getUsername());
        idleUser.setPhoto(user.getPhoto());
        idleUser.setYidou(user.getYidou());
        return idleUser;
    }

    private IdleListVo assembleIdleListVo(CommunityIdle communityIdle) {
        IdleListVo idleListVo = new IdleListVo();
        idleListVo.setId(communityIdle.getId());
        idleListVo.setName(communityIdle.getName());
        idleListVo.setUser_id(communityIdle.getUser_id());
        idleListVo.setStarting_price(communityIdle.getStarting_price());
        idleListVo.setPrice(communityIdle.getPrice());
        idleListVo.setMain_img(communityIdle.getMain_img());
        //这公司云端图片地址吗？先用地址代替
        idleListVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.happymmall.com/"));
        return idleListVo;
    }

    //根据闲置物品名字，进行模糊查询
    public ServerResponse<PageInfo> searchIdle(String name, Integer id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(name)) {
            name = new StringBuilder().append("%").append(name).append("%").toString();
        }
        List<CommunityIdle> communityIdleList = communityIdleMapper.selectByNameAndIdleId(name, id);
        List<IdleListVo> idleListVoList = Lists.newArrayList();
        for (CommunityIdle communityIdle : communityIdleList) {
            IdleListVo idleListVo = assembleIdleListVo(communityIdle);
            idleListVoList.add(idleListVo);
        }
        PageInfo pageResult = new PageInfo(communityIdleList);
        pageResult.setList(idleListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

}
