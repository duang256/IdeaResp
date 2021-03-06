package com.easylife.service;


import com.easylife.common.ServerResponse;
import com.easylife.vo.CartVo;

/**
 * Created by geely
 */
public interface ICartService {
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count,Integer storeId);
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> list(Integer userId);
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer productId, Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);

    ServerResponse<CartVo> selectbystore(Integer userId,Integer storeId);

    ServerResponse<CartVo> store_update(Integer userId, Integer productId, Integer count,Integer storeId);

}
