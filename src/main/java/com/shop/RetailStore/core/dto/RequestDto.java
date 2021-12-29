package com.shop.RetailStore.core.dto;

import java.io.Serializable;


public class RequestDto implements Serializable {
    UserDto userDto;
    ItemDto itemGroceryDto;
    ItemDto itemOtherDto;

    RequestDto(){}

    public RequestDto(UserDto userDto, ItemDto itemGroceryDto, ItemDto itemOtherDto) {
        this.userDto = userDto;
        this.itemGroceryDto = itemGroceryDto;
        this.itemOtherDto = itemOtherDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public ItemDto getItemGroceryDto() {
        return itemGroceryDto;
    }

    public ItemDto getItemOtherDto() {
        return itemOtherDto;
    }
}
