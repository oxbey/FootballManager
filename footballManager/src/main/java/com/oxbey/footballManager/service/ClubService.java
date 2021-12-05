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

    public List<ClubEntity> findAll(){
        return clubRepository.findAll();
    }

//    public ClubEntity updateClub(ClubEntity){
//
//    }
}
