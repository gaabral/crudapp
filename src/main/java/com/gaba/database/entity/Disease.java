package com.gaba.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disease")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "diseaseName")
    String name;
    boolean lethal;
    Duration typicalDuration;
    boolean infectious;
    @ManyToMany(mappedBy = "diseases", fetch = FetchType.EAGER)
    Set<Fish> sickFish = new HashSet<>();

}
