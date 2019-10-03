package com.gaba;

import com.gaba.database.dao.DiseaseRepository;
import com.gaba.database.dao.FishRepository;
import com.gaba.database.entity.Disease;
import com.gaba.database.entity.Fish;
import com.gaba.database.entity.Sex;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.Collections;

@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private FishRepository fishRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }

    @Override
    public void run(String... args)  {

        fishRepository.save(Fish.builder().color("purple").name("Bubba").specie("galaxy").sex(Sex.FEMALE).build());
        log.info("---------------------> Added new fish!");

        diseaseRepository.save(Disease.builder().name("ebola").infectious(true).lethal(true).typicalDuration((Duration.ofDays(5L))).build());
        log.info("---------------------> Added new disease!");
        Fish x = fishRepository.findById(1L).get();
        Disease y = diseaseRepository.findById(1L).get();
        fishRepository.save(x);
        log.info("---------------------> updated a fish!");


    }
}
