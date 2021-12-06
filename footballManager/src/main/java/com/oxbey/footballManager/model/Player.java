package com.oxbey.footballManager.model;

import com.oxbey.footballManager.entity.ClubEntity;
import com.oxbey.footballManager.entity.PlayerEntity;
import lombok.Data;

import java.time.LocalDate;
@Data
public class Player {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate startCareer;
    private Integer transferPrice;

    public static Player toModel(PlayerEntity entity) {
        Player model = new Player();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setAge(entity.getAge());
        model.setStartCareer(entity.getStartCareer());
        model.setTransferPrice(entity.getTransferPrice());
        return model;
    }

    public Player() {
    }
}
