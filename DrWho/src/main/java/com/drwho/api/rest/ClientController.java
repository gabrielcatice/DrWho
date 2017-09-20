package com.drwho.api.rest;

import com.drwho.domain.Client;
import com.drwho.exception.DataFormatException;
import com.drwho.service.ClientService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/v1/users")
@Api(value = "users", description = "DrWho API")
public class ClientController extends AbstractRestHandler {

    @Autowired
    private ClientService clientService;

    //save a client
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a client resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createClient(@RequestBody Client client,
                                    HttpServletRequest request, HttpServletResponse response) {
        Client createdClient = this.clientService.createClient(client);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdClient.getId()).toString());
    }

}

