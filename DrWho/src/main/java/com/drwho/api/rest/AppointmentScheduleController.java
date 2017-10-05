package com.drwho.api.rest;

import com.drwho.domain.AppointmentSchedule;
import com.drwho.exception.DataFormatException;
import com.drwho.service.AppointmentScheduleService;
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
@RequestMapping(value = "/v1/appointmentSchedule")
@Api(value = "appointmentSchedule", description = "DrWho API")
public class AppointmentScheduleController extends AbstractRestHandler {

    @Autowired
    private AppointmentScheduleService appointmentScheduleService;

    //save a appointment schedule
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Created a appointmentSchedule resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createAppointmentSchedule(@RequestBody AppointmentSchedule appointmentSchedule,
                                          HttpServletRequest request, HttpServletResponse response){
        AppointmentSchedule createdAppointmentSchedule = this.appointmentScheduleService.createAppointmentSchedule(appointmentSchedule);
        response.setHeader("Location", request.getRequestURL().append('/').append(createdAppointmentSchedule.getId()).toString());
    }

    //retrieve all the appointmentScheduled Dates
    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all appointmentBooks", notes = "The list is paginated. You can provide a page number (default o) and a page size (default 100)")

    public
    @ResponseBody
    Page<AppointmentSchedule> getAllAppointmentSchedules(@ApiParam(value = "The page number (zero-based)", required = true)
                                                 @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                                 @ApiParam(value = "The page size", required = true)
                                                 @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                                 HttpServletRequest request, HttpServletResponse reponse){
        return this.appointmentScheduleService.getAllAppointmentDates(page, size);
    }

    // retrieve a specific appointmentScheduled Date
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single appointmentScheduled Date", notes = "You have to provide a valid appointmentScheduled Date ID.")
    public
    @ResponseBody
    AppointmentSchedule getAppointmentSchedule(@ApiParam(value = "The ID of the appointmentBook.", required = true)
                                       @PathVariable("id") Long id,
                                       HttpServletRequest request, HttpServletResponse response) throws Exception{
        AppointmentSchedule appointmentSchedule = this.appointmentScheduleService.getAppointmentSchedule(id);
        checkResourceFound(appointmentSchedule);
        return appointmentSchedule;
    }

    //update a doctor
    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a hotel resource.", notes = "You have to provide a valid hotel ID in the URL and in the payload. The ID attribute can not be updated.")
    public void updateAppointmentSchedule(@ApiParam(value = "The ID of the existing hotel resource.", required = true)
                             @PathVariable("id") Long id, @RequestBody AppointmentSchedule appointmentSchedule,
                             HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.appointmentScheduleService.getAppointmentSchedule(id));

        //if (id != doctor.getId()) throw new DataFormatException("ID doesn't match!");
        this.appointmentScheduleService.updateAppointmentSchedule(appointmentSchedule);
    }
}
