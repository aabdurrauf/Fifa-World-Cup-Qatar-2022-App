package com.example.spormusabakatakipuygulamasi;

public abstract class Person {
    protected String name;
    protected String nationality;
    protected int age;

    protected Person(String name, String nationality, int age){
        this.name = name;
        this.nationality = nationality;
        this.age = age;
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
}
