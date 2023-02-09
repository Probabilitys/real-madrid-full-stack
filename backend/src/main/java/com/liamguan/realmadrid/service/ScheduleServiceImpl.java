package com.liamguan.realmadrid.service;

import com.liamguan.realmadrid.model.Schedule;
import com.liamguan.realmadrid.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository ScheduleRepository;

    @Override
    public List<Schedule> getAllSchedules() {
        return ScheduleRepository.findAll();
    }

    @Transactional(readOnly = false)
    @Override
    public Schedule saveSchedule(Schedule Schedule) {
        return ScheduleRepository.save(Schedule);
    }

    @Transactional(readOnly = false)
    @Override
    public List<Schedule> saveScheduleList(List<Schedule> ScheduleList) {
        return ScheduleRepository.saveAll(ScheduleList);
    }

    @Transactional(readOnly = false)
    @Override
    public Optional<Schedule> findScheduleById(long id) {
        return ScheduleRepository.findById(id);
    }

    @Transactional(readOnly = false)
    @Override
    public String deleteScheduleById(long id) {
        ScheduleRepository.deleteById(id);
        return "delete Schedule with id: " + id;
    }


}
