package com.d288.cduque10.services;

import com.d288.cduque10.dao.*;
import com.d288.cduque10.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service

public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private ExcursionRepository excursionRepository;
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl (
            CustomerRepository customerRepository,
            CartRepository cartRepository,
            ExcursionRepository excursionRepository,
            CartItemRepository cartItemRepository

    ) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.excursionRepository = excursionRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    @Transactional

    /* public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        Customer customer = purchase.getCustomer();

        Set<CartItem> cartItems = purchase.getCartItems();

        cartItems.forEach(item -> {
            item.setCart(cart);
            cart.add(item);
        });

        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        customer.add(cart);
        cart.setStatus(StatusType.ordered);

        cartRepository.save(cart);
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

     */
    // Adding validation for empty cart

    public PurchaseResponse placeOrder(Purchase purchase) {

        try {
            Cart cart = purchase.getCart();

            String orderTrackingNumber = generateOTN();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> item.setCart(cart));

            cart.setCartItem(cartItems);

            Customer customer = purchase.getCustomer();
            cart.setCustomer(customer);

            customerRepository.save(customer);
            cartRepository.save(cart);
            customer.add(cart);

            cart.setStatus(StatusType.ordered);

            if (customer == null || cartItems.isEmpty()) {
                throw new IllegalArgumentException("Customer or cart cannot be empty.");
            }

            return new PurchaseResponse(orderTrackingNumber);
        } catch (Exception e) {
            return new PurchaseResponse(e.getMessage());
        }


    }

    private String generateOTN() {
        return UUID.randomUUID().toString();
    }

}
