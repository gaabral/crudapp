package com.gaba.dtos;

import com.gaba.database.entity.Sex;
import lombok.Data;

@Data
public class FishDTO {
    String name;
    String specie;
    String color;
    Sex sex;
}
