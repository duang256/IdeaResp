package com.easylife.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    private int cartTotalyidou;   //hua 2020.12.29
    private BigDecimal cartTotalPrice;
    private Boolean allChecked;//是否已经都勾选
    private String imageHost;

    public int getCartTotalyidou() {
        return cartTotalyidou;
    }

    public void setCartTotalyidou(int cartTotalyidou) {
        this.cartTotalyidou = cartTotalyidou;
    }

    public List<CartProductVo> getCartProductVoList() {
        return cartProductVoList;
    }

    public void setCartProductVoList(List<CartProductVo> cartProductVoList) {
        this.cartProductVoList = cartProductVoList;
    }

    public BigDecimal getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(BigDecimal cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Boolean getAllChecked() {
        return allChecked;
    }

    public void setAllChecked(Boolean allChecked) {
        this.allChecked = allChecked;
    }

    public String getImageHost() {
        return imageHost;
    }

    public void setImageHost(String imageHost) {
        this.imageHost = imageHost;
    }
}
