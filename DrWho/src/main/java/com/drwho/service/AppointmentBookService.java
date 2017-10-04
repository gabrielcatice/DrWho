package com.drwho.service;

import com.drwho.dao.jpa.AppointmentBookRepository;
import com.drwho.domain.AppointmentBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AppointmentBookService {

    private static final  Logger log = LoggerFactory.getLogger(AppointmentBookService.class);

    @Autowired
    private  AppointmentBookRepository appointmentBookRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public AppointmentBookService(){

    }

    public AppointmentBook createAppointmentBook(AppointmentBook appointmentBook){


        return appointmentBookRepository.save(appointmentBook);
    }
    public AppointmentBook getAppointmentBook(long id) { return appointmentBookRepository.findOne(id); }

    public void updateAppointmentBook(AppointmentBook appointmentBook){
        appointmentBookRepository.save(appointmentBook);
    }
    public void deleteAppointmentBook(Long id){ appointmentBookRepository.delete(id); }

    public Page<AppointmentBook> getAllAppointmentBooks(Integer page, Integer size){
        Page pageOfAppointmentBooks = appointmentBookRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            counterService.increment("DrWho.AppointmentBookService.getAll.largePayload");
        }
        return pageOfAppointmentBooks;
    }
}
