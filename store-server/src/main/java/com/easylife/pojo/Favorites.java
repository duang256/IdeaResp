package com.easylife.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Table(name = "community_favorites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorites {
    @Id
    private Integer id;
    private Integer idle_id;
    private Integer user_id;
}
