package com.Tradeling.WebUIPW;
import com.microsoft.playwright.Page;

public class HomePagePW {
    private final Page page;

    private String sideMenu = "[aria-label=\"Open Menu\"]";

    private String category(String cat) {
        return "#hmenu-content a:has-text(" + cat + ")";
    }

    private String supCategory(String supCat) {
        return "text=" + supCat;
    }


    public HomePagePW(Page page) {
        this.page = page;
    }

    public void OpenSideMenu() {
        page.locator(sideMenu).click();
    }

    public void ClickOnCategory(String category) {
        page.locator(category(category)).click();
    }

    public void ClickOnSupCategory(String subCat) {
        page.locator(supCategory(subCat)).click();
    }


}
