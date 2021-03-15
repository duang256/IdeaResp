package com.easylife.service;

import com.github.pagehelper.PageInfo;
import com.easylife.common.ServerResponse;
import com.easylife.pojo.Product;
import com.easylife.vo.ProductDetailVo;

import java.util.List;

/**
 * Created by geely
 */
public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

    /*通过店铺id查询商品
     * hyy*/
    ServerResponse<List<Product>> SelectProductByStoreId(Integer storeId);

}
