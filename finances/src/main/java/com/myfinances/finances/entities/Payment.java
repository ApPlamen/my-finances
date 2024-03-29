package com.myfinances.finances.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;

@Entity
@Table(name = "Payments")
@Getter
@Setter
public class Payment implements EntityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "amount")
    private float amount;
    @Column(name = "dateTime")
    private Timestamp dateTime;
    @Column(name = "userId")
    private int userId;
    @Column(name = "active")
    @ColumnDefault("true")
    private boolean active;

    @ManyToOne
    @JoinColumn(name="paymentOption")
    private PaymentOption paymentOption;

    @ManyToOne
    @JoinColumn(name="paymentCategory")
    private PaymentCategory paymentCategory;
}
