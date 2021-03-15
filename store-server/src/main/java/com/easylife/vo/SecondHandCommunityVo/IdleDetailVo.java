package com.easylife.vo.SecondHandCommunityVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdleDetailVo {
    private Integer id;
    private String name;
    private Integer user_id;
    private BigDecimal starting_price;
    private BigDecimal price;
    private String description;
    private String main_img;
    private String item_img2;
    private String item_img3;
    private String item_img4;
    private String item_img5;
    private String item_img6;
    private String item_img7;
    private String item_img8;
    private String item_img9;
    private String imageHost;
}
