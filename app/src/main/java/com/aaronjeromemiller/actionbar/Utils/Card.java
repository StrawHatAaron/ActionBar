package com.aaronjeromemiller.actionbar;

/**
 * Created by aaronmiller on 7/27/17.
 */

public class Card {
    private String imgURL;
    private String title;

    public Card(String imgURL, String title) {
        this.imgURL = imgURL;
        this.title = title;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
