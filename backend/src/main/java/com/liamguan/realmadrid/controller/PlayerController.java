package com.liamguan.realmadrid.controller;

import com.liamguan.realmadrid.model.Player;
import com.liamguan.realmadrid.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/player")
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/get-player/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable long id) {
        Optional<Player> optPlayer = playerService.findPlayerById(id);
        if (optPlayer.isPresent()) {
            Player player = optPlayer.get();
            return new ResponseEntity<>(player, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/get-all-players")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping(value = "/create-player")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        try {
            Player createdPlayer = playerService.savePlayer(player);
            return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(value = "/update-player/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable long id,
            @RequestBody Player player
    ) {
        Optional<Player> optPlayer = playerService.findPlayerById(id);
        if (optPlayer.isPresent()) {
            Player newPlayer = optPlayer.get();

            newPlayer.setName(player.getName());
            newPlayer.setBirthDate(player.getBirthDate());
            newPlayer.setPosition(player.getPosition());
            newPlayer.setNumber(player.getNumber());

            Player updatedPlayer = playerService.savePlayer(newPlayer);
            return new ResponseEntity<Player>(updatedPlayer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete-player/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable long id) {
        try {
            playerService.deletePlayerById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

}
