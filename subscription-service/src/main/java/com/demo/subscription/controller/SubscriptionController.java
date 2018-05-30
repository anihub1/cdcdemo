package com.demo.subscription.controller;

import static com.demo.subscription.domain.Subscription.SubscriptionType.MONTHLY;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.subscription.domain.Invoice;
import com.demo.subscription.domain.Subscription;
import com.demo.subscription.services.SubscriptionService;

@RestController
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	@RequestMapping("/dosub")
	public Invoice doSubscription() {
		
        String accountId = "12345";
        Subscription subscription = new Subscription(accountId, MONTHLY);

		Invoice invoice=subscriptionService.createInvoice(subscription);
		
		return invoice;
	}
}
