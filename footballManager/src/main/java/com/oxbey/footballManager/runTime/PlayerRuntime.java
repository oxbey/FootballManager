//package com.oxbey.footballManager.runTime;
//
//import com.oxbey.footballManager.entity.PlayerEntity;
//import com.oxbey.footballManager.repository.PlayerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class PlayerRuntime implements CommandLineRunner {
//    @Autowired
//    PlayerRepository playerRepository;
//    @Override
//    public void run(String... args) throws Exception {
//        List<PlayerEntity> playerEntityList = new ArrayList<>(){{
//            add(new PlayerEntity("Vitali", "Mykolenko", 22, LocalDate.of(2020, Month.JANUARY, 18)));
//        }};
//    }
//}
