package com.easylife.common.enums;

/**
 * 2020.12.9
 * hua
 */
public enum StoreStatusEnum {
    ON_SALE(1,"在线");
    private String value;
    private int code;
    StoreStatusEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }
}
