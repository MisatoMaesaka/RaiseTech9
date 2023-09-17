package com.maesaka.crudapi.service;

import com.maesaka.crudapi.entity.Cat;
import com.maesaka.crudapi.exception.ResourceNotFoundException;
import com.maesaka.crudapi.repositry.CatMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatServiceImpl implements CatService {

    private final CatMapper catMapper;

    public CatServiceImpl(CatMapper catMapper) {
        this.catMapper = catMapper;
    }

    @Override
    public List<Cat> findAll() {
        return catMapper.findAll();
    }

    @Override
    public Cat findCatId(int id) {
        Optional<Cat> cat = catMapper.findCatId(id);
        return cat.orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
    }

    @Override
    public Cat createCat(Cat cat) {
        catMapper.insertCat(cat);
        return cat;
    }

    @Override
    public void updateCat(int id, String name, int age, String favoriteSnack) {
        Cat cat = catMapper.findCatId(id).orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
        cat.setName(name);
        cat.setAge(age);
        cat.setFavoriteSnack(favoriteSnack);
        catMapper.updateCat(cat);
    }

    @Override
    public void deleteCat(int id) {
        catMapper.findCatId(id).orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
        catMapper.deleteCat(id);
    }
}

