package com.liamguan.realmadrid.controller;

import com.liamguan.realmadrid.model.Player;
import com.liamguan.realmadrid.model.Schedule;
import com.liamguan.realmadrid.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(value = "/get-schedule/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable long id) {
        Optional<Schedule> optionalSchedule = scheduleService.findScheduleById(id);
        if (optionalSchedule.isPresent()) {
            Schedule Schedule = optionalSchedule.get();
            return new ResponseEntity<>(Schedule, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/get-all-schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @PostMapping(value = "/create-schedule")
    public ResponseEntity<Schedule> createSchedule(@RequestBody Schedule Schedule) {
        try {
            Schedule createdSchedule = scheduleService.saveSchedule(Schedule);
            return new ResponseEntity<>(createdSchedule, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping(value = "/update-schedule/{id}")
    public ResponseEntity<Schedule> updateSchedule(
            @PathVariable long id,
            @RequestBody Schedule schedule
    ) {
        Optional<Schedule> optSchedule = scheduleService.findScheduleById(id);
        if (optSchedule.isPresent()) {
            Schedule newSchedule = optSchedule.get();
            newSchedule.setHome(schedule.getHome());
            newSchedule.setAway(schedule.getAway());
            newSchedule.setDate(schedule.getDate());

            Schedule updatedSchedule = scheduleService.saveSchedule(newSchedule);
            return new ResponseEntity<Schedule>(updatedSchedule, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete-schedule/{id}")
    public ResponseEntity<HttpStatus> deleteSchedule(@PathVariable long id) {
        try {
            scheduleService.deleteScheduleById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
