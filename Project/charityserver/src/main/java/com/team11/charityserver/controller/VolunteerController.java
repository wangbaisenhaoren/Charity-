package com.team11.charityserver.controller;

import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.model.Volunteer;
import com.team11.charityserver.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VolunteerController {
    @Autowired
    VolunteerService volunteerService;

    @PostMapping("/volunteer")
    public RespBean addVolunteer(@RequestBody Volunteer volunteer) {
        if (volunteerService.addVolunteer(volunteer) == 1) {
            return RespBean.ok("Add volunteer successfully!");
        }
        return RespBean.error("Cannot add volunteer!");
    }

    @GetMapping("/charity-volunteers")
    public List<Volunteer> getAllVolunteersByCharityId(@RequestParam(required = false) Integer charityId) {
        return volunteerService.getAllVolunteersByCharityId(charityId);
    }

    @GetMapping("/user-volunteers")
    public List<Volunteer> getUserVolunteersByCharityId(@RequestParam(required = false) Integer charityId) {
        return volunteerService.getUserVolunteersByCharityId(charityId);
    }
}
