package com.myfinances.apigateway.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UpdateRequest<EntityId> {

    @JsonProperty
    private EntityId id;

}
