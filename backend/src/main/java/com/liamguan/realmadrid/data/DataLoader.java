package com.liamguan.realmadrid.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liamguan.realmadrid.model.Player;
import com.liamguan.realmadrid.model.Schedule;
import com.liamguan.realmadrid.repository.PlayerRepository;
import com.liamguan.realmadrid.service.PlayerService;
import com.liamguan.realmadrid.service.ScheduleService;
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
    private final PlayerService playerService;
    private final ScheduleService scheduleService;

    private final String PLAYER_JSON = "/data/players.json";
    private final String SCHEDULE_JSON = "/data/schedules.json";

    public DataLoader(
            PlayerService playerService,
            ScheduleService scheduleService
    ) {
        this.playerService = playerService;
        this.scheduleService = scheduleService;
    }

    private void loadPlayerData() throws Exception {
        logger.info("loading player data...");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<PlayerData>> playerTypeReference
                = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream(PLAYER_JSON);
        List<PlayerData> players = mapper.readValue(inputStream, playerTypeReference);

        if (players != null && !players.isEmpty()) {
            List<Player> playerList = new ArrayList<>();
            players.forEach(player -> playerList.add(
                    new Player(player.getName(), player.getBirthDate(),
                            player.getPosition(), player.getNumber())));
            playerService.savePlayerList(playerList);
        }
    }

    private void loadScheduleData() throws Exception {
        logger.info("loading schedule data...");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ScheduleData>> scheduleTypeReference
                = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream(SCHEDULE_JSON);
        List<ScheduleData> schedules = mapper.readValue(inputStream, scheduleTypeReference);

        if (schedules != null && !schedules.isEmpty()) {
            List<Schedule> scheduleList = new ArrayList<>();
            schedules.forEach(schedule -> scheduleList.add(
                    new Schedule(schedule.getHome(), schedule.getAway(),
                            schedule.getDate())));
            scheduleService.saveScheduleList(scheduleList);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            loadPlayerData();
            loadScheduleData();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
