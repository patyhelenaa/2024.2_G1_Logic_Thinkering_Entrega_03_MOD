package com.logic_thinkering;

import java.util.ArrayList;
import java.util.List;

public class BookGuideBuilder {
    private final List<BookPage> pages = new ArrayList<>();

    public BookGuideBuilder addPage(String title, String text, String imagePath) {
        pages.add(new BookPage(title, text, imagePath));
        return this;
    }

    public BookGuide build() {
        return new BookGuide(pages);
    }
}
