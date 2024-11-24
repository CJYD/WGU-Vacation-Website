package com.d288.cduque10.services;

import com.d288.cduque10.entities.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter

public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
