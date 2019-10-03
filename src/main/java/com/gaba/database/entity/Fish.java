package com.gaba.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fish")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "fishName")
    String name;
    String specie;
    String color;
    Sex sex;
    String favouriteFood;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Fish_Disease",
            joinColumns = { @JoinColumn(name = "fish_id") },
            inverseJoinColumns = { @JoinColumn(name = "disease_id") }
    )
    Set<Disease> diseases = new HashSet<>();

}
