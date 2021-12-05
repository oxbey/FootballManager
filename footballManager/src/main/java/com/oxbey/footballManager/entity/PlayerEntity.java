package com.oxbey.footballManager.entity;


import lombok.Data;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @JsonbDateFormat("yyyy MM dd")
    private LocalDate startCareer;
    private Integer transferPrice;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubEntity club;

    public PlayerEntity() {
    }

    public PlayerEntity(String firstName,
                        String lastName,
                        Integer age,
                        LocalDate startCareer,
                        Integer transferPrice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.startCareer = startCareer;
        this.transferPrice = transferPrice;
    }

    public PlayerEntity(String firstName, String lastName, Integer age, LocalDate startCareer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.startCareer = startCareer;
    }
}
