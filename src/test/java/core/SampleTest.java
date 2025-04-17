package tests;

import browser.Basics;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class SampleTest {

    WebDriver driver;

    @BeforeMethod
    public void init() {
        Basics.setUp();
        driver = Basics.getDriver();
    }

    @Test
    public void openSite() {
        driver.get("https://livedemo00.template-help.com/wt_prod-19186/");
    }

    @Test
    public void openAndClickInPlay() {
        driver.get("https://livedemo00.template-help.com/wt_prod-19186/");

        HomePage homePage = new HomePage(driver);
        homePage.clickPlayButton();


    }
//    @AfterMethod
//    public void cleanUp() {
//        Basics.tearDown();
//    }
}