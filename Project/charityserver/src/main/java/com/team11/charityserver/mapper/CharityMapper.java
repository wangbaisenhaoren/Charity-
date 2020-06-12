package com.team11.charityserver.mapper;

import com.team11.charityserver.model.Charity;

import java.util.List;

public interface CharityMapper {
    int insertSelective(Charity charity);

    Charity getCharityByUserId(Integer userId);

    List<Charity> getAllCharities();
}
