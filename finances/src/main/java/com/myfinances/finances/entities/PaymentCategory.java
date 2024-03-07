package com.myfinances.finances.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

@Entity
@Table(name = "PaymentCategories")
@Getter
@Setter
public class PaymentCategory implements EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "isDefault")
    @ColumnDefault("false")
    private boolean isDefault;

    @OneToMany(mappedBy="id")
    private Set<Payment> items;
}
