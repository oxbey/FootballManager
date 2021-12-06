package com.oxbey.footballManager.controller;

import com.oxbey.footballManager.entity.ClubEntity;
import com.oxbey.footballManager.model.Club;
import com.oxbey.footballManager.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    ClubService clubService;

    @PostMapping("/add")
    public ResponseEntity<ClubEntity> addClub(@RequestBody ClubEntity clubEntity){
        ClubEntity club = clubService.addClub(clubEntity);
        return new ResponseEntity<>(club, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<ClubEntity> updateClub(@RequestParam Long id, @RequestBody ClubEntity clubEntity){
        ClubEntity club = clubService.updateClub(id, clubEntity);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClubEntity>> getAll(){
        List<ClubEntity> clubEntityList = clubService.findAll();
        return new ResponseEntity<>(clubEntityList,HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity<ClubEntity> getOne(Long id){
        ClubEntity club = clubService.findOnById(id);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClubId(@PathVariable Long id){
        clubService.deleteClubById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
