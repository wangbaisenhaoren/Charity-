package com.team11.charityserver.service;

import com.team11.charityserver.mapper.SubscriptionMapper;
import com.team11.charityserver.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    SubscriptionMapper subscriptionMapper;

    public Integer addSubscription(Subscription subscription) {
        return subscriptionMapper.insertSelective(subscription);
    }

    public Integer updateSubscription(Subscription subscription) {
        return subscriptionMapper.updateSubscription(subscription);
    }

    public List<Subscription> getSubscriptionsByUserId(Integer userId) {
        return subscriptionMapper.getSubscriptionsByUserId(userId);
    }
}
