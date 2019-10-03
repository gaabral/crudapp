package com.gaba.database.dao;

import com.gaba.database.entity.Fish;
import org.springframework.data.repository.CrudRepository;

public interface FishRepository extends CrudRepository<Fish, Long> {

    private String testMethod(){
        return "tescik";

    }
}
