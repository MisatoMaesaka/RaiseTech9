package com.maesaka.crudapi.service;

import com.maesaka.crudapi.entity.Cat;

import java.util.List;

public interface CatService {
    List<Cat> findAll();

    Cat findCatId(int id);

    Cat createCat(Cat cat);

    void updateCat(int id, String name, int age, String favorite_snack);

    void deleteCat(int id);

}
