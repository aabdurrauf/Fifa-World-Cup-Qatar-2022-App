package com.example.spormusabakatakipuygulamasi;

import java.util.ArrayList;

public class Coach extends Person implements Information{
    private String takim;
    private ArrayList<String> kupalar = new ArrayList<>();
    private CoachInfoPane infoPane;

    Coach(String name){
        super(name);
    }
    public void setTakim(String takim){
        this.takim = takim;
    }
    public void addKupalar(String kupa){
        this.kupalar.add(kupa);
    }
    public String getTakim(){
        return this.takim;
    }
    public CoachInfoPane getInfoPane(){
        return this.infoPane;
    }
    public ArrayList<String> getKupalar(){
        return this.kupalar;
    }


    @Override
    public void makeInfoPane() {
        try {
            infoPane = new CoachInfoPane(this, country.getCountryName());
        }
        catch (NullPointerException e){
            infoPane = new CoachInfoPane(this, "");
            System.out.println("Kadro bilgileri bulunmuyor");
        }
    }
}
