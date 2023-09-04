package com.maesaka.crudapi.controller.response;

import com.maesaka.crudapi.entity.Cat;

public class CatResponse {

    private String name;
    private String favoriteSnack;

    public CatResponse(Cat cat) {
        this.name = cat.getName();
        this.favoriteSnack = cat.getFavoriteSnack();
    }

    public String getName() {
        return name;
    }

    public String getFavoriteSnack() {
        return favoriteSnack;
    }
}
