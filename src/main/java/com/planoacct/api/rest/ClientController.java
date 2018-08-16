package com.planoacct.api.rest;

import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import com.planoacct.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Client getClient(@PathVariable("id") String id) {
        return clientService.getClientById(Long.parseLong(id));
    }

    @RequestMapping(value="", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Client> getAllClientsByType(@RequestParam(value = "type") ClientType type) {
        return clientService.getAllClientsByType(type);
    }

    @RequestMapping(value="", method=RequestMethod.POST, produces="application/json")
    public @ResponseBody Client addClient(@RequestBody Client newClient) {
        return clientService.addNewClient(newClient);
    }
}
