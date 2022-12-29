package com.example.spormusabakatakipuygulamasi;

public abstract class Person {
    protected String name;
    protected String nationality;
    protected int age;
    protected Country country;

    protected Person(String name, String nationality, int age){
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }
    protected Person(String name){
        this.name = name;
    }
    Person(){}
    public void setName(String name){
        this.name = name;
    }
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCountry(Country country){
        this.country = country;
    }


    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getNationality(){
        return nationality;
    }
    public Country getCountry(){
        return country;
    }
}
