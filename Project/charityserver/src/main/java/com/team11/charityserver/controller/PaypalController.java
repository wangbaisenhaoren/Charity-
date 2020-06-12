package com.team11.charityserver.controller;

import com.paypal.api.payments.Agreement;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Plan;
import com.paypal.base.rest.PayPalRESTException;
import com.team11.charityserver.model.Order;
import com.team11.charityserver.model.Subscription;
import com.team11.charityserver.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

@RestController
public class PaypalController {

    @Autowired
    PaypalService service;

    public static final String SUCCESS_URL = "home";
    public static final String CANCEL_URL = "donate";

    @PostMapping("/pay")
    public String payment(@RequestBody Order order) {
        try {
            Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(),
                     "http://localhost:8080/#/" + CANCEL_URL,
                    "http://localhost:8080/#/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return link.getHref();
                }
            }

        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @PostMapping("/agreement")
    public String agreement(@RequestBody Subscription subscription) {
        try {
            Plan plan = service.executePlan(subscription.getFrequency(), subscription.getCycle(),
                                            subscription.getMoney(),
                                "http://localhost:8080/#/" + CANCEL_URL,
                              "http://localhost:8080/#/" + SUCCESS_URL);
            Agreement agreement = service.createAgreement(plan);
            for(Links link:agreement.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return link.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

}
