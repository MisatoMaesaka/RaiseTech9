package com.maesaka.crudapi.service;

import com.maesaka.crudapi.entity.Cat;
import com.maesaka.crudapi.repositry.CatMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
