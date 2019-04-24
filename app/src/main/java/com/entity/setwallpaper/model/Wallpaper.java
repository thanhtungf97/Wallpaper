package com.entity.setwallpaper.model;

public class Wallpaper {
    private int image;
    private String name;
    private String author;

    public Wallpaper() {
    }

    public Wallpaper(int image, String name, String author) {
        this.image = image;
        this.name = name;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
