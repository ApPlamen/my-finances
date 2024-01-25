package com.myfinances.apigateway.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Authority implements EntityModel {
    private int id;
    private String name;
}
