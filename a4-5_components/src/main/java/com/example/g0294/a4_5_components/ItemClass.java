package com.example.g0294.a4_5_components;

public class ItemClass {
    String text;
    int image;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ItemClass(String text, int image) {

        this.text = text;
        this.image = image;
    }
}
