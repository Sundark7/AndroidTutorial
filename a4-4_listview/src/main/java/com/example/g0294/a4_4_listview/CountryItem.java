package com.example.g0294.a4_4_listview;

public class CountryItem {
    String country;
    int image_id;

    public CountryItem(String country, int image_id) {
        this.country = country;
        this.image_id = image_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
