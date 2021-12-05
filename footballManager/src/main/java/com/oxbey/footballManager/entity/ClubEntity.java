package com.oxbey.footballManager.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class ClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer budget;
    @Column(unique = true)
    private String name;
    private String country;
    private String city;
    @OneToMany(mappedBy = "club")
    private List<PlayerEntity> players;

    public ClubEntity() {
    }

    public ClubEntity(Integer budget, String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.budget = budget;
    }
}

