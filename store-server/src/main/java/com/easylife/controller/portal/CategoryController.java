package com.easylife.controller.portal;

import com.easylife.common.ServerResponse;
import com.easylife.pojo.Category;
import com.easylife.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by geely
 */
@Controller
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;


    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<List<Category>> getList(){
        return iCategoryService.getCategoryList();

    }

    @RequestMapping("by_mallId.do")
    @ResponseBody
    public ServerResponse <List<Category>> seselectCategoryByMallId(
            @RequestParam(value = "mallId" ,required = false) Integer mallId){

        return iCategoryService.selectCategoryByMallId(mallId);

    }


    @RequestMapping("get_category.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(
            @RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId){

        return iCategoryService.getChildrenParallelCategory(categoryId);

    }

    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(
            @RequestParam(value = "categoryId" ,defaultValue = "0") Integer categoryId){

        return iCategoryService.selectCategoryAndChildrenById(categoryId);

    }











}
