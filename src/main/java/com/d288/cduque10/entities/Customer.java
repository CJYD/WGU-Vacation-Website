package com.d288.cduque10.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @NonNull
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @NonNull
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Address is mandatory")
    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "Postal code is mandatory")
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @NotBlank(message = "Phone number is mandatory")
    @Column(name = "phone", nullable = false)
    private String phone;

    @CreationTimestamp
    @Column(name = "create_date", nullable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "cart_id", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this);
        }
    }
}
