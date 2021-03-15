package com.easylife.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "community_idle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityIdle {
    @Id
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
    private Integer category;
}
