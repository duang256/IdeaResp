package com.easylife.controller.portal;


import com.easylife.common.ServerResponse;
import com.easylife.pojo.Recycle;
import com.easylife.service.IRecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/recycle/")
public class RecycleController {

    @Autowired
    private IRecycleService iRecycleService;

    @RequestMapping("Selectall.do")
    @ResponseBody
    public ServerResponse<List<Recycle>> SelectAll(){
        return iRecycleService.SelectAll();
    }

    @RequestMapping("Selectbyid.do")
    @ResponseBody
    public ServerResponse Selectbyid(int id){
        return iRecycleService.Selectbyid(id);
    }

}
