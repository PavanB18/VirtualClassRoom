package com.kslove.VirtualClassRoom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kslove.VirtualClassRoom.entity.Subscription;
import com.kslove.VirtualClassRoom.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	SubscriptionRepository subscriptionRepository;

	public List<Subscription> getAllSubscription() { // fetch all subscriptions.
		List<Subscription> listOfSubscription = new ArrayList<>();
		subscriptionRepository.findAll().forEach(listOfSubscription::add);
		return listOfSubscription;
	}

	public Optional<Subscription> getSubscriptionById(int id) { // fetch subscription by ID.
		return subscriptionRepository.findById(id);
	}

	public String addSubscription(Subscription subscription) { // Add subscriptions.
		subscriptionRepository.save(subscription);
		return "Subscription added";
	}

	public String deleteSubscription(int id) { // soft delete subscription.
		Optional<Subscription> deleteSubscriptionInfo = subscriptionRepository.findById(id);
		if (deleteSubscriptionInfo.isPresent()) {
			Subscription subscriptionInfo = deleteSubscriptionInfo.get();

			subscriptionInfo.setStatus(false);
			subscriptionRepository.save(subscriptionInfo);
		}
		return "Subscription deleted";
	}
}

