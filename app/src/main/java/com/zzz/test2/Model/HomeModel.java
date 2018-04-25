package com.zzz.test2.Model;

/**
 * Created by Administrator on 2018/4/20.
 */

public class HomeModel {
    //用户头像地址
    private String iconImageAddress;
    //userName
    private String name;
    //关注标识
    private int focusIdentity;
    //主图地址
    private String mainImageAddress;
    //图片名字
    private String imageName;
    //爱心标识
    private int loveIdentity;
    //爱心数量
    private String loveNumber;
    //评论
    private String commentString;

    public HomeModel(String iconImageAddress, String name, int focusIdentity, String mainImageAddress, String imageName, int loveIdentity, String loveNumber, String commentString) {
        this.iconImageAddress = iconImageAddress;
        this.name = name;
        this.focusIdentity = focusIdentity;
        this.mainImageAddress = mainImageAddress;
        this.imageName = imageName;
        this.loveIdentity = loveIdentity;
        this.loveNumber = loveNumber;
        this.commentString = commentString;
    }

    public HomeModel () {
        super();

    }

    public String getIconImageAddress() {
        return iconImageAddress;
    }

    public void setIconImageAddress(String iconImageAddress) {
        this.iconImageAddress = iconImageAddress;
    }

    public int getFocusIdentity() {
        return focusIdentity;
    }

    public void setFocusIdentity(int focusIdentity) {
        this.focusIdentity = focusIdentity;
    }

    public String getMainImageAddress() {
        return mainImageAddress;
    }

    public void setMainImageAddress(String mainImageAddress) {
        this.mainImageAddress = mainImageAddress;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getLoveIdentity() {
        return loveIdentity;
    }

    public void setLoveIdentity(int loveIdentity) {
        this.loveIdentity = loveIdentity;
    }

    public String getLoveNumber() {
        return loveNumber;
    }

    public void setLoveNumber(String loveNumber) {
        this.loveNumber = loveNumber;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
