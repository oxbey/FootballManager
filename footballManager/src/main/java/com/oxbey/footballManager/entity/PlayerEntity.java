package com.oxbey.footballManager.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate startCareer;
    private Integer transferPrice;
    @ManyToOne
    private ClubEntity club;

    public PlayerEntity() {
    }

    public PlayerEntity(String firstName, String lastName, Integer age, LocalDate startCareer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.startCareer = startCareer;
    }
}
