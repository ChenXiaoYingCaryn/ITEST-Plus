package com.itest.pojo;

import java.io.Serializable;

/**
 * @author ChanV
 * @create 2021-08-04-22:36
 */

public class Slideshow implements Serializable {

    private int imageId;

    private String imageIntroduction;

    private String imageUrl;

    private int isDeleted;

    public Slideshow() {
    }

    public Slideshow(int imageId, String imageIntroduction, String imageUrl, int isDeleted) {
        this.imageId = imageId;
        this.imageIntroduction = imageIntroduction;
        this.imageUrl = imageUrl;
        this.isDeleted = isDeleted;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageIntroduction() {
        return imageIntroduction;
    }

    public void setImageIntroduction(String imageIntroduction) {
        this.imageIntroduction = imageIntroduction;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
