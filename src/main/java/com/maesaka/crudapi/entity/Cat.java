package com.maesaka.crudapi.entity;

public class Cat {

    private int id;
    private String name;
    private int age;
    private String favorite_snack;

    public Cat(int id, String name, int age, String favorite_snack) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favorite_snack = favorite_snack;
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

    public String getFavorite_snack() {
        return favorite_snack;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFavorite_snack(String favorite_snack) {
        this.favorite_snack = favorite_snack;
    }
}
