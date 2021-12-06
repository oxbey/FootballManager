package com.oxbey.footballManager.model;

import com.oxbey.footballManager.entity.ClubEntity;
import com.oxbey.footballManager.entity.PlayerEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class Club {
    private Long id;
    private Integer budget;
    private String name;
    private String country;
    private String city;
    private List<Player> players;

    public static Club toModel(ClubEntity entity){
        Club model = new Club();
        model.setId(entity.getId());
        model.setBudget(entity.getBudget());
        model.setName(entity.getName());
        model.setCountry(entity.getCountry());
        model.setCity(entity.getCity());
        model.setPlayers(entity.getPlayers().stream().map(Player::toModel).collect(Collectors.toList()));
        return model;
    }

    public Club() {
    }
}
