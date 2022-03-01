package com.Tradeling.WebTestPW;

import com.Tradeling.WebUIPW.*;
import com.Tradeling.utils.Constants;
import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class CheckFilterByDepartmentInDealsAndPromotionsPage {

    static String totalNum;
    static Playwright playwright;
    static Browser browser;
    HomePagePW homePage;
    // New instance for each test method.
    BrowserContext context;
    Page page;

    @BeforeClass
    public void testSetup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeMethod
    public void testInit() {
        context = browser.newContext();
        page = context.newPage();
        homePage = new HomePagePW(page);
    }

    @Test
    public void FirstScenario() {


        page.navigate(Constants.WebTestData.AmazonUrL);

        // Click on side menu btn
        page.click("[aria-label=\"Open Menu\"]");

        // Click on category Smart Home
        page.click("#hmenu-content a:has-text(\"Smart Home\")");

        // Click on sub category Home Entertainment
        page.click("text=Home Entertainment");
        // assert page.url().equals("https://www.amazon.com/gp/browse.html?node=21216826011&ref_=nav_em_sh_home-entertainment_0_2_7_10");

        // Click on sub category Smart Televisions
        page.click("[aria-label=\"Smart Televisions\"]");
        // assert page.url().equals("https://www.amazon.com/b/ref=SHT/ref=s9_acss_bw_cg_SHHE_2a1_w?ie=UTF8&node=21216827011&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=merchandised-search-3&pf_rd_r=MGK0Y4Y2Q77Y9Y16RHXD&pf_rd_t=101&pf_rd_p=ba174060-e226-43dc-9254-21dbcae4cc54&pf_rd_i=21216826011");

        // get total number
        totalNum = page.locator("text=1-12 of 230 results for").textContent();

        // Click .a-section.aok-relative
        page.click(".a-section.aok-relative");
        // assert page.url().equals("https://www.amazon.com/TCL-4K-Smart-LED-50S435/dp/B08DHFX4FV/ref=lp_21216827011_1_1");

        page.pause();
    }

    @AfterMethod
    public void testClosure() {
        context.close();
    }

    @AfterClass
    public void tearDown() {
        playwright.close();
    }


}
