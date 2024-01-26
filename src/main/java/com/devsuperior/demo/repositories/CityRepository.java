package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT obj FROM City obj "
            + "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%')) "
            + "ORDER BY obj.name")
    List<City> searchByName(String name);
}
