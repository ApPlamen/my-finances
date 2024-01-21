package com.myfinances.users.dtos.inputs;

import com.myfinances.users.entities.EntityModel;

public abstract class InputDTO<Entity extends EntityModel> {

    public abstract Entity toEntity();

}
