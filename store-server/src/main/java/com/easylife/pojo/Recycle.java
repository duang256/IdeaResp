package com.easylife.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Table(name = "recycle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recycle {

    private Integer id;
    private String type;
    private String image;
    private String description;
    private double price;
    private double reward;

}
