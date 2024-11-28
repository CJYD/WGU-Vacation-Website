package com.d288.cduque10.services;

import com.d288.cduque10.entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Purchase {

    private Customer customer;
    private String address;
    private Cart cart;
    private Set<CartItem> cartItems;

}
