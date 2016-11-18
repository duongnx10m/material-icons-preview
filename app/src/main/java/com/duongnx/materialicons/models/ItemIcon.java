package com.duongnx.materialicons.models;

/**
 * Created by duongnx on 11/18/16.
 */

public class ItemIcon {
    private int resId;
    private String name;

    public ItemIcon(int resId, String name) {
        this.resId = resId;
        this.name = name;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
