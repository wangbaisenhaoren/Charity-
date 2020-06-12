package com.team11.charityserver.service;

import com.team11.charityserver.mapper.CharityMapper;
import com.team11.charityserver.model.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityService {
    @Autowired
    CharityMapper charityMapper;


    public Integer addCharity(Charity charity) {
        return charityMapper.insertSelective(charity);
    }

    public Charity getCharityByUserId(Integer userId) {
        return charityMapper.getCharityByUserId(userId);
    }

    public List<Charity> getAllCharities() {
        return charityMapper.getAllCharities();
    }
}
