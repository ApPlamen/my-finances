package com.myfinances.apigateway.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myfinances.apigateway.entities.EntityModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UpdateRequest<Entity extends EntityModel, EntityId> {

    @JsonProperty
    private EntityId id;

}
