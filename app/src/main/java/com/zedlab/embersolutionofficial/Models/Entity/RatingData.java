package com.zedlab.embersolutionofficial.Models.Entity;

public class RatingData {

    private int imageUrl;
    private float ratingStars;
    private String userName;
    private String comment;

    public RatingData(int imageUrl, float ratingStars, String userName, String comment) {
        this.imageUrl = imageUrl;
        this.ratingStars = ratingStars;
        this.userName = userName;
        this.comment = comment;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getRatingStars() {
        return ratingStars;
    }

    public void setRatingStars(float ratingStars) {
        this.ratingStars = ratingStars;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
