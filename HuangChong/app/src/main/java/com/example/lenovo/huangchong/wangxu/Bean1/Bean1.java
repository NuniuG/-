package com.example.lenovo.huangchong.wangxu.Bean1;

/**
 * Created by dell on 2018/1/5.
 */

public class Bean1 {
    private int image;
    private  String name;
    private  String dizhi;

    public Bean1() {
        super();
    }

    public Bean1(int image, String name, String dizhi) {
        this.image = image;
        this.name = name;
        this.dizhi = dizhi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
}
