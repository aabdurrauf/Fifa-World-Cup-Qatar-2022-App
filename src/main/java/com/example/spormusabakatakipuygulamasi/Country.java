package com.example.spormusabakatakipuygulamasi;

import java.util.ArrayList;
import java.util.Arrays;

public class Country implements Comparable<Country>{
    private String countryName;
    private ArrayList<Players> players = new ArrayList<>();
    private Coach coach;
    private int ranking;
    private int champions;
    private int[] championYears;
    private int win = 0;
    private int lose = 0;
    private int draw = 0;
    private int goalsScored = 0;
    private int goalsConceded = 0;
    private int points = 0;

    public Country() {

    }
    public Country(String countryName, int ranking, int champions){
        this.countryName = countryName;
        this.ranking = ranking;
        this.champions = champions;
    }
    public void setCoach(Coach coach){
        this.coach = coach;
    }
    public void setPlayers(Players[] players){
        this.players.addAll(Arrays.asList(players));
    }
    public void setChampionYears(int[] championYears){
        this.championYears = championYears;
    }
    public void addPlayer(Players player){
        this.players.add(player);
    }
    public void addPoints(int points){
        this.points += points;
    }
    public void addWin(){
        this.win += 1;
    }
    public void addLose(){
        this.lose += 1;
    }
    public void addDraw(){
        this.draw += 1;
    }
    public void addGoalsScored(int goals){
        this.goalsScored += goals;
    }
    public void addGoalsConceded(int goals){
        this.goalsConceded += goals;
    }

    public String getCountryName(){
        return countryName;
    }
    public Coach getCoach(){
        return coach;
    }
    public ArrayList<Players> getPlayers(){
        return players;
    }
    public int getRank(){
        return ranking;
    }
    public int getChampions(){
        return champions;
    }
    public int getWin(){
        return win;
    }
    public int getLose(){
        return lose;
    }
    public int getDraw(){
        return draw;
    }
    public int getPoints(){
        return points;
    }
    public int getGoalsScored(){
        return goalsScored;
    }
    public int getGoalsConceded(){
        return goalsConceded;
    }
    public int[] getChampionYears(){
        return championYears;
    }
    public void displayPlayers(){
        System.out.println("players: ");
        for(Players player : this.players){
            System.out.print(player.getName() + " ");
            System.out.println(player.getPosition());
        }
    }

    @Override
    public int compareTo(Country o) {
        if (this.getPoints() > o.getPoints()){
            return 1;
        }
        else if (this.getPoints() < o.getPoints()){
            return -1;
        }
        else{
            return 0;
        }
    }
}

//player list
//https://www.eurosport.com/football/world-cup/2022/world-cup-2022-every-world-cup-squad-
// in-full-see-who-brazil-england-france-argentina-germany-and-spa_sto9217767/story.shtml

// fifa country ranking
// https://www.fifa.com/fifa-world-ranking/men?dateId=id13792