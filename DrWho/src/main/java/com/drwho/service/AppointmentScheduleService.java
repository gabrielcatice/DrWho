package com.drwho.service;


import com.drwho.dao.jpa.AppointmentScheduleRepository;
import com.drwho.domain.AppointmentSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class AppointmentScheduleService {

    private static final  Logger log = LoggerFactory.getLogger(AppointmentSchedule.class);

    @Autowired
    private AppointmentScheduleRepository appointmentScheduleRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public AppointmentScheduleService(){

    }

    public AppointmentSchedule createAppointmentSchedule(AppointmentSchedule appointmentSchedule){
        return appointmentScheduleRepository.save(appointmentSchedule);
    }

    public AppointmentSchedule getAppointmentSchedule(long id){
        return appointmentScheduleRepository.findOne(id);
    }

    public void updateAppointmentSchedule(AppointmentSchedule appointmentSchedule){
        appointmentScheduleRepository.save(appointmentSchedule);
    }

    public void deleteAppointmentSchedule(Long id){
        appointmentScheduleRepository.delete(id);
    }

    public Page<AppointmentSchedule> getAllAppointmentDates(Integer page, Integer size){
        Page pageOfAppointmentDates = appointmentScheduleRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            counterService.increment("DrWho.AppointmentScheduleService.getAll.largePayload");
        }
        return pageOfAppointmentDates;
    }


}
