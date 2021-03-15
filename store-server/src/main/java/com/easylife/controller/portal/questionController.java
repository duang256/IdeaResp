package com.easylife.controller.portal;

import com.easylife.common.ServerResponse;
import com.easylife.pojo.Question;
import com.easylife.service.IQuestionService;
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
@RequestMapping("/question/")
public class questionController {

    @Autowired
    private IQuestionService iQuestionService;


    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<List<Question>> getList(){
        return iQuestionService.selectList();

    }

    @RequestMapping("by_id.do")
    @ResponseBody
    public ServerResponse <List<Question>> selectQuestionById(
            @RequestParam(value = "id" ,required = false) int id){

        return iQuestionService.selectQuestionById(id);

    }



}
