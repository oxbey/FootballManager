package com.oxbey.footballManager.db;

import com.oxbey.footballManager.entity.PlayerEntity;
import com.oxbey.footballManager.repository.PlayerRepository;
import com.oxbey.footballManager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerDbToFill implements CommandLineRunner {
    @Autowired
    PlayerService playerService;
    @Override
    public void run(String... args) throws Exception {
        List<PlayerEntity> playerEntityList = new ArrayList<>(){{
            add(new PlayerEntity("Viktor", "Tsygankov", 24, LocalDate.of(2015, Month.MARCH, 10)));
            add(new PlayerEntity("Vitali", "Mykolenko", 22, LocalDate.of(2017,Month.DECEMBER, 20)));
            add(new PlayerEntity("Mykola", "Shaparenko", 23, LocalDate.of(2017, Month.MARCH, 12)));
        }};
        playerEntityList.forEach((player)->playerService.addPlayer(player, 2L));

        List<PlayerEntity> playerEntityList1 = new ArrayList<>(){{
            add(new PlayerEntity("Taras", "Stepanenko", 32, LocalDate.of(2007, Month.MARCH, 14)));
            add(new PlayerEntity("Mykhailo", "Mydruk", 20, LocalDate.of(2017,Month.DECEMBER, 21)));
        }};
        playerEntityList.forEach((player)->playerService.addPlayer(player, 1L));
        playerEntityList1.forEach((player)->playerService.addPlayer(player, 2L));
    }
}
