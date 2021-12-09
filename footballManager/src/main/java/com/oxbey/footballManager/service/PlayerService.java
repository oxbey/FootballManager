package com.oxbey.footballManager.service;

import com.oxbey.footballManager.entity.ClubEntity;
import com.oxbey.footballManager.entity.PlayerEntity;
import com.oxbey.footballManager.exception.ClubNotFoundException;
import com.oxbey.footballManager.exception.NotEnoughBudgetException;
import com.oxbey.footballManager.exception.PlayerNotFoundException;
import com.oxbey.footballManager.repository.ClubRepository;
import com.oxbey.footballManager.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    ClubRepository clubRepository;

    private Integer transferValue (PlayerEntity playerEntity){
        LocalDate now = LocalDate.now();
        int y = now.getYear() - playerEntity.getStartCareer().getYear();
        int m = now.getMonthValue() - playerEntity.getStartCareer().getMonthValue();
        if (m < 0) {
            return ((y - 1) * 12 + m * (-1))*100000/playerEntity.getAge();
        } else
            return (y * 12 + m) * 100000/playerEntity.getAge();
    }

    public PlayerEntity transferOperation(Long playerId, Long newClubId){
        PlayerEntity player = findById(playerId);
        ClubEntity previousClub = player.getClub();
        ClubEntity newClub = clubRepository.findById(newClubId)
                .orElseThrow(()-> new ClubNotFoundException("Club with id" + newClubId + " not found"));
        Integer transferValueWithClubCommission = player.getTransferPrice() * (1 + previousClub.getCommission()/100);
        if ((newClub.getBudget() - transferValueWithClubCommission) > 0) {
            previousClub.setBudget(transferValueWithClubCommission + previousClub.getBudget());
            newClub.setBudget(newClub.getBudget() - transferValueWithClubCommission);
        } else throw new NotEnoughBudgetException("Transfer value with " + previousClub.getName() +
                " commission bigger than budget of " + newClub.getName());
        player.setClub(newClub);
        return playerRepository.save(player);
    }

    public PlayerEntity addPlayer (PlayerEntity playerEntity, Long clubId){
            ClubEntity club = clubRepository.findById(clubId).get();
            playerEntity.setClub(club);
            playerEntity.setTransferPrice(transferValue(playerEntity));
        return playerRepository.save(playerEntity);
    }

    public PlayerEntity updatePlayer(Long id, PlayerEntity playerEntity){
        PlayerEntity player = playerRepository.findById(id).get();
        player.setFirstName(playerEntity.getFirstName());
        player.setLastName(playerEntity.getLastName());
        player.setAge(playerEntity.getAge());
        player.setStartCareer(playerEntity.getStartCareer());
        return playerRepository.save(player);
    }

    public List<PlayerEntity> findAllPlayers(){
        return playerRepository.findAll();
    }

    public PlayerEntity findById(Long id){
        return playerRepository.findPlayerEntityById(id)
                .orElseThrow(()-> new PlayerNotFoundException("Player with id" + id + " exists"));
    }

    public void deletePlayerById(Long id){
        playerRepository.deleteById(id);
    }
}
