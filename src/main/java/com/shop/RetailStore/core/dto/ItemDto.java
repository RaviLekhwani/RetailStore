package com.shop.RetailStore.core.dto;

import com.shop.RetailStore.core.ItemType;

import java.io.Serializable;

public class ItemDto implements Serializable {

    private String name;
    private Double unitPrice;
    private ItemType type;
    private Integer quantity;

    public ItemDto(){}

    public ItemDto(String name, Double unitPrice, Integer type, Integer quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.type = type==0? ItemType.GROCERY : ItemType.OTHER;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public ItemType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
