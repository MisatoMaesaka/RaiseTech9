package com.maesaka.crudapi.controller.form;


import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class CatUpdateForm {
    @NotEmpty(message = "必須入力です")
    private String name;

    @Range(min = 0, max = 30, message = "Please age must be between 0 and 30")
    private int age;

    @NotEmpty(message = "Please provide a favorite snack")
    private String favorite_snack;

    public CatUpdateForm(String name, int age, String favorite_snack) {
        this.name = name;
        this.age = age;
        this.favorite_snack = favorite_snack;
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
}
