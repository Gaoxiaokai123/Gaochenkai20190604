package com.bawei.gaochenkai.bean;

/**
 * @Auther: 高晨凯
 * @Date: 2019/6/4 09:19:59
 * @Description:  封装轮播图中的数据
 */
public class BannerBean {
    private String imageUrl;

    public BannerBean(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
