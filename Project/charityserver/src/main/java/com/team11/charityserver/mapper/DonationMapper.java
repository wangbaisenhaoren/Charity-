package com.team11.charityserver.mapper;

import com.team11.charityserver.model.Donation;

import java.util.List;

public interface DonationMapper {
    int insertSelective(Donation donation);

    List<Donation> getAllDonationsByUserId(Integer userId);

    List<Donation> getAllDonationsByProjectId(Integer projectId);

    List<Donation> getUserDonationsByProjectId(Integer projectId);

    Donation getUserDonationByProjectId(Integer userId, Integer projectId);
}
