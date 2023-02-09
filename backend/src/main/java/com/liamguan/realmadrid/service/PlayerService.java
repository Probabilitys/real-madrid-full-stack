package com.liamguan.realmadrid.service;

import com.liamguan.realmadrid.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    public List<Player> getAllPlayers();

    public Player savePlayer(Player player);

    public Optional<Player> findPlayerById(long id);

    public String deletePlayerById(long id);

    public List<Player> savePlayerList(List<Player> playerList);
}
