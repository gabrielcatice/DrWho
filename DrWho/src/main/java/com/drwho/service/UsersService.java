package com.drwho.service;

import com.drwho.dao.jpa.UsersRepository;
import com.drwho.domain.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private static final  Logger log = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private  UsersRepository usersRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public UsersService(){

    }

    public Users createUsers(Users users){
        return usersRepository.save(users);
    }
    public Users getUsers(long id) { return usersRepository.findOne(id); }
    public void updateUsers(Users users){
        usersRepository.save(users);
    }
    public void deleteUsers(Long id){ usersRepository.delete(id); }

    public Page<Users> getAllUserss(Integer page, Integer size){
        Page pageOfUserss = usersRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            counterService.increment("DrWho.UsersService.getAll.largePayload");
        }
        return pageOfUserss;
    }
}
