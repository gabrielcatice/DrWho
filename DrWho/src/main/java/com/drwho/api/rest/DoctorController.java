package com.drwho.api.rest;

import com.drwho.domain.Doctor;
import com.drwho.exception.DataFormatException;
import com.drwho.service.DoctorService;
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
@RequestMapping(value = "v1/doctors")
@Api(value = "doctors", description = "DrWho API")
public class DoctorController extends AbstractRestHandler {

    @Autowired
    private DoctorService doctorService;

    //save a doctor
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Created a doctor resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createDoctor(@RequestBody Doctor doctor,
                                    HttpServletRequest request, HttpServletResponse response){
        Doctor createdDoctor= this.doctorService.createDoctor(doctor);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdDoctor.getId()).toString());

    }

    //retrieve all the doctors
    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all doctors", notes = "The list is paginated. You can provide a page number (default o) and a page size (default 100)")

    public
    @ResponseBody
    Page<Doctor> getAllDoctors(@ApiParam(value = "The page number (zero-based)", required = true)
                       @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                       @ApiParam(value = "The page size", required = true)
                       @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                       HttpServletRequest request, HttpServletResponse reponse){
        return this.doctorService.getAllDoctors(page, size);

    }

    // retrieve a specific doctor
    @RequestMapping(value = "/{id}",
                    method = RequestMethod.GET,
                    produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single doctor.", notes = "You have to provide a valid doctor ID.")
    public
    @ResponseBody
    Doctor getDoctor(@ApiParam(value = "The ID of the doctor.", required = true)
                     @PathVariable("id") Long id,
                     HttpServletRequest request, HttpServletResponse response) throws Exception{
        Doctor doctor = this.doctorService.getDoctor(id);
        checkResourceFound(doctor);
        return doctor;
    }
}
