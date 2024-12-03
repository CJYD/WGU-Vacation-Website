package com.d288.backendprogramming.services;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CheckoutService { PurchaseResponse placeOrder(Purchase purchase); }
