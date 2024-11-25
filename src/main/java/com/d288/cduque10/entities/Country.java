package com.d288.cduque10.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter
@Setter

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date create_date;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Division> divisions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        return Objects.equals(id, country.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
