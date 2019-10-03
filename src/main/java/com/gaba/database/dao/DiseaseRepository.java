package com.gaba.database.dao;

import com.gaba.database.entity.Disease;
import org.springframework.data.repository.CrudRepository;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {


}
