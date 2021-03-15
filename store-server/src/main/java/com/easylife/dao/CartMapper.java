package com.easylife.dao;

import com.easylife.pojo.Cart;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper extends MyMapper<Cart> {

    Cart selectCartByUserIdProductIdStoreId(@Param("userId") Integer userId, @Param("productId")Integer productId,@Param("storeId")Integer storeId);

    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId")Integer productId);

    List<Cart> selectCartByUserId(Integer userId);

    List<Cart> selectCartByUserIdStoreId(@Param("userId")Integer userId,@Param("storeId")Integer storeId);

    int selectCartProductCheckedStatusByUserId(Integer userId);

    int deleteByUserIdProductIds(@Param("userId") Integer userId,@Param("productIdList")List<String> productIdList);


    int checkedOrUncheckedProduct(@Param("userId") Integer userId,@Param("productId")Integer productId,@Param("checked") Integer checked);

    int selectCartProductCount(@Param("userId") Integer userId);


    List<Cart> selectCheckedCartByUserId(Integer userId);



}