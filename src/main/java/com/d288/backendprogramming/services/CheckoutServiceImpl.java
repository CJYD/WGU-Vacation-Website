package com.d288.backendprogramming.services;

import com.d288.backendprogramming.dao.*;
import com.d288.backendprogramming.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CartRepository cartRepository) {
//        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        try {
            Cart cart = purchase.getCart();

            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(cart::add);


            Customer customer = purchase.getCustomer();
            customer.add(cart);

            // customerRepository.save(customer);
            cart.setStatus(StatusType.ordered);

            cartRepository.save(cart);

            // Handle null customer or empty cart items
            if (customer == null || cartItems.isEmpty()) {
                throw new IllegalArgumentException("Customer cannot be null and cart items cannot be empty.");
            }

            // Return a response
            return new PurchaseResponse(orderTrackingNumber);

        } catch (Exception e) {
            // Handle any exceptions and provide an error response
            return new PurchaseResponse(e.getMessage());
        }
    }

    // Private function to create a random order tracking number
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
