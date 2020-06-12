package com.team11.charityserver.controller;

import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.model.Subscription;
import com.team11.charityserver.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {
    @Autowired
    SubscriptionService subscriptionService;

    @PostMapping("/subscription")
    public RespBean addSubscription(@RequestBody Subscription subscription) {
        if (subscriptionService.addSubscription(subscription) == 1) {
            return RespBean.ok("Subscribe successfully!");
        }
        return RespBean.error("Cannot subscribe!");
    }

    @PutMapping("/subscription")
    public RespBean updateSubscription(@RequestBody Subscription subscription) {
        if (subscriptionService.updateSubscription(subscription) == 1) {
            return RespBean.ok("Subscribe successfully!");
        }
        return RespBean.error("Cannot subscribe!");
    }

    @GetMapping("/subscriptions")
    public List<Subscription> getSubscriptionsByUserId(@RequestParam(required = false) Integer userId) {
        return subscriptionService.getSubscriptionsByUserId(userId);
    }
}
