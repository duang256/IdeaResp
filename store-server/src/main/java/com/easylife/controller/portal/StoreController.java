package com.easylife.controller.portal;

import com.easylife.common.ServerResponse;
import com.easylife.pojo.Store;
import com.easylife.service.IStoreService;
import com.easylife.vo.StoreDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 2020.12.9
 * hua
 */
@Controller
@RequestMapping("/store/")
public class StoreController {

    @Autowired
    private IStoreService iStoreService;


    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<List<Store>> getList(){
        return iStoreService.getStoreList();

    }

    @RequestMapping("byid.do")
    @ResponseBody
    public ServerResponse <List<Store>> getselectStoreById(
            @RequestParam(value = "id" ,required = false) Integer id){

        return iStoreService.selectStoreById(id);

    }

    @RequestMapping("bytype.do")
    @ResponseBody
    public ServerResponse getselectStoreByType(
            @RequestParam(value = "type" ,required = false) Integer type){

        return iStoreService.selectStoreByType(type);

    }

    /*通过店铺name查询商铺
     * hyy*/
    @RequestMapping("selectStoreByName.do")
    @ResponseBody
    public ServerResponse selectStoreByName(
            @RequestParam(value = "name" ,required = false) String name){

        return iStoreService.selectStoreByName(name);
    }

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<StoreDetailVo> detail(Integer id){

        return iStoreService.getStoreDetail(id);
    }
    @RequestMapping("bycommunityid.do")
    @ResponseBody
    public ServerResponse <List<Store>> getSelectStoreByCommunityId(
            @RequestParam(value = "community_id" ,required = false) Integer community_id){

        return iStoreService.selectStoreByCommunityId(community_id);
    }
}
