package com.easylife.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**2020.12.9
 * hua
 */

@Table(name = "store_question")
public class Question {
    @Id
    private int id;
    private String name;
    private String a;
    private String b;
    private String c;
    private String d;
    private int check;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

}