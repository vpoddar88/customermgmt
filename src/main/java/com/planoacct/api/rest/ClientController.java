package com.planoacct.api.rest;

import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import com.planoacct.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Client getClient(@PathVariable("id") String id) {
        return clientService.getClientById(Long.parseLong(id));
    }

    @RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody
    List<Client> getClients(@RequestParam(value = "type") ClientType type) {
        return clientService.getAllClientsByType(type);
    }
}
