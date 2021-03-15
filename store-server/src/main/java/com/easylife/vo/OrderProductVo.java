package com.easylife.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
public class OrderProductVo {
    private List<OrderItemVo> orderItemVoList;
    private BigDecimal productTotalPrice;
    private Integer ProductTotalYidou;
    private String imageHost;


    public Integer getProductTotalYidou() {
        return ProductTotalYidou;
    }

    public void setProductTotalYidou(Integer productTotalYidou) {
        ProductTotalYidou = productTotalYidou;
    }

    public List<OrderItemVo> getOrderItemVoList() {
        return orderItemVoList;
    }

    public void setOrderItemVoList(List<OrderItemVo> orderItemVoList) {
        this.orderItemVoList = orderItemVoList;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
