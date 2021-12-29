package com.shop.RetailStore.core;

/*
 * Interface for all items
 */
public interface Item {
    double getUnitPrice();
    
    double priceForQuantity(int quantity);
    
    String getName();

    com.shop.RetailStore.core.ItemType getType();
}
