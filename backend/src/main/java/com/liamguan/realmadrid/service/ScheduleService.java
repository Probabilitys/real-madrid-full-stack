package com.liamguan.realmadrid.service;

import com.liamguan.realmadrid.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    public List<Schedule> getAllSchedules();

    public Schedule saveSchedule(Schedule schedule);

    public Optional<Schedule> findScheduleById(long id);

    public String deleteScheduleById(long id);

    public List<Schedule> saveScheduleList(List<Schedule> scheduleList);
}
