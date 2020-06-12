package com.team11.charityserver.service;

import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaypalService {

    @Autowired
    private APIContext apiContext;

    public Payment createPayment(
            Double total,
            String currency,
            String method,
            String intent,
            String description,
            String cancelUrl,
            String successUrl) throws PayPalRESTException {

        Amount amount = new Amount();
        amount.setCurrency(currency);
        total = new BigDecimal(total).setScale(2, RoundingMode.HALF_UP).doubleValue();
        amount.setTotal(String.format("%.2f", total));

        Transaction transaction = new Transaction();
        transaction.setDescription(description);
        transaction.setAmount(amount);

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Payer payer = new Payer();
        payer.setPaymentMethod(method.toString());

        Payment payment = new Payment();
        payment.setIntent(intent.toString());
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl(cancelUrl);
        redirectUrls.setReturnUrl(successUrl);
        payment.setRedirectUrls(redirectUrls);
        return payment.create(apiContext);
    }

    public Plan createPlan(
            String frequency,
            String cycle,
            String money,
            String cancelUrl,
            String successUrl) throws PayPalRESTException {
        Plan plan = new Plan();
        plan.setName("Donation");
        plan.setDescription("Donate to the charity.");
        plan.setType("fixed");

        // Payment_definitions
        PaymentDefinition paymentDefinition = new PaymentDefinition();
        paymentDefinition.setName("Regular Payments");
        paymentDefinition.setType("REGULAR");
//        paymentDefinition.setFrequency("MONTH");
        paymentDefinition.setFrequency(frequency);
        paymentDefinition.setFrequencyInterval("1");
//        paymentDefinition.setCycles("12");
        paymentDefinition.setCycles(cycle);

        // Currency
        Currency currency = new Currency();
        currency.setCurrency("GBP");
//        currency.setValue("20");
        currency.setValue(money);
        paymentDefinition.setAmount(currency);

        // Charge_models
        ChargeModels chargeModels = new com.paypal.api.payments.ChargeModels();
        chargeModels.setType("SHIPPING");
        chargeModels.setAmount(currency);
        List<ChargeModels> chargeModelsList = new ArrayList<ChargeModels>();
        chargeModelsList.add(chargeModels);
        paymentDefinition.setChargeModels(chargeModelsList);

        // Payment_definition
        List<PaymentDefinition> paymentDefinitionList = new ArrayList<PaymentDefinition>();
        paymentDefinitionList.add(paymentDefinition);
        plan.setPaymentDefinitions(paymentDefinitionList);

        // Merchant_preferences
        MerchantPreferences merchantPreferences = new MerchantPreferences();
        merchantPreferences.setSetupFee(currency);
//        merchantPreferences.setCancelUrl("http://localhost:8080/#/donate");
//        merchantPreferences.setReturnUrl("http://localhost:8080/#/home");
        merchantPreferences.setCancelUrl(cancelUrl);
        merchantPreferences.setReturnUrl(successUrl);
        merchantPreferences.setMaxFailAttempts("0");
        merchantPreferences.setAutoBillAmount("YES");
        merchantPreferences.setInitialFailAmountAction("CONTINUE");
        plan.setMerchantPreferences(merchantPreferences);
        return plan.create(apiContext);
    }

    public Agreement createAgreement(Plan plan) throws UnsupportedEncodingException, PayPalRESTException, MalformedURLException {
        // Create new agreement
        Agreement agreement = new Agreement();
        agreement.setName("Base Agreement");
        agreement.setDescription("Basic Agreement");
        agreement.setStartDate("2020-06-17T9:45:04Z");

        // Set plan ID
        Plan newPlan = new Plan();
        newPlan.setId(plan.getId());
        agreement.setPlan(newPlan);

        // Add payer details
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        agreement.setPayer(payer);

        return agreement.create(apiContext);
    }

    public Plan executePlan(String frequency,
                            String cycle,
                            String money,
                            String cancelUrl,
                            String successUrl) throws PayPalRESTException {
        // Create payment
        Plan createdPlan = createPlan(frequency, cycle, money, cancelUrl, successUrl);

        // Set up plan activate PATCH request
        List<Patch> patchRequestList = new ArrayList<Patch>();
        Map<String, String> value = new HashMap<>();
        value.put("state", "ACTIVE");

        // Create update object to activate plan
        Patch patch = new Patch();
        patch.setPath("/");
        patch.setValue(value);
        patch.setOp("replace");
        patchRequestList.add(patch);

        // Activate plan
        createdPlan.update(apiContext, patchRequestList);
        return createdPlan;
    }

}
