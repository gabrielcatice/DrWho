package com.drwho.service;

import com.drwho.domain.Doctor;
import com.drwho.dao.jpa.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private static final  Logger log = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private  DoctorRepository doctorRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public DoctorService(){

    }

    public  Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public Doctor getDoctor(long id) {
        return doctorRepository.findOne(id);
    }
    public void updateDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }
    public void deleteDoctor(Long id){
        doctorRepository.delete(id);
    }

    public Page<Doctor> getAllDoctors(Integer page, Integer size){
        Page pageOfDoctors = doctorRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            counterService.increment("DrWho.DoctorService.getAll.largePayload");
        }
        return pageOfDoctors;
    }
}