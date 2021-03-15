package com.easylife.controller.portal;

import com.github.pagehelper.PageInfo;
import com.easylife.common.ServerResponse;
import com.easylife.service.IProductService;
import com.easylife.vo.ProductDetailVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by geely
 */

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;


    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }

    /*通过店铺id查询商品
     * hyy*/
    @RequestMapping("SelectProductByStoreId.do")
    @ResponseBody
    public ServerResponse SelectProductByStoreId(
            @RequestParam(value = "storeId" ,required = false) Integer storeId){
        return iProductService.SelectProductByStoreId(storeId);
    }

    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false)String keyword,
                                         @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "30") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }












    //==================   RESTFUL接口  start  test ======================



    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<ProductDetailVo> detailRESTful(@PathVariable Integer productId){
        return iProductService.getProductDetail(productId);
    }


    //http://www.happymmall.com/product/手机/100012/1/10/price_asc
    @RequestMapping(value = "/{keyword}/{categoryId}/{pageNum}/{pageSize}/{orderBy}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listRESTful(@PathVariable(value = "keyword")String keyword,
                                                @PathVariable(value = "categoryId")Integer categoryId,
                                                @PathVariable(value = "pageNum") Integer pageNum,
                                                @PathVariable(value = "pageSize") Integer pageSize,
                                                @PathVariable(value = "orderBy") String orderBy){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        if(StringUtils.isBlank(orderBy)){
            orderBy = "price_asc";
        }

        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }


    //    http://www.happymmall.com/product/100012/1/10/price_asc
    @RequestMapping(value = "/{categoryId}/{pageNum}/{pageSize}/{orderBy}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listRESTfulBadcase(@PathVariable(value = "categoryId")Integer categoryId,
                                                       @PathVariable(value = "pageNum") Integer pageNum,
                                                       @PathVariable(value = "pageSize") Integer pageSize,
                                                       @PathVariable(value = "orderBy") String orderBy){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        if(StringUtils.isBlank(orderBy)){
            orderBy = "price_asc";
        }

        return iProductService.getProductByKeywordCategory("",categoryId,pageNum,pageSize,orderBy);
    }


    @RequestMapping(value = "/{keyword}/{pageNum}/{pageSize}/{orderBy}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listRESTfulBadcase(@PathVariable(value = "keyword")String keyword,
                                                       @PathVariable(value = "pageNum") Integer pageNum,
                                                       @PathVariable(value = "pageSize") Integer pageSize,
                                                       @PathVariable(value = "orderBy") String orderBy){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        if(StringUtils.isBlank(orderBy)){
            orderBy = "price_asc";
        }

        return iProductService.getProductByKeywordCategory(keyword,null,pageNum,pageSize,orderBy);
    }


    //http://www.happymmall.com/product/keyword/手机/1/10/price_asc
    @RequestMapping(value = "/keyword/{keyword}/{pageNum}/{pageSize}/{orderBy}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listRESTful(@PathVariable(value = "keyword")String keyword,
                                                @PathVariable(value = "pageNum") Integer pageNum,
                                                @PathVariable(value = "pageSize") Integer pageSize,
                                                @PathVariable(value = "orderBy") String orderBy){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        if(StringUtils.isBlank(orderBy)){
            orderBy = "price_asc";
        }

        return iProductService.getProductByKeywordCategory(keyword,null,pageNum,pageSize,orderBy);
    }


    //http://www.happymmall.com/product/category/100012/1/10/price_asc
    @RequestMapping(value = "/category/{categoryId}/{pageNum}/{pageSize}/{orderBy}",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listRESTful(@PathVariable(value = "categoryId")Integer categoryId,
                                                @PathVariable(value = "pageNum") Integer pageNum,
                                                @PathVariable(value = "pageSize") Integer pageSize,
                                                @PathVariable(value = "orderBy") String orderBy){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        if(StringUtils.isBlank(orderBy)){
            orderBy = "price_asc";
        }

        return iProductService.getProductByKeywordCategory("",categoryId,pageNum,pageSize,orderBy);
    }


}
