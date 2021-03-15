package com.easylife.controller.portal;

import com.easylife.common.ResponseCode;
import com.easylife.common.ServerResponse;
import com.easylife.pojo.Community;
import com.easylife.pojo.CommunityIdle;
import com.easylife.pojo.User;
import com.easylife.service.ICommunityService;
import com.easylife.util.JsonUtil;
import com.easylife.util.RedisShardedPoolUtil;
import com.easylife.util.TokenUtil;
import com.easylife.vo.SecondHandCommunityVo.IdleAndUserVo;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/community/")
public class CommunityController {


    @Autowired
    private ICommunityService iCommunityService;

    @RequestMapping("communityDetails.do")
    @ResponseBody
    public ServerResponse<List<Community>> getList() {
        return iCommunityService.getCommunityList();
    }

    @RequestMapping("idleList.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "user_id", required = false) Integer user_id,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "30") int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iCommunityService.getIdleByKeywordUserId(keyword, user_id, pageNum, pageSize, orderBy);
    }

    @RequestMapping("byCategoryId.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "category", required = false) Integer category,
                                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iCommunityService.selectByCategoryId(category, pageNum, pageSize, orderBy);
    }

    @RequestMapping("idleAndUserDetail.do")
    @ResponseBody
    public ServerResponse<IdleAndUserVo> list(@RequestParam(value = "userId", required = false) Integer userId,
                                              @RequestParam(value = "idleId", required = false) Integer idleId) {
        return iCommunityService.selectByIdleAndUserId(userId, idleId);
    }

    //从前台写入照片等数据进入数据库，对应用户发布二手社区的闲置物品功能，以json数据进行传输
    @RequestMapping("releaseJson.do")
    @ResponseBody
    public ServerResponse<String> releasePhoto(@RequestParam(value = "communityIdle", required = false) String communityIdleTest) {
        JSONObject jsonObject = JSONObject.fromObject(communityIdleTest);
        CommunityIdle communityIdle = (CommunityIdle) JSONObject.toBean(jsonObject, CommunityIdle.class);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + communityIdle);
        return iCommunityService.insertCommunityIdle(communityIdle);
    }

    @RequestMapping("selectIdleByName.do")
    @ResponseBody
    public ServerResponse selectIdleByName(
            @RequestParam(value = "idleName", required = false) String name) {
        return iCommunityService.selectIdleByName(name);
    }

    //添加收藏
    @RequestMapping("favoritesAdd.do")
    @ResponseBody
    public ServerResponse favoritesAdd(HttpServletRequest httpServletRequest,
                                       @RequestParam(value = "idleId", required = false) Integer idleId) {
        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        User user = JsonUtil.string2Obj(RedisShardedPoolUtil.get(loginToken), User.class);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCommunityService.favoritesAdd(user.getId(), idleId);
    }

    //取消收藏
    @RequestMapping("deleteFavorites.do")
    @ResponseBody
    public ServerResponse deleteFavorites(HttpServletRequest httpServletRequest,
                                          @RequestParam(value = "idleId", required = false) Integer idleId) {
        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        User user = JsonUtil.string2Obj(RedisShardedPoolUtil.get(loginToken), User.class);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCommunityService.deleteFavorites(user.getId(), idleId);
    }

    //收藏夹展示
    @RequestMapping("selectUserFavorites.do")
    @ResponseBody
    public ServerResponse<PageInfo> selectUserFavorites(HttpServletRequest httpServletRequest,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "30") int pageSize,
                                                        @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        User user = JsonUtil.string2Obj(RedisShardedPoolUtil.get(loginToken), User.class);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCommunityService.selectUserFavorites(user.getId(), pageNum, pageSize, orderBy);
    }
}
