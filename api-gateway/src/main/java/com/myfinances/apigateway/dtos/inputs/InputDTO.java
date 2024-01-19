package com.myfinances.apigateway.dtos.inputs;

import com.myfinances.apigateway.entities.EntityModel;

public abstract class InputDTO<Entity extends EntityModel> {

    public abstract Entity toEntity();

}
