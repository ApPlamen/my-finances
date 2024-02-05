package com.myfinances.finances.dtos.inputs;

import com.myfinances.finances.entities.EntityModel;

public abstract class InputDTO<Entity extends EntityModel> {

    public abstract Entity toEntity();

}
