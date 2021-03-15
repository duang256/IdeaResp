package com.easylife.vo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by hua
 */
public class UserVo {
    /**
     * 用户表id
     */
    @Id
    private Integer id;

    /**
     * 用户头像
     */
    private String photo;

    /**
     * 用户名
     */
    private String username;

    private String email;

    private String phone;


    @Column(name = "yidou")

    private Integer yidou;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getYidou() {
        return yidou;
    }

    public void setYidou(Integer yidou) {
        this.yidou = yidou;
    }
}
