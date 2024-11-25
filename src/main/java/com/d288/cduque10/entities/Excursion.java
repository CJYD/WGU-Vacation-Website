package com.d288.cduque10.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Excursion)) return false;

        Excursion excursion = (Excursion) o;

        return Objects.equals(id, excursion.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
