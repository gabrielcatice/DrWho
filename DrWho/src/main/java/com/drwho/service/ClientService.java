package com.drwho.service;

import com.drwho.domain.Client;
import com.drwho.dao.jpa.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private static final  Logger log = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private  ClientRepository clientRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public ClientService(){

    }

    public  Client createClient(Client client){
        return clientRepository.save(client);
    }
    public Client getClient(long id) {
        return clientRepository.findOne(id);
    }
    public void updateClient(Client client){
        clientRepository.save(client);
    }
    public void deleteClient(Long id){
        clientRepository.delete(id);
    }

    public Page<Client> getAllClients(Integer page, Integer size){
        Page pageOfClients = clientRepository.findAll(new PageRequest(page, size));
        if (size > 50) {
            counterService.increment("DrWho.ClientService.getAll.largePayload");
        }
        return pageOfClients;
    }
}
