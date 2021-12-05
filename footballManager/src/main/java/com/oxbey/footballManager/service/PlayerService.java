package com.oxbey.footballManager.service;

import com.oxbey.footballManager.PlayerNotFoundException;
import com.oxbey.footballManager.entity.PlayerEntity;
import com.oxbey.footballManager.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    private Integer transferValue (PlayerEntity playerEntity){
        LocalDate now = LocalDate.now();
        int y = now.getYear() - playerEntity.getStartCareer().getYear();
        int m = now.getMonthValue() - playerEntity.getStartCareer().getMonthValue();
        if (m < 0) {
            return ((y - 1) * 12 + m * (-1))*100000/playerEntity.getAge();
        } else
            return (y * 12 + m) * 100000/playerEntity.getAge();
    }

    public PlayerEntity addPlayer (PlayerEntity playerEntity){
        playerEntity.setTransferPrice(transferValue(playerEntity));
        return playerRepository.save(playerEntity);
    }

    public PlayerEntity updatePlayer(PlayerEntity playerEntity){
        return playerRepository.save(playerEntity);
    }

    public List<PlayerEntity> findAllPlayers(){
        return playerRepository.findAll();
    }

    public PlayerEntity findById(Long id){
        return playerRepository.findPlayerEntityById(id)
                .orElseThrow(()-> new PlayerNotFoundException("Player with id" + id + " exists"));
    }

    public PlayerEntity findByFirstName(String firstName){
        return playerRepository.findPlayerEntityByFirstName(firstName)
                .orElseThrow(()-> new PlayerNotFoundException("Player with first name" + firstName + " exists"));
    }

    public PlayerEntity findBySecondName(String lastName){
        return playerRepository.findPlayerEntityByLastName(lastName)
                .orElseThrow(()-> new PlayerNotFoundException("Player with last name" + lastName + " exists"));
    }

    public void deletePlayerById(Long id){
        playerRepository.deleteById(id);
    }

    public void deletePlayerByFirstName(String firstName){
        playerRepository.deletePlayerEntityByFirstName(firstName);
    }

    public void deletePlayerBySecondName(String lastName){
        playerRepository.deletePlayerEntityByLastName(lastName);
    }

}
