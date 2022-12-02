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

    public MatchResult(String phase, String date, String time, String team1, String team2,
                       int score1, int score2) {
        this.phase = phase;
        this.date = date;
        this.time = time;
        this.team1 = team1;
        this.score1 = score1;
        this.team2 = team2;
        this.score2 = score2;
    }
    // constructor for "Fase de grupos", "20/11/2022 17:00", "Qatar", 0, "Ecuador", 2
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

}
