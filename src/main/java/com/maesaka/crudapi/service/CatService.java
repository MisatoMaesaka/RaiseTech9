package com.maesaka.crudapi.service;

import com.maesaka.crudapi.entity.Cat;

import java.util.List;

public interface CatService {
    List<Cat> findAll();

}
