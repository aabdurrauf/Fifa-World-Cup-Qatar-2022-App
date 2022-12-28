package com.example.spormusabakatakipuygulamasi;

public class Players extends Person {
    private String club;
    private String position;
    private String height;
    private int shirtNumber;
    private int goals;
    private int assist;
    private int yellowCard;
    private int redCard;

    Players(String name, String position){
        this.name = name;
        this.position = position;
    }
    public String getPosition(){
        return position;
    }
    public int getShirtNumber(){
        return shirtNumber;
    }
    public String getClub(){
        return club;
    }
    public String getHeight(){
        return height;
    }
    public int getGoals(){
        return goals;
    }
    public int getAssist(){
        return assist;
    }
    public int getYellowCard(){
        return yellowCard;
    }
    public int getRedCard(){
        return redCard;
    }

    public void setShirtNumber(int number){
        this.shirtNumber = number;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public void setClub(String club){
        this.club = club;
    }
    public void setGoals(int goals){
        this.goals = goals;
    }
    public void setAssist(int assist){
        this.assist = assist;
    }
    public void setYellowCard(int yellowCard){
        this.yellowCard = yellowCard;
    }
    public void setRedCard(int redCard){
        this.redCard = redCard;
    }
}
