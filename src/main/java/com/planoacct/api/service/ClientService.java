package com.planoacct.api.service;

import com.planoacct.api.data.ClientRepository;
import com.planoacct.api.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }
}
