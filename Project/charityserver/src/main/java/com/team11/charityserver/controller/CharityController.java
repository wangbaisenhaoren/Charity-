package com.team11.charityserver.controller;

import com.team11.charityserver.model.Charity;
import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.service.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharityController {
    @Autowired
    CharityService charityService;

    @PostMapping("/apply")
    public RespBean addCharity(@RequestBody Charity charity) {
        if (charityService.addCharity(charity) == 1) {
            return RespBean.ok("Apply successfully!");
        }
        return RespBean.ok("Cannot apply!");
    }

    @GetMapping("/charity")
    public Charity getCharityByUserId(@RequestParam(required = false) Integer userId) {
        return charityService.getCharityByUserId(userId);
    }

    @GetMapping("/charities")
    public List<Charity> getAllCharities() {
        return charityService.getAllCharities();
    }
}
