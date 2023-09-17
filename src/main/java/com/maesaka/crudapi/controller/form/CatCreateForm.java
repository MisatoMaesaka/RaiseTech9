package com.maesaka.crudapi.controller.form;

import com.maesaka.crudapi.entity.Cat;

public class CatCreateForm {

    private int id;
    private String name;
    private int age;
    private String favoriteSnack;

    public Cat convertToCat() {
        Cat cat = new Cat(id, name, age, favoriteSnack);
        return cat;
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
