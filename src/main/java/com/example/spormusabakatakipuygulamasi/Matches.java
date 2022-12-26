package com.example.spormusabakatakipuygulamasi;

public class Matches {
    private String matchType;
    private String matchDate;
    private int[] score = new int[2];
    private String scoreboard;
    private Country teamA = new Country();
    private Country teamB = new Country();

    Matches(String matchType, Country teamA, Country teamB, String matchDate, int[] score, String scoreboard) {
        this.matchType = matchType;
        this.teamA = teamA;
        this.teamB = teamB;
        this.matchDate = matchDate;
        this.score = score;
        this.scoreboard = scoreboard;

        if (matchType.equals("group stage")){
            teamA.addGoalsScored(score[0]);
            teamA.addGoalsConceded(score[1]);
            teamB.addGoalsScored(score[1]);
            teamB.addGoalsConceded(score[0]);
            if (score[0] > score[1]) {
                teamA.addWin();
                teamA.addPoints(3);
                teamB.addLose();
            } else if (score[0] < score[1]) {
                teamB.addWin();
                teamB.addPoints(3);
                teamA.addLose();
            } else if (score[0] == score[1]) {
                teamA.addPoints(1);
                teamB.addPoints(1);
                teamA.addDraw();
                teamB.addDraw();
            }
        }
    }
    Matches(){

    }
    public String getTeamA(){
        return this.teamA.getCountryName();
    }
    public String getTeamB(){
        return this.teamB.getCountryName();
    }
    public String getMatchDate(){
        return this.matchDate;
    }
    public int[] getScore(){
        return this.score;
    }
    public String getScoreboard(){
        return this.scoreboard;
    }

    @Override
    public String toString() {
        return matchDate + "\n" + teamA.getCountryName() + " " + score[0] + " - " + score[1]
                + " " + teamB.getCountryName();
    }
}
