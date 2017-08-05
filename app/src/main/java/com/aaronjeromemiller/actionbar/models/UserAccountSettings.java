package com.aaronjeromemiller.actionbar.models;

/**
 * Created by aaronmiller on 8/2/17.
 */

public class UserAccountSettings {

    //these names must be the exact same with the firebase data structure
    private String description;
    private String display_name;
    private String food_preferences;
    private long liked_foods;
    private String profile_photo;
    private String username;

    public UserAccountSettings(String description, String display_name, String food_preferencs, long liked_foods, String profile_photo, String username) {
        this.description = description;
        this.display_name = display_name;
        this.food_preferences = food_preferencs;
        this.liked_foods = liked_foods;
        this.profile_photo = profile_photo;
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getFood_preferencs() {
        return food_preferences;
    }

    public void setFood_preferencs(String food_preferencs) {
        this.food_preferences = food_preferencs;
    }

    public long getLiked_foods() {
        return liked_foods;
    }

    public void setLiked_foods(long liked_foods) {
        this.liked_foods = liked_foods;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserAccountSettings{" +
                "description='" + description + '\'' +
                ", display_name='" + display_name + '\'' +
                ", food_preferencs='" + food_preferences + '\'' +
                ", liked_foods='" + liked_foods + '\'' +
                ", profile_photo='" + profile_photo + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

