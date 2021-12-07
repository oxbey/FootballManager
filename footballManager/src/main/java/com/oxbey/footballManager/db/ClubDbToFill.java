package com.oxbey.footballManager.db;

import com.oxbey.footballManager.entity.ClubEntity;
import com.oxbey.footballManager.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClubDbToFill implements CommandLineRunner {
    @Autowired
    ClubRepository clubRepository;
    @Override
    public void run(String... args) throws Exception {
        List<ClubEntity> clubEntityList = new ArrayList<>(){{
            add(new ClubEntity("Dynamo", "Kyiv", "Ukraine", 1145654, 4));
            add(new ClubEntity("Shakhtar", "Donetsk", "Ukraine", 2345654, 6));
            add(new ClubEntity("Real", "Madrid", "Spain", 10145654, 10));
        }};
        clubRepository.saveAll(clubEntityList);
    }
}
