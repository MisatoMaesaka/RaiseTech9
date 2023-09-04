package com.maesaka.crudapi.controller.form;

// 反映されないので解消したい

import jakarata.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class CatUpdateForm {
    @NotEmpty(message = "必須入力です")
    private String name;

    @Range(in = 0, max = 30, message = "Please age must be between 0 and 30")
    private int age;

    @NotEmpty(message = "Please provide a favorite snack")
    private String favoriteSnack;

    public CatUpdateForm(String name, int age, String favoriteSnack) {
        this.name = name;
        this.age = age;
        this.favoriteSnack = favoriteSnack;
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
