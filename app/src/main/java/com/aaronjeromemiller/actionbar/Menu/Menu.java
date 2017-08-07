package com.aaronjeromemiller.actionbar.Menu;

/**
 * Created by aaronmiller on 8/5/17.
 */

public class Menu {
    private String foodCardImage;
    private String foodCardTitle;
    private String foodCardDescription;

    public Menu(String foodCardImage, String foodCardTitle, String foodCardDescription) {
        this.foodCardImage = foodCardImage;
        this.foodCardTitle = foodCardTitle;
        this.foodCardDescription = foodCardDescription;
    }

    public String getFoodCardImage() {
        return foodCardImage;
    }

    public void setFoodCardImage(String foodCardImage) {
        this.foodCardImage = foodCardImage;
    }

    public String getFoodCardTitle() {
        return foodCardTitle;
    }

    public void setFoodCardTitle(String foodCardTitle) {
        this.foodCardTitle = foodCardTitle;
    }

    public String getFoodCardDescription() {
        return foodCardDescription;
    }

    public void setFoodCardDescription(String foodCardDescription) {
        this.foodCardDescription = foodCardDescription;
    }
}
