package com.drwho.api.rest;

import com.drwho.domain.AppointmentBook;
import com.drwho.exception.DataFormatException;
import com.drwho.service.AppointmentBookService;
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
@RequestMapping(value = "v1/appointmentsBook")
@Api(value = "appointmentBooks", description = "DrWho API")
public class AppointmentBookController extends AbstractRestHandler {

    @Autowired
    private AppointmentBookService appointmentBookService;

    //save a appointmentBook
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Created a appointmentBook resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createAppointmentBook(@RequestBody AppointmentBook appointmentBook,
                                      HttpServletRequest request, HttpServletResponse response){
        AppointmentBook createdAppointmentBook= this.appointmentBookService.createAppointmentBook(appointmentBook);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdAppointmentBook.getId()).toString());

    }

    //retrieve all the appointmentBooks
    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all appointmentBooks", notes = "The list is paginated. You can provide a page number (default o) and a page size (default 100)")

    public
    @ResponseBody
    Page<AppointmentBook> getAllAppointmentBooks(@ApiParam(value = "The page number (zero-based)", required = true)
                                                 @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                 @ApiParam(value = "The page size", required = true)
                                                 @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                 HttpServletRequest request, HttpServletResponse reponse){
        return this.appointmentBookService.getAllAppointmentBooks(page, size);

    }

    // retrieve a specific appointmentBook
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single appointmentBook.", notes = "You have to provide a valid appointmentBook ID.")
    public
    @ResponseBody
    AppointmentBook getAppointmentBook(@ApiParam(value = "The ID of the appointmentBook.", required = true)
                                       @PathVariable("id") Long id,
                                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        AppointmentBook appointmentBook = this.appointmentBookService.getAppointmentBook(id);
        checkResourceFound(appointmentBook);
        return appointmentBook;
    }
}
