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

    //retrieve all the clients
    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all clients", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    Page<Client> getAllClient(@ApiParam(value = "The page number (zero-based)", required = true)
                              @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                              @ApiParam(value = "The page size", required = true)
                              @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                              HttpServletRequest request, HttpServletResponse response) {
        return this.clientService.getAllClients(page, size);

    }

    //retrieve a specific client
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single client.", notes = "You have to provide a valid hotel ID.")
    public
    @ResponseBody
    Client getClient(@ApiParam(value = "The ID of the client.", required = true)
                     @PathVariable("id") Long id,
                     HttpServletRequest request, HttpServletResponse response) throws Exception{
        Client client = this.clientService.getClient(id);
        checkResourceFound(client);
        return client;
    }
}

