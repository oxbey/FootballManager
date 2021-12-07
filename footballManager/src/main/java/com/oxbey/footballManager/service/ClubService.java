package com.oxbey.footballManager.service;

import com.oxbey.footballManager.entity.ClubEntity;
import com.oxbey.footballManager.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    ClubRepository clubRepository;

    public ClubEntity addClub(ClubEntity clubEntity){
        return clubRepository.save(clubEntity);
    }

    public ClubEntity updateClub(Long id, ClubEntity clubEntity){
        ClubEntity club = clubRepository.findById(id).get();
        club.setName(clubEntity.getName());
        club.setCity(clubEntity.getCity());
        club.setCountry(clubEntity.getCountry());
        club.setBudget(clubEntity.getBudget());
        club.setCommission(clubEntity.getCommission());
        return clubRepository.save(club);
    }

    public List<ClubEntity> findAll(){
        return clubRepository.findAll();
    }

    public ClubEntity findById(Long id){
        return clubRepository.findById(id).get();
    }

    public void deleteClubById(Long id){
        clubRepository.deleteById(id);
    }


}
