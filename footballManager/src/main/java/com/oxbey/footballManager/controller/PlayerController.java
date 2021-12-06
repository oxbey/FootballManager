package com.oxbey.footballManager.controller;

import com.oxbey.footballManager.entity.PlayerEntity;
import com.oxbey.footballManager.model.Player;
import com.oxbey.footballManager.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/add")
    public ResponseEntity<PlayerEntity> addPlayer(@RequestBody PlayerEntity playerEntity,
                                                  @RequestParam Long clubId) {
        PlayerEntity player = playerService.addPlayer(playerEntity, clubId);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<PlayerEntity> updatePlayer(@RequestParam Long id,
                                                     @RequestBody PlayerEntity playerEntity) {
        PlayerEntity player = playerService.updatePlayer(id, playerEntity);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerEntity>> getAll() {
        List<PlayerEntity> playerEntityList = playerService.findAllPlayers();
        return new ResponseEntity<>(playerEntityList, HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity<PlayerEntity> getOneById(Long id) {
        PlayerEntity player = playerService.findById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByPlayerId(@PathVariable Long id) {
        playerService.deletePlayerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<PlayerEntity> transferOperation(@RequestParam Long playerId,
                                                          @RequestParam Long newClubId) {
        PlayerEntity player = playerService.transferOperation(playerId, newClubId);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
