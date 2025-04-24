package pages;

import model.Event;
import model.Odd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InPlayPage {
    private WebDriver driver;

    public InPlayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Event> extractAllEvents() {
        List<Event> allEvents = new ArrayList<>();

        List<WebElement> sports = driver.findElements(By.cssSelector("h5.heading-component-title"));

        for (WebElement sport : sports) {
            String sportName = sport.getText().trim();

            WebElement leagueElement;
            try {
                leagueElement = sport.findElement(By.xpath("following-sibling::div[1]/p"));
            } catch (Exception e) {
                continue; // ако няма лига, скипваме
            }

            String leagueName = leagueElement.getText().trim();

            List<WebElement> eventElements = sport.findElements(By.xpath("following-sibling::div[1]//div[@class='sport-table']"));

            for (WebElement event : eventElements) {
                try {
                    List<WebElement> teams = event.findElements(By.cssSelector(".sport-table-title-team"));
                    if (teams.size() < 2) continue;

                    String homeTeam = teams.get(0).getText().trim();
                    String awayTeam = teams.get(1).getText().trim();

                    List<WebElement> oddElements = event.findElements(By.cssSelector(".sport-table-wager-button-count"));
                    List<Odd> odds = new ArrayList<>();

                    String[] oddTypes = {"1", "X", "2"};
                    for (int i = 0; i < oddElements.size(); i++) {
                        String oddValue = oddElements.get(i).getText().trim();
                        String oddType = i < oddTypes.length ? oddTypes[i] : "N/A";
                        odds.add(new Odd(oddType, oddValue));
                    }

                    String totalMarkets = "";
                    try {
                        WebElement totalMarketsEl = event.findElement(By.cssSelector(".sport-table-wager-button-count + span"));
                        totalMarkets = totalMarketsEl.getText().trim(); // напр. "+58"
                    } catch (Exception ignored) {}

                    Event eventObj = new Event(sportName, leagueName, homeTeam, awayTeam, odds, totalMarkets);
                    allEvents.add(eventObj);

                } catch (Exception e) {
                    System.out.println("Грешка при обработка на евент: " + e.getMessage());
                }
            }
        }

        return allEvents;
    }
}
