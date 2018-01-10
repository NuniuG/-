package com.example.lenovo.huangchong.chehua.ui.entity;

import android.content.Context;

/******************************************
 * 类名称：LoginUser
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/1/4
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy
 ******************************************/
public class LoginUser  {


    /**
     * body : {"userPhone":"18612187602","password":"123456"}
     */


    private BodyBean body;
    void  setHeaderBean(Context context, HeaderBean header){};

    public HeaderBean header;
    public HeaderBean getHeader() {
        return header;
    }

    public void setHeader(HeaderBean header) {
        this.header = header;
    }

    public static class HeaderBean {
        /**
         * sign : 03BF488EE3CC6BA156424B89D996D84D
         * ip : 127.0.0.3
         * channel : android
         * token : 40D841A78049310EC78AF1654DB0DF75
         */

        private String sign;
        private String ip;
        private String channel;
        private String token;

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }



    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }




    public static class BodyBean {
        /**
         * userPhone : 18612187602
         * password : 123456
         */

        private String userPhone;
        private String password;

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
