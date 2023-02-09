package com.liamguan.realmadrid.service;

import com.liamguan.realmadrid.model.Player;
import com.liamguan.realmadrid.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Transactional(readOnly = false)
    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Transactional(readOnly = false)
    @Override
    public List<Player> savePlayerList(List<Player> playerList) {
        return playerRepository.saveAll(playerList);
    }


    @Override
    public Optional<Player> findPlayerById(long id) {
        return playerRepository.findById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public String deletePlayerById(long id) {
        playerRepository.deleteById(id);
        return "delete player with id:" + id;
    }

}
