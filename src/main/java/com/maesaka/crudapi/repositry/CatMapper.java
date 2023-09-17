package com.maesaka.crudapi.repositry;

import com.maesaka.crudapi.entity.Cat;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CatMapper {

    @Select("SELECT * FROM cats")
    List<Cat> findAll();

    @Select("SELECT * FROM cats WHERE id = #{id}")
    Optional<Cat> findCatId(int id);

    @Insert("INSERT INTO cats(id, name, age, favorite_snack) VALUES(#{id}, #{name}, #{age}, #{favoriteSnack})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertCat(Cat cat);

    @Update("UPDATE cats SET name = #{name}, age = #{age},  favorite_snack = #{favoriteSnack} WHERE id = #{id}")
    void updateCat(Cat cat);

    @Delete("DELETE FROM cats WHERE id = #{id}")
    void deleteCat(int id);
}
