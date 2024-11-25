package com.d288.cduque10.controllers;

import com.d288.cduque10.services.*;
import jakarta.validation.Valid;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin("http://localhost:4200")

public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")

    public PurchaseResponse placeOrder(@RequestBody @Valid Purchase purchase) {

        PurchaseResponse savedResponse = checkoutService.placeOrder(purchase);

        return savedResponse;
    }
}
