package com.edgar.swipesimpleapp.model;



public class Item {

    private String name;
    private String mobile;


    public Item(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
