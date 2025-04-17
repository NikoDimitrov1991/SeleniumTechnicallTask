package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By inPlayButton = By.cssSelector(".rd-navbar-main-container a[href='in-play.html']");

    public void clickPlayButton() {
        driver.findElement(inPlayButton).click();
    }
}
