package com.logic_thinkering;

public class BookPage {
    private final String title;
    private final String text;
    private final String imagePath;

    public BookPage(String title, String text, String imagePath) {
        this.title = title;
        this.text = text;
        this.imagePath = imagePath == null ? "" : imagePath;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImagePath() {
        return imagePath;
    }
}