package com.planoacct.api.service;

import com.planoacct.api.data.ClientRepository;
import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getAllClientsByType(ClientType type) {
        return clientRepository.findAllByClientType(type);
    }

    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }
}
