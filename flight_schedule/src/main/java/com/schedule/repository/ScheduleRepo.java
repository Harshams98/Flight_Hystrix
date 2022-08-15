package com.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schedule.entity.Schedule;


//specifies the extension of repository --- JPA
public interface ScheduleRepo extends JpaRepository<Schedule,Integer>{

}
