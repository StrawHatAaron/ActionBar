package com.aaronjeromemiller.actionbar.Utils;

/**
 * Created by aaronmiller on 8/2/17.
 */

public class StringManipulation {

    public static String expandUsername(String username){
        return username.replace("."," ");
    }

    public static String condensesUsername(String username){
        return username.replace(" ",".");
    }
}
