package com.lanqiao.bean;

public class Result {
    private String res;
    //用来判断是否给登录的结果类,也可以用来判断其他结果
    public Result(String res) {
        this.res = res;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
