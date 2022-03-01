package com.Tradeling.WebUIPW;

import com.microsoft.playwright.Page;

public class ProductsPage {
    private final Page page;

    private String productsCategory(String category){return "[aria-label=\""+category+"\"]";}

    private String numOfProducts(String category){return "";}

    public ProductsPage(Page page) {
        this.page = page;
    }
}
