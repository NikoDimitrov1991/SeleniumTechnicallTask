package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By inPlayButton = By.xpath("//a[normalize-space()='In-Play']");

    public void clickPlayButton() {
        driver.findElement(inPlayButton).click();
    }
}
