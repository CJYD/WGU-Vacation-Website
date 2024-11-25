package com.d288.cduque10.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cart_item", joinColumns = @JoinColumn(name = "cart_item_id"), inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartItem)) return false;

        CartItem cartItem = (CartItem) o;

        return Objects.equals(id, cartItem.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
