package com.myfinances.apigateway.model.request;

import com.myfinances.apigateway.entities.EntityModel;

public abstract class InputRequest<Entity extends EntityModel> {

    public abstract Entity toEntity();

}
