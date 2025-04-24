package core;

import browser.Basics;
import model.Event;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InPlayPage;

import java.util.List;

public class InPlayTest {
    WebDriver driver;

    @BeforeMethod
    public void init() {
        Basics.setUp();
        driver = Basics.getDriver();
    }

//    @Test
//    public void openAndClickInPlay() {
//        driver.get("https://livedemo00.template-help.com/wt_prod-19186/");
//
//        HomePage homePage = new HomePage(driver);
//        homePage.clickPlayButton();
//    }

    @Test
    public void testExtractInPlayEvents() {
        HomePage homePage = new HomePage(driver);
        homePage.clickPlayButton();

        InPlayPage inPlayPage = new InPlayPage(Basics.driver);
        List<Event> allEvents = inPlayPage.extractAllEvents();

        for (Event event : allEvents) {
            System.out.println(event);
        }
    }
}
