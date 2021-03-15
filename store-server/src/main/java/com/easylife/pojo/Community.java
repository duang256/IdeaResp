package com.easylife.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Table(name = "community")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Community {
    @Id
    private Integer id;
    private String name;
    private String place;
    private Double longitude;
    private Double latitude;
    private String community_image;
}
