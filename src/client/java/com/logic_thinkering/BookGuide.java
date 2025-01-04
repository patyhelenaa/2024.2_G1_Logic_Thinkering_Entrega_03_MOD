package com.logic_thinkering;

import java.util.List;

public class BookGuide {
    private final List<BookPage> pages;
    private int currentPageIndex = 0;

    public BookGuide(List<BookPage> pages) {
        this.pages = pages;
    }

    public BookPage getCurrentPage() {
        return pages.get(currentPageIndex);
    }

    public boolean hasNextPage() {
        return currentPageIndex < pages.size() - 1;
    }

    public boolean hasPreviousPage() {
        return currentPageIndex > 0;
    }

    public void nextPage() {
        if (hasNextPage()) {
            currentPageIndex++;
        }
    }

    public void previousPage() {
        if (hasPreviousPage()) {
            currentPageIndex--;
        }
    }
}
