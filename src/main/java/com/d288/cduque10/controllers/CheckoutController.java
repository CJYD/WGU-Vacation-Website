package com.d288.cduque10.controllers;

import com.d288.cduque10.services.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")

public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/purchase")

    public PurchaseResponse placeOrder(@Valid @RequestBody Purchase purchase) {

        PurchaseResponse savedPurchase = checkoutService.placeOrder(purchase);

        return savedPurchase;
    }
}
