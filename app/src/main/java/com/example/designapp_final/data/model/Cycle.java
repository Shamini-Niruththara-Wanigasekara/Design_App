package com.example.designapp_final.data.model;

import android.graphics.drawable.Drawable;

public class Cycle {
    String name;
    Drawable image;

    public Cycle(String name, Drawable image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
