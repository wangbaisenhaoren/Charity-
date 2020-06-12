package com.team11.charityserver.controller;

import com.team11.charityserver.model.Donation;
import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.service.DonationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DonationController {
    @Autowired
    DonationService donationService;

    @PostMapping("/donation")
    public RespBean addDonation(@RequestBody Donation donation) {
        if (donationService.addDonation(donation) == 1) {
            return RespBean.ok("Add donation successfully!");
        }
        return RespBean.error("Cannot add donation!");
    }

    @GetMapping("/donation")
    public List<Donation> getAllDonationsByUserId(@RequestParam(required = false) Integer userId) {
        return donationService.getAllDonationsByUserId(userId);
    }

    @GetMapping("/project-donations")
    public List<Donation> getAllDonationsByProjectId(@RequestParam(required = false) Integer projectId) {
        return donationService.getAllDonationsByProjectId(projectId);
    }

    @GetMapping("/user-donations")
    public List<Donation> getUserDonationsByProjectId(@RequestParam(required = false) Integer projectId) {
        return donationService.getUserDonationsByProjectId(projectId);
    }

    @GetMapping("/user-donation")
    public Donation getUserDonationByProjectId(Integer userId, Integer projectId) {
        return donationService.getUserDonationByProjectId(userId, projectId);
    }
}
