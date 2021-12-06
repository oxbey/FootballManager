package com.oxbey.footballManager.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ClubEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer budget;
    private Integer commission;
//    @Column(unique = true)
    private String name;
    private String country;
    private String city;
    @OneToMany(mappedBy = "club")
    private List<PlayerEntity> players;

    public ClubEntity() {
    }

    public ClubEntity(String name,
                      String city,
                      String country,
                      Integer budget,
                      Integer commission
                      ) {
        this.budget = budget;
        this.commission = commission;
        this.name = name;
        this.country = country;
        this.city = city;
    }
}

