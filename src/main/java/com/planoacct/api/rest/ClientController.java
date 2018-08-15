package com.planoacct.api.rest;

import com.planoacct.api.model.Client;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @RequestMapping(value="{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Client getClient(@PathVariable("id") String id) {
        return null;
    }
}
