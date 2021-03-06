package com.shop.RetailStore.core;

import com.shop.RetailStore.discount.DiscountPolicy;
import com.shop.RetailStore.discount.ThresholdDiscount;
import com.shop.RetailStore.discount.item.PromotionPricing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * ShoppingCart Class to calculate complete to add items and contain the final net amount
 */
public class ShoppingCart {


    DiscountPolicy discountPolicy;

    private Map<Item, Integer> quantities;
   // private DiscountPolicy discountPolicy;
    private com.shop.RetailStore.core.User user;

    public ShoppingCart(com.shop.RetailStore.core.User user) {
        quantities = new LinkedHashMap<Item, Integer>();
        this.user = user;
        discountPolicy = new ThresholdDiscount();
    }
    
    public double total() {
        double result = 0;
        for (Item each : quantities.keySet()) {
            result += each.priceForQuantity(quantities.get(each));
        }
        
        if (discountPolicy != null) {
        	result = discountPolicy.applyDiscount(result);
        }
        
        return result;
    }

    public void add(Item itemToBuy) {    	
        add(itemToBuy, 1);
    }
    

    // To add multiple quantities of item
    public void add(Item itemToBuy, int howMany) {
    	Item item;
    	
    	// Apply 30% discount in case of employee of store
    	if (user.getType() == UserType.EMPLOYEE) {
    		item = new PromotionPricing(itemToBuy, 30);
    	}
    	// Apply 10% discount in case of affiliate
    	else if (user.getType() == UserType.AFFILIATE) {
    		item = new PromotionPricing(itemToBuy, 10);
    	}
    	
    	// If a user has been a customer for 2 or more years apply 5% discount
    	else if (user.getType() == UserType.SIMPLE && 
    			ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDateTime.now()) >= 2) {
    		item = new PromotionPricing(itemToBuy, 5);
    	}
    	
    	else {
    		item = itemToBuy;
    	}
    	
        int previousQuantity = quantities.containsKey(item)
                ? quantities.get(item)
                : 0;
        quantities.put(item, previousQuantity + howMany);
    }
}
