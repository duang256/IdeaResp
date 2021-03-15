package com.easylife.controller.portal;

import com.easylife.common.ServerResponse;
import com.easylife.pojo.Ad;
import com.easylife.service.IAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 2020.12.28
 * hua
 */
@Controller
@RequestMapping("/ad/")
public class AdController {

    @Autowired
    private IAdService iAdService;


    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<List<Ad>> getList(){
        return iAdService.getAdList();

    }

    @RequestMapping("by_type.do")
    @ResponseBody
    public ServerResponse getselectAdByType(
            @RequestParam(value = "type" ,required = false) Integer type){

        return iAdService.selectAdByType(type);

    }


}
