package com.example.spormusabakatakipuygulamasi;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Coach extends Person{
    String takim;
    ArrayList<String> kupalar = new ArrayList<>();

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
    public ArrayList<String> getKupalar(){
        return this.kupalar;
    }
}
