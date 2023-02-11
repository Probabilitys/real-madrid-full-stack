package com.liamguan.realmadrid.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liamguan.realmadrid.model.Player;
import com.liamguan.realmadrid.repository.PlayerRepository;
import com.liamguan.realmadrid.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
    private final PlayerRepository playerRepository;
    private final PlayerService playerService;

    private final String PLAYER_JSON = "/data/players.json";

    public DataLoader(
            PlayerRepository playerRepository,
            PlayerService playerService
    ) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
    }

    private void loadPlayerData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<PlayerData>> playerTypeReference
                = new TypeReference<List<PlayerData>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream(PLAYER_JSON);
        List<PlayerData> players = mapper.readValue(inputStream, playerTypeReference);

        if (players != null && !players.isEmpty()) {
            List<Player> playerList = new ArrayList<>();
            players.forEach(player -> playerList.add(
                    new Player(player.getName(),player.getBirthDate(),
                            player.getPosition(),player.getNumber())));
            playerService.savePlayerList(playerList);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("loading player data...");
        try {
            loadPlayerData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
