package com.d288.backendprogramming.services;

import com.d288.backendprogramming.entities.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private String address;
    private Cart cart;
    private Set<CartItem> cartItems;

}
