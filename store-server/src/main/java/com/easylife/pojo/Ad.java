package com.easylife.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**2020.12.9
 * hua
 */

@Table(name = "store_ad")
public class Ad {
    /**
     * ad id
     */
    @Id
    private Integer id;
    /**
     * ad类型 1-主页 2-商城 3-待定
     */
    private Integer type;

    @Column(name = "url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}