package com.maesaka.crudapi.entity;

public class Cat {

    private int id;
    private String name;
    private int age;
    private String favoriteSnack;

    public Cat(int id, String name, int age, String favoriteSnack) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favoriteSnack = favoriteSnack;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getFavoriteSnack() {
        return favoriteSnack;
    }
}
