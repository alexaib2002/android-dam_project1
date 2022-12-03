package com.dam.resultadosmundial.model;

import java.io.Serializable;

public class MatchResult implements Serializable {
    private final String phase;
    private final String date;
    private final String time;
    private final String team1;
    private final String team2;
    private final int score1;
    private final int score2;

    public MatchResult(String phase, String date, String time, String team1, int score1,
                       String team2, int score2) {
        this.phase = phase;
        this.date = date;
        this.time = time;
        this.team1 = team1;
        this.score1 = score1;
        this.team2 = team2;
        this.score2 = score2;
    }

    public String getPhase() {
        return phase;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}
