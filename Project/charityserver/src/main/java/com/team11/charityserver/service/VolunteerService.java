package com.team11.charityserver.service;

import com.team11.charityserver.mapper.VolunteerMapper;
import com.team11.charityserver.model.Donation;
import com.team11.charityserver.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {
    @Autowired
    VolunteerMapper volunteerMapper;

    public int addVolunteer(Volunteer volunteer) {
        return volunteerMapper.insertSelective(volunteer);
    }

    public List<Volunteer> getAllVolunteersByCharityId(Integer charityId) {
        return volunteerMapper.getAllVolunteersByCharityId(charityId);
    }

    public List<Volunteer> getUserVolunteersByCharityId(Integer charityId) {
        return volunteerMapper.getUserVolunteersByCharityId(charityId);
    }
}
