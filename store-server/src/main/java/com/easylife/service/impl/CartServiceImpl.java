package com.easylife.service.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.easylife.common.Const;
import com.easylife.common.ResponseCode;
import com.easylife.common.ServerResponse;
import com.easylife.dao.CartMapper;
import com.easylife.dao.ProductMapper;
import com.easylife.pojo.Cart;
import com.easylife.pojo.Product;
import com.easylife.service.ICartService;
import com.easylife.util.BigDecimalUtil;
import com.easylife.util.PropertiesUtil;
import com.easylife.vo.CartProductVo;
import com.easylife.vo.CartVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
@Service("iCartService")
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    public ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count,Integer storeId){
        if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }

        Cart cart = cartMapper.selectCartByUserIdProductId(userId,productId);
        if(cart == null){
            //这个产品不在这个购物车里,需要新增一个这个产品的记录
            Cart cartItem = new Cart();
            cartItem.setQuantity(count);
            cartItem.setChecked(Const.Cart.CHECKED);
            cartItem.setStoreId(storeId);
            cartItem.setProductId(productId);
            cartItem.setUserId(userId);
            cartMapper.insert(cartItem);
        }else{
            //这个产品已经在购物车里了.
            //如果产品已存在,数量相加
            count = cart.getQuantity() + count;
            cart.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);
    }

    public ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count){
        if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdProductId(userId,productId);
        if(cart != null){
            cart.setQuantity(count);
        }else{
            //购物车没有该商品
        }
        cartMapper.updateByPrimaryKey(cart);
        return this.list(userId);
    }
//hua 2021.1.4
    public ServerResponse<CartVo> store_update(Integer userId, Integer productId, Integer count,Integer storeId){
        if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartMapper.selectCartByUserIdProductIdStoreId(userId,productId,storeId);
        if(cart != null){
            cart.setQuantity(count);
        }else{
            //购物车没有该商品
        }
        cartMapper.updateByPrimaryKey(cart);
        return this.list(userId);
    }

    public ServerResponse<CartVo> deleteProduct(Integer userId, String productIds){
        List<String> productList = Splitter.on(",").splitToList(productIds);
        if(CollectionUtils.isEmpty(productList)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        cartMapper.deleteByUserIdProductIds(userId,productList);
        return this.list(userId);
    }


    public ServerResponse<CartVo> list (Integer userId){
        CartVo cartVo = this.getCartVoLimit(userId);
        return ServerResponse.createBySuccess(cartVo);
    }

//hua 2021.1.4
    public ServerResponse<CartVo> selectbystore (Integer userId,Integer storeId){
        CartVo cartVo = this.getShopCartVoLimit(userId,storeId);
        return ServerResponse.createBySuccess(cartVo);
    }

    public ServerResponse<CartVo> selectOrUnSelect (Integer userId, Integer productId, Integer checked){
        cartMapper.checkedOrUncheckedProduct(userId,productId,checked);
        return this.list(userId);
    }

    public ServerResponse<Integer> getCartProductCount(Integer userId){
        if(userId == null){
            return ServerResponse.createBySuccess(0);
        }
        return ServerResponse.createBySuccess(cartMapper.selectCartProductCount(userId));
    }


    private CartVo getCartVoLimit(Integer userId){
        CartVo cartVo = new CartVo();
        //查出来的是所有在购物车中的商品，所以即使一个购物车中有多个商品，这多个商品都会被查出来放在cartList中，参考add()方法逻辑
        List<Cart> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();
        int cartTotalyidou=0; //hua 2020.12.29
        BigDecimal cartTotalPrice = new BigDecimal("0");
        if(CollectionUtils.isNotEmpty(cartList)){
            for(Cart cartItem : cartList){
                CartProductVo cartProductVo = new CartProductVo();
                cartProductVo.setId(cartItem.getId());
                cartProductVo.setProductId(cartItem.getProductId());

                Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
                if(product != null){
                    cartProductVo.setProductMainImage(product.getMainImage());
                    cartProductVo.setProductName(product.getName());
                    cartProductVo.setProductSubtitle(product.getSubtitle());
                    cartProductVo.setProductStatus(product.getStatus());
                    cartProductVo.setProductPrice(product.getYi_price());   //hua 2020.12.29
                    cartProductVo.setProductStock(product.getStock());
                    cartProductVo.setProductyidou(product.getYidou());//hua

                    cartProductVo.setStoreId(product.getShopId());//   hua 2021.1.4
                    //判断库存
                    int buyLimitCount = 0;
                    if(product.getStock() >= cartItem.getQuantity()){
                        //库存充足的时候
                        buyLimitCount = cartItem.getQuantity();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else{
                        buyLimitCount = product.getStock();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    cartProductVo.setQuantity(buyLimitCount);
                    //计算总价
                    cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getYi_price().doubleValue(),cartProductVo.getQuantity()));
                    //hua
                    cartProductVo.setProductTotalyidou(product.getYidou().intValue()*cartProductVo.getQuantity());
                    cartProductVo.setProductChecked(cartItem.getChecked());
                }

                if(cartItem.getChecked() == Const.Cart.CHECKED){
                    //如果已经勾选,增加到整个的购物车总价中
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartProductVo.getProductTotalPrice().doubleValue());
                    cartTotalyidou=cartTotalyidou+cartProductVo.getProductTotalyidou();   //hua 2020.12.29
                }
                cartProductVoList.add(cartProductVo);
            }
        }
        cartVo.setCartTotalyidou(cartTotalyidou);   //hua 2020.12.29
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

        return cartVo;
    }

    private boolean getAllCheckedStatus(Integer userId){
        if(userId == null){
            return false;
        }
        return cartMapper.selectCartProductCheckedStatusByUserId(userId) == 0;

    }


    //hua 2021.1.4
    private CartVo getShopCartVoLimit(Integer userId,Integer storeId){
        CartVo cartVo = new CartVo();
        //查出来的是所有在购物车中的商品，所以即使一个购物车中有多个商品，这多个商品都会被查出来放在cartList中，参考add()方法逻辑
        List<Cart> cartList = cartMapper.selectCartByUserIdStoreId(userId,storeId);  //hua 1.4
//        int productId=cartList.get(0).getProductId();
//
//        Cart cart = cartMapper.selectCartByUserIdProductIdStoreId(userId,productId,storeId);
//        if(cart == null){
//

        List<CartProductVo> cartProductVoList = Lists.newArrayList();
        int cartTotalyidou=0; //hua 2020.12.29
        BigDecimal cartTotalPrice = new BigDecimal("0");
        if(CollectionUtils.isNotEmpty(cartList)){
            for(Cart cartItem : cartList){
                CartProductVo cartProductVo = new CartProductVo();
                cartProductVo.setId(cartItem.getId());
                cartProductVo.setUserId(userId);
                cartProductVo.setStoreId(storeId);
                cartProductVo.setProductId(cartItem.getProductId());

                Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
                if(product != null){
                    cartProductVo.setProductMainImage(product.getMainImage());
                    cartProductVo.setProductName(product.getName());
                    cartProductVo.setProductSubtitle(product.getSubtitle());
                    cartProductVo.setProductStatus(product.getStatus());
                    cartProductVo.setProductPrice(product.getYi_price());   //hua 2020.12.29
                    cartProductVo.setProductStock(product.getStock());
                    cartProductVo.setProductyidou(product.getYidou());//hua
                    //判断库存
                    int buyLimitCount = 0;
                    if(product.getStock() >= cartItem.getQuantity()){
                        //库存充足的时候
                        buyLimitCount = cartItem.getQuantity();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else{
                        buyLimitCount = product.getStock();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartMapper.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    cartProductVo.setQuantity(buyLimitCount);
                    //计算总价
                    cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getYi_price().doubleValue(),cartProductVo.getQuantity()));
                    //hua
                    cartProductVo.setProductTotalyidou(product.getYidou().intValue()*cartProductVo.getQuantity());
                    cartProductVo.setProductChecked(cartItem.getChecked());
                }

                if(cartItem.getChecked() == Const.Cart.CHECKED){
                    //如果已经勾选,增加到整个的购物车总价中
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartProductVo.getProductTotalPrice().doubleValue());
                    cartTotalyidou=cartTotalyidou+cartProductVo.getProductTotalyidou();   //hua 2020.12.29
                }
                cartProductVoList.add(cartProductVo);
            }
        }
        cartVo.setCartTotalyidou(cartTotalyidou);   //hua 2020.12.29
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

        return cartVo;
    }





}
