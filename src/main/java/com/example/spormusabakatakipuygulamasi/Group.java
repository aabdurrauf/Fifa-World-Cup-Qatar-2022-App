package com.example.spormusabakatakipuygulamasi;

import java.util.ArrayList;
import java.util.Arrays;

public class Group {
    private ArrayList<Country> countries  = new ArrayList<>();
    private ArrayList<Matches> matches = new ArrayList<>();
    private String groupName;
    Group(String groupName){
        this.groupName = groupName;
    }
    Group(int i){
        // create name group with ASCII code
        this.groupName = Character.toString((char)i);
    }
    public void addCountry(Country country){

        countries.add(country);
    }

    public String getGroupName(){
        return this.groupName;
    }
    public ArrayList<Country> getCountryList(){
        showGroupRanking();
        return countries;
    }
    public void showGroupRanking(){
        Country[] rank = new Country[countries.size()];
        for (int i = 0; i < rank.length; i++) {
            rank[i] = countries.get(i);
        }
        for (int i = 0; i < rank.length-1; i++) {
            for (int j = i+1; j < rank.length; j++) {
                if(rank[i].compareTo(rank[j]) < 0){
                    Country temp = rank[i];
                    rank[i] = rank[j];
                    rank[j] = temp;
                }
            }
        }
        countries = new ArrayList<>();
        countries.addAll(Arrays.asList(rank));
    }
    public void addMatch(Matches match) {
        matches.add(match);
    }
    public ArrayList<Matches> getMatchesList(){
        return matches;
    }
}

