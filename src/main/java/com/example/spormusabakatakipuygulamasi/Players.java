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

    Players(String name, String nationality, int age, String club, String position, int shirtNumber){
        super(name, nationality, age);
        this.club = club;
        this.position = position;
        this.shirtNumber = shirtNumber;
        goals = 0;
        assist = 0;
        yellowCard = 0;
        redCard = 0;
    }
    Players(String name, String position){
        this.name = name;
        this.position = position;
    }
    Players(){
    }
    public String getName(){
        return name;
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
    public int getAge(){
        return age;
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
    public void setAge(int age){
        this.age = age;
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
