package com.drwho.api.rest;

import com.drwho.domain.Users;
import com.drwho.service.UsersService;
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
@RequestMapping(value = "v1/allUsers")
@Api(value = "allUsers", description = "DrWho API")
public class UsersController extends AbstractRestHandler {

    @Autowired
    private UsersService usersService;

    //save a users
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Created a users resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createUsers(@RequestBody Users users,
                            HttpServletRequest request, HttpServletResponse response){
        Users createdUsers= this.usersService.createUsers(users);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdUsers.getId()).toString());

    }

    //retrieve all the users
    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all users", notes = "The list is paginated. You can provide a page number (default o) and a page size (default 100)")

    public
    @ResponseBody
    Page<Users> getAllUserss(@ApiParam(value = "The page number (zero-based)", required = true)
                             @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                             @ApiParam(value = "The page size", required = true)
                             @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                             HttpServletRequest request, HttpServletResponse reponse){
        return this.usersService.getAllUserss(page, size);

    }

    // retrieve a specific users
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single users.", notes = "You have to provide a valid users ID.")
    public
    @ResponseBody
    Users getUsers(@ApiParam(value = "The ID of the users.", required = true)
                   @PathVariable("id") Long id,
                   HttpServletRequest request, HttpServletResponse response) throws Exception{
        Users users = this.usersService.getUsers(id);
        checkResourceFound(users);
        return users;
    }
}
