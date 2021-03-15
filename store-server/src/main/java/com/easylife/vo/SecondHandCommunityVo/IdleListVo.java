package com.easylife.vo.SecondHandCommunityVo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdleListVo {
    private Integer id;
    private String name;
    private Integer user_id;
    private BigDecimal starting_price;
    private BigDecimal price;
    private String main_img;
    private String imageHost;
}
