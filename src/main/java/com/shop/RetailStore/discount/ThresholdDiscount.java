package com.shop.RetailStore.discount;

import org.springframework.stereotype.Component;

/*
 * To generate discount of $5 for every 100 dollars in cart
 */
@Component
public class ThresholdDiscount implements com.shop.RetailStore.discount.DiscountPolicy {

	@Override
	public double applyDiscount(double totalAmount) {
		
		if (totalAmount < 100) {
			return totalAmount;
		}
		
		int discountFactor = (int) totalAmount / 100;
		double discount = discountFactor * 5;
		return totalAmount - discount; 
	}

}
