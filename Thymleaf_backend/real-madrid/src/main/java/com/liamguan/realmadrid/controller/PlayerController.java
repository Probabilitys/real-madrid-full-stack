package com.liamguan.realmadrid.controller;

import com.liamguan.realmadrid.model.Player;
import com.liamguan.realmadrid.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("playerList", playerService.getAllPlayers());
        return "index";
    }

    @GetMapping("/show-add-player-form")
    public String showAddPlayerForm(Model model) {
        Player player = new Player();
        model.addAttribute("player", player);
        return "new_player";
    }

    @GetMapping(value = "/get-player/{id}")
    public Player getPlayerById(@PathVariable long id) {
        return playerService.findPlayerById(id);
    }

    @GetMapping(value = "/get-all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping(value = "/save-player")
    public String savePlayer(@ModelAttribute("player") Player player) {
        playerService.savePlayer(player);
        return "redirect:/";
    }

    @GetMapping(value = "/update-player/{id}")
    public String updatePlayer(@PathVariable (value = "id") long id, Model model) {
        Player player = playerService.findPlayerById(id);
        model.addAttribute("player", player);
        return "update_player";
    }

    @GetMapping(value = "/delete-player/{id}")
    public String deletePlayer(@PathVariable long id) {
        playerService.deletePlayerById(id);
        return "redirect:/";
    }

}
