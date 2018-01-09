package com.example.lenovo.huangchong.beans;

/**
 * Created by ASUS on 2018/1/8.
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class IndexBean {
    //姓名
    private String name;
    //拼音
    private String pinyin;
    //拼音首字母
    private String headerWord;


    public IndexBean(String name, String pinyin, String headerWord) {
        this.name = name;
        this.pinyin = pinyin;
        this.headerWord = headerWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getHeaderWord() {
        return headerWord;
    }

    public void setHeaderWord(String headerWord) {
        this.headerWord = headerWord;
    }

    @Override
    public String toString() {
        return "IndexBean{" +
                "name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", headerWord='" + headerWord + '\'' +
                '}';
    }


}
