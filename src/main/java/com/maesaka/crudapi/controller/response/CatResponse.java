package com.maesaka.crudapi.controller.response;

import com.maesaka.crudapi.entity.Cat;

public class CatResponse {

    private String name;
    private String favorite_snack;

    public CatResponse(Cat cat) {
        this.name = cat.getName();
        this.favorite_snack = cat.getFavorite_snack();
    }

    public String getName() {
        return name;
    }

    public String getFavorite_snack() {
        return favorite_snack;
    }
}
