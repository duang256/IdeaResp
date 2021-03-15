package com.easylife.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**2020.12.9
 * hua
 */

@Table(name = "store_store")
public class Store {
    /**
     * 商铺id
     */
    @Id
    private Integer id;

    /**
     * 商品名称
     */
    private String name;


    /**
     * 产品主图,url相对地址
     */
    @Column(name = "image")
    private String image;


    /**
     * 商品状态.1-在售 2-下架 3-删除
     */
    private Integer status;


    /**
     * 商品详情
     */
    private String detail;


    /**
     * 商铺类型 1-在售 2-下架 3-删除
     */
    private Integer type;


    /**
     * 商铺地址
     */
    private String place;


    /**
     * 商铺tel
     */
    private String tel;



    /**
     * 商铺公告
     */
    private String post;



    /**
     * 创建时间
     */
    @Column(name = "stime")
    private String stime;

    /**
     * 更新时间
     */
    @Column(name = "etime")
    private String etime;

    /**
     * ziqu
     */
    private Integer self;

    /**
     * 外卖
     */
    private Integer delivery;

    /**
     * 社区
     */
    private Integer community_id;

    /**
     * 获取商品id
     *
     * @return id - 商品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品id
     *
     * @param id 商品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类id,对应store_category表的主键
     *
     * @return category_id - 分类id,对应store_category表的主键
     */

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * 获取商品状态.1-在售 2-下架 3-删除
     *
     * @return status - 商品状态.1-在售 2-下架 3-删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置商品状态.1-在售 2-下架 3-删除
     *
     * @param status 商品状态.1-在售 2-下架 3-删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取商品详情
     *
     * @return detail - 商品详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置商品详情
     *
     * @param detail 商品详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public Integer getSelf() {
        return self;
    }

    public void setSelf(Integer self) {
        this.self = self;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(Integer community_id) {
        this.community_id = community_id;
    }
}