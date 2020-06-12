package com.team11.charityserver.mapper;

import com.team11.charityserver.model.Subscription;

import java.util.List;

public interface SubscriptionMapper {
    int insertSelective(Subscription subscription);

    int updateSubscription(Subscription subscription);

    List<Subscription> getSubscriptionsByUserId(Integer userId);
}
