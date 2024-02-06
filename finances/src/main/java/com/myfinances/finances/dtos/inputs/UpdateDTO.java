package com.myfinances.finances.dtos.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myfinances.finances.entities.EntityModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UpdateDTO<Entity extends EntityModel, EntityId> {

    @JsonProperty
    private EntityId id;

    public abstract Entity toEntity(Entity entity);

}
