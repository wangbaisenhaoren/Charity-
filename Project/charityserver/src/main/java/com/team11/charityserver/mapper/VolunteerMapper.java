package com.team11.charityserver.mapper;

import com.team11.charityserver.model.Volunteer;

import java.util.List;

public interface VolunteerMapper {

    int insertSelective(Volunteer volunteer);

    List<Volunteer> getAllVolunteersByCharityId(Integer charityId);

    List<Volunteer> getUserVolunteersByCharityId(Integer charityId);
}
