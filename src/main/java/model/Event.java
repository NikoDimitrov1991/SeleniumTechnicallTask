package model;

import java.util.List;

public class Event {
    private String sportName;
    private String leagueName;
    private String homeTeam;
    private String awayTeam;
    private List<Odd> odds;
    private String totalMarkets;


    public Event(String sportName, String leagueName, String homeTeam, String awayTeam, List<Odd> odds, String totalMarkets) {
        this.sportName = sportName;
        this.leagueName = leagueName;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.odds = odds;
        this.totalMarkets = totalMarkets;
    }

    public String getSportName() {
        return sportName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public List<Odd> getOddList() {
        return odds;
    }

    public String getTotalMarkets() {
        return totalMarkets;
    }

    @Override
    public String toString() {
        return "Event{" +
                "sportName='" + sportName + '\'' +
                ", leagueName='" + leagueName + '\'' +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", odds=" + odds +
                ", totalMarkets='" + totalMarkets + '\'' +
                '}';
    }
}
