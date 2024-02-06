package com.myfinances.apigateway.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment implements EntityModel {
    private int id;
    private String description;
    private float amount;
}
