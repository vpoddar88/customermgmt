package com.planoacct.api.data;

import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAllByClientType(ClientType clientType);
}
