package com.shop.RetailStore.controller;

import com.shop.RetailStore.core.Item;
import com.shop.RetailStore.core.Product;
import com.shop.RetailStore.core.ShoppingCart;
import com.shop.RetailStore.core.User;
import com.shop.RetailStore.core.dto.RequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ShopingCartController {


    @GetMapping("/shoppingcart")
    public ResponseEntity<Double> getDevice(@RequestBody RequestDto requestDto) {

        User employee = new User(requestDto.getUserDto().getType(), requestDto.getUserDto().getUserName(), requestDto.getUserDto().getJoiningDate());

        Item groceryItem = new Product(requestDto.getItemGroceryDto().getName(), requestDto.getItemGroceryDto().getUnitPrice(), requestDto.getItemGroceryDto().getType());
        Item otherItem = new Product(requestDto.getItemOtherDto().getName(), requestDto.getItemOtherDto().getUnitPrice(), requestDto.getItemOtherDto().getType());

        ShoppingCart cart = new ShoppingCart(employee);
        cart.add(groceryItem, requestDto.getItemGroceryDto().getQuantity());
        cart.add(otherItem, requestDto.getItemOtherDto().getQuantity());


        return new ResponseEntity<>(cart.total(), HttpStatus.OK);
    }


}
