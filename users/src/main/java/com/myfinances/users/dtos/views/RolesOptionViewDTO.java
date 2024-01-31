package com.myfinances.users.dtos.views;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RolesOptionViewDTO {
    private int value;
    private String displayValue;
}
