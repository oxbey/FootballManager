package com.oxbey.footballManager.db;

import com.oxbey.footballManager.entity.PlayerEntity;
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
        List<PlayerEntity> playerEntityList1 = new ArrayList<>(){{
            add(new PlayerEntity("Viktor", "Tsygankov", 24, LocalDate.of(2015, Month.MARCH, 10)));
            add(new PlayerEntity("Vitali", "Mykolenko", 22, LocalDate.of(2017,Month.DECEMBER, 20)));
            add(new PlayerEntity("Mykola", "Shaparenko", 23, LocalDate.of(2017, Month.MARCH, 12)));
        }};


        List<PlayerEntity> playerEntityList2 = new ArrayList<>(){{
            add(new PlayerEntity("Taras", "Stepanenko", 32, LocalDate.of(2007, Month.MARCH, 14)));
            add(new PlayerEntity("Mykhailo", "Mydruk", 20, LocalDate.of(2017,Month.DECEMBER, 21)));
            add(new PlayerEntity("Mykola", "Matvienko", 25, LocalDate.of(2012,Month.AUGUST, 9)));
        }};

        List<PlayerEntity> playerEntityList3 = new ArrayList<>(){{
            add(new PlayerEntity("Karin", "Benzema", 33, LocalDate.of(2004, Month.FEBRUARY, 4)));
            add(new PlayerEntity("Gareth", "Bale", 32, LocalDate.of(2005, Month.JUNE, 27)));
            add(new PlayerEntity("Luca", "Modric", 36, LocalDate.of(2000, Month.AUGUST, 17)));
        }};
        playerEntityList1.forEach((player)->playerService.addPlayer(player, 1L));
        playerEntityList2.forEach((player)->playerService.addPlayer(player, 2L));
        playerEntityList3.forEach((player)->playerService.addPlayer(player, 3L));
    }
}
