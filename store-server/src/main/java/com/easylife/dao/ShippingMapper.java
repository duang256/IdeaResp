package com.easylife.dao;

import com.easylife.pojo.Shipping;
import com.easylife.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper extends MyMapper<Shipping> {


    /**  插入并返回主键  */
    int customInsert(Shipping shipping);

    int deleteByShippingIdUserId(@Param("userId")Integer userId, @Param("shippingId") Integer shippingId);

    int updateByShipping(Shipping record);

    Shipping selectByShippingIdUserId(@Param("userId")Integer userId,@Param("shippingId") Integer shippingId);

    List<Shipping> selectByUserId(@Param("userId")Integer userId);


}