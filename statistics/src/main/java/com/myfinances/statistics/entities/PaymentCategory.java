package com.myfinances.statistics.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
