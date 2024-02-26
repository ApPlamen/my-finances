package com.myfinances.statistics.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Payment {
    private int id;
    private String description;
    private String vendor;
    private float amount;
    private Timestamp dateTime;
    private int userId;
    private boolean active;
}
