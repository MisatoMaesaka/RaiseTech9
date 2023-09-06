package com.maesaka.crudapi.repositry;

import com.maesaka.crudapi.entity.Cat;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CatMapper {

    @Select("SELECT * FROM cats")
    List<Cat> findAll();

    @Select("SELECT * FROM cats WHERE id = #{id}")
    Optional<Cat> findCatId(int id);

    @Insert("INSERT INTO cats(id, name, age, favoriteSnack) VALUES(#{id}, #{name}, #{age}, #{favoriteSnack})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertCat(Cat cat);

    @Update("UPDATE cats SET name = #{name}, age = #{age},  favoriteSnack = #{favoriteSnack} WHERE id = #{id}")
    void updateCat(Cat cat);

    @Delete("DELETE FROM cats WHERE id = #{id}")
    void deleteCat(int id);
}
